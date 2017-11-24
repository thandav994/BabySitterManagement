package com.ooad.entities;

import java.math.BigInteger;
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
	private String ssn;
	private Integer hourlypay;
	private String address;
	private Integer zipcode;
	private BigInteger phone;
	private Float experience;
	private String bio;
	
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Integer getHourlypay() {
		return hourlypay;
	}

	public void setHourlypay(Integer hourlypay) {
		this.hourlypay = hourlypay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public Float getExperience() {
		return experience;
	}

	public void setExperience(Float experience) {
		this.experience = experience;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	} 
	
	
}
