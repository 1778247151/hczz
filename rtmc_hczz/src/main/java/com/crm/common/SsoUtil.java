package com.crm.common;

import net.sf.json.JSONObject;

/**
 * 
 * Title:SsoUtil
 * Description: 工具类
 * @author wenhaoboy@gmail.com
 *2016-9-5
 */
public class SsoUtil {
	
	/**
	 * 传入json String返回jsonObject
	 * @param is
	 * @return
	 */
	public static JSONObject jsonStringToObject(String jsonString)
	{
		if(jsonString==null||jsonString.length()<1)
		{
			return null ;
		}
		try{
			 JSONObject jsonobject = JSONObject.fromObject(jsonString);
			 
			 return jsonobject ;
		}catch(Exception e)
		{
			System.out.println("jsonString转换错误");
			return null ;
		}
		
	}

}
