package com.crm.dao;

import java.util.List;
import java.util.Map;

import com.crm.common.BasePageResultVo;
import com.crm.core.DaoManager;
import com.crm.pojo.GwAdminUsersModel;
/**
 * 
 * GwAdminUsersDao:管理员用户数据访问层接口
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
public interface GwAdminUsersDao extends DaoManager<GwAdminUsersModel>{
	/**
	 * 
	 * getAdminUsersByUsername:根据用户账号，获取用户信息
	 *
	 * @date 2016年3月7日
	 * @param username             用户账号
	 * @return
	 */
    public GwAdminUsersModel getAdminUsersByUsername(String username);
    
    /**
     * 
     * getAdminUsersByCondition:根据条件查询，用户信息
     *
     * @author   shengjinpeng
     * @date     2016年8月17日
     *
     * @param params 条件信息集合
     * @return
     */
	public BasePageResultVo getAdminUsersByCondition(Map<String, Object> params);
	
	/**
	 * 
	 * getAdminUsersByPositionCode:根据职位编号获得用户列表
	 *
	 * @param positionCode
	 * @return
	 */
	public List<GwAdminUsersModel> getAdminUsersByPositionCode(String positionCode);
	
	/**
	 * 批量插入
	 * 
	 * @param list
	 * @return
	 */
	public int batchInsert(List<GwAdminUsersModel> list);

	/**
	 * 
	 * batchUpdate:批量更新
	 *
	 * @author hemingjun
	 * @date 2016年9月12日
	 * @param list
	 * @return
	 */
	public int batchUpdate(List<GwAdminUsersModel> list);

	/**
	 * 
	 * batchDelete:批量删除
	 *
	 * @author hemingjun
	 * @date 2016年9月12日
	 * @param list
	 * @return
	 */
	public int batchDelete(List<GwAdminUsersModel> list);
	/**
	 * 
	 * deleteAll:删除所有用户
	 *
	 * @author hemingjun
	 * @date 2016年10月19日
	 * @return
	 */
	public int deleteAll();
}