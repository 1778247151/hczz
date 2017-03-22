package com.crm.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.crm.core.ServersManager;
import com.crm.dao.GwNoticeDao;
import com.crm.pojo.GwNoticeModel;
import com.crm.service.GwNoticeService;

/**
 * 
 * GwNoticeServiceImpl:公告业务逻辑层实现
 *
 * @author xiangtao
 * @date  2016年6月20日
 * @version  jdk1.8
 *
 */
@Service("gwNoticeServiceManage")
public class GwNoticeServiceImpl extends ServersManager<GwNoticeModel, GwNoticeDao> implements GwNoticeService{
	
	@Resource(name = "gwNoticeDaoManage")
	@Override
	public void setDao(GwNoticeDao gwNoticeDao) {
		this.dao = gwNoticeDao;
	}
}
