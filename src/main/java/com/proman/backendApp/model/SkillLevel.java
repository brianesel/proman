package com.proman.backendApp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.proman.security.model.User;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "skillLevel")
@Entity
@Table(name = "user_skills")
public class SkillLevel {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private SkillLevelKey id;

    @ManyToOne()
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @MapsId("skill_id")
    @JoinColumn(name = "skill_id")
    private Skills skill;

    @Column(name = "skill_level")
    @Max(10)
    private int skillLevel;

    public SkillLevel() {
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public SkillLevelKey getId() {
        return id;
    }

    public void setId(SkillLevelKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // SkillLevel other = (SkillLevel) obj;
    // if (id == null) {
    // if (other.id != null)
    // return false;
    // } else if (!id.equals(other.id)){
    // return false;
    // } else if (!skill.equals(other.skill))
    // return false;
    // return true;
    // }

}
