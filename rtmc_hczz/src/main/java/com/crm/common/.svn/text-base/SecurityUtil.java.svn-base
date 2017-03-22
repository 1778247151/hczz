package com.crm.common;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

import com.crm.util.DateUtil;

/**
 * 
 * SecurityUtil:安全认证工具
 *
 * @author yumaochun
 * @date  2016年3月7日
 * @version  jdk1.8
 *
 */
public class SecurityUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3944392963091595823L;
	
	/**
	 * 
	 * createToken:生成token(随机生成)
	 *
	 * @date 2016年3月7日
	 * @param username           用户账号
	 * @param pwd                用户密码
	 */
	public static String createToken(String username,String pwd){
		String token_str=username+"#"+pwd+"#"+DateUtil.getCurrentDatetime("-");
		String token=MD5.getMD5(token_str);
		return token;
	}
    /**
     * 
     * getToken:获取token
     *
     * @date 2016年3月7日
     * @param request
     * @return
     */
	public static String getToken(HttpServletRequest request){
		Object obj=request.getSession().getAttribute("adminUser");
		if(obj!=null){
			AdminUser adminUser=(AdminUser)obj;
			return adminUser.getToken();
		}
		return "";
	}
	/**
	 * 
	 * createSessionToken:创建 token，并将token存入user的session中
	 *
	 * @date 2016年3月7日
	 * @param username            用户账号
	 * @param pwd                 密码
	 * @param request
	 * @return
	 */
	public static String createSessionToken(String username,String pwd,HttpServletRequest request){
		String token=createToken(username,pwd);
		request.getSession().setAttribute("token", token);
		return token;
	}
	/**
	 * 
	 * isLogin:是否登录
	 *
	 * @date 2016年3月8日
	 * @param request
	 * @return    true-已登录，false-未登录
	 */
	public static boolean isLogin(HttpServletRequest request){
		Object obj=request.getSession().getAttribute("adminUser");
		
		if(obj!=null){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * getAdminUser:获取当前登录的用户信息
	 *
	 * @date 2016年3月10日
	 * @param request                 request
	 * @return
	 */
	public static AdminUser getAdminUser(HttpServletRequest request){
		AdminUser adminUser=(AdminUser) request.getSession().getAttribute("adminUser");
		return adminUser;
	}
	/**
	 * 
	 * getUserId:获取当前登录用户id
	 *
	 * @date 2016年4月19日
	 * @param request               request
	 * @return     返回：用户id，用户不存在则放回0
	 */
	public static int getUserId(HttpServletRequest request){
		AdminUser adminUser=getAdminUser(request);
		if(adminUser!=null){
			return adminUser.getUserId();
		}
		return 0;
	}
}
