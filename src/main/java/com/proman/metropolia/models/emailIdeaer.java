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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="email")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "email")
public class emailIdeaer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NaturalId
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
        return email;
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

    public void setId(Long id ){
        this.id = id;
    }
}