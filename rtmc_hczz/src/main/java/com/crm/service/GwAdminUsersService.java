package com.crm.service;

import java.util.List;
import java.util.Map;

import com.crm.common.BasePageResultVo;
import com.crm.core.Services;
import com.crm.pojo.GwAdminUsersModel;
/**
 * 
 * GwAdminUsersService:管理员用户业务逻辑层接口
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
public interface GwAdminUsersService extends Services<GwAdminUsersModel>{
	
	/**
	 * 
	 * getAdminUsersByUsername:根据用户账号，获取用户信息
	 *
	 * @date 2016年3月7日
	 * @param username                 用户账号
	 * @return
	 */
	public GwAdminUsersModel getAdminUsersByUsername(String username);
	
	/**
	 * 
	 * selectByCondition:根据条件查询用户信息
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月17日
	 *
	 * @param params 	条件信息集合
	 * @return
	 */
	public BasePageResultVo selectByCondition(Map<String, Object> params);
	
	/**
	 * 
	 * getAdminUsersByPositionCode:根据职位编号获得用户列表
	 *
	 * @param code
	 * @return
	 */
	public List<GwAdminUsersModel> getAdminUsersByPositionCode(String positionCode);
	
}
