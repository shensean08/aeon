package edu.kgu.aeon.logic;
import edu.kgu.aeon.access.DLinfoAccess;
import edu.kgu.aeon.bean.DLinfoBean;

public class delDownloadLogic extends BaseLogic {
	private DLinfoAccess access = new DLinfoAccess();
	
	public boolean CheckFormBean() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void execute(String userID,String dLNo) {
		DLinfoBean value = new DLinfoBean();
		value.setUserID(userID);
		value.setDLNo(dLNo);
		access.deleteDLinfo(value);
	}

}
