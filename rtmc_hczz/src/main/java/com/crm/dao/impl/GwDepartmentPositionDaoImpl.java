package com.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.core.PagerModel;
import com.crm.dao.GwDepartmentPositionDao;
import com.crm.pojo.GwDepartmentModel;
import com.crm.pojo.GwDepartmentPositionModel;
import com.crm.pojo.GwRoleModel;

/**
 * 
 * 
 * GwDepartmentPositionDaoImpl:职位管理数据访问层的实现
 *
 * @author shengjinpeng
 * @date 2016年8月30日
 * @version jdk1.8
 *
 */
@Repository("gwDepartmentPositionDaoManage")
public class GwDepartmentPositionDaoImpl implements GwDepartmentPositionDao {

	@Resource
	private BaseDao dao;

	@Override
	public int insert(GwDepartmentPositionModel e) {
		// TODO Auto-generated method stub
		return dao.insert("gw.departmentposition.insert", e);
	}

	@Override
	public int delete(GwDepartmentPositionModel e) {
		// TODO Auto-generated method stub
		return dao.delete("", e);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwDepartmentPositionModel e) {
		// TODO Auto-generated method stub
		return dao.update("gw.departmentposition.update", e);
	}

	@Override
	public GwDepartmentPositionModel selectOne(GwDepartmentPositionModel e) {
		// TODO Auto-generated method stub
		return (GwDepartmentPositionModel) dao.selectOne("gw.departmentposition.selectById", e);
	}

	@Override
	public List<GwDepartmentPositionModel> selectList(GwDepartmentPositionModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.delete("gw.departmentposition.deleteById", id);
	}

	@Override
	public GwDepartmentPositionModel selectById(int id) {
		// TODO Auto-generated method stub
		return (GwDepartmentPositionModel) dao.selectOne("gw.departmentposition.selectById", id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.selectPageList("gw.departmentposition.selectPageList", "gw.departmentposition.selectCount", params);
	}

	@Override
	public List<GwDepartmentPositionModel> getAllList() {
		// TODO Auto-generated method stub
		return dao.selectList("gw.departmentposition.selectLists");
	}

	@Override
	public GwDepartmentPositionModel getDepartmentPositionByCode(String code) {
		// TODO Auto-generated method stub
		return (GwDepartmentPositionModel) dao.selectOne("gw.departmentposition.selectByCode", code);
	}

	@Override
	public List<GwDepartmentPositionModel> getDepartmentPositionsByDepartmentCode(String departmentCode) {
		// TODO Auto-generated method stub
		return dao.selectList("gw.departmentposition.selectListsByDeaprtmentCode", departmentCode);
	}

	@Override
	public int batchInsert(List<GwDepartmentPositionModel> list) {
		// TODO Auto-generated method stub
		return dao.insert("gw.departmentposition.batchInsert", list);
	}

	@Override
	public int batchUpdate(List<GwDepartmentPositionModel> list) {
		// TODO Auto-generated method stub
		return dao.update("gw.departmentposition.batchUpdate", list);
	}

	@Override
	public int batchDelete(List<GwDepartmentPositionModel> list) {
		// TODO Auto-generated method stub
		return dao.delete("gw.departmentposition.batchDelete", list);
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return dao.delete("gw.departmentposition.deleteAll");
	}

}
