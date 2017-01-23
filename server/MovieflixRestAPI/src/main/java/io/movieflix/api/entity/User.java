package io.movieflix.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table
@NamedQueries({
@NamedQuery(name="User.findByEmail",query="SELECT u from User u where u.email=:cEmail"),
@NamedQuery(name="User.findByEmailPassword",query="SELECT u from User u where u.email=:cEmail and u.password=:cPass")})
public class User {
@Id
private String userID;
@Column(columnDefinition="VARCHAR(128)", unique=true)
private String email;
private String password;

public User()
{
	this.userID=UUID.randomUUID().toString();
}
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [userID=" + userID + ", email=" + email + ", password=" + password + "]";
}

}
