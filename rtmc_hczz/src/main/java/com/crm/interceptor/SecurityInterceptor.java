package com.crm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.crm.common.ResponseCode;
import com.crm.common.Status;
import com.crm.util.CommonUtil;

public class SecurityInterceptor implements HandlerInterceptor{
	
	//不拦截的地址
    private static final String[] IGNORE_URI = {"/adminUsers/login.do","/system/getRand.do"};


	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       
		//不用拦截的地址
				String url = request.getRequestURI().toString();
		        for (String s : IGNORE_URI) {
		            if (url.equals(s)) {
		            	return true;
		            }
		        }
				//获取session
				Object obj=request.getSession().getAttribute("adminUser");
				if(obj!=null){			
					return true;
				}
				else{
					//ajax请求
					if (request.getHeader("x-requested-with") != null
							&& request.getHeader("x-requested-with").equalsIgnoreCase(
							"XMLHttpRequest")) {
						Status status=new Status();
						status.setCode(ResponseCode.OPR_FAIL);//提示代码
						status.setMsg("会话过期");//提示信息
						status.setDebugMsg("");//bug信息
						status.setUrl("");//url
						//write info
						CommonUtil.outputAjaxJsonData(status,response);
						
						System.out.println("ajax请求为空");
						
						return false;
					}else{
						//非ajax请求
						//重定向地址
						response.sendRedirect("/");
						return false;
					}
				}
	}

}
