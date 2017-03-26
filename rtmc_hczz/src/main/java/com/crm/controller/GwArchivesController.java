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
import com.crm.pojo.GwarchivesModel;
import com.crm.pojo.Rt_arUser;
import com.crm.service.GwAdminUsersService;
import com.crm.service.GwarchivesService;
import com.crm.service.Rt_arUserService;


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
	 * 管理员用户业务逻辑
	 */
	@Resource(name = "gwAdminUsersServiceManage")
	private GwAdminUsersService gwAdminUsersServiceImpl;

	/**
	 * 获取用户档案用户业务逻辑
	 */
	@Resource(name = "gwarchivesServiceDaoManage")
	private GwarchivesService  gwarchivesServiceImpl;
	
	/**
	 * 案件人员业务逻辑
	 */
	@Resource(name = "rt_ArUserServiceManage")
	private Rt_arUserService rt_arUserService;
	
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
	public LigerPageDataVo getAdminUsersList(int currentPage, int pageSize, HttpServletRequest request,String name,String date) {
		AdminUser adminUser=SecurityUtil.getAdminUser(request);
		if(adminUser.getUsername().equals("superadmin")){
			// 条件参数
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("currentPage", currentPage);
			params.put("pageSize", pageSize);
			params.put("name", name);
			params.put("date", date);
			BasePageResultVo baseResultVo =gwarchivesServiceImpl.selectPageList(params);
			// liger ui 分页格式数据
			LigerPageDataVo data = new LigerPageDataVo();
			data.setRows(baseResultVo.getRows());
			data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
			return data;
			
		}else{
			// 条件参数
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("currentPage", currentPage);
			params.put("pageSize", pageSize);
			params.put("name", name);
			params.put("date", date);
			params.put("userid", adminUser.getUserId());
			BasePageResultVo baseResultVo =gwarchivesServiceImpl.selectPageListByAccount(params);
			// liger ui 分页格式数据
			LigerPageDataVo data = new LigerPageDataVo();
			data.setRows(baseResultVo.getRows());
			data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
			return data;
		}
		
		
	}
	
	/**
	 * 
	 * 	
	 * @return
	 */
	@RequestMapping("/allUser.do")
	@ResponseBody
	public  BaseResultVo getAllUser(){
		List<HashMap<String, Object>> treeList = new ArrayList<HashMap<String, Object>>();
	List<GwAdminUsersModel> list=	gwAdminUsersServiceImpl.getAllList();
		for (GwAdminUsersModel gwMembersModel : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", 1);// 菜单id
			map.put("pid", gwMembersModel.getId());// 父级菜单id
			map.put("text", gwMembersModel.getUsername() + "【" + gwMembersModel.getName() + "】");// 菜单名称
			map.put("isExpand", true);
			treeList.add(map);
			
		}
		
		BaseResultVo baseResultVo = BaseResultVo.responseSuccess("获取所有用户");
		baseResultVo.setData(treeList);
		return baseResultVo;
		
	}
	/**
	 * 
	 * 新增案件
	 * @param request
	 * @param response
	 * @param gwarchivesModel
	 * @return
	 */
	
	@RequestMapping("/addArchives.do")
	@ResponseBody
	public BaseResultVo  addArchives(HttpServletRequest request,HttpServletResponse response,GwarchivesModel gwarchivesModel){
		gwarchivesServiceImpl.insert(gwarchivesModel);
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功!");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		baseResultVo.setStatus(status);
		return baseResultVo;
		
	}
/**
 * 
 *getArchivesById:根据id查询用户信息 	
 * @param id
 * @param request
 * @return
 */
	@RequestMapping("/getArchivesById.do")
	@ResponseBody
	public BaseResultVo  getArchivesById(Integer id,HttpServletRequest request){
		
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		if (id < 0||id==null) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");// 提示信息
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		// 获取案件信息
		GwarchivesModel gwarchivesModel=	gwarchivesServiceImpl.selectById(id);
		String userList=getUserByArchives(id);
		gwarchivesModel.setUserList(userList);
		baseResultVo.setData(gwarchivesModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
		
	}
	/**
	 *updateArchives:修改案件 
	 * @param gwarchivesModel
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateArchives.do")
	@ResponseBody
	public BaseResultVo  updateArchives(GwarchivesModel gwarchivesModel,HttpServletRequest request){
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		// 验证主键是否为空
		if (gwarchivesModel.getId() == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		gwarchivesServiceImpl.update(gwarchivesModel);
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		baseResultVo.setStatus(status);
		return baseResultVo;
		
	}
	
	
	public String  getUserByArchives(Integer archId){
		List<String> list_user=new ArrayList<String>();
		List<Rt_arUser> list_aruser=rt_arUserService.selectByArchid(archId);
		for (Rt_arUser rt_arUser : list_aruser) {
			GwAdminUsersModel adminUsersModel=	gwAdminUsersServiceImpl.selectById(rt_arUser.getUiserId());
			list_user.add(adminUsersModel.getName());
		}
		return list_user.toString();
		
	}
	
	
	
	
}
