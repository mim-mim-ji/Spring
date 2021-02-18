package com.spring.web.model;

import java.util.List;

public class UserVO {

	private String userID;
	private String userPW;
	private String userNAME;
	private List<String> hobby;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getUserNAME() {
		return userNAME;
	}
	public void setUserNAME(String userNAME) {
		this.userNAME = userNAME;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	
	@Override
	public String toString() {
		return "UserVO [userID=" + userID + ", userPW=" + userPW + ", userNAME=" + userNAME + ", hobby=" + hobby + "]";
	}
	
	
	
	
}





