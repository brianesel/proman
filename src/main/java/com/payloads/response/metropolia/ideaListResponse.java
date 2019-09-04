package com.payloads.response.metropolia;

import java.util.List;

public class ideaListResponse {

    private Long id;
    
    private String name;

    private String description;

    private List<String> email;
    
    public ideaListResponse(Long id, String name, List<String> email, String description){
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public ideaListResponse(Long id, String name, List<String> email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

	public void setEmail(List<String> email){
		this.email = email;
	}

	public void setId (Long id){
		this.id = id;
	}

	public List<String> getEmail() {
		return email;
    }
    
	public Long getId() {
		return id;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
