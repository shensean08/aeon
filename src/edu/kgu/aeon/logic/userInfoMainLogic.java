package edu.kgu.aeon.logic;

import edu.kgu.aeon.access.userInfoAccess;
import edu.kgu.aeon.bean.registerFormBean;
import edu.kgu.aeon.bean.userInfoBean;

public class userInfoMainLogic extends BaseLogic {

	private userInfoAccess access = new userInfoAccess();
	
	@Override
	public boolean CheckFormBean() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public registerFormBean execute(String userID) {
		registerFormBean rtn = new registerFormBean();
		userInfoBean bean = access.getUserInfoByUserID(userID);
		
		rtn.setUserID(bean.getUserID());
		rtn.setUserName(bean.getUserName());
		rtn.setMailAddress(bean.getMailAddress());
		//rtn.setPassword(bean.getPassword());
		rtn.setFirstname(bean.getFirstname());
		rtn.setLastname(bean.getLastname());
		rtn.setFirstnameSpelling(bean.getFirstnameSpelling());
		rtn.setLastnameSpelling(bean.getLastnameSpelling());
		rtn.setHandPhoneNo(bean.getHandPhoneNo());
		rtn.setAllowSMS(bean.getAllowSMS());
		rtn.setAddress1Name(bean.getAddress1Name());
		rtn.setAddress1Postalcode(bean.getAddress1Postalcode());
		rtn.setAddress1Address(bean.getAddress1Address());
		rtn.setAddress2Name(bean.getAddress2Name());
		rtn.setAddress2Postalcode(bean.getAddress2Postalcode());
		rtn.setAddress2Address(bean.getAddress2Address());		
		rtn.setAddress3Name(bean.getAddress3Name());
		rtn.setAddress3Postalcode(bean.getAddress3Postalcode());
		rtn.setAddress3Address(bean.getAddress3Address());
		rtn.setAddress4Name(bean.getAddress4Name());
		rtn.setAddress4Postalcode(bean.getAddress4Postalcode());
		rtn.setAddress4Address(bean.getAddress4Address());
		rtn.setAddress5Name(bean.getAddress5Name());
		rtn.setAddress5Postalcode(bean.getAddress5Postalcode());
		rtn.setAddress5Address(bean.getAddress5Address());
		
		return rtn;
	}
}
