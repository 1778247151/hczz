package com.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.dao.GwNoticeDao;
import com.crm.pojo.GwNoticeModel;

@Repository("gwNoticeDaoManage")
public class GwNoticeDaoImpl implements GwNoticeDao{
	@Resource
	private BaseDao dao;
	
	@Override
	public int insert(GwNoticeModel e) {
		return dao.insert("gw.notice.insert",e);
	}

	@Override
	public int delete(GwNoticeModel e) {
		return 0;
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwNoticeModel e) {
		return dao.update("gw.notice.update",e);
	}

	@Override
	public GwNoticeModel selectOne(GwNoticeModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GwNoticeModel> selectList(GwNoticeModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		return dao.delete("gw.notice.deleteById",id);
	}

	@Override
	public GwNoticeModel selectById(int id) {
		return (GwNoticeModel) dao.selectOne("gw.notice.selectByPrimaryKey",id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		return dao.selectPageList("gw.notice.selectPageList", "gw.notice.selectCount", params);
	}

	@Override
	public List<GwNoticeModel> getAllList() {
		return null;
	}

}
