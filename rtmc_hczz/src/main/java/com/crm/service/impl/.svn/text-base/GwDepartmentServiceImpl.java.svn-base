package com.crm.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.crm.core.ServersManager;
import com.crm.dao.GwDepartmentDao;
import com.crm.pojo.GwDepartmentModel;
import com.crm.service.GwDepartmentService;

/**
 * 
 * 
 * GwDepartmentServiceImpl:部门管理业务逻辑层实现
 *
 * @author  shengjinpeng
 * @date    2016年8月17日
 * @version jdk1.8
 *
 */
@Service("gwDepartmentServiceManage")
public class GwDepartmentServiceImpl extends ServersManager<GwDepartmentModel, GwDepartmentDao> implements GwDepartmentService{
	
	@Resource(name = "gwDepartmentDaoManage")
	@Override
	public void setDao(GwDepartmentDao gwDepartmentDao) {
		// TODO Auto-generated method stub
		this.dao = gwDepartmentDao;
	}
	
	@Override
	public GwDepartmentModel getDepartmentByCode(String code) {
		return dao.getDepartmentByCode(code);
	}
	
}
