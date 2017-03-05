package com.teamvaps.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="APP_USER")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3249871809322945675L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@NotEmpty
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@NotEmpty
	@Column(name="ROLE", nullable=false)
	private String role;
	
	@NotEmpty
	@Column(name="EMAIL", nullable=false)
	private String email;

	@NotEmpty
	@Column(name="PHONE", nullable=false)
	private String phone;
	
	//@Column(name="TIME", nullable=true)
	//private Timestamp time;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//public Timestamp getTime() {
		//return time;
	//}
}
