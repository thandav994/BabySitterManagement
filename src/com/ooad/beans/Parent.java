package com.ooad.beans;

import java.text.ParseException;
import java.util.ArrayList;

import com.ooad.dao.LoginDAOImpl;
import com.ooad.dao.ParentsFunctionalityDAOImpl;

public class Parent extends User{
	private String special_requests;
	
	public String getSpecial_requests() {
		return special_requests;
	}

	public void setSpecial_requests(String special_requests) {
		this.special_requests = special_requests;
	}
	
	public boolean login() {
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		Login isExistingUser = loginDAO.isExistingParent(this);
		if(isExistingUser.getPassword() == this.getPassword())
			return true;
		return false;
	}
	
	public ArrayList<BabySitter> viewListofBabySitters(String appointmentDate) throws ParseException {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getListofBabySitters(appointmentDate);
	}

	public BabySitter getSitterInformation(String sitterID) {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getSitterInformation(sitterID);
	}

	public boolean bookAppointment(String sitterID, String appointmentDate) throws ParseException {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.bookAppointment(this,sitterID, appointmentDate);
	}

	public ArrayList<Appointment> getAppointmentsList() {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getAppointmentsList(this);
	}

	public boolean cancelAppointment(Integer appointmentID) {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.cancelAppointment(appointmentID);
	}
	
}
