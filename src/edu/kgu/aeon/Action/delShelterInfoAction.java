package edu.kgu.aeon.Action;

import java.util.List;

import edu.kgu.aeon.bean.showShelterInfoFormBean;
import edu.kgu.aeon.logic.delShelterInfoLogic;
import edu.kgu.aeon.logic.showShelterInfoLogic;

public class delShelterInfoAction extends BaseAction {
	private delShelterInfoLogic logic = new delShelterInfoLogic();
	
	private showShelterInfoLogic showlogic = new showShelterInfoLogic();
	
	private String dlNo;

	private String showMinus = "";
	

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}

	private List<showShelterInfoFormBean> shelterList = null;
	
	public List<showShelterInfoFormBean> getShelterList() {
		return shelterList;
	}

	public void setShelterList(List<showShelterInfoFormBean> shelterList) {
		this.shelterList = shelterList;
	}

	public String getShowMinus() {
		return showMinus;
	}

	public void setShowMinus(String showMinus) {
		this.showMinus = showMinus;
	}
	
	public String execute() {
		this.getAppSession();
		logic.execute(this.getUserID(), this.dlNo);
		
		shelterList = showlogic.execute(this.getUserID());
		this.showMinus = "show";
		return SUCCESS;
	}
}
