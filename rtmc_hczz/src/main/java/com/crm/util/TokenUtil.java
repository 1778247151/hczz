package com.crm.util;

import com.crm.common.MD5;

/**
 * 
 * 
 * TokenUtil:令牌工具类
 *
 * @author  yumaochun
 * @date    2016年9月19日
 * @version jdk1.8
 *
 */
public class TokenUtil {

	/**
	  * 
	  * createToken:生成token
	  *
	  * @author   yumaochun
	  * @date     2016年9月19日
	  *
	  * @param account       认证账号
	  * @return   返回：生成的token
	  */
     public static String createToken(String account){
   	     String dateTime=DateUtil.getCurrentDate("-");
   	     //混合的令牌：token(增加盐值)
   	     String token=account+"_GDWS_"+dateTime;
   	     //进行base64位加密
   	     String base64=token;
   	     //加密token
   	     String newToken=MD5.getMD5(account);
	     return newToken;
	 }
     
     public static void main(String[] args) {
		System.out.println("认证账号："+createToken("GDWS2016"));
	}
}
