package com.ooad.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class ReviewsEntity {
	@Id
	private Integer reviewID;
	
	@OneToOne
	@JoinColumn(name = "sitterID")
	private BabySitterEntity babysitter;
	
	@OneToOne
	@JoinColumn(name = "parentID")
	private ParentEntity parent;
	
	private Integer rating;

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

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
}
