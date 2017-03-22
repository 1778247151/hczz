package com.crm.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Commonpage:分页公共实体类
 * 
 * @author yumaochun
 *
 */
public class CommonPage implements Serializable{
	
	/**
	 * 分页构造方法
	 * 
	 * @param currentPage    当前页码
	 * @param pageSize       每页显示记录数
	 */
	public CommonPage(int currentPage,int pageSize){
		if(currentPage>0){
			this.currentPage=currentPage;
		}
		if(pageSize>0){
			this.pageSize=pageSize;
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8962004399614421863L;
	
	/**
	 * 参数集合
	 */
	private HashMap<String,String> paramMap;
	
	/**
	 * 总页数
	 */
	private Integer totalPage;
	
	/**
	 * 总记录数
	 */
	private Integer totalRecord;
	
	/**
	 * 记录数据集合
	 */
	@SuppressWarnings("rawtypes")
	private List list=new ArrayList();
	/**
	 * 每页显示记录数
	 */
	private int pageSize = 10;
	
	/**
	 * 当前页码
	 */
	private int currentPage=1;
	
	/**
	 * 偏移量
	 */
	private int offset;

	
	public HashMap<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(HashMap<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		//每页显示记录数
		int size=getPageSize();
		//余数
		int index=totalRecord%size;
		//总页数
		this.totalPage=index>0?(1+totalRecord/size):totalRecord/size;
		//计算当前页码数
		if(this.totalPage<this.currentPage){
			this.currentPage=this.totalPage;
		}else if(this.currentPage<=0){
			this.currentPage=1;
		}
		//计算偏移量
		this.offset=(this.currentPage-1)*this.pageSize;
		//总记录数
		this.totalRecord = totalRecord;
		
	}

	@SuppressWarnings("rawtypes")
    public List getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
    public void setList(List list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
   

}
