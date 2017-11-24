package com.ooad.beans;

import com.ooad.dao.LoginDAOImpl;

public class BabySitter extends User {
	private String ssn;
	private Integer hourlypay;
	private Float experience;
	private String bio;
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
	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		Login isExistingUser = loginDAO.isExistingSitter(this);
		if(isExistingUser.getPassword() == this.getPassword())
			return true;
		return false;
	}
	
	
}
