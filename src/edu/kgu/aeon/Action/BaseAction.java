package edu.kgu.aeon.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.kgu.aeon.bean.messageBean;

public abstract class BaseAction extends ActionSupport implements ServletRequestAware {
	public messageBean messagebean = new messageBean();
	public HttpServletRequest request;
	public HttpServletResponse response;
	
	public messageBean getMessagebean() {
		return messagebean;
	}

	public void setMessagebean(messageBean messagebean) {
		this.messagebean = messagebean;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
 
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getServletResponse() {
		return this.response;
	}	

	public abstract String execute();
}
