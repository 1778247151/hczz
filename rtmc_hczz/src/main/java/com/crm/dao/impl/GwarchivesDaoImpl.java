package com.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.crm.common.BasePageResultVo;
import com.crm.common.PageInfo;
import com.crm.core.BaseDao;
import com.crm.dao.GwarchivesDao;
import com.crm.pojo.GwarchivesModel;
@Repository("gwarchivesDaoManage")
public class GwarchivesDaoImpl implements GwarchivesDao{
	
	@Resource
	private BaseDao dao;

	@Override
	public int delete(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return dao.delete("gw.archives");
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return dao.update("gw.archives.update", e);
	}

	@Override
	public GwarchivesModel selectOne(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GwarchivesModel> selectList(GwarchivesModel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GwarchivesModel selectById(int id) {
		// TODO Auto-generated method stub
		return (GwarchivesModel) dao.selectOne("gw.archives.selectByid", id);
	}

	@Override
	public BasePageResultVo selectPageList(Map<String, Object> params) {
		String sqlid="gw.archives.selectPageList";
		String param="gw.archives.selectCount";
	int totalRecord=dao.getCount(param,params);
		//当前页码数
		int currentPage=(Integer) params.get("currentPage");
		//每页显示记录数
		int pageSize=(Integer) params.get("pageSize");
		//余数
		int index=totalRecord%pageSize;
		//总页数
		int totalPage=index>0?(1+totalRecord/pageSize):totalRecord/pageSize;
		//是否还有下一页，0-没有 1-有
		String hasMore="0";
		
		
		//计算当前页码数
		if(totalPage<currentPage){
			currentPage=totalPage;
		}
		if(currentPage<=0){
			currentPage=1;
		}
		int offset=(currentPage-1)*pageSize;
		//将偏移量放入haspMap中
		params.put("offset", offset);
		List<GwarchivesModel> list =dao.selectList(sqlid, params);
		for (GwarchivesModel gwarchivesModel : list) {
			gwarchivesModel.setName("<a href='/index3.jsp?id="+gwarchivesModel.getId()+"' target='_Blank'>"+gwarchivesModel.getName()+"</a>");
			gwarchivesModel.setOperation("<div class='btn'>"+"<a href='javascript:InvitationPeople();' id='addArchives' class='add'>"+"邀请人员"+"</a>"+" </div>");
		}
		//分页信息
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageSize(pageSize);//每页显示记录数
		pageInfo.setCurrentPage(currentPage);//当前页码数
		pageInfo.setTotalPage(totalPage);//总页数
		pageInfo.setTotalRecord(totalRecord);//总记录数
		//是否还有下一页
		pageInfo.setHasMore(hasMore);
		BasePageResultVo basePageResultVo=new BasePageResultVo();
		//结果数据集合
		basePageResultVo.setRows(list);
		basePageResultVo.setTotal(totalRecord);

		//分页信息
		basePageResultVo.setPageInfo(pageInfo);
		return basePageResultVo;
		  
	}

	@Override
	public List<GwarchivesModel> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return dao.insert("gw.archives.insert", record);
	}

	@Override
	public int insertSelective(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GwarchivesModel selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(GwarchivesModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BasePageResultVo selectPageListByAccount(Map<String, Object> params) {
		String sqlid="gw.archives.selectPageListByAccount";
		String param="gw.archives.selectCountByAccount";
	int totalRecord=dao.getCount(param,params);
		//当前页码数
		int currentPage=(Integer) params.get("currentPage");
		//每页显示记录数
		int pageSize=(Integer) params.get("pageSize");
		//余数
		int index=totalRecord%pageSize;
		//总页数
		int totalPage=index>0?(1+totalRecord/pageSize):totalRecord/pageSize;
		//是否还有下一页，0-没有 1-有
		String hasMore="0";
		
		
		//计算当前页码数
		if(totalPage<currentPage){
			currentPage=totalPage;
		}
		if(currentPage<=0){
			currentPage=1;
		}
		int offset=(currentPage-1)*pageSize;
		//将偏移量放入haspMap中
		params.put("offset", offset);
		List<GwarchivesModel> list =dao.selectList(sqlid, params);
		for (GwarchivesModel gwarchivesModel : list) {
			gwarchivesModel.setName("<a href='/index3.jsp?id="+gwarchivesModel.getId()+"' target='_Blank'>"+gwarchivesModel.getName()+"</a>");
			gwarchivesModel.setOperation("<div class='btn'>"+"<a href='javascript:InvitationPeople();' id='addArchives' class='add'>"+"邀请人员"+"</a>"+" </div>");
		}
		//分页信息
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageSize(pageSize);//每页显示记录数
		pageInfo.setCurrentPage(currentPage);//当前页码数
		pageInfo.setTotalPage(totalPage);//总页数
		pageInfo.setTotalRecord(totalRecord);//总记录数
		//是否还有下一页
		pageInfo.setHasMore(hasMore);
		BasePageResultVo basePageResultVo=new BasePageResultVo();
		//结果数据集合
		basePageResultVo.setRows(list);
		basePageResultVo.setTotal(totalRecord);

		//分页信息
		basePageResultVo.setPageInfo(pageInfo);
		return basePageResultVo;
	}
	
	
	

}
