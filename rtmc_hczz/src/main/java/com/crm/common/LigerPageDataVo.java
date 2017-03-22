package com.crm.common;

import java.io.Serializable;
/**
 * 
 * LigerPageDataVo:针对liger UI 分页的数据格式
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
public class LigerPageDataVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1698952784411325878L;
	
	/**
	 * list数据集合
	 */
	private Object rows;
	/**
	 * 总记录数
	 */
	private Integer total;
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	

}
