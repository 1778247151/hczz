package com.crm.common;


import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/**
 * func:公用的ajax响应处理业务
 * 
 * @author yumaochun
 * @date   2015-6-26
 * @version
 *
 */
public class CommonJsonMessage {
	
	//日志
	private static Logger logger=Logger.getLogger(CommonJsonMessage.class);
	//响应成功信息对象
	private static Message success_message=new Message();
	//响应失败信息对象
	private static Message fail_message=new Message();
	
	//静态代码
	static{
		//成功
		success_message.setMsg("操作成功！");
		success_message.setStatus("1");
		success_message.setType("success");
		//失败
		fail_message.setMsg("操作失败！");
		fail_message.setStatus("0");
		fail_message.setType("error");
	}

	/**
	 * 
	 * fun:将字符串数据以json格式输出到页面
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @param outputString     要输出的json格式字符串
	 * @param response         response
	 */
	public static void outputAjaxJsonData(String outputString,HttpServletResponse response){ 
		try
		{ 
			outputAjaxJsonString(outputString,response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/**
	 * 
	 * fun:将对象转化成json格式数据以ajax方式输出到页面
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @param have
	 * @param obj
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
    public static void outputAjaxJsonData(boolean have,Map obj,HttpServletResponse response){
		String json = "";
		if (obj == null){
			json = "{success:false}";
			return;
		}
		else{			
			JSONObject object = JSONObject.fromObject(obj);
			try
			{
				json = object.toString();
				outputAjaxJsonString(json,response);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * fun:将对象转化成json格式数据以ajax方式输出到页面
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @param obj
	 * @param response
	 */
	public static void outputAjaxJsonData(Object obj,HttpServletResponse response){
		String json = "";
		if (obj == null){
			json = "{success:false}";
			return;
		}
		else{			
			JSONArray jsonObject = JSONArray.fromObject(obj);
			try
			{
				json = jsonObject.toString();
				outputAjaxJsonString(json,response);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * fun:将message对象以ajax（json数据格式）方式输出到页面上
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @param message   输出信息对象
	 * @param response  response
	 */
	public static void outputAjaxJsonData(Message message,HttpServletResponse response){
		String json = "";	
		JSONObject  jsonObject = JSONObject.fromObject(message);
		try
		{
			json = jsonObject.toString();
			outputAjaxJsonString(json,response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/**
	 * 
	 * outputAjaxJsonObjData:将obj对象，返回给ajax请求
	 *
	 * @date 2016年3月7日
	 * @param obj                    返回的对象
	 * @param response               response
	 */
	public static void outputAjaxJsonObjData(Object obj,HttpServletResponse response){
		String json = "";	
		JSONObject  jsonObject = JSONObject.fromObject(obj);
		try
		{
			json = jsonObject.toString();
			outputAjaxJsonString(json,response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/**
	 * 
	 * fun:将json格式字符串，以ajax 输出到页面上
	 *
	 * @author           yumaochun
	 * @date             2015-6-26
	 *
	 * @param jsonStr    json格式字符串
	 * @param response   response
	 */
	public static void outputAjaxJsonString(String jsonStr,HttpServletResponse response){
		String json=jsonStr;
		try {
			response.setContentType("text/json");
			response.setCharacterEncoding("utf-8");
			response.setHeader("Cache-Control","no-cache");
			response.getWriter().println(json);
			response.getWriter().close();
		} catch (Exception e) {
			logger.error("字符串数据以json格式输出到页面出错");
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * fun:ajax 向页面返回（json数据格式）【操作成功】
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @param message 
	 * @param response
	 * 
	 * @return 向前台抛出json格式数据：{msg:'操作成功',status:'0',type:'success',url:''}
	 */
	public static void responseSuccessMsg(Message message,HttpServletResponse response){
		Message messageObj=success_message;
		if(StringUtils.isNotBlank(message.getMsg())){
			messageObj.setMsg(message.getMsg());
		}
		if(StringUtils.isNotBlank(message.getUrl())){
			messageObj.setUrl(message.getUrl());
		}
        outputAjaxJsonData(messageObj, response);
	}
	/**
	 * 
	 * fun:ajax 向页面返回（json数据格式）【操作失败】
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @param message
	 * @param response
	 * @return 向前台抛出json格式数据：{msg:'操作失败',status:'0',type:'success',url:''}
	 */
	public static void responseFailMsg(Message message,HttpServletResponse response){
		Message messageObj=fail_message;
		if(StringUtils.isNotBlank(message.getMsg())){
			messageObj.setMsg(message.getMsg());
		}
		if(StringUtils.isNotBlank(message.getUrl())){
			messageObj.setUrl(message.getUrl());
		}
        outputAjaxJsonData(messageObj, response);
	}
	/**
	 * 
	 * fun:ajax 向页面返回（json数据格式）
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @param message
	 * @param response
	 */
	public static void responseMsg(Message message,HttpServletResponse response){
        outputAjaxJsonData(message, response);
	}
	/**
	 * 
	 * fun:普通的返回成功信息
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @return   message   信息对象
	 */
	public static Message returnSuccessMsg(){
		return success_message;
	}
	/**
	 * 
	 * fun:普通的返回失败信息
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @return    message     信息对象
	 */
	public static Message returnFailMsg(){
		return fail_message;
	}
	/**
	 * 
	 * fun:普通的返回警告提示信息
	 *
	 * @author   yumaochun
	 * @date     2015-6-26
	 *
	 * @return  message      信息对象
	 */
	public static Message returnWarnMsg(String msg){
		Message message=new Message();
		message.setStatus("0");
		message.setMsg(msg);
		message.setType("warn");
		return message;
	}
}
