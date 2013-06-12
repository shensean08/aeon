package edu.kgu.aeon.logic;

import edu.kgu.aeon.access.userInfoAccess;
import edu.kgu.aeon.bean.registerFormBean;
import edu.kgu.aeon.bean.userInfoBean;
import edu.kgu.util.StringProcess;

public class userInfoEditLogic extends BaseLogic {
	private userInfoAccess access = new userInfoAccess();
	
	private registerFormBean bean;
	private String infoParten;
	
	@Override
	public boolean CheckFormBean() {
		if (infoParten.equals("base")) {
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
			
			// 既存パスワード 空チェック
			if (this.bean.getOldPassword().length() <= 0) {
				this.messagebean.setErrorMsg("既存パスワード入力してください");
				return false;
			}
			
			// 既存パスワード チェック
			userInfoBean out = access.getUserInfoByUserID(this.bean.getUserID());
			if (!out.getPassword().equals(this.bean.getOldPassword())) {
				this.messagebean.setErrorMsg("既存パスワード入力間違いました。");
				return false;
			}
			
			// パスワード 空チェック
			if (this.bean.getPassword().length() <= 0) {
				this.messagebean.setErrorMsg("パスワード入力してください");
				return false;
			}
			
			// パスワード　4桁以上
			if (this.bean.getPassword().length() < 4) {
				this.messagebean.setErrorMsg("パスワードは4~16桁入力してください");
				return false;
			}
			
			// パスワード Comfirm チェック
			if(!this.bean.getPassword().equals(bean.getPasswordConfirm())) {
				this.messagebean.setErrorMsg("パスワード一致ではありません。");
				return false;
			}
		}
		
		if (infoParten.equals("address1")) {
			// 住所1入力チェック
			if (this.bean.getAddress1Name().length() <= 0) {
				this.messagebean.setErrorMsg("住所1の名前入力してください");
				return false;
			}
			
			// 1郵便番号
			if (this.bean.getAddress1Postalcode().length() <= 0) {
				this.messagebean.setErrorMsg("住所1の郵便番号入力してください");
				return false;
			}
			// 1住所
			if (this.bean.getAddress1Address().length() <= 0) {
				this.messagebean.setErrorMsg("住所1の住所入力してください");
				return false;
			}
		}
		
		if (infoParten.equals("address2")) {
			// 住所2入力チェック
			if (this.bean.getAddress2Name().length() <= 0) {
				this.messagebean.setErrorMsg("住所2の名前入力してください");
				return false;
			}
			
			// 2郵便番号
			if (this.bean.getAddress2Postalcode().length() <= 0) {
				this.messagebean.setErrorMsg("住所2の郵便番号入力してください");
				return false;
			}
			// 2住所
			if (this.bean.getAddress2Address().length() <= 0) {
				this.messagebean.setErrorMsg("住所2の住所入力してください");
				return false;
			}
		}
		
		if (infoParten.equals("address3")) {
			// 住所3入力チェック
			if (this.bean.getAddress3Name().length() <= 0) {
				this.messagebean.setErrorMsg("住所3の名前入力してください");
				return false;
			}
			
			// 3郵便番号
			if (this.bean.getAddress3Postalcode().length() <= 0) {
				this.messagebean.setErrorMsg("住所3の郵便番号入力してください");
				return false;
			}
			// 3住所
			if (this.bean.getAddress3Address().length() <= 0) {
				this.messagebean.setErrorMsg("住所3の住所入力してください");
				return false;
			}
		}
		
		if (infoParten.equals("address4")) {
			// 住所4入力チェック
			if (this.bean.getAddress4Name().length() <= 0) {
				this.messagebean.setErrorMsg("住所4の名前入力してください");
				return false;
			}
			
			// 4郵便番号
			if (this.bean.getAddress4Postalcode().length() <= 0) {
				this.messagebean.setErrorMsg("住所4の郵便番号入力してください");
				return false;
			}
			// 4住所
			if (this.bean.getAddress4Address().length() <= 0) {
				this.messagebean.setErrorMsg("住所4の住所入力してください");
				return false;
			}
		}
		
		if (infoParten.equals("address5")) {
			// 住所5入力チェック
			if (this.bean.getAddress5Name().length() <= 0) {
				this.messagebean.setErrorMsg("住所5の名前入力してください");
				return false;
			}
			
			// 5郵便番号
			if (this.bean.getAddress5Postalcode().length() <= 0) {
				this.messagebean.setErrorMsg("住所5の郵便番号入力してください");
				return false;
			}
			// 5住所
			if (this.bean.getAddress5Address().length() <= 0) {
				this.messagebean.setErrorMsg("住所5の住所入力してください");
				return false;
			}
		}
		
		return true;
	}

	public boolean execute(registerFormBean value,String infoParten) {
		boolean rtn = false;
		
		this.bean =  value;
		this.infoParten = infoParten;
		
		// form value check
		if (CheckFormBean()) {
			userInfoBean in = new userInfoBean();
			in.setUserID(this.bean.getUserID());
			in.setUserName(this.bean.getUserName());
			in.setPassword(this.bean.getPassword());
			in.setMailAddress(this.bean.getMailAddress());
			in.setAddress1Name(this.bean.getAddress1Name());
			in.setAddress1Postalcode(this.bean.getAddress1Postalcode());
			in.setAddress1Address(this.bean.getAddress1Address());
			in.setAddress2Name(this.bean.getAddress2Name());
			in.setAddress2Postalcode(this.bean.getAddress2Postalcode());
			in.setAddress2Address(this.bean.getAddress2Address());
			in.setAddress3Name(this.bean.getAddress3Name());
			in.setAddress3Postalcode(this.bean.getAddress3Postalcode());
			in.setAddress3Address(this.bean.getAddress3Address());
			in.setAddress4Name(this.bean.getAddress4Name());
			in.setAddress4Postalcode(this.bean.getAddress4Postalcode());
			in.setAddress4Address(this.bean.getAddress4Address());
			in.setAddress5Name(this.bean.getAddress5Name());
			in.setAddress5Postalcode(this.bean.getAddress5Postalcode());
			in.setAddress5Address(this.bean.getAddress5Address());
			
			if (access.updateUserInfoAddressByUserName(in) == 0) {
				rtn = true;
			}
		}
		
		return rtn;
	}
}
