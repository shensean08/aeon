package edu.kgu.util;

public class StringProcess {
	public static boolean chkMailAddress(String value) {
		return value.matches("[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+");
	}
	
	public static boolean chkKatakana(String value) {
		return value.matches("^[ァ-ヶー]*$");
	}
	
	public static String EraseInterpunction(String value) {
		String rtn = value.replaceAll("(\\.)*(\\,)*(\\-)*(\\?)*(\\%)*(\\')*(\\@)*", "");
		return rtn;
	}
	
	public static String[] DelStringListItem(String[] value,int index) {
		String[] rtn = new String[value.length - 1];
		System.arraycopy(value, 0, rtn, 0, index);
		System.arraycopy(value, index + 1, rtn, index, value.length - index - 1);
		return rtn;
	}
}
