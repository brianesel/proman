package com.payloads.request.metropolia;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class IdeaSearch {

	@NotBlank
	@Email
	private String email;

	private int Id;

	private Long id = new Long(Id);
	
	public void setEmail(String email){
		this.email = email;
	}

	public void setId (Long id){
		this.id = id;
	}

	public String getEmail() {
		return email;
    }
    
	public Long getId() {
		return id;
	}
}
