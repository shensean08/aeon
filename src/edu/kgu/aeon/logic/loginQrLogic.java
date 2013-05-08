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
				
				currObj.put("name", "現在地");
				currObj.put("address", "大阪府大阪市西区千代崎3丁目北2");
				
				for (int i = 0; i < 3; i++) {
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
