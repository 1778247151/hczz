package com.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.core.ServersManager;
import com.crm.dao.GwRoleGroupDao;
import com.crm.pojo.GwMenuTreeModel;
import com.crm.pojo.GwRoleGroupModel;
import com.crm.service.GwRoleGroupService;
/**
 * 
 * GwRoleGroupServiceImpl:角色权限业务逻辑层实现
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
@Service("gwRoleGroupServiceManage")
public class GwRoleGroupServiceImpl extends ServersManager<GwRoleGroupModel, GwRoleGroupDao> implements GwRoleGroupService{
	
	@Resource(name = "gwRoleGropDaoManage")
	@Override
	public void setDao(GwRoleGroupDao gwRoleGroupDao) {
		// TODO Auto-generated method stub
		this.dao = gwRoleGroupDao;
	}

	@Override
	public int insertRoleGroups(List<HashMap<String, Object>> list) {
		// TODO Auto-generated method stub
		return dao.insertRoleGroups(list);
	}

	@Override
	public List<GwRoleGroupModel> getRoleGroupsByRoleId(int roleId) {
		return dao.getRoleGroupsByRoleId(roleId);
	}

	@Override
	public boolean deleteRoleGroup(int roleId, int[] menuIds) {
		// TODO Auto-generated method stub
		return dao.deleteRoleGroupBy(roleId, menuIds);
	}

	@Override
	public List<GwMenuTreeModel> getMenuFuncListByMenuId(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.getMenuFuncListByMenuId(params);
	}
	
}
