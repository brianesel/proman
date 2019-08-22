package com.proman.email.controller;

import com.proman.email.services.EmailServiceImpl;
import com.proman.email.model.PublicMail;
import com.proman.email.model.MailToMe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/mail")
public class PublicMailController {

    @Autowired
    public EmailServiceImpl emailService;

    @Value("${attachment.invoice}")
    private String attachmentPath;

    @Value("${my.email}")
    private String myEmail;

    @Autowired
    public SimpleMailMessage template;

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();

        // Simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);

        // Email with template
        props = new HashMap<>();
        props.put("headerText", "Send Email Using Template");
        props.put("messageLabel", "Template Parameter");
        props.put("additionalInfo", "The parameter value will be added to the following message template:<br>"
                + "<b>This is the test email template for your email:<br>'Template Parameter'</b>");
        labels.put("sendTemplate", props);

        // Email with attachment
        props = new HashMap<>();
        props.put("headerText", "Send Email With Attachment");
        props.put("messageLabel", "Message");
        props.put("additionalInfo",
                "To make sure that you send an attachment with this email, change the value for the 'attachment.invoice' in the application.properties file to the path to the attachment.");
        labels.put("sendAttachment", props);
    }

    @PostMapping("/send")
    public String createMail(@Valid @RequestBody PublicMail mailObject) {

        emailService.sendSimpleMessage(mailObject.getTo(), mailObject.getSubject(), mailObject.getText());

        return "message sent";
    }

    @PostMapping("/sendtoMe")
    public String mailToMe(@Valid @RequestBody MailToMe mailObject) {

        try {
            emailService.sendSimpleMessage(myEmail, mailObject.getSubject(), mailObject.getText());
        } catch (Exception e) {
            System.out.println(e);
            return "message failed";
        }

        return "message sent";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showEmailsPage() {
        return "emails";
    }

    @RequestMapping(value = { "/send", "/sendTemplate", "/sendAttachment" }, method = RequestMethod.GET)
    public String createMail(Model model, HttpServletRequest request) {
        String action = request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/") + 1);
        Map<String, String> props = labels.get(action);
        Set<String> keys = props.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            model.addAttribute(key, props.get(key));
        }

        model.addAttribute("publicMail", new PublicMail());
        return "mail/send";
    }

    @RequestMapping(value = "/sendTemplate", method = RequestMethod.POST)
    public String createMailWithTemplate(Model model, @ModelAttribute("publicMail") @Valid PublicMail mailObject,
            Errors errors) {
        if (errors.hasErrors()) {
            return "mail/send";
        }
        emailService.sendSimpleMessageUsingTemplate(mailObject.getTo(), mailObject.getSubject(), template,
                mailObject.getText());

        return "redirect:/home";
    }

    @RequestMapping(value = "/sendAttachment", method = RequestMethod.POST)
    public String createMailWithAttachment(Model model, @ModelAttribute("publicMail") @Valid PublicMail mailObject,
            Errors errors) {
        if (errors.hasErrors()) {
            return "mail/send";
        }
        emailService.sendMessageWithAttachment(mailObject.getTo(), mailObject.getSubject(), mailObject.getText(),
                attachmentPath);

        return "redirect:/home";
    }
}