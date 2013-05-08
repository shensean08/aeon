package edu.kgu.aeon.Action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import sun.misc.BASE64Decoder;
import javax.imageio.ImageIO;
import edu.kgu.aeon.logic.downloadLogic;
import edu.kgu.log.LogLogger;

public class downloadAction extends BaseAction {
	// logic
	downloadLogic logic = new downloadLogic();
	
	// request param
	private String pic;
	private String userID;
	private String type;
	private String startName;
	private String startLat;
	private String startLng;
	private String destinationName;
	private String destinationLat;
	private String destinationLng;
	
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
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
	
	
	// execute
	public String execute() {
		try {
			logic.execute(pic, userID, type, startName, startLat, startLng, destinationName, destinationLat, destinationLng);

		} catch(Exception e) {
			LogLogger.error(e);
		}
		
		return SUCCESS;		 
	}
}
