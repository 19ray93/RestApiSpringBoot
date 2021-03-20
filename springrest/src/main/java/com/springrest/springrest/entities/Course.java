package com.springrest.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	private long id;
	private String titleString;
	private String description;	

	public Course() {
		super();
	}
	
	public Course(long id, String titeString, String description) {
		super();
		this.id = id;
		this.titleString = titeString;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitleString() {
		return titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", titleString=" + titleString + ", description=" + description + "]";
	}
}

