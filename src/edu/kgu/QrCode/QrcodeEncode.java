package edu.kgu.QrCode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QrcodeEncode {
	private Qrcode qrEnc = new Qrcode();
	private int height,width;
	private char QRMode,QRErrCorrect;
	private int QRVer = 2;
	private int QrSize = 80;

	public QrcodeEncode(char QREncodeMode,char QRErrorCorrect,int Width,int Height) {
		this.QRMode = QREncodeMode;
		this.QRErrCorrect = QRErrorCorrect;
		this.width = Width;
		this.height = Height;
		
		this.qrEnc.setQrcodeEncodeMode(this.QRMode);
		this.qrEnc.setQrcodeErrorCorrect(this.QRErrCorrect);
	}
	
	public void OutQRImage(String InText,String OutPath) throws Exception {
		qrEnc.setQrcodeVersion(this.QRVer);
		
		byte[] QrByte =InText.getBytes("UTF-8");
		
		BufferedImage bufImg = new BufferedImage(this.QrSize, this.QrSize, BufferedImage.TYPE_INT_RGB);   
		            
		// createGraphics   
		Graphics2D paint = bufImg.createGraphics();   

		// set QR area information   
		paint.setBackground(Color.WHITE);   
		paint.clearRect(0, 0, this.QrSize, this.QrSize);   
		paint.setColor(Color.BLACK);   
		            
		boolean[][] QrBool = this.qrEnc.calQrcode(QrByte);   

		for (int i = 0; i < QrBool.length; i++) {
			for (int j = 0; j < QrBool.length; j++) {   
				if (QrBool[j][i]) {
					paint.fillRect(j*3+2,i*3+2,3,3);
				}
			}
		}    
		          
		paint.dispose();
		
		bufImg.flush();
		
		BufferedImage outImg = new BufferedImage(this.width, this.height ,BufferedImage.TYPE_INT_RGB);   
		   
		outImg.getGraphics().drawImage(bufImg, 0, 0, this.width, this.height, null); 
		  
		File QrFile = new File(OutPath);   

		ImageIO.write(outImg, "png", QrFile);
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public char getQRMode() {
		return QRMode;
	}

	public void setQRMode(char qRMode) {
		QRMode = qRMode;
	}

	public char getQRErrCorrect() {
		return QRErrCorrect;
	}

	public void setQRErrCorrect(char qRErrCorrect) {
		QRErrCorrect = qRErrCorrect;
	}

	public int getQRVer() {
		return QRVer;
	}

	public void setQRVer(int qRVer) {
		QRVer = qRVer;
	}
	
	public int getQrSize() {
		return QrSize;
	}

	public void setQrSize(int qrSize) {
		QrSize = qrSize;
	}
}
