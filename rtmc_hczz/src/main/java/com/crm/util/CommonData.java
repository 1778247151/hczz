package com.crm.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.crm.common.Status;


/**
 * 
 * 
 * CommonData:认证系统服务器返回的数据格式，功能的json字符串转换为实体对象的工具类
 *
 * @author  yumaochun
 * @date    2016年10月11日
 * @version jdk1.8
 *
 */
public class CommonData<T> implements Serializable{

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
    private T data;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@SuppressWarnings("rawtypes")
	public static CommonData fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(CommonData.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(CommonData.class, clazz);
        return gson.toJson(this, objectType);
    }

    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
    

    
}
