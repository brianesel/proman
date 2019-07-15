
package com.proman.security.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proman.backendApp.model.Company;
import com.proman.backendApp.model.SocialMedia;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String name;

	@NotBlank
	@Size(max = 15)
	private String username;

	@Size(max = 100)
	private String phoneNumber;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@Size(max = 200)
	private String location;

	@Size(max = 250)
	private String degree;

	@NaturalId
	@NotBlank
	@Size(max = 40)
	@Email
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private SocialMedia SocialMedia;

	@NotBlank
	@JsonIgnore
	@Size(max = 100)
	private String password;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_company", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
	private Set<Company> company = new HashSet<>();

	public User() {

	}

	public User(String name, String username, String email, Date dateOfBirth, String location, String password,
			String phoneNumber, String degree, Set<Company> company, SocialMedia SocialMedia) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.company = company;
		this.dateOfBirth = dateOfBirth;
		this.location = location;
		this.degree = degree;
		this.phoneNumber = phoneNumber;
		this.SocialMedia = SocialMedia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return degree;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Company> getCompany() {
		return company;
	}

	public void setCompany(Set<Company> company) {
		this.company = company;
	}

	public SocialMedia getSocialMedia() {
		return SocialMedia;
	}

	public void setSocialMedia(SocialMedia SocialMedia) {
		this.SocialMedia = SocialMedia;
	}
}
