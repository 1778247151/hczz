package com.crm.util;

import java.io.Serializable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.crm.common.Status;


/**
 * 
 * 
 * CommonJson:认证系统服务器返回的数据格式，功能的json字符串转换为实体对象的工具类
 *
 * @author  yumaochun
 * @date    2016年10月11日
 * @version jdk1.8
 *
 */
public class CommonJson implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -1586190541302271923L;
	
    /**
     * 状态信息对象
     */
    private Status status;

    /**
     * 数据
     */
    private String data;

	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static CommonJson fromJson(String json) {
        Gson gson = new Gson();
		//将json数据转换为为
        return gson.fromJson(json, new TypeToken<CommonJson>(){}.getType());
    }

}
