import edu.kgu.QrCode.QrcodeEncode;
import edu.kgu.aeon.bean.registerFormBean;
import edu.kgu.aeon.logic.registerLogic;
import edu.kgu.util.StringProcess;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		register();
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
	
	public static void register() {
		registerFormBean bean = new registerFormBean();
		bean.setUserID("asdfasdf@ggg.com");
		bean.setPassword("1234567");
		bean.setPasswordConfirm("1234567");
		bean.setFirstnameSpelling("チン");
		bean.setLastnameSpelling("ジネン");
		bean.setFirstname("沈");
		bean.setLastname("治年");
		bean.setHandPhoneNo("08033331");
		bean.setHomeAddress("sssss");
		bean.setWorkAddress("aaa");
		
		registerLogic logic = new registerLogic();
		logic.execute(bean);
	}
}
