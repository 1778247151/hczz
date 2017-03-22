package com.crm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.dao.GwRoleDao;
import com.crm.pojo.GwRoleModel;

/**
 * 
 * TSysMenuDaoImpl:系统菜单数据访问层的实现
 *
 * @author yumaochun
 * @date 2016年3月1日 下午10:51:45
 */
@Repository("gwRoleDaoManage")
public class GwRoleDaoImpl implements GwRoleDao{
	
	@Resource
	private BaseDao dao;

	@Override
	public int insert(GwRoleModel e) {
		// TODO Auto-generated method stub
		return dao.insert("gw.role.insert", e);
	}

	@Override
	public int delete(GwRoleModel e) {
		// TODO Auto-generated method stub
		return dao.delete("",e);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwRoleModel e) {
		// TODO Auto-generated method stub
		return dao.update("gw.role.update", e);
	}

	@Override
	public GwRoleModel selectOne(GwRoleModel e) {
		// TODO Auto-generated method stub
		return (GwRoleModel) dao.selectOne("gw.role.selectById", e);
	}

	@Override
	public List<GwRoleModel> selectList(GwRoleModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.delete("gw.role.deleteById", id);
	}

	@Override
	public GwRoleModel selectById(int id) {
		// TODO Auto-generated method stub
		return (GwRoleModel) dao.selectOne("gw.role.selectById", id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.selectPageList("gw.role.selectPageList", "gw.role.selectCount", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GwRoleModel> getAllList() {
		return dao.selectList("gw.role.selectList");
	}

	@Override
	public int batchInsert(List<GwRoleModel> list) {
		// TODO Auto-generated method stub
		return dao.insert("gw.role.batchInsert", list);
	}

	@Override
	public int batchUpdate(List<GwRoleModel> list) {
		// TODO Auto-generated method stub
		return dao.update("gw.role.batchUpdate", list);
	}

	@Override
	public int batchDelete(List<GwRoleModel> list) {
		// TODO Auto-generated method stub
		return dao.delete("gw.role.batchDelete", list);
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return dao.delete("gw.role.deleteAll");
	}

	
	
}
