package edu.kgu.aeon.logic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.kgu.log.LogLogger;

import sun.misc.BASE64Decoder;

public class downloadLogic extends BaseLogic {

	public boolean CheckFormBean() {
		// TODO Auto-generated method stub
		return false;
	}

	public String execute(String fileName, String jpgStream)  {
		String rtn;
		BASE64Decoder decoder = new sun.misc.BASE64Decoder(); 
		
		try {
			byte[] tmpBytes = decoder.decodeBuffer(jpgStream);   
        
		
			ByteArrayInputStream bais = new ByteArrayInputStream(tmpBytes);   
			BufferedImage bi =ImageIO.read(bais);   
			File file = new File(fileName); 
			ImageIO.write(bi, "jpg", file);
			rtn = "{0}";
		} catch (Exception e) {
			rtn = "{1}";
			LogLogger.error(e);
		}
		
		return rtn;
	}
}
