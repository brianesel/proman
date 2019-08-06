package com.proman.backendApp.model;

import com.proman.backendApp.model.SkillLevel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(length = 250)
    private String skill_name;

    @ManyToOne
    @JoinTable(name = "user_skills", joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "level", referencedColumnName = "skill_level"))
    private SkillLevel skillLevel;

    public Skills() {

    }

    public Skills(String skill_name) {
        this.skill_name = skill_name;
    }

    public Long getId() {
        return id;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skill_level) {
        this.skillLevel = skill_level;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skill_name;
    }

    public void setSkillName(String skill_name) {
        this.skill_name = skill_name;
    }

}
