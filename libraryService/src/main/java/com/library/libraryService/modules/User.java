package com.library.libraryService.modules;

public class User {

	private int userId;
	private String username;
	private String userLastName;
	private String userFirstName;
	private String userPhoneNumber;
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserLastName() {
		return userLastName;
	}
	
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public String getUserFirstName() {
		return userFirstName;
	}
	
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", userLastName=" + userLastName
				+ ", userFirstName=" + userFirstName + ", userPhoneNumber=" + userPhoneNumber + ", password=" + password
				 + "]";
	}
}
