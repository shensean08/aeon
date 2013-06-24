package edu.kgu.aeon.Action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import edu.kgu.log.LogLogger;

public class SessionIterceptor extends AbstractInterceptor{

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = invocation.getInvocationContext();
        String user = (String)ctx.getSession().get("userID");
        
        if (user != null) {
            return invocation.invoke();
        }
        
        return Action.LOGIN;
    }
}
