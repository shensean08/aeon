package edu.kgu.aeon.logic;

import org.json.JSONObject;
import org.json.JSONArray;

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
				this.messagebean.setErrorMsg("{Qrコード間違いました。}");
			} else {
				JSONArray allObj = new JSONArray();
				JSONObject homeObj = new JSONObject();
				JSONObject schoolObj = new JSONObject();
				JSONObject workObj = new JSONObject();
				JSONObject currObj = new JSONObject();
				
				homeObj.put("name", "家");
				homeObj.put("address", bean.getHomeAddress());
				
				schoolObj.put("name", "学校");
				schoolObj.put("address", bean.getSchoolAddress());
				
				workObj.put("name", "会社");
				workObj.put("address", bean.getWorkAddress());

				currObj.put("name", "現在地");
				currObj.put("address", "大阪府大阪市西区千代崎3丁目北2");
				
				allObj.put(homeObj);
				allObj.put(schoolObj);
				allObj.put(workObj);
				allObj.put(currObj); 
				
				jsonResult.put("places",allObj);
			}
		} catch (Exception e) {
			LogLogger.error(e);
		}
		
		rtn = jsonResult.toString();
		return rtn;
	}
}
