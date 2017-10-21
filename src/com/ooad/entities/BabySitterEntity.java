package com.ooad.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "babysitters")
public class BabySitterEntity {
	@Id
	private int sitterID;
	
	@OneToOne
	@JoinColumn(name = "emailID")
	private LoginEntity login;
	private String firstName;
	private String lastName;
	private String gender;
	
	@Temporal(TemporalType.DATE)
    private Date dateOfBirth;

	public int getSitterID() {
		return sitterID;
	}

	public void setSitterID(int sitterID) {
		this.sitterID = sitterID;
	}

	public LoginEntity getLogin() {
		return login;
	}

	public void setLogin(LoginEntity login) {
		this.login = login;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	} 
	
	
}
