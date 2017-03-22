package com.crm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.BasePageResultVo;
import com.crm.common.BaseResultVo;
import com.crm.common.LigerPageDataVo;
import com.crm.common.ResponseCode;
import com.crm.common.SecurityUtil;
import com.crm.common.Status;
import com.crm.interceptor.BussAnnotation;
import com.crm.interceptor.exception.BaseException;
import com.crm.pojo.GwSysLoggerModel;
import com.crm.service.GwSysLoggerService;
import com.crm.util.DateUtil;

/**
 * 
 * GwSysLoggerController:系统日志访问控制层
 *
 * @author xiangtao
 * @date 2016年6月20日
 * @version jdk.8
 *
 */
@Controller
@RequestMapping("/sysLogger")
public class GwSysLoggerController extends BaseException {

	// 日志
	private Logger logger = LoggerFactory.getLogger(GwSysLoggerController.class);

	/**
	 * 系统日志业务逻辑
	 */
	@Resource(name = "gwSysLoggerServiceManage")
	private GwSysLoggerService gwSysLoggerServiceImpl;

	/**
	 * 
	 * getSysLoggerById:根据系统日志id，获取系统日志信息
	 *
	 * @date 206年3月5日
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSysLoggerById.do")
	@ResponseBody
	@BussAnnotation(moduleName = "系统日志维护", option = "获取信息通过ID")
	public BaseResultVo getSysLoggerById(int id, HttpServletRequest request) {
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

		// 获取系统日志信息
		GwSysLoggerModel gwSysLoggerModel = gwSysLoggerServiceImpl.selectById(id);
		baseResultVo.setData(gwSysLoggerModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * addSysLogger 添加系统日志
	 * 
	 * @date 2016年6月20日
	 * @param
	 * @return
	 */
	@RequestMapping("/addSysLogger.do")
	@ResponseBody
	@BussAnnotation(moduleName = "系统日志维护", option = "添加")
	public BaseResultVo addSysLogger(GwSysLoggerModel gwSysLoggerModel, HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();

		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url

		String ip = request.getRemoteAddr();
		gwSysLoggerModel.setIp(ip);
		gwSysLoggerModel.setOperateTime(DateUtil.getCurrentDatetime("-"));
		gwSysLoggerModel.setOperateUserId(SecurityUtil.getAdminUser(request).getUserId());

		List<GwSysLoggerModel> list = new ArrayList<GwSysLoggerModel>();
		GwSysLoggerModel gwSysLoggerModel1 = gwSysLoggerModel;

		gwSysLoggerModel1.setIp(ip);
		gwSysLoggerModel1.setOperateTime(DateUtil.getCurrentDatetime("-"));
		gwSysLoggerModel1.setOperateUserId(SecurityUtil.getAdminUser(request).getUserId());

		GwSysLoggerModel gwSysLoggerModel2 = gwSysLoggerModel;

		gwSysLoggerModel2.setIp(ip);
		gwSysLoggerModel2.setOperateTime(DateUtil.getCurrentDatetime("-"));
		gwSysLoggerModel2.setOperateUserId(SecurityUtil.getAdminUser(request).getUserId());

		list.add(gwSysLoggerModel1);
		list.add(gwSysLoggerModel2);

		gwSysLoggerServiceImpl.insetSysLoggerBatch(list);

		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * delSysLoggerById:根据系统日志id，删除系统日志
	 *
	 * @date 2016年6月20日
	 * @param id
	 *            系统日志id
	 * @param request
	 * @return
	 */
	@RequestMapping("/delSysLogger.do")
	@ResponseBody
	@BussAnnotation(moduleName = "系统日志维护", option = "删除")
	public BaseResultVo delSysLoggerById(String ids, HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		List<Integer> list = new ArrayList<>();
		String[] strs = ids.split(",");
		for (String str : strs) {
			list.add(Integer.parseInt(str));
		}

		int num = gwSysLoggerServiceImpl.batchDelete(list);
		if (num < 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("操作失败");// 提示信息
		}
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * updateSysLogger:更新系统日志
	 *
	 * @date 2016年6月20日
	 * @param gwSysLoggerModel
	 *            系统日志信息对象
	 * @return
	 */
	@RequestMapping("/updateSysLogger.do")
	@ResponseBody
	@BussAnnotation(moduleName = "系统日志维护", option = "修改")
	public BaseResultVo updateSysLogger(GwSysLoggerModel gwSysLoggerModel, HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url

		// 验证主键是否为空
		if (gwSysLoggerModel.getId() == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");
			baseResultVo.setStatus(status);
			return baseResultVo;
		}

		// 更新系统日志信息
		gwSysLoggerServiceImpl.update(gwSysLoggerModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * getSysLoggerList:获取系统日志集合（分页）
	 *
	 * @date 2016年6月20日
	 * @param page
	 *            当前页码数
	 * @param pagesize
	 *            每页显示记录数
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/getSysLoggerList.do")
	@ResponseBody
	@BussAnnotation(moduleName = "系统日志维护", option = "获取系统日志列表")
	public LigerPageDataVo getSysLoggerList(int currentPage, int pageSize, String description, String startTime,
			String endTime, HttpServletRequest request) {

		LigerPageDataVo data = new LigerPageDataVo();
		// 条件参数
		BaseResultVo ba = new BaseResultVo();
		// 时间验证
		// if (startTime != null && endTime != null) {
		// SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
		// try {
		// Date d1 = dfs.parse(startTime);
		// Date d2 = dfs.parse(endTime);
		// if ((d2.getTime() - d1.getTime()) < 0) {
		// ba.responseFail("结束时间不能小于开始时间");
		// data.setRows(ba);
		// return data;
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);
		params.put("description", description);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		BasePageResultVo baseResultVo = gwSysLoggerServiceImpl.selectPageList(params);
		// liger ui 分页格式数据

		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}
}
