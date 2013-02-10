package edu.kgu.aeon.Action;

import com.opensymphony.xwork2.ActionSupport;

import edu.kgu.aeon.bean.messageBean;

public abstract class BaseAction extends ActionSupport {
	public messageBean messagebean = new messageBean();
	
	public messageBean getMessagebean() {
		return messagebean;
	}

	public void setMessagebean(messageBean messagebean) {
		this.messagebean = messagebean;
	}

	public abstract String execute();
}
