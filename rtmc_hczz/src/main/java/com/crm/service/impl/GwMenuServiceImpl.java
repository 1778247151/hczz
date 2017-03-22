package com.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.BasePageResultVo;
import com.crm.dao.GwMenuTreeDao;
import com.crm.dao.impl.GwMenuTreeDaoImpl;
import com.crm.pojo.GwMenuTreeModel;
import com.crm.service.GwMenuService;
/**
 * 
 * GwMenuServiceImpl:菜单管理业务逻辑层实现
 *
 * @author yumaochun
 * @date  2016年3月3日
 * @version  jdk1.8
 *
 */
@Service
public class GwMenuServiceImpl implements GwMenuService{
	
	@Autowired
	private GwMenuTreeDaoImpl gwMenuTreeDaoImpl;

	@Override
	public int insert(GwMenuTreeModel e) {
		// TODO Auto-generated method stub
		return gwMenuTreeDaoImpl.insert(e);
	}

	@Override
	public int delete(GwMenuTreeModel e) {
		// TODO Auto-generated method stub
		return gwMenuTreeDaoImpl.delete(e);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return gwMenuTreeDaoImpl.deleteById(id);
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwMenuTreeModel e) {
		// TODO Auto-generated method stub
		return gwMenuTreeDaoImpl.update(e);
	}

	@Override
	public GwMenuTreeModel selectOne(GwMenuTreeModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GwMenuTreeModel selectById(int id) {
		// TODO Auto-generated method stub
		return gwMenuTreeDaoImpl.selectById(id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GwMenuTreeModel> selectList(GwMenuTreeModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GwMenuTreeModel> getGwMenuListByPid(int fid) {
		// TODO Auto-generated method stub
		return gwMenuTreeDaoImpl.getGwMenuTreeByParentId(fid);
	}

	@Override
	public List<GwMenuTreeModel> getAllList() {
		// TODO Auto-generated method stub
		return gwMenuTreeDaoImpl.getAllList();
	}

	@Override
	public List<GwMenuTreeModel> getGwMenuListByPid_roleId(int pid, int roleId) {
		
		return gwMenuTreeDaoImpl.getMenuTreeByPid_roleId(pid, roleId);
	}

    @Override
    public List<GwMenuTreeModel> selectMenuTreeListBy(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        return gwMenuTreeDaoImpl.selectMenuTreeListBy(paramMap);
    }

    @Override
    public List<GwMenuTreeModel> selectSynMenuTreeByParentId(int fid) {
        // TODO Auto-generated method stub
        return gwMenuTreeDaoImpl.selectSynMenuTreeByParentId(fid);
    }

	@Override
	public List<GwMenuTreeModel> selectMeneTreeListByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return gwMenuTreeDaoImpl.selectMeneTreeListByRoleId(roleId);
	}

	

}
