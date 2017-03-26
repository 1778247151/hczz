package com.crm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.AdminUser;
import com.crm.common.BaseResultVo;
import com.crm.common.ResponseCode;
import com.crm.common.SecurityUtil;
import com.crm.common.Status;
import com.crm.interceptor.exception.BaseException;
import com.crm.pojo.Rt_arUser;
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
@RequestMapping("/rt_User")
public class Rt_UserController extends BaseException {

	// 日志
	private Logger logger = LoggerFactory.getLogger(Rt_UserController.class);
	/**
	 * 案件人员业务逻辑
	 */
	@Resource(name = "rt_ArUserServiceManage")
	private Rt_arUserService rt_arUserService;

	/**
	 * 
	 * 	
	 * @return
	 */
	@RequestMapping("/saveArUser.do")
	@ResponseBody
	public  BaseResultVo saveArUser(Rt_arUser record,HttpServletResponse response,HttpServletRequest request,String arid,String ids){

		
		Status status = new Status();
		BaseResultVo baseResultVo = new BaseResultVo();
		if(null==ids&&"".equals(ids)||null==arid&&"".equals(arid)){
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("请添加人员！");
			baseResultVo.setStatus(status);
			return baseResultVo;
			
		}else{
			String[]  ids1=	ids.split(",");
			Rt_arUser  e=new Rt_arUser();
			for (String userid : ids1) {
				e.setArchId(Integer.parseInt(arid));
				e.setUiserId(Integer.parseInt(userid));
				Rt_arUser rt=rt_arUserService.selectOne(e);
				//Rt_arUser rt=rt_arUserService.selectByUserId(Integer.parseInt(userid));
				if(rt!=null){
					status.setCode(ResponseCode.OPR_FAIL);// 提示代码
					status.setMsg("该成员已经加入");// 提示信息
					status.setDebugMsg("");// bug信息
					status.setUrl("");// url
					baseResultVo.setStatus(status);
					return baseResultVo;
				}
				record.setArchId(Integer.valueOf(arid));
				record.setUiserId(Integer.valueOf(userid));
				rt_arUserService.insert(record);
			}
			status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
			status.setMsg("操作成功!");// 提示信息
			status.setDebugMsg("");// bug信息
			status.setUrl("");// url
			baseResultVo.setStatus(status);
			return baseResultVo;
		
		}
	
		
	}
	/**
	 * 
	 * 	
	 * @return
	 */
	@RequestMapping("deleteUsers.do")
	@ResponseBody
	public  BaseResultVo deleteUsers(Rt_arUser record,HttpServletResponse response,HttpServletRequest request,String ids,String arid){
		AdminUser adminUser=SecurityUtil.getAdminUser(request);
		Status status = new Status();
		BaseResultVo baseResultVo = new BaseResultVo();
		if(null==ids&&"".equals(ids)){
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("该成员未添加！");
			baseResultVo.setStatus(status);
			return baseResultVo;
			
		}else{
			if(adminUser.getUsername().equals("superadmin")){
				Rt_arUser arUser=new Rt_arUser();
				String[]  ids1=	ids.split(",");
				for (String userid : ids1) {
					arUser.setArchId(Integer.parseInt(arid));
					arUser.setUiserId(Integer.parseInt(userid));
					Rt_arUser rt=rt_arUserService.selectOne(arUser);
					//Rt_arUser rt=rt_arUserService.selectByUserId(Integer.parseInt(userid));
					if(rt==null){
						status.setCode(ResponseCode.OPR_FAIL);// 提示代码
						status.setMsg("该成员未参与该案件！");// 提示信息
						status.setDebugMsg("");// bug信息
						status.setUrl("");// url
						baseResultVo.setStatus(status);
						return baseResultVo;
					}
					rt_arUserService.deleteById(rt.getId());
				}
				status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
				status.setMsg("踢出成功!");// 提示信息
				status.setDebugMsg("");// bug信息
				status.setUrl("");// url
				baseResultVo.setStatus(status);
				return baseResultVo;
				
			}else{
				status.setCode(ResponseCode.OPR_FAIL);
				status.setMsg("抱歉您没有该权限！");
				baseResultVo.setStatus(status);
				return baseResultVo;
			}
		
		}
		
		
	}
}
