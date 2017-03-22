package com.crm.service;

import java.util.HashMap;
import java.util.List;

import com.crm.core.Services;
import com.crm.pojo.GwMenuTreeModel;
import com.crm.pojo.GwRoleGroupModel;
/**
 * 
 * GwRoleGroupService:角色权限业务逻辑层接口
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
public interface GwRoleGroupService extends Services<GwRoleGroupModel>{
	
	/**
	 * 
	 * insertRoleGroups:批量操作角色权限
	 *
	 * @date 2016年3月8日
	 * 
	 * @param list        角色权限集合
	 * @return
	 */
	public int insertRoleGroups(List<HashMap<String, Object>> list);
	
	/**
	 * 
	 * getRoleGroupsByRoleId:根据角色id，获取角色权限集合
	 *
	 * @date 2016年3月9日
	 * @param roleId          角色id
	 * @return
	 */
	public List<GwRoleGroupModel> getRoleGroupsByRoleId(int roleId);
	/**
	 * 
	 * deleteRoleGroup:删除权限
	 *
	 * @date 2016年3月9日
	 * @param roleId            角色id
	 * @param menuIds           菜单ids
	 * @return
	 */
	public boolean deleteRoleGroup(int roleId,int[] menuIds); 
	
	
	/**
	 * 
	 * getMenuFuncListByMenuId:根据角色id和菜单id（菜单类型links的id），获取菜单功能集合 
	 *
	 * @author yumaochun
	 * @date 2016年5月18日
	 * @param params   角色id和菜单id map
	 * @return   返回：用户角色菜单功能的集合
	 */
	public List<GwMenuTreeModel> getMenuFuncListByMenuId(HashMap<String, Object> params);
}
