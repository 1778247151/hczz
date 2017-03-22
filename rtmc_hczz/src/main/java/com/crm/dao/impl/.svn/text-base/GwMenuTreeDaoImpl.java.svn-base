package com.crm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.core.BaseDao;
import com.crm.dao.GwMenuTreeDao;
import com.crm.pojo.GwMenuTreeModel;

/**
 * 
 * TSysMenuDaoImpl:系统菜单数据访问层的实现
 *
 * @author yumaochun
 * @date 2016年3月1日 下午10:51:45
 */
@Repository
public class GwMenuTreeDaoImpl implements GwMenuTreeDao{
	
	@Resource
	private BaseDao dao;

	public int insert(GwMenuTreeModel e) {
		return dao.insert("insertGwMenuTree", e);
	}

	public int delete(GwMenuTreeModel e) {
		
		return dao.delete("deleteGwMenuTreeById", e);
	}

	public int update(GwMenuTreeModel e) {
		return dao.update("updateGwMenuTree", e);
	}

	public GwMenuTreeModel selectOne(GwMenuTreeModel e) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<GwMenuTreeModel> selectList(GwMenuTreeModel e) {
		
		return dao.selectList("insertGwMenuTree", e);
	}

	public int deleteById(int id) {
		return dao.delete("deleteGwMenuTreeById", id);
	}

	public GwMenuTreeModel selectById(int id) {

		return (GwMenuTreeModel) dao.selectOne("selectGwMenuTreeById", id);
	}
    /**
     * 
     * getGwMenuTreeByParentId:根据父级菜单ID，获取对应的下级菜单
     *
     * @date 2016年3月3日
     * @param pId
     * @return
     */
	public List<GwMenuTreeModel> getGwMenuTreeByParentId(int pId) {
	
		return dao.selectList("selectGwMenuTreeByParentId", pId);
	}

	public BasePageResultVo selectPageList(Map<String, Object> params) {

		return null;
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GwMenuTreeModel> getAllList() {
		// TODO Auto-generated method stub
		return dao.selectList("selectGwMenuTreeList");
	}

	@Override
	public List<GwMenuTreeModel> getMenuTreeByPid_roleId(int pid, int roleId) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("pid", pid);//父级菜单id
		params.put("roleId", roleId);//角色id
		return dao.selectList("getMenuTreeByPid_RoleId", params);
	}


    @Override
    public List<GwMenuTreeModel> selectMenuTreeListBy(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        return dao.selectList("selectMenuTreeListBy", paramMap);
    }

    @Override
    public List<GwMenuTreeModel> selectSynMenuTreeByParentId(int fid) {
        // TODO Auto-generated method stub
        return dao.selectList("selectSynMenuTreeByParentId",fid);
    }

	@Override
	public List<GwMenuTreeModel> selectMeneTreeListByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return dao.selectList("selectMeneTreeListByRoleId",roleId);
	}

	
}
