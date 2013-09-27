package edu.kgu.aeon.bean;

public class registerConfirmFormBean {
	public String userID = "";
	public String userName = "";
	public String firstName = "";
	public String qrImage = "";
	public String password = "";
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getQrImage() {
		return qrImage;
	}
	public void setQrImage(String qrImage) {
		this.qrImage = qrImage;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
