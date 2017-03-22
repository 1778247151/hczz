package com.crm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;

/**
 * 提供不同的结构类型之间的数据转换成JSON 
 * (XML,MAP,POJO ) -- >JSON
 * 
 * @author yumaochun
 * 
 */
public class JsonUtil {
	/**
	 * 将xml字符串转换为JSON对象
	 * 
	 * @param xmlFile
	 *            xml字符串
	 * @return JSON对象
	 */
	public static JSON getJSONFromXml(String xmlString) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSON json = xmlSerializer.read(xmlString);
		return json;
	}

	/**
	 * 将xmlDocument转换为JSON对象
	 * 
	 * @param xmlDocument
	 *            XML Document
	 * @return JSON对象
	 */
	public JSON getJSONFromXml(Document xmlDocument) {
		String xmlString = xmlDocument.toString();
		return getJSONFromXml(xmlString);
	}

	/**
	 * 将xml字符串转换为JSON字符串
	 * 
	 * @param xmlString
	 * @return JSON字符串
	 */
	public String getJSONStringFromXml(String xmlString) {
		return getJSONFromXml(xmlString).toString();
	}
	
	/**
	 * 将list转换为JSON字符串
	 * 
	 * @param list
	 *            List
	 * @return JSON字符串
	 */
	public static String getJSONStringFromList(@SuppressWarnings("rawtypes") List list) {
		return JSONSerializer.toJSON(list).toString();
	}

	/**
	 * 将xmlDocument转换为JSON字符串
	 * 
	 * @param xmlDocument
	 *            XML Document
	 * @return JSON字符串
	 */
	public String getJSONStringFromXMl(Document xmlDocument) {
		return getJSONStringFromXml(xmlDocument.toString());
	}

	/**
	 * 读取XML文件准换为JSON字符串
	 * 
	 * @param xmlFile
	 *            XML文件
	 * @return JSON字符串
	 */
	public String getJSONStringFromXMLFile(String xmlFile) {
		InputStream is = JsonUtil.class.getResourceAsStream(xmlFile);
		String xml;
		JSON json = null;
		try {
			xml = IOUtils.toString(is);
			XMLSerializer xmlSerializer = new XMLSerializer();
			json = xmlSerializer.read(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	/**
	 * 将Java对象转换为JSON格式的字符串
	 * 
	 * @param javaObj
	 *            POJO,例如日志的model
	 * @return JSON格式的String字符串
	 */
	public static String getJsonStringFromJavaPOJO(Object javaObj) {
		return JSONObject.fromObject(javaObj).toString(1);
	}

	/**
	 * 将Map转换为JSON字符串
	 * 
	 * @param map
	 * @return JSON字符串
	 */
	public static String getJsonStringFromMap(Map<?, ?> map) {
		JSONObject object = JSONObject.fromObject(map);
		return object.toString();
	}
	/**
	 * 
	 * getBeanFromMap:将map转换为bean对象
	 *
	 * @date 2016年3月23日
	 * @param map            map
	 * @return
	 */
	public static Object getBeanFromMap(Map<?, ?> map){
		String jsonStr=getJsonStringFromMap(map);
		return getBeanFromJsonString(jsonStr);
	}
	
	/**
	 * 将Map转换为JSON字符串
	 * 
	 * @param map
	 * @return JSON字符串
	 */
	public static String getLinkJsonStringFromMap(LinkedHashMap<String, String> map) {
		StringBuffer sb = new StringBuffer("{");
		String json = "";
		@SuppressWarnings("rawtypes")
        Iterator iter =  map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next().toString();
			sb.append("\""+key+"\"").append(":").append("\""+map.get(key)+"\"").append(",");
		}
		json = sb.substring(0, sb.length()-1);
		json+="}";
		return json;
	}
	
	/**
	 * 将Map转换为JSON字符串
	 * 
	 * @param map
	 * @return JSON字符串
	 */
	@SuppressWarnings("rawtypes")
    public static String getLinkJsonStringFromMap1(LinkedHashMap<String, Object> map) {
		StringBuffer sb = new StringBuffer("{");
		String json = "";
		Iterator iter =  map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next().toString();
			sb.append("\""+key+"\"").append(":").append("\""+map.get(key).toString()+"\"").append(",");
		}
		json = sb.substring(0, sb.length()-1);
		json+="}";
		return json;
	}
	
	/**
	 * 将Map转换为JSON字符串
	 * 
	 * @param map
	 * @return JSON字符串
	 */
	public static String getJsonStringFromXml(Map<?, ?> map) {
		JSONObject object = JSONObject.fromObject(map);
		return object.toString();
	}
	
	/**
	 * 将JSON转换为java Bean
	 * 
	 * @param String
	 * @return bean
	 */
	public static JSONObject getBeanFromJsonString(String json) {
		JSONObject object = JSONObject.fromObject(json);
		return object;
	}
	
	public static void main(String[] args) {
		//String jsString = "{'a':'1'}";
	}
}
