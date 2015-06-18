package chapter5;
import java.io.*;
/**
 * BAO DOAN
 * CIS 144
 * Professor Kevin Truong
 * Program: Employee.java
 * Purpose: An external class which creates a programmer-defined employee record
			when it is called.
 * Date: 11/18/2013
 * 
  */
	public class Employee {
	
	private String FirstName;
	private String LastName;
	private String Position;
	private float Rate;
	private float Hours;
	
	public Employee(String f, String l, String p, float r, float h){
		FirstName = f;
		LastName = l;
		Position = p;
		Rate = r;
		Hours = h;		
	}
	
	public Employee(String l, String f, String p){
		LastName=l;
		FirstName = f;
		Position = p;
	}
	
	public String getFirstName(){
		return FirstName;
	}
	
public String getLastName(){
		return LastName;
	}

public String getPosition(){
	return Position;
}

public float getRate(){
	return Rate;
}

public float getHours(){
	return Hours;
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
