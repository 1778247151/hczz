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
public interface Services<E> {
	/**
	 * 
	 * insert:插入记录
	 *
	 * @date 2016年3月3日
	 * @param e           需要插入的数据对象
	 * @return
	 */
	public int insert(E e);

	/**
	 * 
	 * delete:根据条件，删除记录
	 *
	 * @date 2016年3月3日
	 * @param e     条件对象
	 * @return
	 */
	public int delete(E e);
	
	/**
	 * 
	 * deleteById:根据主键ID，删除记录
	 *
	 * @date 2016年3月3日
	 * @param id            主键ID
	 * @return
	 */
	public int deleteById(int id);

	/**
	 * 
	 * deletes:根据主键ids,批量删除数据
	 *
	 * @date 2016年3月3日
	 * @param ids      主键数组ids
	 * @return
	 */
	public int deletes(int[] ids);

	/**
	 * 
	 * update:更新记录
	 *
	 * @date 2016年3月3日
	 * @param e
	 * @return
	 */
	public int update(E e);

	/**
	 * 
	 * selectOne:根据条件，查询一条记录
	 *
	 * @date 2016年3月3日
	 * @param e
	 * @return
	 */
	public E selectOne(E e);
	
	/**
	 * 根据ID查询一条记录
	 * 
	 * @param id
	 * @return
	 */
	public E selectById(int id);

	/**
	 * 
	 * selectPageList:分页查询
	 *
	 * @date 2016年3月3日
	 * @param params     分页参数集合
	 * @return
	 */
	public BasePageResultVo selectPageList(Map<String,Object> params);
	
	/**
	 * 
	 * selectList:根据条件，查询记录list集合
	 *
	 * @date 2016年3月3日
	 * @param e          查询条件对象
	 * @return
	 */
	public List<E> selectList(E e);
	
	/**
	 * 
	 * getAllList:获取所有数据
	 *
	 * @date 2016年3月4日
	 * @return
	 */
	public List<E> getAllList();
	
}
