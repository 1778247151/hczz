package com.crm.common;

import java.io.Serializable;

/**
 * 
 * BasePageResultVo:公共分页，数据实体类
 *
 * @author yumaochun
 * @date 2016年3月3日 下午4:31:38
 */
public class BasePageResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1657851494282948692L;
	/**
	 * 分页数据集合
	 */
	private Object rows;
	private Integer total ;
	/**
	 * 状态信息对象
	 */
	private Status status;
	/**
	 * 分页信息对象
	 */
	private PageInfo pageInfo;
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "BasePageResultVo [rows=" + rows + ", total=" + total + ", status=" + status + ", pageInfo=" + pageInfo
				+ "]";
	}
	

}
