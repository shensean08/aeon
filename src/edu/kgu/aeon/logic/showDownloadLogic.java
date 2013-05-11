package edu.kgu.aeon.logic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

import edu.kgu.aeon.access.DLinfoAccess;
import edu.kgu.aeon.bean.DLinfoBean;
import edu.kgu.aeon.bean.showDownloadFormBean;
import edu.kgu.log.LogLogger;
import edu.kgu.util.SystemParameter;

public class showDownloadLogic extends BaseLogic {

	DLinfoAccess access = new DLinfoAccess();
	
	public boolean CheckFormBean() {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<showDownloadFormBean> execute(String userID) {
		ArrayList<showDownloadFormBean> rtn = new ArrayList<showDownloadFormBean>();
		ArrayList<DLinfoBean> result = access.getDownloadListByUserID(userID);
		
		for (int i = 0; i < result.size(); i++) {
			showDownloadFormBean sbean = new showDownloadFormBean();
			DLinfoBean bean = result.get(i);
			
			sbean.setDLNo(bean.getDLNo());
			sbean.setDLName(bean.getDLName());
			sbean.setMapLink(createLink(bean));
			sbean.setImageLink(createImage(bean.getUserID() + "_" + bean.getDLNo(),bean.getImgData()));
			
			rtn.add(sbean);
		}
		return rtn;
	}
	
	public static String createImage(String fileName, InputStream imageData) {
		String rtn = "routeTmp/" + fileName + ".png";
		try {
			BufferedImage image = ImageIO.read(imageData);
			String path = SystemParameter.getClassesPath();
			path = path.replaceAll("WEB-INF/classes/", "") + "routeTmp/";
//			path = "/Users/seanshen/Documents/";
			ImageIO.write(image,"png", new File(path + fileName + ".png"));
		} catch (Exception e) {
			LogLogger.error(e);
		}
		return rtn;
	}
	
	public static InputStream readImage(String fileName) {
		InputStream rtn = null;
		try {
			String path = SystemParameter.getClassesPath();
			path = path.replaceAll("WEB-INF/classes/", "") + "routeTmp/";
//			path = "/Users/seanshen/Documents/";
			rtn = new FileInputStream(path + fileName + ".png");
		} catch (Exception e) {
			LogLogger.error(e);
		}
		return rtn;
	}
	
	private String createLink(DLinfoBean value) {
		String rtn = "https://maps.google.com/maps?";
		rtn += "saddr=" + value.getsLat() + "," + value.getsLng();
		if (value.getdLat().length() > 0) {
			rtn += "&daddr=" + value.getdLat() + "," + value.getdLng();
		}
		rtn += "&hl=jp&ie=UTF8&geocode=FbfH3AEdAw48Bw%3BFXU53AEdCMw8Bw&dirflg=w&mra=ls&t=m&z=14";
		return rtn;
	}
}
