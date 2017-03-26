package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crm.core.DaoManager;
import com.crm.core.ServersManager;
import com.crm.dao.Rt_arUserDao;
import com.crm.pojo.Rt_arUser;
import com.crm.service.Rt_arUserService;
@Service("rt_ArUserServiceManage")
public class Rt_arUserServiceImpl  extends ServersManager<Rt_arUser, Rt_arUserDao> implements Rt_arUserService{
	@Resource(name="rt_ArUserDaoManage")
	
	@Override
	public void setDao(Rt_arUserDao arUserDao) {
		this.dao=arUserDao;		
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return dao.selectByUserId(userid) ;
	}
	@Override
	public List<Rt_arUser> selectByArchid(int archid) {
		// TODO Auto-generated method stub
		return dao.selectByArchid(archid);
	}

	
	
	

}
