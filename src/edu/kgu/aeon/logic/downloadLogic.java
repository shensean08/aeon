package edu.kgu.aeon.logic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

import edu.kgu.aeon.access.DLinfoAccess;
import edu.kgu.aeon.bean.DLinfoBean;
import edu.kgu.log.LogLogger;
import edu.kgu.util.SystemParameter;

public class downloadLogic extends BaseLogic {
	private DLinfoAccess access = new DLinfoAccess();
	
	public boolean CheckFormBean() {
		return false;
	}

	/*
	 * Insert ImageData and MapLink
	 */
	public int execute(InputStream pic, String userID,String type, String sName, String sLat, String sLng, String dName, String dLat, String dLng)  {
		int rtn = -1;
		
		DLinfoBean bean = new DLinfoBean();

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
		
		// set ImageData
		showDownloadLogic.createImage(userID + "_" + dlNo,pic);
		bean.setImgData(showDownloadLogic.readImage(userID + "_" + dlNo));
		
		rtn = access.insertDLinfo(bean);
		
		return rtn;
	}
}
