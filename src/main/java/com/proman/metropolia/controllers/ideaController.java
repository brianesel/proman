package com.proman.metropolia.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.payloads.IdeaSubmission;
import com.proman.metropolia.models.anIdea;
import com.proman.metropolia.models.emailIdeaer;
import com.proman.metropolia.repo.emailRepo;
import com.proman.metropolia.repo.ideaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metropolia")
public class ideaController {

    @Autowired
    private ideaRepo ideaRepo;

    @Autowired
    private emailRepo emailRepo;

    @PostMapping("/idea/submit")
    public String submitIdea(@Valid @RequestBody IdeaSubmission ideaSubmit) throws Exception{
        emailIdeaer email = new emailIdeaer();
        if(emailRepo.existsByEmail(ideaSubmit.getEmail()) == true){
            email = emailRepo.findByEmail(ideaSubmit.getEmail());
        }else {
            email.setEmail(ideaSubmit.getEmail());
        }
        anIdea idea = new anIdea(ideaSubmit.getNickName(), email, ideaSubmit.getSubject(), ideaSubmit.getDescription());
        ideaRepo.save(idea);
        return "sucess";
    }


}
