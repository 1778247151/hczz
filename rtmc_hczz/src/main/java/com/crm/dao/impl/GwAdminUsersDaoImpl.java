package com.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.dao.GwAdminUsersDao;
import com.crm.pojo.GwAdminUsersModel;

/**
 * 
 * TSysMenuDaoImpl:系统菜单数据访问层的实现
 *
 * @author yumaochun
 * @date 206年3月日 下午0:5:45
 */
@Repository("gwAdminUsersDaoManage")
public class GwAdminUsersDaoImpl implements GwAdminUsersDao{
	
	@Resource
	private BaseDao dao;

	@Override
	public int insert(GwAdminUsersModel e) {
		// TODO Auto-generated method stub
		return dao.insert("gw.adminUsers.insert", e);
	}

	@Override
	public int delete(GwAdminUsersModel e) {
		// TODO Auto-generated method stub
		return dao.delete("",e);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwAdminUsersModel e) {
		// TODO Auto-generated method stub
		return dao.update("gw.adminUsers.update", e);
	}

	@Override
	public GwAdminUsersModel selectOne(GwAdminUsersModel e) {
		// TODO Auto-generated method stub
		return (GwAdminUsersModel) dao.selectOne("gw.adminUsers.selectById", e);
	}


	@Override
	public List<GwAdminUsersModel> selectList(GwAdminUsersModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.delete("gw.adminUsers.deleteById", id);
	}

	@Override
	public GwAdminUsersModel selectById(int id) {
		// TODO Auto-generated method stub
		return (GwAdminUsersModel) dao.selectOne("gw.adminUsers.selectById", id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.selectPageList("gw.adminUsers.selectPageList", "gw.adminUsers.selectCount", params);
	}

	@Override
	public List<GwAdminUsersModel> getAllList() {
		// TODO Auto-generated method stub
		return dao.selectList("gw.adminUsers.selectLists");
	}

	@Override
	public GwAdminUsersModel getAdminUsersByUsername(String username) {
		
		return (GwAdminUsersModel) dao.selectOne("gw.adminUsers.getAdminUsersByUsername", username);
	}

	@Override
	public BasePageResultVo getAdminUsersByCondition(Map<String, Object> params) {
		return dao.selectPageList("gw.adminUsers.selectByCondition", "gw.adminUsers.selectCountByCondition", params);
	}

	@Override
	public List<GwAdminUsersModel> getAdminUsersByPositionCode(String positionCode) {
		// TODO Auto-generated method stub
		return dao.selectList("gw.adminUsers.selectListsByPositionCode", positionCode);
	}

	@Override
	public int batchInsert(List<GwAdminUsersModel> list) {
		// TODO Auto-generated method stub
		return dao.insert("gw.adminUsers.batchinsert", list);
	}

	@Override
	public int batchUpdate(List<GwAdminUsersModel> list) {
		// TODO Auto-generated method stub
		return dao.update("gw.adminUsers.batchUpdate", list);
	}

	@Override
	public int batchDelete(List<GwAdminUsersModel> list) {
		// TODO Auto-generated method stub
		return dao.delete("gw.adminUsers.batchDelete", list);
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return dao.delete("gw.adminUsers.deleteAll");
	}
	
}
