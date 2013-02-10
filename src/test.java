import java.util.Random;

import edu.kgu.QrCode.*;
import edu.kgu.aeon.bean.loginFormBean;
import edu.kgu.aeon.bean.registerFormBean;
import edu.kgu.aeon.logic.registerLogic;
import edu.kgu.aeon.Action.*;
import edu.kgu.util.*;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		loginQr();
	}

	public static void loginQrAction() {
		loginQrAction action = new loginQrAction();
		action.execute();
	}
	public static void QrcodeDecode() {
		QrcodeDecode a = new QrcodeDecode();
		String b = a.QrcodeDecode("/Users/seanshen/Documents/Cloud/Dropbox/workspace/aeon/aeonsite/QRtmp/ontologyhotmailcom.png");
		System.out.println(b);
	}
	
	public static void qrcode() {
		QrcodeEncode qr = new QrcodeEncode('B','M',139,139);
    	qr.setQRVer(2);
    	try {
			qr.OutQRImage("sean@hotmail.com", "/Users/seanshen/Documents/Cloud/Dropbox/workspace/aeon/qrtest.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mailAddress() {
		System.out.println(StringProcess.chkMailAddress("sdfsadf@co.com"));
	}
	public static void login() {
		loginFormBean bean = new loginFormBean();
		bean.setUserName("shensean08");
		bean.setPassword("1234567");
		
		loginAction action = new loginAction();
		action.setLoginBean(bean);
		action.execute();
	}
	public static void register() {
		registerFormBean bean = new registerFormBean();

		bean.setUserName("sean");
		bean.setPassword("1234567");
		bean.setPasswordConfirm("1234567");
		bean.setMailAddress("sdfsdf@ggg.com");
		bean.setFirstname("沈");
		bean.setFirstnameSpelling("チン");
		bean.setLastname("治年");
		bean.setLastnameSpelling("ジネン");
		bean.setHandPhoneNo("43452345");
		bean.setAllowSMS("1");
		bean.setHomePostalcode("532535");
		bean.setHomeAddress("safsdfasf");
		
		registerAction action = new registerAction();
		action.setRegisterBean(bean);
		
		action.execute();
	}
	
	public static void loginQr() {
		loginQrAction action = new loginQrAction();
		action.setQrdecode("1315492432");
		action.execute();
	}
}
