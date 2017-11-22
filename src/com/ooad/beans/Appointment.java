package com.ooad.beans;

import java.util.Date;

import com.ooad.dao.BabysitterDAOImpl;

public class Appointment {
	
	private int id;
	private AppointmentStatus status;
	private Date date;
	private int babysitterID;
	private int parentID;
	private Parent parent;
	private BabySitter babysitter;
	
	public Appointment() {
		
	}
	
	public Appointment (int babysitterID, int parentID, Date date, AppointmentStatus status) {
		this.babysitterID = babysitterID;
		this.parentID = parentID;
		this.date = date;
		this.status = status;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date startDate) {
		this.date = startDate;
	}

	public int getBabysitterID() {
		return babysitterID;
	}

	public void setBabysitterID(int babysitterID) {
		this.babysitterID = babysitterID;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	
	public BabySitter getBabysitter() {
		if (babysitter == null) {
			//TODO Fetch from database
		}
		return babysitter;
	}

	public Parent getParent() {
		if (parent == null) {
			BabysitterDAOImpl daoObj = new BabysitterDAOImpl();
			parent = daoObj.getParentInfo(parentID);
		}
		return parent;
	}
}
