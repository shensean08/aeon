package edu.kgu.util;

public class SystemParameter {
	public static String getClassesPath() {
		return Thread.currentThread().getContextClassLoader().getResource("").getPath();
	}
}
