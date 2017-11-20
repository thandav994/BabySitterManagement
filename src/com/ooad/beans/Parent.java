package com.ooad.beans;

import java.util.ArrayList;

import com.ooad.dao.ParentsFunctionalityDAOImpl;

public class Parent extends User{
	
	private int babyAge;

	public ArrayList<BabySitter> viewListofBabySitters() {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getListofBabySitters();
	}

	public BabySitter getSitterInformation(String sitterID) {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getSitterInformation();
	}

	public int getBabyAge() {
		return babyAge;
	}

	public void setBabyAge(int babyAge) {
		this.babyAge = babyAge;
	}
	
}
