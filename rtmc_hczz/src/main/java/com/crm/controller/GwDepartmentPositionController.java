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
import com.crm.pojo.GwAdminUsersModel;
import com.crm.pojo.GwDepartmentPositionModel;
import com.crm.pojo.GwRoleModel;
import com.crm.service.GwAdminUsersService;
import com.crm.service.GwDepartmentPositionService;
import com.crm.util.DateUtil;
import com.crm.util.ValidateUtil;


/**
 * 
 * 
 * GwDepartmentPositionController:职位管理控制层
 *
 * @author  shengjinpeng
 * @date    2016年8月30日
 * @version jdk1.8
 *
 */
@Controller
@RequestMapping("/departmentPosition")
public class GwDepartmentPositionController extends BaseException {

	// 日志
	private Logger logger = LoggerFactory.getLogger(GwDepartmentPositionController.class);

	/**
	 * 职位管理业务逻辑
	 */
	@Resource(name = "gwDepartmentPositionServiceManage")
	private GwDepartmentPositionService gwDepartmentPositionServiceImpl;
	
	@Resource(name = "gwAdminUsersServiceManage")
	private GwAdminUsersService gwAdminUsersServiceImpl;

	/**
	 * 
	 * addDepartmentPosition:添加职位
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月30日
	 *
	 * @param gwDepartmentPositionModel 
	 * 						职位信息对象
	 * @return
	 */
	@RequestMapping("/addDepartmentPosition.do")
	@ResponseBody
	public BaseResultVo addDepartmentPosition(GwDepartmentPositionModel gwDepartmentPositionModel, HttpServletResponse response,HttpServletRequest request) {
		
		if(!ValidateUtil.isAvailableCodeStr(gwDepartmentPositionModel.getCode())) {
			return BaseResultVo.responseFail("职位编号只能是数字、字母或下划线!");
		}
		GwDepartmentPositionModel departmentPosition = gwDepartmentPositionServiceImpl.getDepartmentPositionByCode(gwDepartmentPositionModel.getCode());
		if(departmentPosition!=null) {
			return BaseResultVo.responseFail("职位编号已存在!");
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
		gwDepartmentPositionModel.setCreateUserId(adminUser.getUserId());
		//创建时间
		gwDepartmentPositionModel.setCreateTime(DateUtil.getCurrentDatetime("-"));
		//插入一条职位记录
		gwDepartmentPositionServiceImpl.insert(gwDepartmentPositionModel);
		logger.info(username+"新增了一条departmentPositionId为"+gwDepartmentPositionModel.getId()+"的职位");
		return baseResultVo;
	}

	/**
	 * 
	 * updateDepartmentPosition:更新职位信息
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月16日
	 *
	 * @param gwDepartmentPositionModel 
	 * 						职位信息对象
	 * @return
	 */
	@RequestMapping("/updateDepartmentPosition.do")
	@ResponseBody
	public BaseResultVo updateDepartmentPosition(GwDepartmentPositionModel gwDepartmentPositionModel,HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		if (gwDepartmentPositionModel.getId() == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");// 提示信息
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		
		//得到修改人信息
		AdminUser adminUser=SecurityUtil.getAdminUser(request);
		String username = adminUser.getUsername();

		//修改人
		gwDepartmentPositionModel.setUpdateUserId(adminUser.getUserId());
		//更新时间
		gwDepartmentPositionModel.setUpdateTime(DateUtil.getCurrentDatetime("-"));
		//更新职位信息
		gwDepartmentPositionServiceImpl.update(gwDepartmentPositionModel);
		logger.info(username+"更新了departmentPositionId为"+gwDepartmentPositionModel.getId()+"的职位");
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * getDepartmentPositionList:获取职位列表（分页）
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
	@RequestMapping("/getDepartmentPositionList.do")
	@ResponseBody
	public LigerPageDataVo getDepartmentPositionList(int currentPage, int pageSize, HttpServletRequest request) {
		// 条件参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);

		BasePageResultVo baseResultVo = gwDepartmentPositionServiceImpl.selectPageList(params);
		// liger ui 分页格式数据
		LigerPageDataVo data = new LigerPageDataVo();
		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}

	/**
	 * 
	 * getDepartmentPositionById:根据职位id，获取职位信息
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月16日
	 *
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getDepartmentPositionById.do")
	@ResponseBody
	public BaseResultVo getDepartmentPositionById(int id, HttpServletRequest request) {
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
		GwDepartmentPositionModel gwDepartmentPositionModel = gwDepartmentPositionServiceImpl.selectById(id);
		baseResultVo.setData(gwDepartmentPositionModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * deleteDepartmentPositionById:根据职位id，删除职位
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月16日
	 *
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteDepartmentPositionById.do")
	@ResponseBody
	public BaseResultVo deleteDepartmentPositionById(int id, HttpServletRequest request) {
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
		
		GwDepartmentPositionModel position = gwDepartmentPositionServiceImpl.selectById(id);
		List<GwAdminUsersModel> adminUserList =  gwAdminUsersServiceImpl.getAdminUsersByPositionCode(position.getCode());
		if(adminUserList!=null && adminUserList.size()>0) {
			return BaseResultVo.responseFail("该职位正在使用中，无法删除");
		}
		gwDepartmentPositionServiceImpl.deleteById(id);
		logger.info(username+"删除了departemntPositionId为"+id+"的职位");
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
	
	/**
	 * 
	 * getAllRoles:获取所有职位
	 *
	 * @date 2016年8月16日
	 * @return
	 */
	@RequestMapping("/getAllDepartmentPositions.do")
	@ResponseBody
	public Object getAllDepartmentPositions(){
		//获取所有角色
		List<GwDepartmentPositionModel> departmentPositions=gwDepartmentPositionServiceImpl.getAllList();
		List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		for (GwDepartmentPositionModel departmentPosition : departmentPositions) {
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("code", departmentPosition.getCode());
			map.put("text", departmentPosition.getCnName());
			list.add(map);
		}
		return list;
	}
	
	@RequestMapping("/getDepartmentPositionsByDepartmentCode.do")
	@ResponseBody
	public Object getDepartmentPositionsByDepartmentCode(String departmentCode){
		//获取所有角色
		List<GwDepartmentPositionModel> departmentPositions=gwDepartmentPositionServiceImpl.getDepartmentPositionsByDepartmentCode(departmentCode);
		List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		for (GwDepartmentPositionModel departmentPosition : departmentPositions) {
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("code", departmentPosition.getCode());
			map.put("text", departmentPosition.getCnName());
			list.add(map);
		}
		return list;
	}
	
	
}
