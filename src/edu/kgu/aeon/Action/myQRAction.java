package edu.kgu.aeon.Action;

import edu.kgu.aeon.bean.registerConfirmFormBean;
import edu.kgu.aeon.logic.myQRLogic;

public class myQRAction extends BaseAction{

	private myQRLogic logic = new myQRLogic();
	
	private registerConfirmFormBean registerConfirmBean;
	
	public registerConfirmFormBean getRegisterConfirmBean() {
		return registerConfirmBean;
	}

	public void setRegisterConfirmBean(registerConfirmFormBean registerConfirmBean) {
		this.registerConfirmBean = registerConfirmBean;
	}
	
	@Override
	public String execute() {
		this.registerConfirmBean = logic.execute(this.getUserName());
		return SUCCESS;
	}
}
