
// package com.proman.security.model;

// import java.util.HashSet;
// import java.util.Set;

// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
// import javax.persistence.Table;
// import javax.validation.constraints.Email;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.Size;

// import org.hibernate.annotations.NaturalId;

// @Entity
// @Table(name = "users_info")
// public class UserInfo {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;

// private String linkedIn;
// private String occupation;
// private String workplace;
// private String profileImage;
// private String externalCV;

// @ManyToMany(fetch = FetchType.LAZY)
// @JoinTable(name = "users", joinColumns = @JoinColumn(name = "user_id"),
// inverseJoinColumns = @JoinColumn(name = "role_id"))
// private Set<Role> roles = new HashSet<>();

// public UserInfo() {

// }

// public UserInfo(String linkedIn, String occupation, String workplace, String
// password) {
// this.linkedIn = linkedIn;
// this.occupation = occupation;
// this.workplace = workplace;
// }

// public Long getId() {
// return id;
// }

// public void setId(Long id) {
// this.id = id;
// }

// public String getlinkedIn() {
// return linkedIn;
// }

// public void setlinkedIn(String linkedIn) {
// this.linkedIn = linkedIn;
// }

// public String getOccupation() {
// return occupation;
// }

// public void setOccupation(String occupation) {
// this.occupation = occupation;
// }

// public String getWorkPlace() {
// return workplace;
// }

// public void setWorkPlace(String workplace) {
// this.workplace = workplace;
// }

// }
