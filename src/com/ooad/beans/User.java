package com.ooad.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ooad.dao.LoginDAOImpl;

@Component
@Scope("session")
public class User {
	private String email;
	private String password;
	private String category;
	private String firstName;
	private String lastName;
	private String birthday;
	private String gender;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean login() {
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		boolean isExistingUser = loginDAO.isExistingUser(this);
		if(isExistingUser)
			return true;
		return false;
		
	}
	
}
