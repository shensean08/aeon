package edu.kgu.aeon.Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.kgu.aeon.bean.messageBean;
import edu.kgu.log.LogLogger;

public abstract class BaseAction extends ActionSupport implements SessionAware {	
	private Map session;
	
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
	
	public void setSession(Map session) {
        this.session = session;
    }
	
	protected void getAppSession() {
		this.userID = (String)this.session.get("userID");
		this.userName = (String)this.session.get("userName");
//		LogLogger.info("session userid:" + this.userID);
//		LogLogger.info("session userName:" + this.userName);
	}
	
	protected void setAppSession() {
	    this.session.put("userID",this.userID);
	    this.session.put("userName",this.userName);
	}
	
	public abstract String execute();
}
