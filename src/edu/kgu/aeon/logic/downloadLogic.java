package edu.kgu.aeon.logic;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Decoder;

import edu.kgu.aeon.access.DLinfoAccess;
import edu.kgu.aeon.bean.DLinfoBean;
import edu.kgu.log.LogLogger;

public class downloadLogic extends BaseLogic {
	private DLinfoAccess access = new DLinfoAccess();
	
	public boolean CheckFormBean() {
		return false;
	}

	/*
	 * Insert ImageData and MapLink
	 */
	public int execute(String pic, String userID,String type, String sName, String sLat, String sLng, String dName, String dLat, String dLng)  {
		int rtn = -1;
		
		DLinfoBean bean = new DLinfoBean();
		bean.setImgData(Image2DBStream(pic));
		bean.setUserID(userID);
		
		// make downloadNo
		String dlNo = String.valueOf(Integer.parseInt(access.getMaxDLNo(userID)) + 100001).substring(1);
		bean.setDLNo(dlNo);
		
		bean.setType(type);
		bean.setDLName(sName + "_" + dName);
		bean.setsName(sName);
		bean.setsLat(sLat);
		bean.setsLng(sLng);
		bean.setdName(dName);
		bean.setdLat(dLat);
		bean.setdLng(dLng);
		
		rtn = access.insertDLinfo(bean);
		
		return rtn;
	}
	
	public InputStream Image2DBStream(String imageData) {
		InputStream rtn = null;
		try {
			BASE64Decoder decoder = new BASE64Decoder(); 
			byte[] imgByte = decoder.decodeBuffer(imageData);
			InputStream imgStream = new ByteArrayInputStream(imgByte);
			rtn = imgStream;
		} catch (Exception e) {
			LogLogger.error(e);
		}
		
		return rtn;
	}
}
