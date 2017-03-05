//package com.teamvaps.app.model;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import java.io.Serializable;
//
//
//import org.hibernate.validator.constraints.NotEmpty;
//
//public class Kb implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -6055604067393026873L;
//
//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	private Long id;
//	
//	@NotEmpty
//	@Column(name="TITLE", nullable=false)
//	private String title;
//	
//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//
//	public String getTitle() {
//		return title;
//	}
//
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//
//	public String getDesc() {
//		return desc;
//	}
//
//
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}
//
//
//	public String getAuthorid() {
//		return authorid;
//	}
//
//
//	public void setAuthorid(String authorid) {
//		this.authorid = authorid;
//	}
//
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//
//	@NotEmpty
//	@Column(name="DESC", nullable=false)
//	private String desc;
//
//	
//	@NotEmpty
//	@Column(name="AUTHORID", nullable=false)
//	private String authorid;
//
//
//}
