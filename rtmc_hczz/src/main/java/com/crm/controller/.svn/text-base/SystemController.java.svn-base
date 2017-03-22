package com.crm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.common.AdminUser;
import com.crm.common.BaseResultVo;
import com.crm.common.SecurityUtil;
import com.crm.interceptor.BussAnnotation;
import com.crm.interceptor.exception.BaseException;
import com.crm.util.CommonUtil;


/**
 * 
 * SystemController:系统级访问控制层
 *
 * @author yumaochun
 * @date  2016年3月7日
 * @version  jdk1.8
 *
 */
@Controller
@RequestMapping("/system")
public class SystemController extends BaseException{
	//日志
	private Logger logger=LoggerFactory.getLogger(SystemController.class);

	/**
	 * 
	 * getRand:获取生产的随机字符串
	 *
	 * @date 2016年3月7日
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getRand.do")
	public void getRand(HttpServletRequest request,HttpServletResponse response) throws Exception{
		CommonUtil.outputImage(request,response);
		
	}
	@RequestMapping("/getRandStr.do")
	@ResponseBody
	public BaseResultVo getRandStr(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//只生成验证码
		String radmonStr=CommonUtil.getRandomInfo(request);
		return BaseResultVo.responseSuccess(radmonStr);
	}
	/**
	 * 
	 * login:进入用户登录界面
	 *
	 * @author   yumaochun
	 * @date     2016年10月28日
	 *
	 * @return
	 */
	@RequestMapping("/login.do")
	public ModelAndView login(){
		return new ModelAndView("/login");
	}
	/**
	 * 
	 * main:登录进入CRM系统主界面
	 *
	 * @author   yumaochun
	 * @date     2016年10月28日
	 *
	 * @return
	 */
	@RequestMapping("/main.do")
	public ModelAndView main(){
		return new ModelAndView("/main");
	}
	
	/**
	 * 
	 * isLogin:用户是否登录
	 *
	 * @date 2016年3月8日
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/isLogin.do")
	@ResponseBody
	public BaseResultVo isLogin(HttpServletRequest request){
		
		if(SecurityUtil.isLogin(request)){
			return BaseResultVo.responseSuccess("已登录");
		}
		
		return BaseResultVo.responseFail("未登录");
	}
	/**
	 * 
	 * loginOut:CRM用户退出系统
	 *
	 * @author   yumaochun
	 * @date     2016年10月10日
	 *
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/loginOut.do")
	@BussAnnotation(moduleName="CRM系统",option="退出系统")
	public ModelAndView loginOut(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session=request.getSession();
		AdminUser users=(AdminUser) session.getAttribute("adminUser");
		String username="";
		if(users!=null){
			username=users.getUsername();
			//销毁当前用户session
			session.removeAttribute("adminUser");
			//session.invalidate();
			logger.info("【"+username+"】用户成功退出系统");
		}else{
			logger.info("用户会话已过期，直接退出系统");
		}	
		return new ModelAndView("redirect:/system/login.do");
	}
	
	/**
	 * 
	 * logOutSystem:注销系统
	 *
	 * @date 2016年3月13日
	 * @return
	 */
	@RequestMapping(value="/logOutSystem.do")
	@ResponseBody
	@BussAnnotation(moduleName="CRM系统",option="退出系统")
	public BaseResultVo logOutSystem(HttpServletRequest request){
		
		AdminUser users=SecurityUtil.getAdminUser(request);
		String username="";
		if(users!=null){
			username=users.getUsername();
			request.removeAttribute("adminUser");
			logger.info("【"+username+"】用户成功退出系统");
			return BaseResultVo.responseSuccess("注销系统成功！");
		}else{
			logger.info("用户会话已过期，直接退出系统");
			return BaseResultVo.responseFail("用户会话已过期，直接退出系统");
		}	
		
		
	}
}
