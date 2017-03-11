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
@Table(name="APP_CHECKLIST")
public class Checklist implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9114919190407759718L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name="TYPE", nullable=false)
	private String type;
	
	@NotEmpty
	@Column(name="ITEM", nullable=false)
	private String item;
	
	@NotEmpty
	@Column(name="SCORE", nullable=false)
	private Long score;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}
