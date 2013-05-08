package edu.kgu.aeon.access;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.kgu.aeon.bean.DLinfoBean;
import edu.kgu.log.LogLogger;

public class DLinfoAccess extends BaseAccess {
	public int insertDLinfo(DLinfoBean value) {
		int rtn = -1;
		
		dbConn = conn.getDBConnect();
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO DLinfo ");
		query.append("   	 (userID ");
		query.append("       ,DLNo");
		query.append("       ,Type");
		query.append("       ,DLName");
		query.append("       ,ImgData");
		query.append("       ,sName");
		query.append("		 ,sLat");
		query.append("       ,sLng");
		query.append("       ,dName");
		query.append("       ,dLat");
		query.append("       ,dLng)");
		query.append("   VALUES ('" + value.getUserID() + "'");					//userID
		query.append("   		,'" + value.getDLNo() + "'");					//DLNo
		query.append("   		,'" + value.getType() + "'");					//Type		
		query.append("   		,'" + value.getDLName() + "'");					//Name
		query.append("   		,'" + value.getImgData() + "'");				//ImgData
		query.append("   		,'" + value.getsName() + "'");					//sName
		query.append("   		,'" + value.getsLat() + "'");					//sLat
		query.append("   		,'" + value.getsLng() + "'");					//sLng
		query.append("   		,'" + value.getdName() + "'");					//dName
		query.append("   		,'" + value.getdLat() + "'");					//dLat
		query.append("   		,'" + value.getdLng() + "')");					//dLng	
		
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
	
	public String getMaxDLNo(String userID) {
		String rtn = "0";
		ResultSet result;
		
		dbConn = conn.getDBConnect();
		StringBuffer query = new StringBuffer();
		query.append(" SELECT IFNULL(MAX(DLNo),0) DLNo ");
		query.append("   FROM DLinfo ");
		query.append("  WHERE userID = '" + userID + "'");
		
		try {
			result = dbConn.ExecuteQuery(query.toString());
			if (result.next()) {
				rtn = result.getString("DLNo");
			}
		} catch (Exception e) {
			LogLogger.error(e);
		} finally {
			dbConn.Close();
		}
		
		return rtn;
	}
	
	public ArrayList<DLinfoBean> getDownloadListByUserID(String userID) {
		ArrayList<DLinfoBean> rtn = new ArrayList<DLinfoBean>();
		ResultSet result;
		
		dbConn = conn.getDBConnect();
		StringBuffer query = new StringBuffer();
		query.append(" SELECT DLNo ");
		query.append(" 		 ,Type ");
		query.append("       ,DLName ");
		query.append("       ,ImgData ");
		query.append("       ,sName ");
		query.append("       ,sLat ");
		query.append("       ,sLng ");
		query.append("       ,dName ");
		query.append("       ,dLat ");
		query.append("       ,dLng ");
		query.append("   FROM DLinfo ");
		query.append("  WHERE userID = '" + userID + "'");
		query.append("  ORDER BY DLNo");
		
		try {
			result = dbConn.ExecuteQuery(query.toString());
			
			while (result.next()) {
				DLinfoBean bean = new DLinfoBean();
				bean.setUserID(userID);
				bean.setDLNo(result.getString("DLNo"));
				bean.setType(result.getString("Type"));
				bean.setDLName(result.getString("DLName"));
				bean.setImgData(result.getString("ImgData"));
				bean.setsName(result.getString("sName"));
				bean.setsLat(result.getString("sLat"));
				bean.setsLng(result.getString("sLng"));
				bean.setdName(result.getString("dName"));
				bean.setdLat(result.getString("dLat"));
				bean.setdLng(result.getString("dLng"));
				rtn.add(bean);
			}
		} catch (Exception e) {
			LogLogger.error(e);
		} finally {
			dbConn.Close();
		}
		
		return rtn;
	}
}
