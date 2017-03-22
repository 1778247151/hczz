package com.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.dao.GwarchivesDao;
import com.crm.pojo.GwarchivesModel;
@Repository("gwarchivesDaoManage")
public class GwarchivesDaoImpl implements GwarchivesDao{
	
	@Resource
	private BaseDao dao;

	@Override
	public int delete(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return dao.delete("gw.archives");
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GwarchivesModel selectOne(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GwarchivesModel> selectList(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GwarchivesModel selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.selectPageList("gw.archives.selectPageList", "gw.archives.selectCount", params);
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
		return 0;
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
	
	
	

}
