package com.crm.dao;

import java.util.List;

import com.crm.core.DaoManager;
import com.crm.pojo.GwDepartmentModel;
import com.crm.pojo.GwRoleModel;
/**
 * 
 * 
 * GwDepartmentDao:部门管理数据访问层接口
 *
 * @author  shengjinpeng
 * @date    2016年8月17日
 * @version jdk1.8
 *
 */
public interface GwDepartmentDao extends DaoManager<GwDepartmentModel>{
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
	
	/**
	 * 批量插入
	 * 
	 * @param list
	 * @return
	 */
	public int batchInsert(List<GwDepartmentModel> list);

	/**
	 * 
	 * batchUpdate:批量更新
	 *
	 * @author hemingjun
	 * @date 2016年9月12日
	 * @param list
	 * @return
	 */
	public int batchUpdate(List<GwDepartmentModel> list);

	/**
	 * 
	 * batchDelete:批量删除
	 *
	 * @author hemingjun
	 * @date 2016年9月12日
	 * @param list
	 * @return
	 */
	public int batchDelete(List<GwDepartmentModel> list);
	/**
	 * 
	 * deleteAll:删除所有部门信息
	 *
	 * @author hemingjun
	 * @date 2016年10月19日
	 * @return
	 */
	public int deleteAll();
}