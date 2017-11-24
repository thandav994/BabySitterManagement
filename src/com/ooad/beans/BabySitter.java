package com.ooad.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.ooad.dao.BabysitterDAOImpl;
import com.ooad.dao.LoginDAOImpl;

public class BabySitter extends User {
	
	private float experience;
	private int hourlyPay;
	private String info;
	private String ssn;
	private String bio;
	
	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public int getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(int hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	public ArrayList<Appointment> getListOfAppointments() throws ParseException{
		BabysitterDAOImpl daoObj = new BabysitterDAOImpl();
		ArrayList<Appointment> list = daoObj.getListOfAppointments(this);
		if (list != null) {
			for (int i = 0; i<list.size(); i++) {
				Appointment cur = list.get(i);
				Date appointmentDateFormatted = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(cur.getAppointmentDate());
				/* If the appointment date has passed, then update to 'Completed' */
				if (cur.getStatus() == AppointmentStatus.Accepted &&
						appointmentDateFormatted.before(Calendar.getInstance().getTime())) {
					cur.setStatus(AppointmentStatus.Completed);
					daoObj.saveAppointment(cur);
				}
				/* If the appointment is in 'Pending' beyond date then update it to 'Rejected' */
				else if (cur.getStatus() == AppointmentStatus.Pending &&
						appointmentDateFormatted.before(Calendar.getInstance().getTime()))  {
					cur.setStatus(AppointmentStatus.Rejected);
					daoObj.saveAppointment(cur);
				}
			}
		}
		return list;
	}
	
	public void updateBabySitterApproval(Appointment app, Boolean approval) {
		BabysitterDAOImpl daoObj = new BabysitterDAOImpl();
		if(app.getStatus() == AppointmentStatus.Pending) {
			if (approval) {
				app.setStatus(AppointmentStatus.Accepted);
			} else {
				app.setStatus(AppointmentStatus.Rejected);
			}
			daoObj.saveAppointment(app);
		}
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
