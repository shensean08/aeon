package edu.kgu.aeon.Action;

import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import edu.kgu.aeon.logic.downloadLogic;
import edu.kgu.aeon.logic.showDownloadLogic;
import edu.kgu.log.LogLogger;

public class downloadAction extends BaseAction {
	// logic
	downloadLogic logic = new downloadLogic();

	// request param
	private String userID;
	private String type;
	private String startName;
	private String startLat;
	private String startLng;
	private String destinationName;
	private String destinationLat;
	private String destinationLng;

	// return value
	private String result;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartName() {
		return startName;
	}

	public void setStartName(String startName) {
		this.startName = startName;
	}

	public String getStartLat() {
		return startLat;
	}

	public void setStartLat(String startLat) {
		this.startLat = startLat;
	}

	public String getStartLng() {
		return startLng;
	}

	public void setStartLng(String startLng) {
		this.startLng = startLng;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDestinationLat() {
		return destinationLat;
	}

	public void setDestinationLat(String destinationLat) {
		this.destinationLat = destinationLat;
	}

	public String getDestinationLng() {
		return destinationLng;
	}

	public void setDestinationLng(String destinationLng) {
		this.destinationLng = destinationLng;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	// execute
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try {
//			LogLogger.info("userID:" + userID);
//			LogLogger.info("type:" + type);
//			LogLogger.info("startName:" + startName);
//			LogLogger.info("startLat:" + startLat);
//			LogLogger.info("startLng:" + startLng);
//			LogLogger.info("destinationName:" + destinationName);
//			LogLogger.info("destinationLat:" + destinationLat);
//			LogLogger.info("destinationLng:" + destinationLng);
			
			InputStream pic = request.getInputStream();
			
			logic.execute(pic, userID, type, startName, startLat, startLng, destinationName, destinationLat, destinationLng);
			
			this.result = "{0}";
		} catch(Exception e) {
			this.result = "{1}";
			LogLogger.error(e);
		}
		
		return SUCCESS;		 
	}
}
