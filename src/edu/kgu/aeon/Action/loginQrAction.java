package edu.kgu.aeon.Action;

import edu.kgu.aeon.logic.loginQrLogic;

public class loginQrAction extends BaseAction {
	// logic
	loginQrLogic logic = new loginQrLogic();
	
	private String qrdecode;
    private String result;
    
	public String getQrdecode() {
		return qrdecode;
	}

	public void setQrdecode(String qrdecode) {
		this.qrdecode = qrdecode;
	}
	
    public String getResult() {
        return result;
    }
	
	public String execute() {
		this.result = logic.execute(qrdecode);
		this.messagebean = logic.messagebean;
		return SUCCESS;
	}
}
