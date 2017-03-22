package com.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.dao.GwSysLoggerDao;
import com.crm.pojo.GwSysLoggerModel;

@Repository("gwSysLoggerDaoManage")
public class GwSysLoggerDaoImpl implements GwSysLoggerDao{
	@Resource
	private BaseDao dao;

	@Override
	public int insert(GwSysLoggerModel e) {
		return dao.insert("gw.sys.logger.insert", e);
	}

	@Override
	public int delete(GwSysLoggerModel e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwSysLoggerModel e) {
		return dao.update("gw.sys.logger.update",e);
	}

	@Override
	public GwSysLoggerModel selectOne(GwSysLoggerModel e) {
		return null;
	}

	@Override
	public List<GwSysLoggerModel> selectList(GwSysLoggerModel e) {
		return null;
	}

	@Override
	public int deleteById(int id) {
		return dao.delete("gw.sys.logger.deleteById", id);
	}

	@Override
	public GwSysLoggerModel selectById(int id) {
		return (GwSysLoggerModel) dao.selectOne("gw.sys.logger.selectByPrimaryKey", id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		return dao.selectPageList("gw.sys.logger.selectPageList", "gw.sys.logger.selectCount", params);
	}

	@Override
	public List<GwSysLoggerModel> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int insetSysLoggerBatch(List<GwSysLoggerModel> list){
		return dao.insert("gw.sys.logger.insertBatch", list);
	}
	@Override
	public int batchDelete(List<Integer> list) {
		// TODO Auto-generated method stub
		return dao.delete("gw.sys.logger.batchDelete", list);
	}
}
