package edu.kgu.QrCode;

import java.awt.image.BufferedImage;  
import java.io.File;   
import javax.imageio.ImageIO;  

import edu.kgu.log.LogLogger;
import jp.sourceforge.qrcode.QRCodeDecoder;  

public class QrcodeDecode {
	public String QrcodeDecode(String qrcodefile) {
		String rtn = "";
		try {  
			File imageFile = new File(qrcodefile);  
			BufferedImage image = ImageIO.read(imageFile);  
            QRCodeDecoder decoder = new QRCodeDecoder(); 
            rtn = new String(decoder.decode(new J2SEImageGucas(image)));  
        } catch (Exception e) {  
            LogLogger.error(e);
        }  
        
        return rtn; 
	}
}
