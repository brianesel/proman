package com.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class IdeaSubmission {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String description;

    @NotBlank
    private String nickname;

    @NotBlank
	private String subject;
	
	public void setEmail(String email){
		this.email = email;
	}

	public void setNickname (String nickname){
		this.nickname = nickname;
	}

	public void setSubject (String subject){
		this.subject = subject;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public String getNickName(){
		return nickname;
	}

	public String getDescription(){
		return description;
	}

	public String getSubject() {
		return subject;
	}
}
