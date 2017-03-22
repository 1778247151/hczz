package com.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.dao.GwTypeTreeDao;
import com.crm.pojo.GwTypeTreeModel;

@Repository("gwTypeTreeDaoManage")
public class GwTypeTreeDaoImpl implements GwTypeTreeDao{
	@Resource
	private BaseDao dao;

	@Override
	public int insert(GwTypeTreeModel e) {
		return dao.update("gw.typeTree.insert", e);
	}

	@Override
	public int delete(GwTypeTreeModel e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIds(int[] ids) {
		return 0;
	}

	@Override
	public int update(GwTypeTreeModel e) {
		return dao.update("gw.typeTree.update", e);
	}

	@Override
	public GwTypeTreeModel selectOne(GwTypeTreeModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GwTypeTreeModel> selectList(GwTypeTreeModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.delete("gw.typeTree.deleteById", id);
	}

	@Override
	public GwTypeTreeModel selectById(int id) {
		return (GwTypeTreeModel) dao.selectOne("gw.typeTree.selectByPrimaryKey",id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GwTypeTreeModel> getAllList() {
		return dao.selectList("gw.typeTree.selectAllNode");
	}

	@Override
	public List<GwTypeTreeModel> getTypeTreeByPid(int pId) {
		return dao.selectList("gw.typeTree.selectByPid", pId);
	}


	@Override
	public BasePageResultVo getStoreHouseByPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.selectPageList("gw.typeTree.selectStoreHouseByPageList", "gw.typeTree.selectStoreHouseByPageCount", params);
	}


	@Override
	public List<GwTypeTreeModel> getTypeTreeByPcode(String code) {
		return dao.selectList("gw.typeTree.selectByPcode",code);
	}

	@Override
	public GwTypeTreeModel getTypeTreeByCode(String code) {
		return (GwTypeTreeModel) dao.selectOne("gw.typeTree.selectByCode", code);
	}
	
	@Override
	public List<GwTypeTreeModel> getTypeTreeByType(String type) {
		return dao.selectList("gw.typeTree.selectByType", type);
	}

	@Override
	public GwTypeTreeModel getTypeTreeByName(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return (GwTypeTreeModel) dao.selectOne("gw.typeTree.getTypeTreeByName", params);
	}

}
