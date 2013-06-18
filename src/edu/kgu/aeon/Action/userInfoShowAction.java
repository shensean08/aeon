package edu.kgu.aeon.Action;

import edu.kgu.aeon.bean.registerFormBean;
import edu.kgu.aeon.logic.userInfoEditLogic;
import edu.kgu.log.LogLogger;

public class userInfoShowAction extends BaseAction {
	private userInfoEditLogic logic = new userInfoEditLogic();
	
	private String infoParten;
	
	private registerFormBean userInfoBean;

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

	public String execute() {
		String rtn = "BASEINFO_SHOW";
		LogLogger.info("infoParten:" + infoParten);
		this.getAppSession();
		
		userInfoBean = logic.execute(this.getUserID());
		
		if (infoParten.equals("base")) {
			rtn = "BASEINFO_SHOW";
		}
		
		if (infoParten.equals("address1")) {
			rtn = "ADDRESS1_SHOW";
		}
		
		if (infoParten.equals("address2")) {
			rtn = "ADDRESS2_SHOW";
		}
		
		if (infoParten.equals("address3")) {
			rtn = "ADDRESS3_SHOW";
		}
		
		if (infoParten.equals("address4")) {
			rtn = "ADDRESS4_SHOW";
		}
		
		if (infoParten.equals("address5")) {
			rtn = "ADDRESS5_SHOW";
		}
		
		LogLogger.info("rtn:" + rtn);
		return rtn;
	}
}
