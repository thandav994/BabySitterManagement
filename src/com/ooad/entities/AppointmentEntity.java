package com.ooad.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ooad.beans.PaymentStatus;

@Entity
@Table(name = "appointments")

public class AppointmentEntity {

	@Id
	private int appointmentid;
	
	@Temporal(TemporalType.DATE)
	private Date appointmentDate;
	private int appointmentStatus;
	
	@OneToOne
	@JoinColumn(name = "sitterID")
	private BabySitterEntity babysitter;
	
	@OneToOne
	@JoinColumn(name = "parentID")
	private ParentEntity parent;
	private Integer paymentStatus;
	public int getId() {
		return appointmentid;
	}

	public void setId(int id) {
		this.appointmentid = id;
	}

	public BabySitterEntity getBabysitter() {
		return babysitter;
	}

	public void setBabysitter(BabySitterEntity babysitter) {
		this.babysitter = babysitter;
	}

	public ParentEntity getParent() {
		return parent;
	}

	public void setParent(ParentEntity parent) {
		this.parent = parent;
	}

	public Date getDate() {
		return appointmentDate;
	}
	
	public void setDate(Date date) {
		this.appointmentDate = date;
	}

	public int getStatus() {
		return appointmentStatus;
	}

	public void setStatus(int status) {
		this.appointmentStatus = status;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}