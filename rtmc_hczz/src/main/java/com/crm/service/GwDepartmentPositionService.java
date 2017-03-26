package com.crm.service;

import java.util.List;

import com.crm.core.Services;
import com.crm.pojo.GwDepartmentPositionModel;
/**
 * 
 * 
 * GwDepartmentPositionService:部门管理业务逻辑层接口
 *
 * @author  shengjinpeng
 * @date    2016年8月17日
 * @version jdk1.8
 *
 */
public interface GwDepartmentPositionService extends Services<GwDepartmentPositionModel>{
	/**
	 * 
	 * getDepartmentPositionByCode:根据职位编号，获得职位信息
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月17日
	 *
	 * @param code
	 * @return
	 */
	public GwDepartmentPositionModel getDepartmentPositionByCode(String code);
	
	/**
	 * 
	 * getDepartmentPositionsByDepartmentCode:根据部门编号获得职位列表
	 *
	 * @param departmentCode
	 * @return
	 */
	public List<GwDepartmentPositionModel> getDepartmentPositionsByDepartmentCode(String departmentCode);
}
