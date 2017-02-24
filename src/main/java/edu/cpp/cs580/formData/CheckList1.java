package edu.cpp.cs580.formData;

import java.util.ArrayList;
import java.util.Date;

import edu.cpp.cs580.data.Company;
import edu.cpp.cs580.data.Customer;
import edu.cpp.cs580.data.User;

public class CheckList1 {

	public int userTerminationId=1;
	public String employeeName;
	public String computerName;
	public String date;
	public long ticketNumber = 10000;
	public String issues;
	public String resolved = "false";
	public String comments = "Null";
	public int technicianID = 1;
	public boolean issue1;
	public boolean issue2;
	public boolean issue3;
	public boolean issue4;
	public boolean issue5;
	
	
	public CheckList1(){
		
	}
	
	public CheckList1(int userTerminationID, String employeeName, String computerName, String date, long ticketNumber, String issues, int technicianID ){
		this.userTerminationId = userTerminationID;
		this.employeeName = employeeName;
		this.computerName = computerName;
		this.date = date;
		this.ticketNumber = ticketNumber;
		this.issues = issues;
		this.technicianID = technicianID;
		
	}
	
	public CheckList1(int userTerminationID, String employeeName, String computerName, String date, long ticketNumber, String issues, String resolved, String comments, int technicianID ){
		this.userTerminationId = userTerminationID;
		this.employeeName = employeeName;
		this.computerName = computerName;
		this.date = date;
		this.ticketNumber = ticketNumber;
		this.issues = issues;
		this.resolved = resolved;
		this.comments = comments;
		this.technicianID = technicianID;
		
	}
	


	public int getUserTerminationId() {
		return userTerminationId;
	}

	public void setUserTerminationId(int userTerminationId) {
		this.userTerminationId = userTerminationId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public void setModifiedComputerName(String employeeName, long ticketNumber) {
		this.computerName = employeeName + "" + ticketNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getIssues() {
		return issues;
	}

	public void setIssues(String issues) {
		this.issues = issues;
	}

	public String isResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getTechnicianID() {
		return technicianID;
	}

	public void setTechnicianID(int technicianID) {
		this.technicianID = technicianID;
	}

	public boolean isIssue1() {
		return issue1;
	}

	public void setIssue1(boolean issue1) {
		this.issue1 = issue1;
	}

	public boolean isIssue2() {
		return issue2;
	}

	public void setIssue2(boolean issue2) {
		this.issue2 = issue2;
	}

	public boolean isIssue3() {
		return issue3;
	}

	public void setIssue3(boolean issue3) {
		this.issue3 = issue3;
	}

	public boolean isIssue4() {
		return issue4;
	}

	public void setIssue4(boolean issue4) {
		this.issue4 = issue4;
	}

	public boolean isIssue5() {
		return issue5;
	}

	public void setIssue5(boolean issue5) {
		this.issue5 = issue5;
	}
	

	
	
}
