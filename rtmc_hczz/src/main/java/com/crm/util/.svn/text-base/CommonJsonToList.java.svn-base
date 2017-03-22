package com.crm.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.crm.common.Status;
import com.google.gson.Gson;

/**
 * 
 * @author ymc  json数据公共转换工具类
 *
 * @param <T>                 转换的数据rows的对象类型
 */
public class CommonJsonToList<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -369558847578246550L;
    
    /**
     * 状态信息对象
     */
    private Status status;

    /**
     * 返回的记录数据集合
     */
    private List<T> data;

    
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public static CommonJsonToList fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(CommonJsonToList.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(CommonJsonToList.class, clazz);
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
