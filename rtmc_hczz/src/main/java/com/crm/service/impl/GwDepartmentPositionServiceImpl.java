package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crm.core.ServersManager;
import com.crm.dao.GwDepartmentPositionDao;
import com.crm.pojo.GwDepartmentPositionModel;
import com.crm.service.GwDepartmentPositionService;

/**
 * 
 * 
 * GwDepartmentPositionServiceImpl:部门管理业务逻辑层实现
 *
 * @author  shengjinpeng
 * @date    2016年8月17日
 * @version jdk1.8
 *
 */
@Service("gwDepartmentPositionServiceManage")
public class GwDepartmentPositionServiceImpl extends ServersManager<GwDepartmentPositionModel, GwDepartmentPositionDao> implements GwDepartmentPositionService{
	
	@Resource(name = "gwDepartmentPositionDaoManage")
	@Override
	public void setDao(GwDepartmentPositionDao gwDepartmentPositionDao) {
		// TODO Auto-generated method stub
		this.dao = gwDepartmentPositionDao;
	}
	
	@Override
	public GwDepartmentPositionModel getDepartmentPositionByCode(String code) {
		return dao.getDepartmentPositionByCode(code);
	}

	@Override
	public List<GwDepartmentPositionModel> getDepartmentPositionsByDepartmentCode(String departmentCode) {
		// TODO Auto-generated method stub
		return dao.getDepartmentPositionsByDepartmentCode(departmentCode);
	}
	
}
