package com.proman.metropolia.models;

import com.proman.metropolia.models.emailIdeaer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "idea")
public class anIdea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String subject;

    @NotNull
    private String description;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "email_idea", joinColumns = @JoinColumn(name = "idea_id"), inverseJoinColumns = @JoinColumn(name = "email_id"))
    private List<emailIdeaer> email;

    @NotNull
    private String nickname;

    public anIdea(){

    }

    public anIdea(String nickname, emailIdeaer email,String subject, String description ){
        List<emailIdeaer> emailList = new ArrayList<emailIdeaer>();
        emailList.add(email);
        this.nickname = nickname;
        this.email = emailList;
        this.subject = subject;
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<emailIdeaer> Email() {
        return email;
    }

    public void setEmail(List<emailIdeaer> email) {
        this.email = email;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setNickName(String nickname){
        this.nickname = nickname;
    }

    public String getNickName(){
        return this.nickname;
    }

    public Long getId(){
        return id;
    }
}