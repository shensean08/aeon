package edu.kgu.aeon.Action;

import com.opensymphony.xwork2.ActionSupport;

import edu.kgu.aeon.bean.messageBean;

public abstract class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 5832517917760933647L;
	
	private String userID;
	private String userName;
	private messageBean messagebean = new messageBean();
	
	public messageBean getMessagebean() {
		return messagebean;
	}

	public void setMessagebean(messageBean messagebean) {
		this.messagebean = messagebean;
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
	
	public abstract String execute();
}
