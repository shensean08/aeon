package edu.kgu.aeon.Action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import edu.kgu.aeon.bean.loginFormBean;
import edu.kgu.aeon.bean.registerConfirmFormBean;
import edu.kgu.aeon.logic.loginLogic;
import edu.kgu.log.LogLogger;

public class loginAction extends BaseAction implements ServletResponseAware {
	private HttpServletResponse response;
	
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
			this.setUserID(registerConfirmBean.getUserID());
			this.setUserName(registerConfirmBean.getUserName());
			this.setAppSession();
			
			Cookie cookie = new Cookie("userName",this.getUserName());
			cookie.setMaxAge(60 * 60 * 24 * 14);
			cookie.setPath("/");
			cookie.setDomain("dps.or.jp");
			response.addCookie(cookie);
			rtn = SUCCESS;
		}
		
		this.setMessagebean(logic.messagebean);
		return rtn;
	}


	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}