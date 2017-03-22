package com.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crm.common.BasePageResultVo;
import com.crm.core.ServersManager;
import com.crm.dao.GwTypeTreeDao;
import com.crm.pojo.GwTypeTreeModel;
import com.crm.service.GwTypeTreeService;

/**
 * 
 * GwTypeTreeServiceImpl:类型树业务逻辑层实现
 *
 * @author xiangtao
 * @date  2016年6月20日
 * @version  jdk1.8
 *
 */
@Service("gwTypeTreeServiceManage")
public class GwTypeTreeServiceImpl extends ServersManager<GwTypeTreeModel, GwTypeTreeDao> implements GwTypeTreeService{
	
	@Resource(name = "gwTypeTreeDaoManage")
	@Override
	public void setDao(GwTypeTreeDao gwTypeTreeDao) {
		this.dao = gwTypeTreeDao;
	}
	
	/**
	 * 根据父节点查询节点
	 * 
	 * @param pId
	 * @return
	 */
	public List<GwTypeTreeModel> getTypeTreeByPid(int pId) {
		return dao.getTypeTreeByPid(pId);
	}

	@Override
	public BasePageResultVo getStoreHouseByPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.getStoreHouseByPageList(params);
	}

	/**
	 * 根据父节点code查询子节点
	 * 
	 * @param code
	 * @return
	 */
	@Override
	public List<GwTypeTreeModel> getTypeTreeByPcode(String code) {
		return dao.getTypeTreeByPcode(code);
	}

	@Override
	public GwTypeTreeModel getTypeTreeByCode(String code) {
		return dao.getTypeTreeByCode(code);
	}

	@Override
	public List<GwTypeTreeModel> getTypeTreeByType(String type) {
		return dao.getTypeTreeByType(type);
	}

	@Override
	public GwTypeTreeModel getTypeTreeByName(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.getTypeTreeByName(params);
	}
	
}
