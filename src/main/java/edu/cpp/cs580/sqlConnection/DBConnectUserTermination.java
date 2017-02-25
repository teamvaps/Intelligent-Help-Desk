package edu.cpp.cs580.sqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBConnectUserTermination {

	Connection con;
	Statement st;
	ResultSet resultSet;
	PreparedStatement preparedStatement;
	DBConnect dbCon;

	public DBConnectUserTermination() {
		dbCon = new DBConnect();
		con = dbCon.con;
	}

	public void getCheckList1() throws SQLException {
		ArrayList<String> list = new ArrayList();
		try {
			st = con.createStatement();
			resultSet = st.executeQuery("select * from helpdesk.usertermination");
			while (resultSet.next()) {
				int userTerminationId = resultSet.getInt("UserTerminationID");
				String employeeName = resultSet.getString("EmployeeName");
				String computerName = resultSet.getString("ComputerName");
				String date = resultSet.getString("Date");
				long ticketNumber = resultSet.getLong("TicketNumber");
				String issues = resultSet.getString("Issues");
				String resolved = resultSet.getString("Resolved");
				String comments = resultSet.getString("Comments");
				int technicianID = resultSet.getInt("TechnicianID");

				list.add(userTerminationId + "");
				list.add(employeeName);
				list.add(computerName);
				list.add(date);
				list.add(ticketNumber + "");
				list.add(issues);
				list.add(resolved + "");
				list.add(comments);
				list.add(technicianID + "");

			}
		} catch (Exception e) {
			System.out.println("Exception occurs in getting usertermination from database: " + e);
		}
	}

	public ArrayList<String> getCheckList1UsingTicketNumber(long ticketNumber) {
		ArrayList<String> list = new ArrayList();

		try {
			st = con.createStatement();
			resultSet = st.executeQuery("select * from helpdesk.usertermination where TicketNumber =" + ticketNumber);
			while (resultSet.next()) {
				int userTerminationId = resultSet.getInt("UserTerminationID");
				String employeeName = resultSet.getString("EmployeeName");
				String computerName = resultSet.getString("ComputerName");
				String date = resultSet.getString("Date");
				String issues = resultSet.getString("Issues");
				String resolved = resultSet.getString("Resolved");
				String comments = resultSet.getString("Comments");
				int technicianID = resultSet.getInt("TechnicianID");

				list.add(userTerminationId + "");
				list.add(employeeName);
				list.add(computerName);
				list.add(date);
				list.add(ticketNumber + "");
				list.add(issues);
				list.add(resolved + "");
				list.add(comments);
				list.add(technicianID + "");

			}

		} catch (Exception e) {
			System.out.println("Exception occurs in getting usertermination from database: " + e);
		}
		return list;

	}

	public ArrayList<String> getCheckList1UsingComputerName(String computerName) {
		ArrayList<String> list = new ArrayList();

		try {
			st = con.createStatement();
			resultSet = st.executeQuery("select * from helpdesk.usertermination where ComputerName ='" + computerName +"'");
	
			while (resultSet.next()) {
				int userTerminationId = resultSet.getInt("UserTerminationID");
				String employeeName = resultSet.getString("EmployeeName");
				String date = resultSet.getString("Date");
				long ticketNumber = resultSet.getLong("TicketNumber");
				String issues = resultSet.getString("Issues");
				String resolved = resultSet.getString("Resolved");
				String comments = resultSet.getString("Comments");
				int technicianID = resultSet.getInt("TechnicianID");

				list.add(userTerminationId + "");
				list.add(employeeName);
				list.add(computerName);
				list.add(date);
				list.add(ticketNumber + "");
				list.add(issues);
				list.add(resolved + "");
				list.add(comments);
				list.add(technicianID + "");
				
			
			}

		} catch (Exception e) {
			System.out.println("Exception occurs in getting usertermination from database: " + e);
		}
		return list;

	}

	public void editCheckList1(String computerName, String issues) {
		boolean status = false;

		try {
			st = con.createStatement();
			resultSet = st.executeQuery("select * from helpdesk.usertermination where ComputerName ='" + computerName +"'");
			while (resultSet.next()) {
				status = true;
			}

			if (status) {
				PreparedStatement update = con.prepareStatement(
						"UPDATE helpdesk.usertermination SET Issues = ? WHERE ComputerName ='" + computerName + "'");

				update.setString(1, issues);
				update.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println("Exception occurs in editting usertermination from database: " + e);
		}

	}

	public void insertDateIntoCheckList1ByTechnician(int userTerminationID, String employeeName, String computerName,
			String date, long ticketNumber, String issues, String resolved, String comments, int technicianID) {
		try {
			preparedStatement = con.prepareStatement("insert into helpdesk.usertermination values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, userTerminationID);
			preparedStatement.setString(2, employeeName);
			preparedStatement.setString(3, computerName);
			preparedStatement.setString(4, date);
			preparedStatement.setLong(5, ticketNumber);
			preparedStatement.setString(6, issues);
			preparedStatement.setString(7, resolved);
			preparedStatement.setString(8, comments);
			preparedStatement.setInt(9, technicianID);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occurs in inserting the data to usertermination :" + e);
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("Database connection terminated");
				} catch (Exception e) {

				}
			}
		}

	}

	public void insertDateIntoCheckList1ByEmp(int userTerminationID, String employeeName, String computerName,
			String date, long ticketNumber, String issues, int technicianID) {
		try {
			preparedStatement = con.prepareStatement("insert into helpdesk.usertermination values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, userTerminationID);
			preparedStatement.setString(2, employeeName);
			preparedStatement.setString(3, computerName);
			preparedStatement.setString(4, date);
			preparedStatement.setLong(5, ticketNumber);
			preparedStatement.setString(6, issues);
			preparedStatement.setString(7, "false");
			preparedStatement.setString(8, "Null");
			preparedStatement.setInt(9, technicianID);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occurs in inserting the data to usertermination :" + e);
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("Database connection terminated");
				} catch (Exception e) {

				}
			}
		}

	}

	public long getLastTicketNumber() {
		long ticketNum = 0;
		try {
			st = con.createStatement();
			resultSet = st.executeQuery("select * from helpdesk.usertermination");
			while (resultSet.next()) {

				ticketNum = resultSet.getLong("TicketNumber");
			}

		} catch (Exception e) {
			System.out.println("Exception occurs in getting usertermination from database: " + e);
		}
		return ticketNum;

	}

	public String getEmployeeName(long ticketNumber) {
		String employeeName = "";
		try {
			st = con.createStatement();
			resultSet = st.executeQuery("select * from helpdesk.usertermination where TicketNumber = " + ticketNumber);
			while (resultSet.next()) {

				employeeName = resultSet.getString("EmployeeName");
			}

		} catch (Exception e) {
			System.out.println("Exception occurs in getting usertermination from database: " + e);
		}
		return employeeName;

	}

	public String getDate(long ticketNumber) {
		String date = "";
		try {
			st = con.createStatement();
			resultSet = st.executeQuery("select * from helpdesk.usertermination where TicketNumber = " + ticketNumber);
			while (resultSet.next()) {

				date = resultSet.getString("Date");
			}

		} catch (Exception e) {
			System.out.println("Exception occurs in getting usertermination from database: " + e);
		}
		return date;

	}

	public int getTechnician(long ticketNumber) {
		int techID = 1;
		try {
			st = con.createStatement();
			resultSet = st.executeQuery("select * from helpdesk.usertermination where TicketNumber = " + ticketNumber);
			while (resultSet.next()) {

				techID = resultSet.getInt("TechnicianID");
			}

		} catch (Exception e) {
			System.out.println("Exception occurs in getting usertermination from database: " + e);
		}
		return techID;

	}
	
	public int getUserTerminationID(long ticketNumber) {
		int id = 0;
		try {
			st = con.createStatement();
			resultSet = st.executeQuery("select * from helpdesk.usertermination");
			while (resultSet.next()) {
				int temp = resultSet.getInt("UserTerminationID");
				if(id<temp)
					id = temp;
			}

		} catch (Exception e) {
			System.out.println("Exception occurs in getting usertermination from database: " + e);
		}
		return id+1;

	}
}
