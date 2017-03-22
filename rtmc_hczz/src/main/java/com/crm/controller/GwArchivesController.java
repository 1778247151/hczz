package com.crm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.BasePageResultVo;
import com.crm.common.LigerPageDataVo;
import com.crm.interceptor.exception.BaseException;
import com.crm.service.GwarchivesService;


/**
 * 
 * GwAdminUsersController:管理员用户访问控制层
 *
 * @author yumaochun
 * @date 206年3月5日
 * @version jdk.8
 *
 */
@Controller
@RequestMapping("/archives")
public class GwArchivesController extends BaseException {

	// 日志
	private Logger logger = LoggerFactory.getLogger(GwArchivesController.class);

	/**
	 * 获取用户档案用户业务逻辑
	 */
	@Resource(name = "gwarchivesServiceDaoManage")
	private GwarchivesService  gwarchivesServiceImpl;
	/**
	 * 
	 * getAdminUsersList:获取用户档案集合（分页）
	 *
	 * @date 206年3月5日
	 * @param page
	 *            当前页码数
	 * @param pagesize
	 *            每页显示记录数
	 * @param request
	 * @return
	 */
	@RequestMapping("/getArchivesList.do")
	@ResponseBody
	public LigerPageDataVo getAdminUsersList(int currentPage, int pageSize, HttpServletRequest request) {
		// 条件参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);

		BasePageResultVo baseResultVo =gwarchivesServiceImpl.selectPageList(params);
		// liger ui 分页格式数据
		LigerPageDataVo data = new LigerPageDataVo();
		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}
}
