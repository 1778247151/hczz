package com.crm.dao;

import java.util.List;

import com.crm.core.DaoManager;
import com.crm.pojo.GwDepartmentPositionModel;
import com.crm.pojo.GwRoleModel;

/**
 * 
 * 
 * GwDepartmentPositionDao:职位管理数据访问层接口
 *
 * @author  shengjinpeng
 * @date    2016年8月30日
 * @version jdk1.8
 *
 */
public interface GwDepartmentPositionDao extends DaoManager<GwDepartmentPositionModel>{
	
	/**
	 * 
	 * getDepartmentPositionByCode:根据职位编号查询职位
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月30日
	 *
	 * @param code		职位编号
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
	
	
	/**
	 * 批量插入
	 * 
	 * @param list
	 * @return
	 */
	public int batchInsert(List<GwDepartmentPositionModel> list);

	/**
	 * 
	 * batchUpdate:批量更新
	 *
	 * @author hemingjun
	 * @date 2016年9月12日
	 * @param list
	 * @return
	 */
	public int batchUpdate(List<GwDepartmentPositionModel> list);

	/**
	 * 
	 * batchDelete:批量删除
	 *
	 * @author hemingjun
	 * @date 2016年9月12日
	 * @param list
	 * @return
	 */
	public int batchDelete(List<GwDepartmentPositionModel> list);
	/**
	 * 
	 * deleteAll:删除所有职位信息
	 *
	 * @author hemingjun
	 * @date 2016年10月19日
	 * @return
	 */
	public int deleteAll();
}