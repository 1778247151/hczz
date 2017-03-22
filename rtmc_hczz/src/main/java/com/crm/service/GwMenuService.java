package com.crm.service;


import java.util.List;
import java.util.Map;

import com.crm.core.Services;
import com.crm.pojo.GwMenuTreeModel;
/**
 * 
 * GwMenuService:系统菜单业务逻辑层接口
 *
 * @author yumaochun
 * @date  2016年3月3日
 * @version  jdk1.8
 *
 */
public interface GwMenuService extends Services<GwMenuTreeModel>{
	
	/**
	 * 
	 * getGwMenuListByPid:根据父级菜单ID，获取下级菜单list集合
	 *
	 * @date 2016年3月3日
	 * @param pid   父级菜单ID
	 * @return
	 */
	public List<GwMenuTreeModel> getGwMenuListByPid(int pid);
	
	/**
	 * 
	 * getGwMenuListByPid_roleId:根据pid和role获取菜单
	 *
	 * @date 2016年3月9日
	 * @param pid             父级菜单id
	 * @param roleId          角色id
	 * @return
	 */
	public List<GwMenuTreeModel> getGwMenuListByPid_roleId(int pid,int roleId);
	
	/**
     * 
     * selectMenuTreeListBy:根据条件获取菜单集合
     *
     * @author yumaochun
     * @date 2016年7月15日
     * @param paramMap    条件map
     * @return   返回：菜单集合
     */
    public List<GwMenuTreeModel> selectMenuTreeListBy(Map<String,Object> paramMap);
    
    /**
     * 
     * selectSynMenuTreeByParentId:在是需要同步数据的条件下， 根据父级菜单ID，获取下级菜单集合
     *
     * @author yumaochun
     * @date 2016年7月15日
     * @param fid                父级菜单id
     * @return
     */
    public List<GwMenuTreeModel> selectSynMenuTreeByParentId(int fid);
    
    /**
     * 
     * selectMeneTreeListByRoleId:根据角色获取所有角色菜单
     *
     * @author   cpf
     * @date     2016年11月15日
     *
     * @param roleId
     * @return
     */
    public List<GwMenuTreeModel> selectMeneTreeListByRoleId(int roleId);

}
