package com.library.libraryService.modules;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the user")
public class User {

	@ApiModelProperty(notes = "The unique ID of the user")
	private int userId;
	@ApiModelProperty(notes = "The username chose by the user")
	private String username;
	@ApiModelProperty(notes = "Users last name")
	private String userLastName;
	@ApiModelProperty(notes = "Users first name")
	private String userFirstName;
	@ApiModelProperty(notes = "Users phone number")
	private String userPhoneNumber;
	@ApiModelProperty(notes = "Password chose by the user")
	private String password;
	@ApiModelProperty(notes = "Users email address")
	private String userEmailAddress;

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

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", userLastName=" + userLastName
				+ ", userFirstName=" + userFirstName + ", userPhoneNumber=" + userPhoneNumber + ", password=" + password
				+ ", userEmailAddress=" + userEmailAddress + "]";
	}

}
