package edu.kgu.util;

import edu.kgu.log.LogLogger;

public final class Resourse {
	public static String getItem(String key) {
		String rtn = "";
		
		String file = SystemParameter.getClassesPath();
		
		file = file + "resourse/aeon.properties";
		
		PropertiesFile pFile;
		try {
			pFile = new PropertiesFile(file);
			rtn = pFile.getValue(key);
		} catch (Exception e) {
			LogLogger.error(e);
		}
		
		return rtn;
	}
}
