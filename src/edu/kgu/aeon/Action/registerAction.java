package edu.kgu.aeon.Action;

import org.omg.CORBA.Request;

import edu.kgu.aeon.bean.*;
import edu.kgu.aeon.logic.*;

public class registerAction extends BaseAction{
	
	// logic
	private registerLogic registerlogic = new registerLogic();
	
	// register form bean
	private registerFormBean registerBean;

	public registerFormBean getRegisterBean() {
		return registerBean;
	}

	public void setRegisterBean(registerFormBean registerBean) {
		this.registerBean = registerBean;
	}
	
	// registerConfirm Form Bean
	private registerConfirmFormBean registerConfirmBean;
	
	public registerConfirmFormBean getRegisterConfirmBean() {
		return registerConfirmBean;
	}

	public void setRegisterConfirmBean(registerConfirmFormBean registerConfirmBean) {
		this.registerConfirmBean = registerConfirmBean;
	}
	
	public String execute() {
		
		String rtn = INPUT;
		
		if (registerlogic.execute(this.registerBean)) {
			this.registerConfirmBean = registerlogic.getRegisterconfirmbean();
			rtn = SUCCESS;
		} else {
			this.messagebean.setErrorMsg(registerlogic.messagebean.getErrorMsg());
			rtn = INPUT;	
		}

		return rtn;
	}






}