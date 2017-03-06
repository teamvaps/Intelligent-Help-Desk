package com.teamvaps.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name="APP_TICKET")
public class Ticket implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 834077464990770686L;
	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="AUTHORID", nullable=false)
	private Long authorid;
	
	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@NotEmpty
	@Column(name="DESCR", nullable=false)
	private String descr;
	
	@NotEmpty
	@Column(name="TYPE", nullable=false)
	private String type;

	@NotEmpty
	@Column(name="STATUS", nullable=false)
	private String status;
	
	@NotNull
	@Column(name="AGENTID", nullable=false)
	private Long agentid;
	
	@NotEmpty
	@Column(name="AGENTCOMMENTS", nullable=false)
	private String agentcomments;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Long authorid) {
		this.authorid = authorid;
	}

	public String getName() {
		return name;
	}

	public void setTitle(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getAgentcomments() {
		return agentcomments;
	}

	public void setAgentcomments(String agentcomments) {
		this.agentcomments = agentcomments;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAgentid() {
		return agentid;
	}

	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}
	
	//@Column(name="TIME", nullable=true)
	//private Timestamp time;

}
