package edu.kgu.aeon.Action;

import edu.kgu.aeon.bean.registerConfirmFormBean;
import edu.kgu.aeon.logic.myQRLogic;

public class myQRAction extends BaseAction{

	private myQRLogic logic = new myQRLogic();
	
	private String userName;
	private registerConfirmFormBean registerConfirmBean;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public registerConfirmFormBean getRegisterConfirmBean() {
		return registerConfirmBean;
	}

	public void setRegisterConfirmBean(registerConfirmFormBean registerConfirmBean) {
		this.registerConfirmBean = registerConfirmBean;
	}
	
	@Override
	public String execute() {
		this.registerConfirmBean = logic.execute(this.userName);
		return SUCCESS;
	}
}
