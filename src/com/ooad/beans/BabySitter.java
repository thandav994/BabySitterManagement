package com.ooad.beans;

import java.util.ArrayList;
import java.util.Calendar;

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

	public ArrayList<Appointment> getListOfAppointments() {
		BabysitterDAOImpl daoObj = new BabysitterDAOImpl();
		ArrayList<Appointment> list = daoObj.getListOfAppointments(this);
		if (list != null) {
			for (int i = 0; i<list.size(); i++) {
				Appointment cur = list.get(i);
				/* If the appointment date has passed, then update to 'Completed' */
				if (cur.getStatus() == AppointmentStatus.Accepted &&
						cur.getDate().before(Calendar.getInstance().getTime())) {
					cur.setStatus(AppointmentStatus.Completed);
					daoObj.saveAppointment(cur);
				}
				/* If the appointment is in 'Pending' beyond date then update it to 'Rejected' */
				else if (cur.getStatus() == AppointmentStatus.Pending &&
						cur.getDate().before(Calendar.getInstance().getTime()))  {
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
}
