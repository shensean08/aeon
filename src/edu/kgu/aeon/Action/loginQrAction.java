package edu.kgu.aeon.Action;

import com.opensymphony.xwork2.Action;

import edu.kgu.log.LogLogger;


public class loginQrAction {
	private String name;
    private String result;

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }
	
	public String execute() {
		LogLogger.info("--");
		LogLogger.info(name);
		 this.result = "Hello! " + this.name + ".";
		return Action.SUCCESS;
	}
}
