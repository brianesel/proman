package com.proman.metropolia.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="email")
public class emailIdeaer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    @Column(unique=true)
    private String email;

    @ManyToMany(mappedBy = "email",cascade = CascadeType.ALL)
    private List<anIdea> idea;

    public emailIdeaer(){

    }

    public emailIdeaer(String email){
        this.email = email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setIdea(List<anIdea> idea){
        this.idea = idea;
    }

    public List<anIdea> getIdea(){
        return idea;
    }

    public Long getId(){
        return id;
    }
}