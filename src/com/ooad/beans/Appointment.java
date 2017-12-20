package com.ooad.beans;

public class Appointment {
	
	private int id;
	private String appointmentDate;
	private AppointmentStatus status;
	private Parent parent;
	private BabySitter babysitter;
	private PaymentStatus paymentStatus;
	
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
		return babysitter;
	}

	public void setSitter(BabySitter sitter) {
		this.babysitter = sitter;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}	
	
	
	
}
