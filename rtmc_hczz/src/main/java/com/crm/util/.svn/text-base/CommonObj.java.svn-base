package com.crm.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import com.google.gson.Gson;
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
public class CommonObj<T> implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -1586190541302271923L;
	/**
     * 分页信息
     */
    private String pageInfo;
    /**
     * 总记录数
     */
    private Integer total;
    
    /**
     * 状态信息对象
     */
    private Status status;

    /**
     * 数据
     */
    private T rows;

	public String getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}
     
	@SuppressWarnings("rawtypes")
	public static CommonObj<String> fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(CommonObj.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(CommonObj.class, clazz);
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
