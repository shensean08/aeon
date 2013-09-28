package edu.kgu.aeon.logic;

import edu.kgu.aeon.access.shelterInfoAccess;
import edu.kgu.aeon.bean.shelterInfoBean;

public class delShelterInfoLogic extends BaseLogic {
	private shelterInfoAccess access = new shelterInfoAccess();
	
	public boolean CheckFormBean() {
		return false;
	}
	
	public void execute(String userID,String dLNo) {
		shelterInfoBean value = new shelterInfoBean();
		value.setUserID(userID);
		value.setDlNo(dLNo);
		access.deleteShelterinfo(value);
	}
}
