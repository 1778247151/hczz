package com.crm.core;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.LoggerFactory;

import com.crm.common.BasePageResultVo;
import com.crm.common.PageInfo;


/**
 * BaseDao:封装mybatis最基本的数据库操作
 *
 * @author yumaochun
 * @date 2016年3月1日 下午10:58:15
 */
public class BaseDao extends SqlSessionDaoSupport {

	protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseDao.class);

	/**
	 * 打开session，mybatis中的session能进行数据库基本的操作
	 * 
	 * @return
	 */
	public SqlSession openSession() {
		try {
			SqlSession session = getSqlSession();
			return session;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询一条记录
	 * 
	 * @param sqlId       sqlId
	 * @return
	 */
	public Object selectOne(String sqlId) {
		SqlSession session = openSession();
		return session.selectOne(sqlId);
	}

	/**
	 * 根据条件，查询一条记录
	 * 
	 * @param sqlId          sqlId
	 * @param paramObj       参数对象
	 * @return
	 */
	public Object selectOne(String sqlId, Object paramObj) {
		SqlSession session = openSession();
		return session.selectOne(sqlId, paramObj);
	}

	/**
	 * 分页查询
	 * 
	 * @param selectList          分页sqlId
	 * @param selectCount         分页记录数sqlId
	 * @param params               查询条件参数对象(必须是hashMap类型，且包含currentPage,pageSize参数)
	 * @return        返回：分页对象
	 */
	public BasePageResultVo selectPageList(String selectList, String selectCount,
			Map<String,Object> params) {
		SqlSession session = openSession();
		
		//获取总记录数
		int totalRecord = session.selectOne(selectCount, params);
		
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
		//获取数据的集合
		@SuppressWarnings("rawtypes")
        List list = session.selectList(selectList, params);
		
		//是否还有下一页
		if(currentPage<totalPage){
			hasMore="1";
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
	
	
	

	/**
	 * 查询多条记录
	 * 
	 * @param sqlId       查询多条记录sqlId
	 * @return      返回：查询的数据list集合
	 */
	@SuppressWarnings("rawtypes")
    public List selectList(String sqlId) {
		SqlSession session = openSession();
		return session.selectList(sqlId);
	}

	/**
	 * 根据条件，查询多条记录
	 * 
	 * @param sqlId       查询多条记录sqlId
	 * @param param       查询多条记录参数对象
	 * @return   返回：查询的数据list集合
	 */
	@SuppressWarnings("rawtypes")
    public List selectList(String sqlId, Object param) {
		SqlSession session = openSession();
		return session.selectList(sqlId, param);
	}

	/**
	 * 根据条件，查询记录总数
	 * 
	 * @param sqlId          查询记录数sqlId
	 * @param param          查询条件参数对象
	 * @return   返回：总记录数
	 */
	public int getCount(String sqlId, Object param) {
		SqlSession session = openSession();
		return (Integer) session.selectOne(sqlId, param);
	}
	/**
	 * 根据条件，查询记录总数
	 * 
	 * @param sqlId          查询记录数sqlId
	 * @param param          查询条件参数对象
	 * @return   返回：总记录数
	 */
	public int getCount(String sqlId) {
		SqlSession session = openSession();
		return (Integer) session.selectOne(sqlId);
	}

	/**
	 * 插入一条记录
	 * 
	 * @param     sqlId          插入一条记录的sqlId
	 * @return    返回：受影响的记录数
	 */
	public int insert(String sqlId) {
		
		SqlSession session = openSession();
		return session.insert(sqlId);
	}

	/**
	 * 插入一条记录，成功则返回插入的ID；失败则抛出异常
	 * 
	 * @param sqlId          插入数据的sqlId
	 * @param params         插入数据的对象
	 * @return     返回：插入成功的主键id
	 */
	public int insert(String sqlId, Object params) {
		
		SqlSession session = openSession();
		int row = session.insert(sqlId, params);
		if(row==1){
			//JsonUtil.g
		}
		return row;
	}

	/**
	 * 无条件，更新记录
	 * 
	 * @param sqlId      更新一条记录的sqlId
	 * @return     返回：受影响的结果数
	 */
	public int update(String sqlId) {
		
		SqlSession session = openSession();
		return session.update(sqlId);
	}

	/**
	 * 根据条件，更新记录
	 * 
	 * @param sqlId          更新记录的sqlId
	 * @param params         更新记录的条件参数对象
	 * @return    返回：受影响的结果数
	 */
	public int update(String sqlId, Object params) {
		
		SqlSession session = openSession();
		int row = session.update(sqlId, params);
		return row;
	}

	/**
	 * 无条件，删除记录
	 * 
	 * @param sqlId              删除记录的sqlId
	 * @return   返回：删除记录，受影响的结果数
	 */
	public int delete(String sqlId) {
		
		SqlSession session = openSession();
		return session.delete(sqlId);
	}

	/**
	 * 根据条件，删除记录
	 * 
	 * @param sqlId      删除记录的sqlId
	 * @param params     删除记录的条件对象
	 * @return
	 */
	public int delete(String sqlId, Object params) {
		
		SqlSession session = openSession();
		return session.delete(sqlId, params);
	}

}
