package edu.kgu.aeon.Action;

import java.util.List;

import edu.kgu.aeon.bean.showShelterInfoFormBean;
import edu.kgu.aeon.logic.showShelterInfoLogic;
import edu.kgu.log.LogLogger;

public class showShelterInfoAction extends BaseAction {
	private showShelterInfoLogic logic = new showShelterInfoLogic();

	private List<showShelterInfoFormBean> shelterList = null;
	
	public List<showShelterInfoFormBean> getShelterList() {
		return shelterList;
	}

	public void setShelterList(List<showShelterInfoFormBean> shelterList) {
		this.shelterList = shelterList;
	}

	public String execute() {
		this.getAppSession();
		shelterList = logic.execute(this.getUserID());
		return SUCCESS;
	}
}
