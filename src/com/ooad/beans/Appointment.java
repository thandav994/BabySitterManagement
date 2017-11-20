package com.ooad.beans;

import java.util.Date;

import com.ooad.dao.BabysitterDAOImpl;

public class Appointment {
	
	private int id;
	private AppointmentStatus status;
	private Date startDate;
	private Date endDate;
	private int babysitterID;
	private int parentID;
	private Parent parent;
	private BabySitter babysitter;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
		BabySitter temp = null;
		//TODO Fetch from database
		return temp;
	}

	public Parent getParent() {
		if (parent == null) {
			BabysitterDAOImpl daoObj = new BabysitterDAOImpl();
			parent = daoObj.GetParentInfo(parentID);
		}
		return parent;
	}
}
