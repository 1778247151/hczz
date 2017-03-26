package com.crm.service;

import com.crm.core.Services;
import com.crm.pojo.GwDepartmentModel;
/**
 * 
 * 
 * GwDepartmentService:部门管理业务逻辑层接口
 *
 * @author  shengjinpeng
 * @date    2016年8月17日
 * @version jdk1.8
 *
 */
public interface GwDepartmentService extends Services<GwDepartmentModel>{
	/**
	 * 
	 * getDepartmentByCode:根据部门编号，获得部门信息
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月17日
	 *
	 * @param code
	 * @return
	 */
	public GwDepartmentModel getDepartmentByCode(String code);
}
