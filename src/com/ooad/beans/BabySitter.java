package com.ooad.beans;

import com.ooad.dao.BabysitterDAOImpl;

public class BabySitter extends User {
	
	private int experience;
	private float hourlyPay;
	private String info;

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public float getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(float hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Appointment[] getListOfAppointments() {
		BabysitterDAOImpl daoObj = new BabysitterDAOImpl();
		return daoObj.getListOfAppointments(this);
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
}
