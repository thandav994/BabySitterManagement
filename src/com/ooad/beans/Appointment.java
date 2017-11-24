package com.ooad.beans;


public class Appointment {
	
	private int id;
	private String appointmentDate;
	private BabySitter sitter;
	private Parent parent;
	private AppointmentStatus status;

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

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public BabySitter getSitter() {
		return sitter;
	}

	public void setSitter(BabySitter sitter) {
		this.sitter = sitter;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}	
}
