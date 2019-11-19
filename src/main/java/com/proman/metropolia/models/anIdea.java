package com.proman.metropolia.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.proman.metropolia.models.emailIdeaer;

import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "subject")
public class anIdea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NaturalId
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true)
    private Long specialID;

    @NotNull
    private String subject;

    @NotNull
    private String description;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "email_idea", joinColumns = @JoinColumn(name = "idea_id"), inverseJoinColumns = @JoinColumn(name = "email_id"))
    private Set<emailIdeaer> email = new HashSet<>();

    @NotNull
    private String nickname;

    public anIdea(){

    }

    public anIdea(String nickname, emailIdeaer email,String subject, String description ){
        Set<emailIdeaer> emailList = new HashSet<emailIdeaer>();
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

    public void setEmail(Set<emailIdeaer> email) {
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

    public Long getSpecialID(){
        return specialID;
    }

    public void setSpecialID(Long specialID){
        this.specialID = specialID;
    }

    public Set<emailIdeaer> getEmail(){
        return email;
    }

    public void addEmail(Set<emailIdeaer> email){
        for (emailIdeaer anEmail: email){
            this.email.add(anEmail);
        }
    }
}