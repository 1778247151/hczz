package com.crm.dao.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.core.PagerModel;
import com.crm.dao.GwDepartmentDao;
import com.crm.pojo.GwDepartmentModel;
import com.crm.pojo.GwRoleModel;

/**
 * 
 * 
 * GwDepartmentDaoImpl:部门管理数据访问层的实现
 *
 * @author  shengjinpeng
 * @date    2016年8月17日
 * @version jdk1.8
 *
 */
@Repository("gwDepartmentDaoManage")
public class GwDepartmentDaoImpl implements GwDepartmentDao{
	
	@Resource
	private BaseDao dao;

	@Override
	public int insert(GwDepartmentModel e) {
		// TODO Auto-generated method stub
		return dao.insert("gw.department.insert", e);
	}

	@Override
	public int delete(GwDepartmentModel e) {
		// TODO Auto-generated method stub
		return dao.delete("",e);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwDepartmentModel e) {
		// TODO Auto-generated method stub
		return dao.update("gw.department.update", e);
	}

	@Override
	public GwDepartmentModel selectOne(GwDepartmentModel e) {
		// TODO Auto-generated method stub
		return (GwDepartmentModel) dao.selectOne("gw.department.selectById", e);
	}
	@Override
	public List<GwDepartmentModel> selectList(GwDepartmentModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.delete("gw.department.deleteById", id);
	}

	@Override
	public GwDepartmentModel selectById(int id) {
		// TODO Auto-generated method stub
		return (GwDepartmentModel) dao.selectOne("gw.department.selectById", id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.selectPageList("gw.department.selectPageList", "gw.department.selectCount", params);
	}

	@Override
	public List<GwDepartmentModel> getAllList() {
		// TODO Auto-generated method stub
		return dao.selectList("gw.department.selectLists");
	}

	@Override
	public GwDepartmentModel getDepartmentByCode(String code) {
		// TODO Auto-generated method stub
		return (GwDepartmentModel)dao.selectOne("gw.department.selectByCode", code);
	}
	
	@Override
	public int batchInsert(List<GwDepartmentModel> list) {
		// TODO Auto-generated method stub
		return dao.insert("gw.department.batchInsert", list);
	}

	@Override
	public int batchUpdate(List<GwDepartmentModel> list) {
		// TODO Auto-generated method stub
		return dao.update("gw.department.batchUpdate", list);
	}

	@Override
	public int batchDelete(List<GwDepartmentModel> list) {
		// TODO Auto-generated method stub
		return dao.delete("gw.department.batchDelete", list);
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return dao.delete("gw.department.deleteAll");
	}
	
}
