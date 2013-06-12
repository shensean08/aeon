package edu.kgu.aeon.Action;

import java.util.List;

import edu.kgu.aeon.bean.showDownloadFormBean;
import edu.kgu.aeon.logic.delDownloadLogic;
import edu.kgu.aeon.logic.showDownloadLogic;

public class delDownloadAction extends BaseAction {

	private delDownloadLogic logic = new delDownloadLogic();
	
	private showDownloadLogic showlogic = new showDownloadLogic();
	
	
	private String DLNo;

	public String getDLNo() {
		return DLNo;
	}

	public void setDLNo(String dLNo) {
		DLNo = dLNo;
	}

	private List<showDownloadFormBean> downloadlist = null;

	public List<showDownloadFormBean> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<showDownloadFormBean> downloadlist) {
		this.downloadlist = downloadlist;
	}
	
	public String execute() {
		logic.execute(this.getUserID(), DLNo);
		
		downloadlist = showlogic.execute(this.getUserID());
		
		return SUCCESS;
	}
}
