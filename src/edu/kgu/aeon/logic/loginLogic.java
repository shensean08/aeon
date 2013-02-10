package edu.kgu.aeon.logic;

import edu.kgu.aeon.access.userInfoAccess;
import edu.kgu.aeon.bean.*;
import edu.kgu.log.LogLogger;

public class loginLogic extends BaseLogic {
	private userInfoAccess access = new userInfoAccess();
	private loginFormBean bean;
	private registerConfirmFormBean registerConfirmBean = new registerConfirmFormBean();
	
	public registerConfirmFormBean getRegisterConfirmBean() {
		return registerConfirmBean;
	}
	
	@Override
	public boolean CheckFormBean() {
		// ユーザ名入力チェック
		if (bean.getUserName().length() <= 0) {
			this.messagebean.setErrorMsg("ユーザ名入力してください");
			return false;
		}
		
		// パスワード入力チェック
		if (bean.getPassword().length() <= 0) {
			this.messagebean.setErrorMsg("パスワード入力してください");
			return false;
		}
		
		// パスワード正しいチェック
		userInfoBean result = access.getUserInfoByUserName(bean.getUserName());
		if (!bean.getPassword().equals(result.getPassword())) {
			this.messagebean.setErrorMsg("ユーザ名とパスワードが不一致です。");
			return false;
		}
		
		String path = "QRtmp/";
		this.registerConfirmBean.setFirstName(result.getFirstname());
		this.registerConfirmBean.setQrImage(path + result.getUserID() + ".png");
		return true;
	}
	
	public boolean execute(loginFormBean value) {
		boolean rtn = false;
		bean = value;
		
		// form value check
		if (CheckFormBean()) {
			rtn = true;
		}
		
		return rtn;
	}
}
