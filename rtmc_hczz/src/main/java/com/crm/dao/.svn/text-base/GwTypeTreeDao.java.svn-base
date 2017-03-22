package com.crm.dao;

import java.util.List;
import java.util.Map;

import com.crm.common.BasePageResultVo;
import com.crm.core.DaoManager;
import com.crm.pojo.GwTypeTreeModel;
/**
 * 
 * GwTypeTreeDao:类型树数据访问层接口
 *
 * @author xiangtao
 * @date  2016年6月20日
 * @version  jdk1.8
 *
 */
public interface GwTypeTreeDao extends DaoManager<GwTypeTreeModel>{
	List<GwTypeTreeModel> getTypeTreeByPid(int pId);

	
	/**
	 * 获取仓库类分页List
	 * @param params
	 * @return
	 */
	public BasePageResultVo getStoreHouseByPageList(Map<String,Object> params);


	GwTypeTreeModel getTypeTreeByCode(String code);

	List<GwTypeTreeModel> getTypeTreeByPcode(String code);


	List<GwTypeTreeModel> getTypeTreeByType(String type);
	/**
	 * 
	 * getTypeTreeByName:通过名称获取对象信息
	 *
	 * @author hemingjun
	 * @date 2016年10月10日
	 * @param params
	 * @return
	 */
	public GwTypeTreeModel getTypeTreeByName(Map<String, Object> params);
}