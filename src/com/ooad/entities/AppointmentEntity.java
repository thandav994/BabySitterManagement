package com.ooad.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")

public class AppointmentEntity {

	@Id
	private int id;
	private Date date;
	private int status;
	
	@OneToOne
	@JoinColumn(name = "sitterID")
	private BabySitterEntity babysitter;
	
	@OneToOne
	@JoinColumn(name = "parentID")
	private ParentEntity parent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}