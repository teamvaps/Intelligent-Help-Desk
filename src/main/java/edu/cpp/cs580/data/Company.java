package edu.cpp.cs580.data;

public abstract class Company {
	private String name;
	
Company(String name){
	this.name=name;
}
public String getname(){
	return this.name;
}
public void setname(String name){
	this.name=name;
}

}
