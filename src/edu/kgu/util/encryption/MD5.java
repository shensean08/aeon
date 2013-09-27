package edu.kgu.util.encryption;

import java.lang.reflect.*; 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
   
public class MD5 {      
	public static String StrToMD5(String value ) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(value.getBytes());
			byte byteDigest[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset];
				if(i < 0) i+= 256;
				if(i < 16) buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			value = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
		return value.toUpperCase();
	}
}  