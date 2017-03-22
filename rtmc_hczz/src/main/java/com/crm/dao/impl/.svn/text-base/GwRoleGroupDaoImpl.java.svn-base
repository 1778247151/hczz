package com.crm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.dao.GwRoleGroupDao;
import com.crm.pojo.GwMenuTreeModel;
import com.crm.pojo.GwRoleGroupModel;
import com.sun.swing.internal.plaf.basic.resources.basic;
/**
 * 
 * GwRoleGroupDaoImpl:角色权限组数据访问层接口的实现
 *
 * @author yumaochun
 * @date  2016年3月8日
 * @version  jdk1.8
 *
 */
@Repository("gwRoleGropDaoManage")
public class GwRoleGroupDaoImpl implements GwRoleGroupDao{

	@Resource
	private BaseDao dao;
	
	@Override
	public int insert(GwRoleGroupModel e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(GwRoleGroupModel e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwRoleGroupModel e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GwRoleGroupModel selectOne(GwRoleGroupModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<GwRoleGroupModel> selectList(GwRoleGroupModel e) {
		return dao.selectList("gw.roleGroup.selectList");
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GwRoleGroupModel selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GwRoleGroupModel> getAllList() {
		return dao.selectList("gw.roleGroup.selectList");
	}

	public int insertRoleGroups(List<HashMap<String, Object>> list) {
		
		return dao.insert("gw.roleGroup.insertRoleGroups", list);
	}

	@SuppressWarnings("unchecked")
	public List<GwRoleGroupModel> getRoleGroupsByRoleId(int roleId) {
		return dao.selectList("gw.roleGroup.selectListByRoleId", roleId);
	}

	@Override
	public boolean deleteRoleGroupBy(int roleId, int[] menuIds) {
		try {
			for (int menuId : menuIds) {
				Map<String, Object> params=new HashMap<String, Object>();
				params.put("roleId", roleId);
				params.put("menuId", menuId);
				dao.delete("gw.roleGroup.deleteByRoleIdMenuId", params);
			}
			return true;
		} catch (Exception e) {
		   return false;
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GwMenuTreeModel> getMenuFuncListByMenuId(HashMap<String, Object> params) {
		return dao.selectList("gw.roleGroup.getMenuFuncListByMenuId", params);
	}

}
