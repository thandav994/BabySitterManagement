package com.ooad.beans;

import java.util.ArrayList;

import com.ooad.dao.ParentsFunctionalityDAOImpl;

public class Parent extends User{

	public ArrayList<BabySitter> viewListofBabySitters() {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getListofBabySitters();
	}

	public ArrayList<BabySitter> getSitterInformation(String sitterID) {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getSitterInformation();
	}
	
}
