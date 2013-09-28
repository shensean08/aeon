package edu.kgu.aeon.logic;

import edu.kgu.aeon.access.shelterInfoAccess;
import edu.kgu.aeon.bean.shelterInfoBean;

public class shelterInfoLogic extends BaseLogic {
	private shelterInfoAccess access = new shelterInfoAccess();
	
	public boolean CheckFormBean() {
		return false;
	}

	public int execute(shelterInfoBean bean)  {
		int rtn = -1;
		
		// make downloadNo
		String dlNo = String.valueOf(Integer.parseInt(access.getMaxDLNo(bean.getUserID())) + 100001).substring(1);
		bean.setDlNo(dlNo);
		
		rtn = access.insertShelterInfo(bean);
		
		return rtn;
	}
}
