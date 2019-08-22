package com.proman.backendApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;

@Entity
@Table(name = "cv_storage")
public class CVStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Lob
    private byte[] cv;

    @JsonIgnore
    @Lob
    private byte[] motiLetter;

    @JsonIgnore
    @Lob
    private byte[] profilePicture;

    public CVStorage (byte[] profilePicture, byte[] cv, byte[] motiLetter) {
        this.profilePicture = profilePicture;
        this.cv = cv;
        this.motiLetter = motiLetter;
    }

    public CVStorage() {
	}

	public byte[] getMotiLetter() {
        return motiLetter;
    }

    public void setMotiLetter(byte[] motiLetter) {
        this.motiLetter = motiLetter;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public byte[] getCV() {
        return cv;
    }

    public void setCV(byte[] cv) {
        this.cv = cv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
