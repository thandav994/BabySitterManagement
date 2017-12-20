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
	private int reviewID;
	
	@OneToOne
	@JoinColumn(name = "sitterID")
	private BabySitterEntity sitter;
	
	@OneToOne
	@JoinColumn(name = "parentID")
	private ParentEntity parent;
	
	private Integer rating;

	public BabySitterEntity getSitter() {
		return sitter;
	}

	public void setSitter(BabySitterEntity babysitter) {
		this.sitter = babysitter;
	}

	public ParentEntity getParent() {
		return parent;
	}

	public void setParent(ParentEntity parent) {
		this.parent = parent;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
