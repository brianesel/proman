package com.proman.metropolia.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.payloads.request.metropolia.*;
import com.payloads.response.metropolia.ideaListResponse;
import com.proman.metropolia.models.anIdea;
import com.proman.metropolia.models.emailIdeaer;
import com.proman.metropolia.repo.emailRepo;
import com.proman.metropolia.repo.ideaRepo;
import com.proman.metropolia.service.IdeaServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metropolia")
public class ideaController {

    @Autowired
    private ideaRepo ideaRepo;

    @Autowired
    private emailRepo emailRepo;

    @Autowired
    private IdeaServicesImpl ideaService;

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

    @GetMapping("/idea/list")
    @ResponseBody
    public Object getIdeaList() throws Exception{
        List<ideaListResponse> ideaListRes = new ArrayList<ideaListResponse>();
        for(anIdea idea: ideaRepo.findAll()){
            List<String> emailAddressList = new ArrayList<>();
            for(emailIdeaer emailList : idea.getEmail()){
                emailAddressList.add(emailList.getEmail());
            }
            ideaListRes.add(new ideaListResponse(idea.getId(), idea.getSubject(), emailAddressList));
        }
        return ideaListRes;
    }

    @GetMapping("/idea/details")
    @ResponseBody
    public Object getIdeaDetails(@Valid @RequestParam Long ideaID) throws Exception {
        anIdea ideaToSearch = ideaRepo.getOne(ideaID);
        List<String> emailAddressList = new ArrayList<>();
            for(emailIdeaer emailList : ideaToSearch.getEmail()){
                emailAddressList.add(emailList.getEmail());
            }
        ideaListResponse ideaRes = new ideaListResponse(ideaToSearch.getId(), ideaToSearch.getSubject(), emailAddressList, ideaToSearch.getDescription());
        return ideaRes;
    }

    @PostMapping("/idea/join")
    public Object joinIdea(@Valid @RequestBody IdeaSearch ideaSearch) {
        return ideaService.updateEmailList(ideaSearch.getEmail(), ideaSearch.getId());
    }
}
