package com.proman.backendApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class SkillLevelKey implements Serializable {

    private static final long serialVersionUID = 2794197554601834898L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long skillId;

    public SkillLevelKey() {
    }

    public void setId(Long userId, Long skillId) {
        this.userId = userId;
        this.skillId = skillId;
    }

    public Long getuserId() {
        return userId;
    }

    public Long getskillId() {
        return skillId;
    }

    public void setuserId(Long userId) {
        this.userId = userId;
    }

    public void setskillId(Long skillId) {
        this.skillId = skillId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SkillLevelKey other = (SkillLevelKey) obj;
        if (skillId == null) {
            if (other.skillId != null)
                return false;
        } else if (!skillId.equals(other.skillId))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

}