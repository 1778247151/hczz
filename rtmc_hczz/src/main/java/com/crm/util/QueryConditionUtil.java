package com.crm.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crm.common.Condition;
import com.crm.common.QueryConditon;

/**
 * 
 * QueryConditionUtil:公用分页查询条件工具类
 *
 * @author yumaochun
 * @date  2016年4月14日
 * @version  jdk1.8
 *
 */
public class QueryConditionUtil {
	
	/**
	 * 
	 * getParamsMapByCondition:通过查询条件json字符串,转换为map条件集合
	 *
	 * @date 2016年4月14日
	 * @param condition  json字符串条件
	 * @return   返回：map类型的查询条件
	 */
	public static Map<String, Object> getParamsMapByCondition(String condition){
	   Map<String,Object> params = new HashMap<String,Object>();
	   //将json字符串转换为Condition
	   JsonMapper jsonUtil=JsonMapper.buildNonDefaultMapper();
	   List<Condition>  list=jsonUtil.fromJsonToList(condition,Condition.class);
	   if(list==null){
		   return params;
	   }
	   for (Condition conditionBean : list) {
	 	   //查询条件的，字段名称和字段对应的值
	 	   params.put(conditionBean.getField(), conditionBean.getValue());
	   }
	   return params;
	}
	
	/**
	 * 
	 * getParamsMap:将查询条件信息，转换为参数集合map
	 * 
	 * 注：该方法主要针对条件为json格式的查询方式
	 *
	 * @date 2016年4月14日
	 * @param queryParamArr               查询条件的字符数组（不需传递分页信息）
	 * @param queryCondition              查询条件对象
	 * @return     返回：查询条件集合Map
	 */
	public static Map<String, Object> getParamsMap(String[] queryParamArr,QueryConditon queryCondition){
		Map<String,Object> params=new HashMap<String,Object>();
		//当前页码数
		params.put("currentPage", queryCondition.getCurrentPage());
		//每页显示记录数
		params.put("pageSize", queryCondition.getPageSize());
		
		//liger ui查询条件json字符串
		String condition=queryCondition.getCondition();
		Map<String,Object> queryParamsMap=getParamsMapByCondition(condition);
		
		//查询条件初始化为空值，""
		for (String param : queryParamArr) {
			//循环将查询条件值，赋值到查询参数中
			params.put(param, queryParamsMap.get(param));
		}
		return params;
		
	}
	

}
