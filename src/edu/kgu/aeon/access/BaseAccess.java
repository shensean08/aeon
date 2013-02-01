package edu.kgu.aeon.access;

import edu.kgu.sql.DBConnect;

public abstract class BaseAccess {
	
	protected ConnectAccess conn = new ConnectAccess();
	
	protected DBConnect dbConn;
}
