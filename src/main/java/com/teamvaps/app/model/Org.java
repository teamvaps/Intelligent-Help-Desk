package com.teamvaps.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="APP_ORG")
public class Org implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7601657609401777076L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@NotEmpty
	@Column(name="CONTACT", nullable=false)
	private String contact;
	
	@NotEmpty
	@Column(name="LOCATION", nullable=false)
	private String location;
	
	@NotEmpty
	@Column(name="AUTHORID", nullable=false)
	private Long authorid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Long authorid) {
		this.authorid = authorid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
