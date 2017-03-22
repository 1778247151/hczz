package com.crm.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.common.AdminUser;
import com.crm.common.BaseResultVo;
import com.crm.common.ResponseCode;
import com.crm.common.Status;
import com.crm.util.CommonUtil;



public class SessionFilter implements Filter {

	//不拦截的地址
    private static final String[] IGNORE_URI = {"/adminUsers/login.do","/system/getRandStr.do","/system/login.do"};
	
    //CRM接口地址
    String crmApi="/crmApi";
   
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) servletRequest;
		HttpServletResponse response=(HttpServletResponse) servletResponse;
		//当前请求的url
		String requestUrl = request.getRequestURI().toString();
		//判断是否是crm接口地址
        if(requestUrl.indexOf(crmApi)!=-1){
        	chain.doFilter(request, response);
        	return;
        }
		
		/*//获取sso认证登录的session
		SsoUser ssoUser = (SsoUser) request.getSession().getAttribute("ssoUser");
	    //判读sso用户是否已经在sso认证系统登录
	    if(ssoUser==null)
	    {    //sso用户未登录，重新定向到登录页面
	    	 response.sendRedirect("/system/login.do");
	    	 return;
	    }else{
	    	AdminUser user=(AdminUser) request.getSession().getAttribute("adminUser"); 
	        if(user==null){
	        	 String username= ssoUser.getUsername();
	        	 GwAdminUsersService gwAdminUsersServiceImpl=(GwAdminUsersService) ToolSpring.getBean("gwAdminUsersServiceManage");
	        	 //查询本地用户是否存在
	        	 GwAdminUsersModel tempAdminUser= gwAdminUsersServiceImpl.getAdminUsersByUsername(username);
	        	 if(tempAdminUser==null){
	        		 //重定向到前台系统登录页面
	    	    	 response.sendRedirect("/system/login.do");
	    	    	 return;
	    	     }else{
	    	    	 user=new AdminUser();
	    	    	 user.setGwRoleId(tempAdminUser.getGwRoleId());
	    	    	 user.setUserId(tempAdminUser.getId());
	    	    	 user.setName(tempAdminUser.getName());
	    	    	 user.setGwRoleName(tempAdminUser.getGwRoleName());
	    	    	 //将前台用户信息，存入session中
	    	    	 request.getSession().setAttribute("adminUser", user); 
	    	    	 //重定向到前台系统主页面
	    	    	 response.sendRedirect("/system/main.do");
	    	    	 return ;
	    	     } 
	        }else{
	        	String url = request.getRequestURI().toString();
	        	if(url.equals("/")||url.equals("/system/login.do")){
	        		 response.sendRedirect("/system/main.do");
	        		 return ;
	        	}
	        }
	    }		
		
		*/
		
		
		if(!isHasNoFilterUrl(request)){
			AdminUser user = (AdminUser)request.getSession().getAttribute("adminUser");
//		    System.out.println("====后台管理过滤开始======");
		    if(user != null) {
		    	
		    }
		    else{
		    	//不用拦截的地址
				String url = request.getRequestURI().toString();
		        for (String s : IGNORE_URI) {
		            if (url.equals(s)) {
		            	chain.doFilter(request, response);
		            	return;
		            }
		        }
		        
		        
		    	
				//ajax请求
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with").equalsIgnoreCase(
						"XMLHttpRequest")) {
					System.out.println("ajax请求为空");
					BaseResultVo baseResultVo=new BaseResultVo();
					Status status=new Status();
					status.setCode(ResponseCode.OPR_FAIL);//提示代码
					status.setMsg("会话过期");//提示信息
					status.setDebugMsg("");//bug信息
					status.setUrl("");//url
					//write info
					baseResultVo.setStatus(status);
					CommonUtil.outputAjaxJsonData(baseResultVo,response);
					return;
				}else{
					//非ajax请求
					//重定向地址
					System.out.println("非ajax请求");
					response.sendRedirect("/");
					return;
				}
			}
		}else{
			System.out.println("不用拦截");
		}

	    chain.doFilter(request, response);
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * isHasNoFilterUrl:是否是不需要拦截的url
	 *
	 * @date 2016年3月7日
	 * @param request
	 * @return
	 */
	public boolean isHasNoFilterUrl(HttpServletRequest request){
		//不用拦截的地址
		String url = request.getRequestURI().toString();
		for (String s : IGNORE_URI) {
		      if (url.equals(s)) {
		         return true;
		      }
		 }
		return false;
	}

	
}

