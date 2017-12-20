package com.ooad.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
		if(isExistingUser!=null) {
			if(isExistingUser.getPassword().contentEquals(this.getPassword())) {
				System.out.println("Verified password");
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<BabySitter> viewListofBabySitters(String appointmentDate, String name, String gender) throws ParseException {

		// TODO Auto-generated method stub

		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();

		return parentDAO.getListofBabySitters(appointmentDate, name, gender);

	}

	public BabySitter getSitterInformation(String sitterID) {
		// TODO Auto-generated method stub

		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.getSitterInformation(sitterID);
	}


	public boolean bookAppointment(BabySitter sitter, String appointmentDate) throws ParseException {

		// TODO Auto-generated method stub

		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(appointmentDate);
		appointment.setParent(this);
		appointment.setSitter(sitter);
		return parentDAO.bookAppointment(appointment);
	}

	public ArrayList<Appointment> getAppointmentsList() throws ParseException {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		ArrayList<Appointment> appointmentsList = parentDAO.getAppointmentsList(this);
//		if (appointmentsList != null) {
//			for (int i = 0; i<appointmentsList.size(); i++) {
//				Appointment cur = appointmentsList.get(i);
//				Date appointmentDateFormatted = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(cur.getAppointmentDate());
//				/* If the appointment date has passed, then update to 'Completed' */
//				if (cur.getStatus() == AppointmentStatus.Accepted &&
//						appointmentDateFormatted.before(Calendar.getInstance().getTime())) {
//					cur.setStatus(AppointmentStatus.Completed);
//					parentDAO.saveAppointment(cur);
//				}
//				/* If the appointment is in 'Pending' beyond date then update it to 'Rejected' */
//				else if (cur.getStatus() == AppointmentStatus.Pending &&
//						appointmentDateFormatted.before(Calendar.getInstance().getTime()))  {
//					cur.setStatus(AppointmentStatus.Rejected);
//					parentDAO.saveAppointment(cur);
//				}
//			}
//		}
		return appointmentsList;
	}

	public boolean cancelAppointment(Integer appointmentID) {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.cancelAppointment(appointmentID);
	}

	public boolean rateaSitter(BabySitter sitter, Integer rating) {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		return parentDAO.rateaSitter(this, sitter, rating);
	}

	public boolean makePayment(Integer appointmentID) {
		// TODO Auto-generated method stub
		ParentsFunctionalityDAOImpl parentDAO = new ParentsFunctionalityDAOImpl();
		Appointment appointment = new Appointment();
		appointment.setId(appointmentID);
		return parentDAO.makePayment(appointment);
	}

}
