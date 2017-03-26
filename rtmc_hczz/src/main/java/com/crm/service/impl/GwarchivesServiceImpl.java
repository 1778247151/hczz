package com.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crm.common.BasePageResultVo;
import com.crm.core.DaoManager;
import com.crm.core.ServersManager;
import com.crm.dao.GwarchivesDao;
import com.crm.pojo.GwarchivesModel;
import com.crm.service.GwarchivesService;
@Service("gwarchivesServiceDaoManage")
public class GwarchivesServiceImpl extends ServersManager<GwarchivesModel, GwarchivesDao> implements GwarchivesService{
	@Resource(name="gwarchivesDaoManage")
	@Override
	public void setDao(GwarchivesDao dao) {
		this.dao=dao;
	}
	@Override
	public int delete(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<GwarchivesModel> selectList(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GwarchivesModel> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GwarchivesModel selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public BasePageResultVo selectPageListByAccount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.selectPageListByAccount(params);
	}



}
