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
		query.append("       ,address1Name");
		query.append("       ,address1Postalcode");
		query.append("       ,address1Address");
		query.append("       ,address2Name");
		query.append("       ,address2Postalcode");
		query.append("       ,address2Address");
		query.append("       ,address2Name");
		query.append("       ,address2Postalcode");
		query.append("       ,address2Address");
		query.append("       ,address3Name");
		query.append("       ,address3Postalcode");
		query.append("       ,address3Address");
		query.append("       ,address4Name");
		query.append("       ,address4Postalcode");
		query.append("       ,address4Address");
		query.append("       ,address5Name");
		query.append("       ,address5Postalcode");
		query.append("       ,address5Address");
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
				rtn.setAddress1Name(result.getString("address1Name"));
				rtn.setAddress1Postalcode(result.getString("address1Postalcode"));
				rtn.setAddress1Address(result.getString("address1Address"));
				rtn.setAddress2Name(result.getString("address2Name"));
				rtn.setAddress2Postalcode(result.getString("address2Postalcode"));
				rtn.setAddress2Address(result.getString("address2Address"));
				rtn.setAddress3Name(result.getString("address3Name"));
				rtn.setAddress3Postalcode(result.getString("address3Postalcode"));
				rtn.setAddress3Address(result.getString("address3Address"));
				rtn.setAddress4Name(result.getString("address4Name"));
				rtn.setAddress4Postalcode(result.getString("address4Postalcode"));
				rtn.setAddress4Address(result.getString("address4Address"));
				rtn.setAddress5Name(result.getString("address5Name"));
				rtn.setAddress5Postalcode(result.getString("address5Postalcode"));
				rtn.setAddress5Address(result.getString("address5Address"));
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
		query.append("       ,address1Name");
		query.append("       ,address1Postalcode");
		query.append("       ,address1Address");
		query.append("       ,address2Name");
		query.append("       ,address2Postalcode");
		query.append("       ,address2Address");
		query.append("       ,address2Name");
		query.append("       ,address2Postalcode");
		query.append("       ,address2Address");
		query.append("       ,address3Name");
		query.append("       ,address3Postalcode");
		query.append("       ,address3Address");
		query.append("       ,address4Name");
		query.append("       ,address4Postalcode");
		query.append("       ,address4Address");
		query.append("       ,address5Name");
		query.append("       ,address5Postalcode");
		query.append("       ,address5Address");
		query.append("       ,isValidate");
		query.append("   FROM userInfo ");
		query.append("  WHERE userID = '" + userID + "'");
		
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
				rtn.setAddress1Name(result.getString("address1Name"));
				rtn.setAddress1Postalcode(result.getString("address1Postalcode"));
				rtn.setAddress1Address(result.getString("address1Address"));
				rtn.setAddress2Name(result.getString("address2Name"));
				rtn.setAddress2Postalcode(result.getString("address2Postalcode"));
				rtn.setAddress2Address(result.getString("address2Address"));
				rtn.setAddress3Name(result.getString("address3Name"));
				rtn.setAddress3Postalcode(result.getString("address3Postalcode"));
				rtn.setAddress3Address(result.getString("address3Address"));
				rtn.setAddress4Name(result.getString("address4Name"));
				rtn.setAddress4Postalcode(result.getString("address4Postalcode"));
				rtn.setAddress4Address(result.getString("address4Address"));
				rtn.setAddress5Name(result.getString("address5Name"));
				rtn.setAddress5Postalcode(result.getString("address5Postalcode"));
				rtn.setAddress5Address(result.getString("address5Address"));
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
		query.append("       ,address1Name");
		query.append("       ,address1Postalcode");
		query.append("       ,address1Address");
		query.append("       ,address2Name");
		query.append("       ,address2Postalcode");
		query.append("       ,address2Address");
		query.append("       ,address3Name");
		query.append("       ,address3Postalcode");
		query.append("       ,address3Address");
		query.append("       ,address4Name");
		query.append("       ,address4Postalcode");
		query.append("       ,address4Address");
		query.append("       ,address5Name");
		query.append("       ,address5Postalcode");
		query.append("       ,address5Address");
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
		query.append("			,'" + value.getAddress1Name() + "'");			//address1Name
		query.append("   		,'" + value.getAddress1Postalcode() + "'");		//address1Postalcode
		query.append("   		,'" + value.getAddress1Address() + "'");		//address1Address
		query.append("			,'" + value.getAddress2Name() + "'");			//address2Name
		query.append("   		,'" + value.getAddress2Postalcode() + "'");		//address2Postalcode
		query.append("   		,'" + value.getAddress2Address() + "'");		//address2Address
		query.append("			,'" + value.getAddress3Name() + "'");			//address3Name
		query.append("   		,'" + value.getAddress3Postalcode() + "'");		//address3Postalcode
		query.append("   		,'" + value.getAddress3Address() + "'");		//address3Address
		query.append("			,'" + value.getAddress4Name() + "'");			//address4Name
		query.append("   		,'" + value.getAddress4Postalcode() + "'");		//address4Postalcode
		query.append("   		,'" + value.getAddress4Address() + "'");		//address4Address
		query.append("			,'" + value.getAddress5Name() + "'");			//address5Name
		query.append("   		,'" + value.getAddress5Postalcode() + "'");		//address5Postalcode
		query.append("   		,'" + value.getAddress5Address() + "'");		//address5Address
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
	
	public int updateUserInfoAddressByUserName(userInfoBean value) {
		int rtn = -1;
		
		dbConn = conn.getDBConnect();
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE userInfo ");
		if (value.getAddress1Name().trim().length() > 0) {
			query.append("    SET address1Name = '" + value.getAddress1Name() + "'");					//address1Name
			query.append("   	 ,address1Postalcode = '" + value.getAddress1Postalcode() + "'");		//address1Postalcode
			query.append("   	 ,address1Address = '" + value.getAddress1Address() + "'");				//address1Address
		}
		if (value.getAddress2Name().trim().length() > 0) {
			query.append("    SET address2Name = '" + value.getAddress2Name() + "'");					//address2Name
			query.append("   	 ,address2Postalcode = '" + value.getAddress2Postalcode() + "'");		//address2Postalcode
			query.append("   	 ,address2Address = '" + value.getAddress2Address() + "'");				//address2Address
		}
		if (value.getAddress3Name().trim().length() > 0) {
			query.append("    SET address3Name = '" + value.getAddress3Name() + "'");					//address3Name
			query.append("   	 ,address3Postalcode = '" + value.getAddress3Postalcode() + "'");		//address3Postalcode
			query.append("   	 ,address3Address = '" + value.getAddress3Address() + "'");				//address3Address
		}
		if (value.getAddress4Name().trim().length() > 0) {
			query.append("    SET address4Name = '" + value.getAddress4Name() + "'");					//address4Name
			query.append("   	 ,address4Postalcode = '" + value.getAddress4Postalcode() + "'");		//address4Postalcode
			query.append("   	 ,address4Address = '" + value.getAddress4Address() + "'");				//address4Address
		}
		if (value.getAddress5Name().trim().length() > 0) {
			query.append("    SET address5Name = '" + value.getAddress1Name() + "'");					//address5Name
			query.append("   	 ,address5Postalcode = '" + value.getAddress1Postalcode() + "'");		//address5Postalcode
			query.append("   	 ,address5Address = '" + value.getAddress1Address() + "'");				//address5Address
		}
		query.append(" WHERE userName = '" + value.getUserName() + "'");
		
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