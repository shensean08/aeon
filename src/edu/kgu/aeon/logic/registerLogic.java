package edu.kgu.aeon.logic;
import java.util.Random;

import edu.kgu.QrCode.QrcodeEncode;
import edu.kgu.aeon.access.userInfoAccess;
import edu.kgu.aeon.bean.*;
import edu.kgu.log.LogLogger;
import edu.kgu.util.NumberProcess;
import edu.kgu.util.StringProcess;

public class registerLogic extends BaseLogic {
	private registerFormBean bean;
	private userInfoAccess access = new userInfoAccess();
	private registerConfirmFormBean registerconfirmbean = new registerConfirmFormBean();
	
	public registerConfirmFormBean getRegisterconfirmbean() {
		return registerconfirmbean;
	}
	
	public boolean CheckFormBean() {
		userInfoBean out;
		
		// ユーザ名 空チェック
		if (this.bean.getUserName().length() <= 0) {
			this.messagebean.setErrorMsg("ユーザ名入力してください");
			return false;
		}
		
		// ユーザ名 重複チェック
		out = access.getUserInfoByUserName(bean.getUserName());
		if (out.getUserID().trim().length() > 0) {
			this.messagebean.setErrorMsg("ユーザ名既に存在している");
			return false;
		}
		
		// メールアドレス 空チェック
		if (this.bean.getMailAddress().length() <= 0) {
			this.messagebean.setErrorMsg("メールアドレス入力してください");
			return false;
		}
		
		// メールアドレス Format チェック
		if (!StringProcess.chkMailAddress(bean.getMailAddress())) {
			this.messagebean.setErrorMsg("メールアドレスフォマットエラー");
			return false;
		}
		
		// パスワード 空チェック
		if (this.bean.getPassword().length() <= 0) {
			this.messagebean.setErrorMsg("パスワード入力してください");
			return false;
		}
		
		// パスワード Comfirm チェック
		if(!this.bean.getPassword().equals(bean.getPasswordConfirm())) {
			this.messagebean.setErrorMsg("パスワード一致ではありません。");
			return false;
		}
		
		// 氏(カタカナ) 空チェック
		if (this.bean.getFirstnameSpelling().length() <= 0) {
			this.messagebean.setErrorMsg("氏(カタカナ)入力してください");
			return false;
		}
		
		// 名(カタカナ) 空チェック
		if (this.bean.getLastnameSpelling().length() <= 0) {
			this.messagebean.setErrorMsg("名(カタカナ)入力してください");
			return false;
		}
		
		// 氏名 カタカナチェック
		if (!StringProcess.chkKatakana(bean.getFirstnameSpelling()) || !StringProcess.chkKatakana(bean.getLastnameSpelling())) {
			this.messagebean.setErrorMsg("氏名(カタカナ)の値はカタカナではありません");
			return false;
		}
		
		// 氏(漢字) 空チェック
		if (this.bean.getFirstname().length() <= 0) {
			this.messagebean.setErrorMsg("氏(漢字)入力してください");
			return false;
		}
		
		// 名(漢字) 空チェック
		if (this.bean.getLastname().length() <= 0) {
			this.messagebean.setErrorMsg("名(漢字)入力してください");
			return false;
		}
		
		// 携帯番号　空チェック
		if (this.bean.getHandPhoneNo().length() <= 0) {
			this.messagebean.setErrorMsg("携帯番号入力してください");
			return false;
		}
		
		if (!NumberProcess.chkNumber(bean.getHandPhoneNo())) {
			this.messagebean.setErrorMsg("携帯番号数字のみ入力してください");
			return false;
		}
		
		// お住まい郵便番号 空チェック
		if (this.bean.getHomePostalcode().length() <= 0) {
			this.messagebean.setErrorMsg("お住まい郵便番号入力してください");
			return false;
		}
		
		// お住まい 空チェック
		if (this.bean.getHomeAddress().length() <= 0) {
			this.messagebean.setErrorMsg("お住まい入力してください");
			return false;
		}
		
		return true;
	}
	
	public userInfoBean setUserInfoBean() {
		userInfoBean rtn = new userInfoBean();
		
		// create userId
		userInfoBean tmpUserinfo;
		int iUserid;
		do {
			Random random = new Random();
			iUserid =random.nextInt();
			if (iUserid < 0) {
				iUserid = iUserid * -1;
			}
			tmpUserinfo = access.getUserInfoByUserID(String.valueOf(iUserid));
		} while(tmpUserinfo.getUserID().length() < 0);
		
		rtn.setUserID(String.valueOf(iUserid));
		rtn.setUserName(this.bean.getUserName());
		rtn.setPassword(this.bean.getPassword());
		rtn.setMailAddress(this.bean.getMailAddress());
		rtn.setFirstnameSpelling(this.bean.getFirstnameSpelling());
		rtn.setLastnameSpelling(this.bean.getLastnameSpelling());
		rtn.setFirstname(this.bean.getFirstname());
		rtn.setLastname(this.bean.getLastname());
		rtn.setHandPhoneNo(this.bean.getHandPhoneNo());
		if (this.bean.getAllowSMS().equals("true")) {
			rtn.setAllowSMS("1");
		} else {
			rtn.setAllowSMS("0");
		}
		rtn.setHomePostalcode(this.bean.getHomePostalcode());
		rtn.setHomeAddress(this.bean.getHomeAddress());
		rtn.setWorkPostalcode(this.bean.getWorkPostalcode());
		rtn.setWorkAddress(this.bean.getWorkAddress());
		rtn.setSchoolPostalcode(this.bean.getSchoolPostalcode());
		rtn.setSchoolAddress(this.bean.getSchoolAddress());
		rtn.setIsValidate("0");
		
		return rtn;	
	}
	
	public boolean execute(registerFormBean value) {
		boolean rtn = false;
		
		this.bean =  value;
		
		// form value check
		if (CheckFormBean()) {
			userInfoBean in = this.setUserInfoBean();
			if (access.insertUserInfo(in) == 0) {
				this.registerconfirmbean.setFirstName(this.bean.getFirstname());
				String filename = createQrCode(in.getUserID());
				this.registerconfirmbean.setQrImage("QRtmp/" + filename);
				rtn = true;
			}
		}
		
		return rtn;
	}
	
	private String createQrCode(String value) {
		String file = "";
		String fileName = "";
		QrcodeEncode qr = new QrcodeEncode('B','M',139,139);
    	qr.setQRVer(2);
    	try {
    		String path = this.getClass().getResource("/").getPath().replaceAll("WEB-INF/classes/", "") + "QRtmp/";
    		fileName = StringProcess.EraseInterpunction(value) + ".png";
    		file = path + fileName;
			qr.OutQRImage(value, file);
		} catch (Exception e) {
			LogLogger.error(e);
		}
		
		return fileName;
	}
}