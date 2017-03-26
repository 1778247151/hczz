package com.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.dao.Rt_arUserDao;
import com.crm.pojo.Rt_arUser;
@Repository("rt_ArUserDaoManage")
public class Rt_arUserDaoImpl implements Rt_arUserDao {
	
	@Resource
	private BaseDao dao;
	
	@Override
	public int delete(Rt_arUser e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Rt_arUser e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rt_arUser selectOne(Rt_arUser e) {
		return (Rt_arUser) dao.selectOne("gw.arUser.selectByArchidAndUserid", e);
	}

	@Override
	public List<Rt_arUser> selectList(Rt_arUser e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.delete("gw.arUser.delete", id);
	}

	@Override
	public Rt_arUser selectById(int id) {
		// TODO Auto-generated method stub
		return (Rt_arUser) dao.selectOne("gw.arUser.selectByid",id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rt_arUser> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete("gw.arUser.delete", id);
	}

	@Override
	public int insert(Rt_arUser record) {
		// TODO Auto-generated method stub
		return dao.insert("gw.arUser.inserts", record);
	}

	@Override
	public int insertSelective(Rt_arUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rt_arUser selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Rt_arUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Rt_arUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rt_arUser selectByUserId(int userid) {
		return (Rt_arUser) dao.selectOne("gw.arUser.selectByUserId", userid);
	}

	@Override
	public List<Rt_arUser> selectByArchid(int archid) {
		// TODO Auto-generated method stub
		return dao.selectList("gw.arUser.selectByArchid", archid);
	}
	
	
	

}
