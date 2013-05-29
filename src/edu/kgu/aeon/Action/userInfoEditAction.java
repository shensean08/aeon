package edu.kgu.aeon.Action;

import edu.kgu.aeon.bean.registerFormBean;
import edu.kgu.aeon.logic.userInfoEditLogic;

public class userInfoEditAction extends BaseAction {
	private userInfoEditLogic logic = new userInfoEditLogic();
	
	private String userID;
	private String userName;
	private String infoParten;
	
	private registerFormBean userInfoBean;
	
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
	
	public String getInfoParten() {
		return infoParten;
	}

	public void setInfoParten(String infoParten) {
		this.infoParten = infoParten;
	}

	public registerFormBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(registerFormBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}

	@Override
	public String execute() {
		String rtn = "BASEINFO";
		userInfoBean = logic.execute(userID);
		
		if (infoParten.equals("base")) {
			rtn = "BASEINFO";
		}
		
		if (infoParten.equals("address1")) {
			rtn = "ADDRESS1";
		}
		
		if (infoParten.equals("address2")) {
			rtn = "ADDRESS2";
		}
		
		if (infoParten.equals("address3")) {
			rtn = "ADDRESS3";
		}
		
		if (infoParten.equals("address4")) {
			rtn = "ADDRESS4";
		}
		
		if (infoParten.equals("address5")) {
			rtn = "ADDRESS5";
		}
		
		return rtn;
	}
}
