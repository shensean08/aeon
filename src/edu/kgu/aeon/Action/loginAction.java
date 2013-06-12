package edu.kgu.aeon.Action;

import edu.kgu.aeon.bean.loginFormBean;
import edu.kgu.aeon.bean.registerConfirmFormBean;
import edu.kgu.aeon.logic.loginLogic;

public class loginAction extends BaseAction {

	// form bean
	private loginFormBean loginBean;

	public loginFormBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(loginFormBean loginBean) {
		this.loginBean = loginBean;
	}

	// registerConfirm Form Bean
	private registerConfirmFormBean registerConfirmBean;
	
	public registerConfirmFormBean getRegisterConfirmBean() {
		return registerConfirmBean;
	}

	public void setRegisterConfirmBean(registerConfirmFormBean registerConfirmBean) {
		this.registerConfirmBean = registerConfirmBean;
	}
	
	// logic
	private loginLogic logic = new loginLogic();
	
	public String execute() {
		String rtn = INPUT;
		
		if (logic.execute(this.loginBean)) {
			// jump to register confirm page
			this.registerConfirmBean = logic.getRegisterConfirmBean();
			rtn = SUCCESS;
		}
		
		this.setMessagebean(logic.messagebean);
		
		return rtn;
	}
}