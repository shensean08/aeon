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
	
	private String pic;
	private String userID;
	
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
	
	public String execute() {
		try {
			LogLogger.info("pic:" + pic);
			LogLogger.info("userID:" + userID);
			
			BASE64Decoder decoder = new BASE64Decoder(); 
			byte[] imgByte = decoder.decodeBuffer(this.pic);
			ByteArrayInputStream imgStreamIn = new ByteArrayInputStream(imgByte);
			BufferedImage image = ImageIO.read(imgStreamIn);
			ImageIO.write(image,"png", new File("/Users/seanshen/Documents/testPic.png"));
		} catch(Exception e) {
			LogLogger.error(e);
		}
		
		return SUCCESS;		 
	}
}
