package com.crm.service;

import java.util.List;
import java.util.Map;

import com.crm.common.BasePageResultVo;
import com.crm.core.Services;
import com.crm.pojo.GwTypeTreeModel;
/**
 * 
 * GwTypeTreeService:类型树业务逻辑层接口
 *
 * @author xiangtao
 * @date  2016年6月20日
 * @version  jdk1.8
 *
 */
public interface GwTypeTreeService extends Services<GwTypeTreeModel>{
	/**
	 * 根据父节点查询子节点
	 * 
	 * @param pId
	 * @return
	 */
	List<GwTypeTreeModel> getTypeTreeByPid(int pId);
	
	/**
	 * 获取仓库类分页List
	 * @param params
	 * @return
	 */
	public BasePageResultVo getStoreHouseByPageList(Map<String,Object> params);
	
	/**
	 * 根据父节点code查询子节点
	 * 
	 * @param code
	 * @return
	 */
	List<GwTypeTreeModel> getTypeTreeByPcode(String code);
	
	/**
	 * 根据编号获取对象
	 * 
	 * @param code
	 * @return
	 */
	GwTypeTreeModel getTypeTreeByCode(String code);
	
	/**
	 * 根据数据类型获取子节点
	 * 
	 * @param type
	 * @return
	 */
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
