package edu.kgu.aeon.Action;

import java.util.ArrayList;
import java.util.List;

import edu.kgu.aeon.logic.showDownloadLogic;
import edu.kgu.aeon.bean.showDownloadFormBean;

public class showDownloadAction extends BaseAction {

	private showDownloadLogic logic = new showDownloadLogic();
	
	private String userID;
	private String userName;
	private List<showDownloadFormBean> downloadlist = null;
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<showDownloadFormBean> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<showDownloadFormBean> downloadlist) {
		this.downloadlist = downloadlist;
	}
	
	public String execute() {
		downloadlist = logic.execute(userID);
		
		return SUCCESS;
	}
}
