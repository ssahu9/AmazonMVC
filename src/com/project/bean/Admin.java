package com.project.bean;

public class Admin {
	private String mail; // to store the mail address
	private String password; //to store the password of admin

	
	//constructor used to fetch values for further processing
	public Admin(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public Admin() {

	}
	
	//toString() method used to return the above mentioned values:
	@Override
	public String toString() {
		return "Admin [mail=" + mail + ", password=" + password + "]";
	}

	
	//setters and getters for above mentioned fields:
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
