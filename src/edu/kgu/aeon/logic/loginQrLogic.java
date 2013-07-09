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
				JSONObject addressObj[] = new JSONObject[5];
				JSONObject currObj = new JSONObject();
				
				addressObj[0] = new JSONObject();
				addressObj[0].put("name", bean.getAddress1Name());
				addressObj[0].put("address", bean.getAddress1Address());
				
				addressObj[1] = new JSONObject();
				addressObj[1].put("name", bean.getAddress2Name());
				addressObj[1].put("address", bean.getAddress2Address());

				addressObj[2] = new JSONObject();
				addressObj[2].put("name", bean.getAddress3Name());
				addressObj[2].put("address", bean.getAddress3Address());
				
				addressObj[3] = new JSONObject();
				addressObj[3].put("name", bean.getAddress4Name());
				addressObj[3].put("address", bean.getAddress4Address());
				
				addressObj[4] = new JSONObject();
				addressObj[4].put("name", bean.getAddress5Name());
				addressObj[4].put("address", bean.getAddress5Address());
				
				currObj.put("name", "現在地");
				currObj.put("address", "京都市右京区西京極豆田町29");
				
				for (int i = 0; i < 5; i++) {
					allObj.put(addressObj[i]);
				}
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
