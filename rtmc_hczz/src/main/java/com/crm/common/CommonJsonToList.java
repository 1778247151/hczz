package com.crm.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

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
     * 
     */
    private String openid;
    
    /**
     * 记录数
     */
    private Integer total;
    
    /**
     * 状态编号
     */
    private String bm;

   

    /**
     * 返回的记录数据集合
     */
    private List<T> rows;

   

    public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
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
