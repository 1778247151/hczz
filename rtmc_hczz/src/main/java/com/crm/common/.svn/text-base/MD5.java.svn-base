package com.crm.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.crm.util.DateUtil;
/**
 * 
 * MD5:MD5加密字符串
 *
 * @author yumaochun
 * @date  2016年3月7日
 * @version  jdk1.8
 *
 */
public class MD5 {
	
	 /**
	  * 
	  * getMD5:得到加密后的字符串
	  *
	  * @date 2016年3月7日
	  * @param orgin     待加密的字符串
	  * @return   返回加密的字符串
	  */
	 public static String getMD5(String orgin)
	 {
		 MessageDigest md=null;
		 byte[] bt=null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		 //得到加密后的字节数组(长度为16)
		 bt=md.digest(orgin.getBytes());
		 
		 StringBuffer stbf=new StringBuffer();
		 //对加密后的数组中的各个字节进行转换
		 for(int i=0;i<bt.length;i++)
		 {
			 int b=bt[i];
			 if(b<0)
				 b+=256;
			 if(b<16)
				 stbf.append("0");
			 stbf.append(Integer.toHexString(b));
		 }
		 return stbf.toString();
	 }
	 
	 public static void main(String[] args)
	 {
		 System.out.println(getMD5("SDK-BBX-010-255011-c7c[-[ccc").toUpperCase());
		
	 }
	 /**
	  * 
	  * createToken:生成token
	  *
	  * @author   yumaochun
	  * @date     2016年9月19日
	  *
	  * @param account
	  * @return
	  */
      public static String createToken(String account){
    	  String dateTime=DateUtil.getCurrentDatetime("-");
    	  //混合的令牌：token(增加盐值)
    	  String token=account+"_GDWS_"+dateTime;
    	  //进行base64位加密
    	  String base64=token;
    	  //加密token
    	  String newToken=getMD5(base64);
		 return newToken;
	 }
	 
	}
