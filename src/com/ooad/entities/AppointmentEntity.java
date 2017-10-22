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
	private Date startDate;
	private Date endDate;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}