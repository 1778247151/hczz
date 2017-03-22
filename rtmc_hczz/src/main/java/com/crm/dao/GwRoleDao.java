package com.crm.dao;

import java.util.List;

import com.crm.core.DaoManager;
import com.crm.pojo.GwRoleModel;
/**
 * 
 * GwRoleDao:管理员角色数据访问接口层
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
public interface GwRoleDao extends DaoManager<GwRoleModel>{
	/**
	 * 批量插入
	 * 
	 * @param list
	 * @return
	 */
	public int batchInsert(List<GwRoleModel> list);

	/**
	 * 
	 * batchUpdate:批量更新
	 *
	 * @author hemingjun
	 * @date 2016年9月12日
	 * @param list
	 * @return
	 */
	public int batchUpdate(List<GwRoleModel> list);

	/**
	 * 
	 * batchDelete:批量删除
	 *
	 * @author hemingjun
	 * @date 2016年9月12日
	 * @param list
	 * @return
	 */
	public int batchDelete(List<GwRoleModel> list);
	/**
	 * 
	 * deleteAll:删除全部角色
	 *
	 * @author hemingjun
	 * @date 2016年10月19日
	 * @return
	 */
	public int deleteAll();
}