package com.proman.backendApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill_level")
public class SkillLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int skill_level;

    public SkillLevel() {

    }

    public int getSkillLevel() {
        return skill_level;
    }

    public void setSkillLevel(int skill_level) {
        this.skill_level = skill_level;
    }

}
