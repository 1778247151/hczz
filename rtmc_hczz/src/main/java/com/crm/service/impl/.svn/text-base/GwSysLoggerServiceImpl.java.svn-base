package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crm.core.ServersManager;
import com.crm.dao.GwSysLoggerDao;
import com.crm.pojo.GwSysLoggerModel;
import com.crm.service.GwSysLoggerService;

/**
 * 
 * GwSysLoggerServiceImpl:系统日志业务逻辑层实现
 *
 * @author xiangtao
 * @date  2016年6月20日
 * @version  jdk1.8
 *
 */
@Service("gwSysLoggerServiceManage")
public class GwSysLoggerServiceImpl extends ServersManager<GwSysLoggerModel, GwSysLoggerDao> implements GwSysLoggerService{
	
	@Resource(name = "gwSysLoggerDaoManage")
	@Override
	public void setDao(GwSysLoggerDao gwSysLoggerDao) {
		this.dao = gwSysLoggerDao;
	}
	
	/**
	 * 
	 * 批量添加日志记录
	 * @param list
	 * @return
	 */
	@Override
	public int insetSysLoggerBatch(List<GwSysLoggerModel> list){
		return dao.insetSysLoggerBatch(list);
	}

	@Override
	public int batchDelete(List<Integer> list) {
		// TODO Auto-generated method stub
		return dao.batchDelete(list);
	}
	
}
