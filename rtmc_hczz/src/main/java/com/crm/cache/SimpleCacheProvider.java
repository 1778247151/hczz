package com.crm.cache;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * SimpleCacheProvider:自定义简单缓存工具
 *
 * @author yumaochun
 * @date  2016年9月25日
 * @version  jdk1.8
 *
 */
public class SimpleCacheProvider{
   
    /**
     * 构造方法
     */
    public SimpleCacheProvider() {

    }
    private static SimpleCacheProvider instance = new SimpleCacheProvider();
    
    /**
     * 缓存管理器
     */
    private static Map<String, Serializable> cacheContainer = Maps.newHashMap();

    public SimpleCacheProvider getInstance() {
        return instance;
    }

    public static void put(String key, Serializable cacheObject) {
        cacheContainer.put(key, cacheObject);
    }

    public static Serializable get(String key) {
        return cacheContainer.get(key);
    }

    public static void remove(String key) {
        cacheContainer.remove(key);
    }

    public static void clear() {
        cacheContainer.clear();
    }
    
    public static void main(String[] args) {
    	SimpleCacheProvider.put("name", "ymc");
    	System.out.println(SimpleCacheProvider.get("name"));
	}
    
}
