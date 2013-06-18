package edu.kgu.aeon.Action;

import edu.kgu.aeon.bean.registerFormBean;
import edu.kgu.aeon.logic.userInfoUpdateLogic;
import edu.kgu.log.LogLogger;

public class userInfoUpdateAction extends BaseAction {

	private userInfoUpdateLogic logic = new userInfoUpdateLogic();
	
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
		String rtn = "BASEINFO_UPDATE";
//		LogLogger.info(this.getUserID());
//		LogLogger.info(this.getUserName());
//		LogLogger.info(this.getUserInfoBean().getMailAddress());
		
		this.getAppSession();
		userInfoBean.setUserID(this.getUserID());
		userInfoBean.setUserName(this.getUserName());

		if (logic.execute(userInfoBean, infoParten)) {
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
		} else {
			if (infoParten.equals("base")) {
				rtn = "BASEINFO_UPDATE";
			}
			
			if (infoParten.equals("address1")) {
				rtn = "ADDRESS1_UPDATE";
			}
			
			if (infoParten.equals("address2")) {
				rtn = "ADDRESS2_UPDATE";
			}
			
			if (infoParten.equals("address3")) {
				rtn = "ADDRESS3_UPDATE";
			}
			
			if (infoParten.equals("address4")) {
				rtn = "ADDRESS4_UPDATE";
			}
			
			if (infoParten.equals("address5")) {
				rtn = "ADDRESS5_UPDATE";
			}
		}

		this.setMessagebean(logic.messagebean);
		return rtn;
	}

}
