package edu.cpp.cs580.data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ModelAttribute;

@Entity
@Table(name = "user_termination")
public class BitLockerEntity {
    private String ticket;
    private String date;
    private String tech;
    @Id
    private String computerName;
    private String jsonChecklist;
    
	@Column(name="ticket", columnDefinition="varchar(255)")
    public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	@Column(name="date", columnDefinition="varchar(255)")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Column(name="tech", columnDefinition="varchar(255)")
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	@Column(name="computer_name", columnDefinition="varchar(255)")	
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	
	@Column(name="json_checklist", columnDefinition="text")	
	public String getJsonChecklist() {
		return jsonChecklist;
	}
	public void setJsonChecklist(String jsonChecklist) {
		this.jsonChecklist = jsonChecklist;
	}
}