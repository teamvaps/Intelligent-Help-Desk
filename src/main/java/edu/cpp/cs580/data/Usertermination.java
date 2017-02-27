package edu.cpp.cs580.data;

import org.springframework.web.bind.annotation.ModelAttribute;
import javax.persistence.*;

public class Usertermination {

    private String ticket;
    private String date;
    private String tech;
    private String computerName;
    // Checkboxes
    private Boolean C1;
    private Boolean C2;
    private Boolean C3;
    private Boolean C4;
    private Boolean C5;
        
    
    @ModelAttribute("tech")   
    public String getTech() {
        return this.tech;
    }
  
    @ModelAttribute("tech")
    public void setTech(String Tech) {
        this.tech = Tech;
    }
    
	@ModelAttribute("computerName")
	public String getComputerName() {
		return this.computerName;
	}
	
	@ModelAttribute("computerName")
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	@ModelAttribute("ticket")
	public String getTicket() {
		return this.ticket;
	}

	@ModelAttribute("ticket")
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	@ModelAttribute("date")
	public String getDate() {
		return date;
	}

	@ModelAttribute("date")
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	@ModelAttribute("C1")
	public Boolean getC1() {
		return C1;
	}

	@ModelAttribute("C1")
	public void setC1(Boolean c1) {
		this.C1 = c1;
	}
	@ModelAttribute("C2")
	public Boolean getC2() {
		return C2;
	}
	
	@ModelAttribute("C2")
	public void setC2(Boolean c2) {
		this.C2 = c2;
	}
	@ModelAttribute("C3")
	public Boolean getC3() {
		return C3;
	}
	
	@ModelAttribute("C3")
	public void setC3(Boolean c3) {
		this.C3 = c3;
	}
	@ModelAttribute("C4")
	public Boolean getC4() {
		return C4;
	}
	
	@ModelAttribute("C4")
	public void setC4(Boolean c4) {
		this.C4 = c4;
	}
	@ModelAttribute("C5")
	public Boolean getC5() {
		return C5;
	}
	
	@ModelAttribute("C5")
	public void setC5(Boolean c5) {
		this.C5 = c5;
	}
}