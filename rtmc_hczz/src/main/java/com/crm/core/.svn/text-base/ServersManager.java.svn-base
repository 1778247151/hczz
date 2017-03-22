package com.crm.core;

import java.util.List;
import java.util.Map;

import com.crm.common.BasePageResultVo;

public abstract class ServersManager<E, DAO extends  DaoManager<E>> implements Services<E>{
	
	protected DAO dao;

	public DAO getDao() {
		return dao;
	}

	public abstract void setDao(DAO dao);

	/**
	 * 添加
	 * 
	 * @param e
	 * @return
	 */
	public int insert(E e) {
		if(e==null){
			throw new NullPointerException();
		}
		return dao.insert(e);
	}

	/**
	 * 删除
	 * 
	 * @param e
	 * @return
	 */
	public int delete(E e) {
		if(e==null){
			throw new NullPointerException();
		}
		return dao.delete(e);
	}
	
	/**
	 * 根据id，删除记录
	 * 
	 * @param e
	 * @return
	 */
	public int deleteById(int id) {
		if(id==0){
			throw new NullPointerException("id不能全为空！");
		}
		return dao.deleteById(id);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	public int deletes(int[] ids) {
		if (ids == null || ids.length == 0) {
			throw new NullPointerException("id不能全为空！");
		}
		
		for (int i = 0; i < ids.length; i++) {
			if(ids[i] == 0){
				throw new NullPointerException("id不能为空！");
			}
			dao.deleteById(ids[i]);
		}
		return 0;
	}

	/**
	 * 修改
	 * 
	 * @param e
	 * @return
	 */
	public int update(E e) {
		if(e==null){
			throw new NullPointerException();
		}
		return dao.update(e);
	}

	/**
	 * 查询一条记录
	 * 
	 * @param e
	 * @return
	 */
	public E selectOne(E e) {
		return dao.selectOne(e);
	}

	public List<E> selectList(E e) {
		return dao.selectList(e);
	}

	public E selectById(int id) {
		return dao.selectById(id);
	}
	
	/**
	 * 获取分页数据对象
	 */
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		return dao.selectPageList(params);
	}
	/**
	 * 无条件，获取所有数据list
	 */
	public List<E> getAllList() {
		return dao.getAllList();
	}
}
