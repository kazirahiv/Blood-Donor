package entities;

import java.lang.*;


public class Donor
{
	private String name,addressArea,phoneNumber,email,password;
	int id,isDonor;
	
	public Donor(){}

	public Donor(int id, String name, String addressArea, String phoneNumber, String email, String password)
	{
        this.id = id;
        this.name = name;
        this.addressArea = addressArea;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
	}


	public void print(){
		System.out.print("Id "+id);
		System.out.println("Name "+name);
		System.out.println("Address Area "+addressArea);
		System.out.println("Phone Number "+phoneNumber);
		System.out.println("Email "+email);
		System.out.println("Password "+password);
	}
	
    //public void setUserId(String id){this.id = id;}
    //public void setPassword(String password){this.password = password;}
	//public void setStatus(int status){this.status = status;}
	
	public String getEmail(){return email;}
	public String getPassword(){return password;}
	//public int getStatus(){return status;}
}