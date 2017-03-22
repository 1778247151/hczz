package com.crm.interceptor;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 异常拦截
 * 
 * @author yumaochun
 *
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
	
public ModelAndView resolveException(HttpServletRequest request,  

      HttpServletResponse response, Object handler, Exception ex) {  
	if (ex instanceof NumberFormatException) {
        return new ModelAndView("exception/number");
    } else if (ex instanceof NullPointerException) {
        return new ModelAndView("exception/null");
    }
	// ajax 请求
	if (request.getHeader("x-requested-with") != null
		&& request.getHeader("x-requested-with").equalsIgnoreCase(
		"XMLHttpRequest")) {
		try {
			response.getWriter().write("参数异常");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	try {
		response.getWriter().write("参数异常");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
    //return new ModelAndView("exception/exception");
	}  
}
 