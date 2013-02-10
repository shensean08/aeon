package edu.kgu.aeon.logic;

import org.json.JSONObject;

import edu.kgu.aeon.access.userInfoAccess;
import edu.kgu.aeon.bean.userInfoBean;
import edu.kgu.log.LogLogger;

public class loginQrLogic extends BaseLogic {
	userInfoAccess access = new userInfoAccess();
	
	@Override
	public boolean CheckFormBean() {
		return false;
	}

	public String execute(String qrdecode) {
		String rtn = "";
		JSONObject jsonResult = new JSONObject();
		
		
		try {
			userInfoBean bean = access.getUserInfoByUserID(qrdecode);
			
			if (bean.getUserName().length() <= 0) {
				this.messagebean.setErrorMsg("Qrコード間違いました。");
			} else {
				jsonResult.put("homeAddress", bean.getHomeAddress());
				jsonResult.put("workAddress", bean.getWorkAddress());
				jsonResult.put("schoolAddress", bean.getSchoolAddress());
			}
		} catch (Exception e) {
			LogLogger.error(e);
		}
		rtn = jsonResult.toString();
		
		return rtn;
	}
}
