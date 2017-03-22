package com.crm.common;

import java.io.Serializable;
import java.util.Map;

/**
 * desc:返回信息实体类
 * 
 * @author yumaochun
 * @date   2015-6-26
 * @version
 *
 */
public class Message implements Serializable{

	
	private static final long serialVersionUID = -2064208810761802770L;
	
	/**
	 * 无参构造方法
	 */
	public Message(){
		
	}
	/**
	 * 一个参数构造方法
	 * 
	 * 
	 * @param msg    返回信息
	 */
	public Message(String msg){
		this.msg=msg;
	}
	/**
	 * 两个参数构造方法
	 * 
	 * @param msg   返回信息
	 * @param url   返回地址
	 */
	 public Message(String msg,String url){
			this.msg=msg;
			this.url=url;
	 }
	 /**
	  * 三个参数构造方法
	  * 
	  * @param type       返回类型
	  * @param msg        返回信息
	  * @param status     状态码
	  */
    public Message(String type,String msg,String status){
		this.type=type;
		this.msg=msg;
		this.status=status;
	}
    /**
     * 
     * 四个参数构造方法
     * 
     * @param type      返回类型
     * @param msg       返回信息
     * @param status    状态码
     * @param url       返回地址
     */
    public Message(String type,String msg,String status,String url){
		this.type=type;
		this.msg=msg;
		this.status=status;
		this.url=url;
	}
    /**
     * 
     * 四个参数构造方法
     * 
     * @param type      返回类型
     * @param msg       返回信息
     * @param status    状态码
     * @param data      数据对象
     */
    public Message(String type,String msg,String status,Map<String,Object> data){
		this.type=type;
		this.msg=msg;
		this.status=status;
		this.data=data;
	}
	
	/**
	 * 返回文本信息
	 */
	private String msg;
	/**
	 * 返回状态  (自定义的数字)
	 */
	private String status;
	/**
	 * 返回信息类型  如：error,success,warn,info
	 */
    private String type;
    /**
     * 返回的地址（主要用于跳转的地址）
     */
    private String url;
    
    /**
     * 数据对象
     */
    private Map<String, Object> data;
    
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
    
}
