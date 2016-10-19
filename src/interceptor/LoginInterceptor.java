package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import vo.Members;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Map<String, Object> session = invocation.getInvocationContext().getSession();
			Members loginId=(Members) session.get("members");
			
			if(loginId == null){
				return Action.LOGIN;
			}
		
		return invocation.invoke();
	}

}
