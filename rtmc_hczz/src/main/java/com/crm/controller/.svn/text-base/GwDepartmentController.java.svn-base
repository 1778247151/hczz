package com.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.AdminUser;
import com.crm.common.BasePageResultVo;
import com.crm.common.BaseResultVo;
import com.crm.common.LigerPageDataVo;
import com.crm.common.ResponseCode;
import com.crm.common.SecurityUtil;
import com.crm.common.Status;
import com.crm.interceptor.exception.BaseException;
import com.crm.pojo.GwDepartmentModel;
import com.crm.pojo.GwDepartmentPositionModel;
import com.crm.service.GwDepartmentPositionService;
import com.crm.service.GwDepartmentService;
import com.crm.util.DateUtil;
import com.crm.util.ValidateUtil;


/**
 * 
 * 
 * GwDepartmentController:部门管理控制层
 *
 * @author  shengjinpeng
 * @date    2016年8月16日
 * @version jdk1.8
 *
 */
@Controller
@RequestMapping("/department")
public class GwDepartmentController extends BaseException {

	// 日志
	private Logger logger = LoggerFactory.getLogger(GwDepartmentController.class);

	/**
	 * 部门管理业务逻辑
	 */
	@Resource(name = "gwDepartmentServiceManage")
	private GwDepartmentService gwDepartmentServiceImpl;
	
	@Resource(name="gwDepartmentPositionServiceManage")
	private GwDepartmentPositionService gwDepartmentPositionServiceImpl;
	
	/**
	 * 
	 * addDepartment:添加部门
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月16日
	 *
	 * @param gwDepartmentModel 
	 * 						部门信息对象
	 * @return
	 */
	@RequestMapping("/addDepartment.do")
	@ResponseBody
	public BaseResultVo addDepartment(GwDepartmentModel gwDepartmentModel, HttpServletResponse response,HttpServletRequest request) {
		
		if(!ValidateUtil.isAvailableCodeStr(gwDepartmentModel.getCode())) {
			return BaseResultVo.responseFail("部门编号只能是数字、字母或下划线!");
		}
		GwDepartmentModel department = gwDepartmentServiceImpl.getDepartmentByCode(gwDepartmentModel.getCode());
		if(department!=null) {
			return BaseResultVo.responseFail("部门编号已存在!");
		}
		
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		baseResultVo.setStatus(status);
		//获取创建人信息
		AdminUser adminUser=SecurityUtil.getAdminUser(request);
		String username = adminUser.getUsername();

		//创建人
		gwDepartmentModel.setCreateUserId(adminUser.getUserId());
		//创建时间
		gwDepartmentModel.setCreateTime(DateUtil.getCurrentDatetime("-"));
		//部门状态
		//gwDepartmentModel.setStatus(1);
		//插入一条部门记录
		gwDepartmentServiceImpl.insert(gwDepartmentModel);
		logger.info(username+"新增了一条departmentId为"+gwDepartmentModel.getId()+"的部门");
		return baseResultVo;
	}

	/**
	 * 
	 * updateDepartment:更新部门信息
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月16日
	 *
	 * @param gwDepartmentModel 
	 * 						部门信息对象
	 * @return
	 */
	@RequestMapping("/updateDepartment.do")
	@ResponseBody
	public BaseResultVo updateDepartment(GwDepartmentModel gwDepartmentModel,HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		if (gwDepartmentModel.getId() == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");// 提示信息
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		
		//得到修改人信息
		AdminUser adminUser=SecurityUtil.getAdminUser(request);
		String username = adminUser.getUsername();

		//修改人
		gwDepartmentModel.setUpdateUserId(adminUser.getUserId());
		//更新时间
		gwDepartmentModel.setUpdateTime(DateUtil.getCurrentDatetime("-"));
		//更新部门信息
		gwDepartmentServiceImpl.update(gwDepartmentModel);
		logger.info(username+"更新了departmentId为"+gwDepartmentModel.getId()+"的部门");
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * getDepartmentList:获取部门列表（分页）
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月16日
	 *
	 * @param currentPage  
	 * 					当前页
	 * @param pageSize  
	 * 				每页记录数
	 * @return
	 */
	@RequestMapping("/getDepartmentList.do")
	@ResponseBody
	public LigerPageDataVo getDepartmentList(int currentPage, int pageSize, HttpServletRequest request) {
		// 条件参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);

		BasePageResultVo baseResultVo = gwDepartmentServiceImpl.selectPageList(params);
		// liger ui 分页格式数据
		LigerPageDataVo data = new LigerPageDataVo();
		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}

	/**
	 * 
	 * getDepartmentById:根据部门id，获取部门信息
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月16日
	 *
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getDepartmentById.do")
	@ResponseBody
	public BaseResultVo getDepartmentById(int id, HttpServletRequest request) {
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

		// 获取管理员用户信息
		GwDepartmentModel gwDepartmentModel = gwDepartmentServiceImpl.selectById(id);
		baseResultVo.setData(gwDepartmentModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * deleteDepartmentById:根据部门id，删除部门
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月16日
	 *
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteDepartmentById.do")
	@ResponseBody
	public BaseResultVo deleteDepartmentById(int id, HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		String username = SecurityUtil.getAdminUser(request).getUsername();
		if (id == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");// 提示信息
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		
		GwDepartmentModel department = gwDepartmentServiceImpl.selectById(id);
		List<GwDepartmentPositionModel>	departmentPositionList = gwDepartmentPositionServiceImpl.getDepartmentPositionsByDepartmentCode(department.getCode());
		
		if(departmentPositionList!=null && departmentPositionList.size()>0) {
			return BaseResultVo.responseFail("该部门正在使用中，无法删除");
		}
		
		gwDepartmentServiceImpl.deleteById(id);
		logger.info(username+"删除了departemntId为"+id+"的部门");
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
	
	/**
	 * 
	 * getAllRoles:获取所有部门
	 *
	 * @date 2016年8月30日
	 * @return
	 */
	@RequestMapping("/getAllDepartments.do")
	@ResponseBody
	public Object getAllDepartments(){
		//获取所有角色
		List<GwDepartmentModel> departments=gwDepartmentServiceImpl.getAllList();
		List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		for (GwDepartmentModel department : departments) {
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("code", department.getCode());
			map.put("text", department.getCnName());
			list.add(map);
		}
		return list;
	}
	
}
