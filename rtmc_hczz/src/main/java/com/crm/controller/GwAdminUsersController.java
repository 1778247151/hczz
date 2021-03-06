package com.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.bean.TMonPopManagerBean;
import com.crm.common.AdminUser;
import com.crm.common.BasePageResultVo;
import com.crm.common.BaseResultVo;
import com.crm.common.LigerPageDataVo;
import com.crm.common.MD5;
import com.crm.common.ResponseCode;
import com.crm.common.SecurityUtil;
import com.crm.common.Status;
import com.crm.enums.AdminUserStatusEnum;
import com.crm.interceptor.BussAnnotation;
import com.crm.interceptor.exception.BaseException;
import com.crm.pojo.GwAdminUsersModel;
import com.crm.service.GwAdminUsersService;
import com.crm.util.AdminUtil;
import com.crm.util.Certification;
import com.crm.util.DateUtil;
import com.crm.util.ValidateUtil;


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
@RequestMapping("/adminUsers")
public class GwAdminUsersController extends BaseException {

	// 日志
	private Logger logger = LoggerFactory.getLogger(GwAdminUsersController.class);

	/**
	 * 管理员用户业务逻辑
	 */
	@Resource(name = "gwAdminUsersServiceManage")
	private GwAdminUsersService gwAdminUsersServiceImpl;

	/**
	 * 
	 * addAdminUsers:添加管理员用户
	 *
	 * @date 206年3月5日
	 * @param gwAdminUsersModel
	 * @return
	 */
	@RequestMapping("/addAdminUsers.do")
	@ResponseBody
	public BaseResultVo addAdminUsers(GwAdminUsersModel gwAdminUsersModel, HttpServletResponse response,HttpServletRequest request) {
		String username = SecurityUtil.getAdminUser(request).getUsername();
		if (!ValidateUtil.isAvailableAccountStr(gwAdminUsersModel.getUsername(), 3, 20)) {
			return BaseResultVo.responseFail("用户名只能输入3-20位英文、数字、下划线、或者邮箱");	    
		}
		if (!ValidateUtil.isAvailableAccountStr(gwAdminUsersModel.getPassword(), 5, 20)) {
			return BaseResultVo.responseFail("密码只能输入5-50位英文、数字、下划线、或者邮箱");
		}
		if (!ValidateUtil.isLengthRangeStr(gwAdminUsersModel.getName(), 2, 6)) {
			return BaseResultVo.responseFail("姓名长度为2-6个字符");
		}
		
		GwAdminUsersModel adminUser = gwAdminUsersServiceImpl.getAdminUsersByUsername(gwAdminUsersModel.getUsername());
		if(adminUser!=null) {
			return BaseResultVo.responseFail("该用户名已存在");
		}
		
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功!");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		baseResultVo.setStatus(status);
		// 密码加密
		gwAdminUsersModel.setPassword(MD5.getMD5(gwAdminUsersModel.getPassword()));

		// 更新时间
		gwAdminUsersModel.setDtime(DateUtil.getCurrentDatetime("-"));
		//创建人
		gwAdminUsersModel.setCreateUserId(SecurityUtil.getAdminUser(request).getUserId());
		//创建时间
		gwAdminUsersModel.setCreateTime(DateUtil.getCurrentDatetime("-"));
        System.out.println(gwAdminUsersModel.getPassword());
		gwAdminUsersServiceImpl.insert(gwAdminUsersModel);
		logger.info(username+"新增了一条userId为"+gwAdminUsersModel.getId()+"的管理员");
		return baseResultVo;
	}

	/**
	 * 
	 * updateAdminUsers:更新管理员用户
	 *
	 * @date 206年3月5日
	 * @param gwAdminUsersModel
	 *            管理员用户信息对象
	 * @return
	 */
	@RequestMapping("/updateAdminUsers.do")
	@ResponseBody
	@BussAnnotation(moduleName="用户管理",option="修改用户")  
	public BaseResultVo updateAdminUsers(GwAdminUsersModel gwAdminUsersModel,HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功!");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		if (!ValidateUtil.isAvailableAccountStr(gwAdminUsersModel.getUsername(), 3, 20)) {
			return BaseResultVo.responseFail("用户名只能输入3-20位英文、数字、下划线、或者邮箱");	    
		}
		if (!ValidateUtil.isLengthRangeStr(gwAdminUsersModel.getName(), 2, 6)) {
			return BaseResultVo.responseFail("姓名长度为2-6个字符");
		}
		String username = SecurityUtil.getAdminUser(request).getUsername();
		// 验证主键是否为空
		if (gwAdminUsersModel.getId() == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		//得到修改人信息
		AdminUser adminUser=SecurityUtil.getAdminUser(request);
		
		// 更新时间
		gwAdminUsersModel.setDtime(DateUtil.getCurrentDatetime("-"));
		
		//修改人
		gwAdminUsersModel.setUpdateUserId(adminUser.getUserId());
		//更新时间
		gwAdminUsersModel.setUpdateTime(DateUtil.getCurrentDatetime("-"));
		// 更新管理员用户
		gwAdminUsersServiceImpl.update(gwAdminUsersModel);
		logger.info(username+"更新了userId为"+gwAdminUsersModel.getId()+"的管理员");
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * getAdminUsersList:获取管理员用户集合（分页）
	 *
	 * @date 206年3月5日
	 * @param page
	 *            当前页码数
	 * @param pagesize
	 *            每页显示记录数
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAdminUsersList.do")
	@ResponseBody
	public LigerPageDataVo getAdminUsersList(int currentPage, int pageSize, HttpServletRequest request) {
		// 条件参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);

		BasePageResultVo baseResultVo = gwAdminUsersServiceImpl.selectPageList(params);
		// liger ui 分页格式数据
		LigerPageDataVo data = new LigerPageDataVo();
		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}

	/**
	 * 
	 * getAdminUsersById:根据管理员用户id，获取管理员用户信息
	 *
	 * @date 206年3月5日
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAdminUsersById.do")
	@ResponseBody
	public BaseResultVo getAdminUsersById(Integer id, HttpServletRequest request) {
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

		// 获取管理员用户信息
		GwAdminUsersModel gwAdminUsersModel = gwAdminUsersServiceImpl.selectById(id);
		baseResultVo.setData(gwAdminUsersModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * getAdminUsersByCondition:根据条件查询用户
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月18日
	 *
	 * @param currentPage   当前页
	 * @param pageSize		每页的记录数
	 * @param name			用户姓名
	 * @param sfz			用户身份证号
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAdminUsersByCondition.do")
	@ResponseBody
	public LigerPageDataVo getAdminUsersByCondition(int currentPage, int pageSize,String username,String name,String sfz,Integer state, HttpServletRequest request) {
		// 条件参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);
		params.put("name", name);
		params.put("sfz", sfz);
		params.put("username", username);
		params.put("state", state);
		
		// 获取管理员用户信息
		BasePageResultVo baseResultVo = gwAdminUsersServiceImpl.selectByCondition(params);
		// liger ui 分页格式数据
		LigerPageDataVo data = new LigerPageDataVo();
		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}

	/**
	 * 
	 * deleteAdminUsersById:根据管理员用户id，删除管理员用户
	 *
	 * @date 206年3月5日
	 * @param id
	 *            管理员用户id
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteseGroup.do")
	@ResponseBody
	public BaseResultVo deleteAdminUsersById(int id, HttpServletRequest request) {
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

		//新建一个管理员对象
		GwAdminUsersModel user = new GwAdminUsersModel();
		user.setId(id);
		user.setState(-1);
		int num = gwAdminUsersServiceImpl.update(user);
		if (num < 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("操作失败");// 提示信息
		}
		logger.info(username+"删除了userId为"+id+"的管理员");
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * login:管理员登录
	 *
	 * @date 2016年3月7日
	 * @param username
	 *            用户账号
	 * @param pwd
	 *            登录密码
	 * @param random
	 *            验证码
	 * @param response
	 *            response
	 * @param request
	 *            request
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public BaseResultVo login(String username, String pwd, String random, HttpServletResponse response,
			HttpServletRequest request) {
		// 验证码验证
		String code = request.getSession().getAttribute("rand").toString();
		random = MD5.getMD5(random.toLowerCase());
		if (!code.equals(random)) {
			return BaseResultVo.responseFail("验证码不正确");
		}
		// 验证账号
		if (!ValidateUtil.isAvailableAccountStr(username, 3, 20)) {
			return BaseResultVo.responseFail("用户名只能输入英文、数字、下划线、或者邮箱");
		}
		// 验证密码
		if (!ValidateUtil.isAvailableAccountStr(pwd, 3, 20)) {
			return BaseResultVo.responseFail("密码只能输入英文、数字、下划线");
		}
		AdminUtil util = new AdminUtil();
		//是否是超级管理员
		if(util.isSuperAdmin(username))
		{
			TMonPopManagerBean user1 = util.getSuperAdmin();
			if(!user1.getSMnPwd().equals(new Certification().encryptMD5(pwd)))
			{
				//IpNotAllowLogin.Insert(ipAddress);
				return BaseResultVo.responseFail("密码不正确！");
			}
			AdminUser adminUserInfo = new AdminUser();
			adminUserInfo.setUsername(username);
			adminUserInfo.setGwRoleId(0);//0-表示超级管理员角色
			adminUserInfo.setGwRoleName("superadmin");
			adminUserInfo.setName("超级管理员");
			adminUserInfo.setUserId(0);//0-表示超级管理员
			// 生成token,放入session中
			String token = SecurityUtil.createSessionToken(username, pwd, request);
			adminUserInfo.setToken(token);
			request.getSession().setAttribute("adminUser", adminUserInfo);
			logger.info("超级管理员【" + username + "】登录系统成功");
			return BaseResultVo.responseSuccess("登录成功");
		}
		//非超级管理员
		else{
			// 根据用户账号，获取用户信息
			GwAdminUsersModel adminUser = gwAdminUsersServiceImpl.getAdminUsersByUsername(username);

			String md5Pwd = MD5.getMD5(pwd);
			if (adminUser != null) {
				String password = adminUser.getPassword();
				if (!password.equals(md5Pwd)) {
					return BaseResultVo.responseFail("账号或密码不正确");
				} else {
					if (adminUser.getState() == 0) {
						return BaseResultVo.responseFail("账号已被冻结");
					} else if (adminUser.getState() == -1) {
						return BaseResultVo.responseFail("账号已被删除");
					}
					AdminUser adminUserInfo = new AdminUser();
					adminUserInfo.setUsername(username);
					adminUserInfo.setGwRoleId(adminUser.getGwRoleId());
					adminUserInfo.setGwRoleName(adminUser.getGwRoleName());
					adminUserInfo.setUserId(adminUser.getId());
					adminUserInfo.setName(adminUser.getName());
					// 生成token,放入session中
					String token = SecurityUtil.createSessionToken(username, pwd, request);
					adminUserInfo.setToken(token);
					request.getSession().setAttribute("adminUser", adminUserInfo);
					logger.info("用户【" + username + "】登录系统成功");
					return BaseResultVo.responseSuccess("登录成功");
				}
			} else {
				return BaseResultVo.responseFail("账号或密码不正确");
			}
		}
		
		

	}

	@ResponseBody
	@RequestMapping("/getAllAdminUserName.do")
	public Object getAllGroupInfosi() {
		// 获取所有用户名称
		List<GwAdminUsersModel> MallInfoList = gwAdminUsersServiceImpl.getAllList();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (GwAdminUsersModel mallInfo : MallInfoList) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", mallInfo.getId());
			map.put("text", mallInfo.getName());
			list.add(map);
		}
		return list;
	}

	@RequestMapping("/getAdminUserInfo.do")
	@ResponseBody
	public Object getCurrentUserInfo(HttpServletRequest request) {

		AdminUser user = SecurityUtil.getAdminUser(request);
		int userId = user.getUserId();

		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url

		if (userId == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");// 提示信息
			baseResultVo.setStatus(status);
			return baseResultVo;
		}

		// 获取管理员用户信息
		GwAdminUsersModel gwAdminUsersModel = gwAdminUsersServiceImpl.selectById(userId);
		baseResultVo.setData(gwAdminUsersModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	@RequestMapping("/updateAdminUsersInfo.do")
	@ResponseBody
	public Object updateAdminUsersInfo(GwAdminUsersModel gwAdminUsersModel,HttpServletRequest request) {
		AdminUser user = SecurityUtil.getAdminUser(request);
		int userId = user.getUserId();

		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url

		// 验证主键是否为空
		if (userId == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		// 更新时间
		gwAdminUsersModel.setDtime(DateUtil.getCurrentDatetime("-"));

		// 更新管理员用户
		gwAdminUsersModel.setId(userId);
		gwAdminUsersServiceImpl.update(gwAdminUsersModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
	@RequestMapping("/goUpdatePwd.do")
	@ResponseBody
	public Object goUpdatePwd(HttpServletRequest request,String oldPwd,String newPwd,String newPwd2) {
		AdminUser user = SecurityUtil.getAdminUser(request);
		GwAdminUsersModel gwUser = gwAdminUsersServiceImpl.getAdminUsersByUsername(user.getUsername());
		
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		
		if (gwUser == null) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		if(!gwUser.getPassword().equals(MD5.getMD5(oldPwd))){
			return BaseResultVo.responseFail("旧密码不正确");
		}
		if (!ValidateUtil.isAvailableAccountStr(newPwd, 5, 20) || !ValidateUtil.isAvailableAccountStr(newPwd2, 3, 20)) {
			return BaseResultVo.responseFail("密码只能输入5-20位英文、数字、下划线、或者邮箱");
		}
		if(!newPwd.equals(newPwd2)){
			return BaseResultVo.responseFail("两次密码输入不一致");
		}
		logger.info(user.getUsername()+"修改了userId为"+gwUser.getId()+"的密码");
		gwUser.setPassword(MD5.getMD5(newPwd));
		gwAdminUsersServiceImpl.update(gwUser);
		
		// 更新管理员用户
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
	
	/**
	 * MIS数据接口api地址
	 */
//	@Value("${mis.api.resetPassword.url}")
//	private String url;
	/**
	 * 
	 * resetPwd:重置用户密码
	 *
	 * @author   shengjinpeng
	 * @date     2016年8月18日
	 *
	 * @param request
	 * @param id		需要重置的用户id
	 * @param newPwd	重置密码
	 * @param newPwd2	确认密码
	 * @return
	 */
	@RequestMapping("/resetPwd.do")
	@ResponseBody
	public Object resetPwd(HttpServletRequest request,int id,String newPwd,String newPwd2) throws ClientProtocolException {
		//得到需要重置密码的用户对象
		GwAdminUsersModel gwUser = gwAdminUsersServiceImpl.selectById(id);

		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url
		
		if (gwUser == null) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		if (!ValidateUtil.isAvailableAccountStr(newPwd, 5, 20) || !ValidateUtil.isAvailableAccountStr(newPwd2, 3, 20)) {
			return BaseResultVo.responseFail("密码只能输入5-20位英文、数字、下划线、或者邮箱");
		}
		if(!newPwd.equals(newPwd2)){
			return BaseResultVo.responseFail("两次密码输入不一致");
		}
		
		//同步到mis端用户密码
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", gwUser.getUsername());
		map.put("oldPassWord", gwUser.getPassword());
		map.put("newPassWord", MD5.getMD5(newPwd));
		net.sf.json.JSONObject json=net.sf.json.JSONObject.fromObject(map);
		
		Map<String, Object> newMap = new HashMap<String, Object>();
		newMap.put("DYLX", "UPDATE_PASSWORD");
	//	newMap.put("YHBS", CommonUrl.YHBS);
		String jsonParams= "\""+json.toString()+"\"";
		newMap.put("DATA", jsonParams);
		String body = null;
		//body = HttpClientUtil.httpPost(url, newMap);
		logger.info("连接MIS成功！");
		System.out.println(body);
		net.sf.json.JSONObject jsonBody=net.sf.json.JSONObject.fromObject(body);
		String statusMsg=jsonBody.getString("status");
		net.sf.json.JSONObject statusMsgJson=net.sf.json.JSONObject.fromObject(statusMsg);
		String code=statusMsgJson.getString("code");
		if("10000".equals(code)){
			logger.info("同步到mis端密码成功！");
			//设置新密码
			gwUser.setPassword(MD5.getMD5(newPwd));
			//更新用户
			gwAdminUsersServiceImpl.update(gwUser);
			logger.info(gwUser.getUsername()+"修改了userId为"+gwUser.getId()+"的密码");
		}else{
			return baseResultVo.responseFail("同步mis端密码失败");
		}
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
	
	@RequestMapping("/updateStateByid.do")
	@ResponseBody
	public BaseResultVo updateStateByid(int id) {
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
		GwAdminUsersModel params=new GwAdminUsersModel();
		params.setState(AdminUserStatusEnum.quit.getValue());
		params.setId(id);
		int number = gwAdminUsersServiceImpl.update(params);
		if (number < 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("操作失败");// 提示信息
		}
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
	
}
