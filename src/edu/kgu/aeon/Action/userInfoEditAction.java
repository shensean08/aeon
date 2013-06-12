package edu.kgu.aeon.Action;

import edu.kgu.aeon.bean.registerFormBean;
import edu.kgu.aeon.logic.userInfoEditLogic;
import edu.kgu.log.LogLogger;

public class userInfoEditAction extends BaseAction {

	private userInfoEditLogic logic = new userInfoEditLogic();
	
	private registerFormBean userInfoBean;
	
	private String infoParten;
	
	public registerFormBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(registerFormBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}
	
	public String getInfoParten() {
		return infoParten;
	}

	public void setInfoParten(String infoParten) {
		this.infoParten = infoParten;
	}
	
	public String execute() {
		String rtn = "BASEINFO";
		LogLogger.info(this.getUserID());
		LogLogger.info(this.getUserName());
		LogLogger.info(this.getUserInfoBean().getMailAddress());
		
		userInfoBean.setUserID(this.getUserID());
		userInfoBean.setUserName(this.getUserName());

		
		if (logic.execute(userInfoBean, infoParten)) {
			rtn = SUCCESS;
		} else {
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
		}

		this.setMessagebean(logic.messagebean);
		return rtn;
	}

}
