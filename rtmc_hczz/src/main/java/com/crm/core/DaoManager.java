package com.crm.core;

import java.util.List;
import java.util.Map;

import com.crm.common.BasePageResultVo;


/**
 * 该接口提供业务逻辑最基本的服务，所有的业逻辑类都必须实现此接口，这样该业务逻辑类对应
 * 的action就免去了写基本selectList、insert、update、toEdit、deletes麻烦s
 * 
 * @author yumaochun
 * 
 */
public interface DaoManager<E> {
	/**
	 * 添加
	 * 
	 * @param e
	 * @return
	 */
	public int insert(E e);

	/**
	 * 删除
	 * 
	 * @param e
	 * @return
	 */
	public int delete(E e);
	
	/**
	 * 
	 * deleteByIds:根据IDs数组,批量删除
	 *
	 * @date 2016年3月4日
	 * @param ids
	 * @return
	 */
	public int deleteByIds(int[] ids);

	/**
	 * 修改
	 * 
	 * @param e
	 * @return
	 */
	public int update(E e);

	/**
	 * 查询一条记录
	 * 
	 * @param e
	 * @return
	 */
	public E selectOne(E e);

	
	/**
	 * 根据条件查询所有
	 * @return
	 */
	public List<E> selectList(E e);

	/**
	 * 根据ID来删除一条记录
	 * @param id
	 */
	public int deleteById(int id);

	/**
	 * 根据ID查询一条记录
	 * @param id
	 * @return
	 */
	public E selectById(int id);
	
	/**
	 * 
	 * @func selectPageList：根据条件查询分页
	 *
	 * @date 2016年3月3日
	 * @param params        分页条件参数HashMap集合
	 * @return   BasePageResultVo  返回：分页信息对象
	 */
	public BasePageResultVo selectPageList(Map<String,Object> params);
	
	/**
	 * 
	 * getAllList:根据条件，获取所有菜单
	 *
	 * @date 2016年3月4日
	 * @param params       参数集合
	 * @return
	 */
	public List<E> getAllList();
}
