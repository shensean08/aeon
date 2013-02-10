package edu.kgu.aeon.access;

import java.sql.ResultSet;

import edu.kgu.aeon.bean.userInfoBean;
import edu.kgu.log.LogLogger;

public class userInfoAccess extends BaseAccess {
	public userInfoBean getUserInfoByUserName(String userName) {
		userInfoBean rtn = new userInfoBean();
		ResultSet result;
		
		dbConn = conn.getDBConnect();
		StringBuffer query = new StringBuffer();
		query.append(" SELECT userID ");
		query.append("       ,userName");
		query.append("       ,password");
		query.append("       ,firstname");
		query.append("       ,lastname");
		query.append("       ,firstnameSpelling");
		query.append("       ,lastnameSpelling");
		query.append("       ,sex");
		query.append("       ,birthday");
		query.append("       ,telNo");
		query.append("       ,handPhoneNo");
		query.append("       ,mailAddress");
		query.append("       ,allowSMS");
		query.append("       ,homePostalcode");
		query.append("       ,homeAddress");
		query.append("       ,schoolPostalcode");
		query.append("       ,schoolAddress");
		query.append("       ,workPostalcode");
		query.append("       ,workAddress");
		query.append("       ,isValidate");
		query.append("   FROM userInfo ");
		query.append("  WHERE userName = '" + userName + "'");
		
		try {
			result = dbConn.ExecuteQuery(query.toString());		   

			if (result.next()) {
				rtn.setUserID(result.getString("userID"));
				rtn.setUserName(result.getString("userName"));
				rtn.setPassword(result.getString("password"));
				rtn.setFirstname(result.getString("firstname"));
				rtn.setLastname(result.getString("lastname"));
				rtn.setFirstnameSpelling(result.getString("firstnameSpelling"));
				rtn.setLastnameSpelling(result.getString("lastnameSpelling"));
				rtn.setSex(result.getString("sex"));
				rtn.setBirthday(result.getString("birthday"));
				rtn.setTelNo(result.getString("telNo"));
				rtn.setHandPhoneNo(result.getString("handPhoneNo"));
				rtn.setMailAddress(result.getString("mailAddress"));
				rtn.setAllowSMS(result.getString("allowSMS"));
				rtn.setHomePostalcode(result.getString("homePostalcode"));
				rtn.setHomeAddress(result.getString("homeAddress"));
				rtn.setSchoolPostalcode(result.getString("schoolPostalcode"));
				rtn.setSchoolAddress(result.getString("schoolAddress"));
				rtn.setWorkPostalcode(result.getString("workPostalcode"));
				rtn.setWorkAddress(result.getString("workAddress"));
				rtn.setIsValidate(result.getString("isValidate"));
			}
		} catch (Exception e) {
			LogLogger.error(e);
		} finally {
			dbConn.Close();
		}
		
		return rtn;
	}
	
	public userInfoBean getUserInfoByUserID(String userID) {
		userInfoBean rtn = new userInfoBean();
		ResultSet result;
		
		dbConn = conn.getDBConnect();
		StringBuffer query = new StringBuffer();
		query.append(" SELECT userID ");
		query.append("       ,userName");
		query.append("       ,password");
		query.append("       ,firstname");
		query.append("       ,lastname");
		query.append("       ,firstnameSpelling");
		query.append("       ,lastnameSpelling");
		query.append("       ,sex");
		query.append("       ,birthday");
		query.append("       ,telNo");
		query.append("       ,handPhoneNo");
		query.append("       ,mailAddress");
		query.append("       ,allowSMS");
		query.append("       ,homePostalcode");
		query.append("       ,homeAddress");
		query.append("       ,schoolPostalcode");
		query.append("       ,schoolAddress");
		query.append("       ,workPostalcode");
		query.append("       ,workAddress");
		query.append("       ,isValidate");
		query.append("   FROM userInfo ");
		query.append("  WHERE userName = '" + userID + "'");
		
		try {
			result = dbConn.ExecuteQuery(query.toString());		   

			if (result.next()) {
				rtn.setUserID(result.getString("userID"));
				rtn.setUserName(result.getString("userName"));
				rtn.setPassword(result.getString("password"));
				rtn.setFirstname(result.getString("firstname"));
				rtn.setLastname(result.getString("lastname"));
				rtn.setFirstnameSpelling(result.getString("firstnameSpelling"));
				rtn.setLastnameSpelling(result.getString("lastnameSpelling"));
				rtn.setSex(result.getString("sex"));
				rtn.setBirthday(result.getString("birthday"));
				rtn.setTelNo(result.getString("telNo"));
				rtn.setHandPhoneNo(result.getString("handPhoneNo"));
				rtn.setMailAddress(result.getString("mailAddress"));
				rtn.setAllowSMS(result.getString("allowSMS"));
				rtn.setHomePostalcode(result.getString("homePostalcode"));
				rtn.setHomeAddress(result.getString("homeAddress"));
				rtn.setSchoolPostalcode(result.getString("schoolPostalcode"));
				rtn.setSchoolAddress(result.getString("schoolAddress"));
				rtn.setWorkPostalcode(result.getString("workPostalcode"));
				rtn.setWorkAddress(result.getString("workAddress"));
				rtn.setIsValidate(result.getString("isValidate"));
			}
		} catch (Exception e) {
			LogLogger.error(e);
		} finally {
			dbConn.Close();
		}
		
		return rtn;
	}	
	
	public int insertUserInfo(userInfoBean value) {
		int rtn = -1;
		
		dbConn = conn.getDBConnect();
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO userInfo ");
		query.append("   	 (userID ");
		query.append("       ,userName");
		query.append("       ,password");
		query.append("       ,firstname");
		query.append("       ,lastname");
		query.append("       ,firstnameSpelling");
		query.append("       ,lastnameSpelling");
		query.append("       ,sex");
		query.append("       ,birthday");
		query.append("       ,telNo");
		query.append("       ,handPhoneNo");
		query.append("       ,mailAddress");
		query.append("       ,allowSMS");
		query.append("       ,homePostalcode");
		query.append("       ,homeAddress");
		query.append("       ,schoolPostalcode");
		query.append("       ,schoolAddress");
		query.append("       ,workPostalcode");
		query.append("       ,workAddress");
		query.append("       ,isValidate)");
		query.append("   VALUES ('" + value.getUserID() + "'");					//userID
		query.append("   		,'" + value.getUserName() + "'");				//userName
		query.append("   		,'" + value.getPassword() + "'");				//password		
		query.append("   		,'" + value.getFirstname() + "'");				//firstname
		query.append("   		,'" + value.getLastname() + "'");				//lastname
		query.append("   		,'" + value.getFirstnameSpelling() + "'");		//firstnameSpelling
		query.append("   		,'" + value.getLastnameSpelling() + "'");		//lastnameSpelling
		query.append("   		,'" + value.getSex() + "'");					//sex
		query.append("   		,'" + value.getBirthday() + "'");				//birthday
		query.append("   		,'" + value.getTelNo() + "'");					//telNo
		query.append("   		,'" + value.getHandPhoneNo() + "'");			//handPhoneNo
		query.append("   		,'" + value.getMailAddress() + "'");			//handPhoneMailAddress
		query.append("   		,'" + value.getAllowSMS() + "'");				//allowSMS
		query.append("   		,'" + value.getHomePostalcode() + "'");			//homePostalcode
		query.append("   		,'" + value.getHomeAddress() + "'");			//homeAddress
		query.append("   		,'" + value.getSchoolPostalcode() + "'");		//schoolPostalcode
		query.append("   		,'" + value.getSchoolAddress() + "'");			//schoolAddress
		query.append("   		,'" + value.getWorkPostalcode() + "'");			//workPostalcode		
		query.append("   		,'" + value.getWorkAddress() + "'");			//workAddress
		query.append("   		,'" + value.getIsValidate() + "')");			//isValidate		
		
		try {
			dbConn.BeginTransaction();
			dbConn.Execute(query.toString());
			dbConn.Commit();
			rtn = 0;
		} catch (Exception e) {
			LogLogger.error(e);
		} finally {
			dbConn.Close();
		}
		
		return rtn;
	}
}
