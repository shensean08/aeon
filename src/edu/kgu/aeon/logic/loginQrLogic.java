package edu.kgu.aeon.logic;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import edu.kgu.log.LogLogger;

public class loginQrLogic extends BaseLogic {
	
	@Override
	public boolean CheckFormBean() {
		return false;
	}

	public String execute(String qrdecode) {
		String rtn = "";
//		JSONArray jsonResult = new JSONArray();
//		
//		
//		try {
//			ArrayList<userlinkBean> resultLst= access.getUserInfo(qrdecode);
//			
//			for (int i = 0; i < resultLst.size(); i++) {
//				JSONObject rec = new JSONObject();
//				userlinkBean bean = resultLst.get(i);
//				rec.put("link", bean.getLink());
//				jsonResult.put(rec);
//			}
//		} catch (Exception e) {
//			LogLogger.error(e);
//		}
//		rtn = jsonResult.toString();
		
		return rtn;
	}
}
