package com.payloads;

import java.io.IOException;
import java.sql.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.multipart.MultipartFile;
import com.proman.backendApp.model.CVStorage;
import com.proman.backendApp.model.Company;
import com.proman.backendApp.model.SkillLevel;
import com.proman.backendApp.model.SocialMedia;

public class SignUpRequest {

	@NotBlank
	@Size(min = 4, max = 40)
	private String name;

	@NotBlank
	@Size(min = 3, max = 15)
	private String username;

	@NotBlank
	@Size(max = 40)
	@Email
	private String email;

	@Size(max = 100)
	private String phoneNumber;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@Size(max = 200)
	private String location;

	@Size(max = 250)
	private String degree;

	@NotBlank
	@Size(min = 6, max = 20)
	private String password;

	private SocialMedia SocialMedia;

	private Set<Company> company;

	private Set<SkillLevel> skills;

	private MultipartFile profilePicture;

	private MultipartFile cvFile;

	private MultipartFile motiLetter;

	private CVStorage cvStorage;

	public Set<Company> getCompany() {
		return company;
	}

	public void setCompany(Set<Company> company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDegree() {
		return location;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SocialMedia getSocialMedia() {
		return SocialMedia;
	}

	public void setSocialMedia(SocialMedia SocialMedia) {
		this.SocialMedia = SocialMedia;
	}

	public Set<SkillLevel> getSkills() {
		return skills;
	}

	public void setSkills(Set<SkillLevel> skillLevels) {
		this.skills = skillLevels;
	}

	public void setCvStorage(CVStorage cvStorage) {
		this.cvStorage = cvStorage;
	}

	public CVStorage getCvStorage() throws IOException {
		return cvStorage;
	}
}
