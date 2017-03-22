package com.crm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crm.common.BasePageResultVo;
import com.crm.common.BaseResultVo;
import com.crm.common.LigerPageDataVo;
import com.crm.common.ResponseCode;
import com.crm.common.SecurityUtil;
import com.crm.common.Status;
import com.crm.core.BaseDao;
import com.crm.interceptor.BussAnnotation;
import com.crm.interceptor.exception.BaseException;
import com.crm.pojo.GwNoticeModel;
import com.crm.pojo.GwTypeTreeModel;
import com.crm.service.GwNoticeService;
import com.crm.util.DateUtil;

/**
 * 
 * GwDepartmentController:公告访问控制层
 *
 * @author xiangtao
 * @date 2016年6月20日
 * @version jdk.8
 *
 */
@Controller
@RequestMapping("/notice")
public class GwNoticeController extends BaseException {

	// 日志
	private Logger logger = LoggerFactory.getLogger(GwNoticeController.class);

	/**
	 * 公告业务逻辑
	 */
	@Resource(name = "gwNoticeServiceManage")
	private GwNoticeService gwNoticeServiceImpl;
	
	/**
	 * 
	 * getNoticeById:根据公告id，获取公告信息
	 *
	 * @date 206年3月5日
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getNoticeById.do")
	@ResponseBody
	@BussAnnotation(moduleName="公告维护",option="获取公告信息通过ID")
	public BaseResultVo getNoticeById(int id, HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url

		if (id == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");// 提示信息
			baseResultVo.setStatus(status);
			return baseResultVo;
		}

		// 获取公告信息
		GwNoticeModel gwNoticeModel = gwNoticeServiceImpl.selectById(id);
		baseResultVo.setData(gwNoticeModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * addNotice 添加公告
	 * 
	 * @date 2016年6月20日
	 * @param
	 * @return
	 */
	@RequestMapping("/addNotice.do")
	@ResponseBody
	@BussAnnotation(moduleName="公告维护",option="添加")
	public BaseResultVo addNotice(GwNoticeModel gwNoticeModel, HttpServletRequest request) {
		Integer userid = SecurityUtil.getAdminUser(request).getUserId();
		gwNoticeModel.setCreateUserId(userid);
		gwNoticeModel.setCreateTime(DateUtil.getCurrentDatetime("-"));
		gwNoticeModel.setUpdateUserId(userid);
		gwNoticeModel.setUpdateTime(DateUtil.getCurrentDatetime("-"));
		gwNoticeModel.setSendStatus(0);

		String content = gwNoticeModel.getContent();
		if (content != null) {
			content = content.replaceAll("&", "&amp;");
			content = content.replaceAll("<", "&lt;");
			content = content.replaceAll(">", "&gt;");
			content = content.replaceAll("\"", "&quot;");
		}

		gwNoticeServiceImpl.insert(gwNoticeModel);

		BaseResultVo baseResultVo = new BaseResultVo();

		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url

		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * delNoticeById:根据公告id，删除公告
	 *
	 * @date 2016年6月20日
	 * @param id
	 *            公告id
	 * @param request
	 * @return
	 */
	@RequestMapping("/delNotice.do")
	@ResponseBody
	@BussAnnotation(moduleName="公告维护",option="删除")
	public BaseResultVo delNoticeById(int id, HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url

		if (id == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");// 提示信息
			baseResultVo.setStatus(status);
			return baseResultVo;
		}

		GwNoticeModel gwNoticeModel = gwNoticeServiceImpl.selectById(id);
		if (gwNoticeModel != null) {
			gwNoticeModel.setStatus(0);
		}

		int num = gwNoticeServiceImpl.update(gwNoticeModel);
		if (num < 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("操作失败");// 提示信息
		}
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * updateNotice:更新公告
	 *
	 * @date 2016年6月20日
	 * @param gwNoticeModel
	 *            公告信息对象
	 * @return
	 */
	@RequestMapping("/updateNotice.do")
	@ResponseBody
	@BussAnnotation(moduleName="公告维护",option="修改")
	public BaseResultVo updateNotice(GwNoticeModel gwNoticeModel, HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url

		// 验证主键是否为空
		if (gwNoticeModel.getId() == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");
			baseResultVo.setStatus(status);
			return baseResultVo;
		}

		// 更新时间
		gwNoticeModel.setUpdateTime(DateUtil.getCurrentDatetime("-"));
		int userid = SecurityUtil.getAdminUser(request).getUserId();
		gwNoticeModel.setUpdateUserId(userid);
		
		String content = gwNoticeModel.getContent();
		if (content != null) {
			content = content.replaceAll("&", "&amp;");
			content = content.replaceAll("<", "&lt;");
			content = content.replaceAll(">", "&gt;");
			content = content.replaceAll("\"", "&quot;");
		}

		// 更新公告信息
		gwNoticeServiceImpl.update(gwNoticeModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * getNoticeList:获取公告集合（分页）
	 *
	 * @date 2016年6月20日
	 * @param page
	 *            当前页码数
	 * @param pagesize
	 *            每页显示记录数
	 * @param request
	 * @return
	 */
	@RequestMapping("/getNoticeList.do")
	@ResponseBody
	@BussAnnotation(moduleName="公告维护",option="获取公告列表")
	public LigerPageDataVo getNoticeList(int currentPage, int pageSize, String startDate, String endDate, String title,String content,
			HttpServletRequest request) {
		// 条件参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);

		params.put("title", title);
		params.put("content", content);
		params.put("startDate", startDate);
		params.put("endDate", endDate);

		BasePageResultVo baseResultVo = gwNoticeServiceImpl.selectPageList(params);
		// liger ui 分页格式数据
		LigerPageDataVo data = new LigerPageDataVo();
		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}
}
