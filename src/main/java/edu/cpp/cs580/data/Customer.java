package edu.cpp.cs580.data;

public class Customer {
      
    private long id;
    private long date;
    private long check1;
    private String firstname;
    private String lastname;
      
  
    public long getId() {
        return id;
    }
  
    public void setId(long id) {
        this.id = id;
    }
    
    public long getdate() {
        return date;
    }
  
    public void setdate(long date) {
        this.date = date;
    }
  
    public String getFirstname() {
        return firstname;
    }
  
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
  
    public String getLastname() {
        return lastname;
    }
  
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public long getcheck1() {
        return check1;
    }
  
    public void setcheck1(long check1) {
        this.check1 = check1;
    }
  
}