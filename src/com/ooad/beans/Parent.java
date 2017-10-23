package com.ooad.beans;

import java.text.ParseException;
import java.util.ArrayList;

import com.ooad.dao.ParentsFunctionalityDAOImpl;

public class Parent extends User{

	public ArrayList<BabySitter> viewListofBabySitters(String appointmentDate) throws ParseException {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getListofBabySitters(appointmentDate);
	}

	public ArrayList<BabySitter> getSitterInformation(String sitterID) {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getSitterInformation();
	}

	public boolean bookAppointment(String sitterID, String appointmentDate) throws ParseException {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.bookAppointment(sitterID, appointmentDate);
	}
	
}
