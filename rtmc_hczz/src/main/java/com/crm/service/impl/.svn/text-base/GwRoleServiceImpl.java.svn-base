package com.crm.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.core.ServersManager;
import com.crm.dao.GwRoleDao;
import com.crm.pojo.GwRoleModel;
import com.crm.service.GwRoleService;
/**
 * 
 * GwMenuServiceImpl:菜单管理业务逻辑层实现
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
@Service("gwRoleServiceManage")
public class GwRoleServiceImpl extends ServersManager<GwRoleModel, GwRoleDao> implements GwRoleService{
	
	@Resource(name = "gwRoleDaoManage")
	@Override
	public void setDao(GwRoleDao gwRoleDao) {
		// TODO Auto-generated method stub
		this.dao = gwRoleDao;
	}
	
}
