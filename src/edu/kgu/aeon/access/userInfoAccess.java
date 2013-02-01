package edu.kgu.aeon.access;

import java.sql.ResultSet;

import edu.kgu.aeon.bean.userInfoBean;
import edu.kgu.log.LogLogger;

public class userInfoAccess extends BaseAccess {
	public userInfoBean getUserInfo(userInfoBean value) {
		userInfoBean rtn = new userInfoBean();
		ResultSet result;
		
		dbConn = conn.getDBConnect();
		StringBuffer query = new StringBuffer();
		query.append(" SELECT password ");
		query.append("   FROM userInfo ");
		query.append("  WHERE userID = '" + value.getUserID().trim() + "'");
		
		try {
			result = dbConn.ExecuteQuery(query.toString());		   

			if (result.next()) {
				rtn.setPassword(result.getString("password"));
			}
		} catch (Exception e) {
			LogLogger.error(e);
		} finally {
			dbConn.Close();
		}
		
		return rtn;
	}
	
	public int insertUserInfo(userInfoBean value) {
		boolean result;
		int rtn = -1;
		
		dbConn = conn.getDBConnect();
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO userInfo ");
		query.append("   		(userID ");
		query.append("   		,password ");
		query.append("   		,firstname ");
		query.append("   		,lastname ");
		query.append("   		,firstnameSpelling ");
		query.append("   		,lastnameSpelling ");
		query.append("   		,sex ");
		query.append("   		,birthday ");
		query.append("   		,telNo ");
		query.append("   		,handPhoneNo ");
		query.append("   		,handPhoneMailAddress ");
		query.append("   		,allowSMS ");
		query.append("   		,homeAddress ");
		query.append("   		,workAddress ");
		query.append("   		,validateCode ");
		query.append("   		,isValidate ) ");
		query.append("   VALUES ('" + value.getUserID() + "'");					//userID
		query.append("   		,'" + value.getPassword() + "'");				//password
		query.append("   		,'" + value.getFirstname() + "'");				//firstname
		query.append("   		,'" + value.getLastname() + "'");				//lastname
		query.append("   		,'" + value.getFirstnameSpelling() + "'");		//firstnameSpelling
		query.append("   		,'" + value.getLastnameSpelling() + "'");		//lastnameSpelling
		query.append("   		,'" + value.getSex() + "'");					//sex
		query.append("   		,'" + value.getBirtyday() + "'");				//birthday
		query.append("   		,'" + value.getTelNo() + "'");					//telNo
		query.append("   		,'" + value.getHandPhoneNo() + "'");			//handPhoneNo
		query.append("   		,'" + value.getHandPhoneMailAddess() + "'");	//handPhoneMailAddress
		query.append("   		,'" + value.getAllowSMS() + "'");				//allowSMS
		query.append("   		,'" + value.getHomeAddress() + "'");			//homeAddress
		query.append("   		,'" + value.getWorkAddress() + "'");			//workAddress
		query.append("   		,'" + value.getValidateCode() + "'");			//validateCode
		query.append("   		,'" + value.getIsValidate() + "')");			//isValidate		
		
		try {
			result = dbConn.Execute(query.toString());
			rtn = 0;
		} catch (Exception e) {
			LogLogger.error(e);
		} finally {
			dbConn.Close();
		}
		
		return rtn;
	}
}
