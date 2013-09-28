package edu.kgu.aeon.logic;

import java.util.ArrayList;

import edu.kgu.aeon.access.shelterInfoAccess;
import edu.kgu.aeon.bean.shelterInfoBean;
import edu.kgu.aeon.bean.showShelterInfoFormBean;

public class showShelterInfoLogic extends BaseLogic {
	shelterInfoAccess access = new shelterInfoAccess();
	
	public boolean CheckFormBean() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ArrayList<showShelterInfoFormBean> execute(String userID) {
		ArrayList<showShelterInfoFormBean> rtn = new ArrayList<showShelterInfoFormBean>();
		ArrayList<shelterInfoBean> result = access.getShelterListByUserID(userID);
		
		for (int i = 0; i < result.size(); i++) {
			showShelterInfoFormBean sbean = new showShelterInfoFormBean();
			shelterInfoBean bean = result.get(i);
			
			sbean.setDlNo(bean.getDlNo());
			sbean.setPlaceName(bean.getPlaceName());
			sbean.setLat(bean.getLat());
			sbean.setLng(bean.getLng());
			sbean.setFid(bean.getFid());
			sbean.setTel(bean.getTel());
			sbean.setComment(bean.getComment());
			sbean.setPlaceLink(createLink(bean));
		
			rtn.add(sbean);
		}
		return rtn;
	}
	
	
	private String createLink(shelterInfoBean value) {
		//http://maps.google.com/maps?q=36.146747,137.514153
		String rtn = "https://maps.google.com/maps?";
		rtn += "q=" + value.getLat() + "," + value.getLng();
		return rtn;
	}
}
