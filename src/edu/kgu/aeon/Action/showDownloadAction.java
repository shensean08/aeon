package edu.kgu.aeon.Action;

import java.util.List;

import edu.kgu.aeon.logic.showDownloadLogic;
import edu.kgu.aeon.bean.showDownloadFormBean;

public class showDownloadAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private showDownloadLogic logic = new showDownloadLogic();

	private List<showDownloadFormBean> downloadlist = null;
	
	public List<showDownloadFormBean> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<showDownloadFormBean> downloadlist) {
		this.downloadlist = downloadlist;
	}
	
	public String execute() {
		downloadlist = logic.execute(this.getUserID());
		
		return SUCCESS;
	}
}
