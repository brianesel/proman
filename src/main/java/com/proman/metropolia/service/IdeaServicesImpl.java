package com.proman.metropolia.service;

import javax.transaction.Transactional;

import com.proman.metropolia.models.anIdea;
import com.proman.metropolia.models.emailIdeaer;
import com.proman.metropolia.repo.emailRepo;
import com.proman.metropolia.repo.ideaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdeaServicesImpl implements IdeaServices {
    @Autowired
    private emailRepo emailRepo;

    @Autowired
    private ideaRepo ideaRepo;

    @Transactional
    public Object updateEmailList(String email, Long ideaID){
        try {
            anIdea idea = ideaRepo.getOne(ideaID);
            emailIdeaer newEmail = new emailIdeaer(email);
            if (!emailRepo.existsByEmail(email)){
                emailRepo.save(newEmail);
            }
            emailIdeaer currentEmail = emailRepo.findByEmail(email);
            idea.getEmail().add(currentEmail);
            ideaRepo.save(idea);
            return "Successfull";
        } catch(Exception e){
            return e;
        }
    }
}