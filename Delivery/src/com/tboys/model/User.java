package com.tboys.model;

public class User {

	private String accout;
	private String password;

	public User() {
		super();
	}
	
	public User(String accout, String password) {
		super();
		this.accout = accout;
		this.password = password;
	}

	public String getAccout() {
		return accout;
	}

	public void setAccout(String accout) {
		this.accout = accout;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [ " +" accout=" + accout + ", password=" + password + "]";
	}
}
