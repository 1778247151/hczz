package com.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.crm.common.BasePageResultVo;
import com.crm.common.BaseResultVo;
import com.crm.common.LigerPageDataVo;
import com.crm.common.ResponseCode;
import com.crm.common.Status;
import com.crm.interceptor.exception.BaseException;
import com.crm.pojo.GwMenuTreeModel;
import com.crm.pojo.GwRoleGroupModel;
import com.crm.pojo.GwRoleModel;
import com.crm.service.GwMenuService;
import com.crm.service.GwRoleGroupService;
import com.crm.service.GwRoleService;
import com.crm.util.DateUtil;
/**
 * 
 * GwRoleController:角色访问控制层
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
@Controller
@RequestMapping("/role")
public class GwRoleController extends BaseException{
    
    
    /**
     * 数据同步标志
     */
    @Value("${crm.synchronize.flag}")
    private Boolean synchronize;
    

	/**
	 * 角色业务逻辑
	 */
	@Resource(name="gwRoleServiceManage")
	private GwRoleService gwRoleServiceImpl;
	
	/**
	 * 菜单业务逻辑
	 */
	@Autowired
	private GwMenuService gwMenuServiceImpl;
	/**
	 * 角色权限业务逻辑
	 */
	@Resource(name="gwRoleGroupServiceManage")
	private GwRoleGroupService gwRoleGroupServiceImpl;
	

	/**
	 * 
	 * addRole:添加角色
	 *
	 * @date 2016年3月5日
	 * @param gwRoleModel
	 * @return
	 */
	@RequestMapping("/addRole.do")
	@ResponseBody
	public BaseResultVo addRole(GwRoleModel gwRoleModel){
		
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		baseResultVo.setStatus(status);
		//验证为实现
		
		//更新时间
		gwRoleModel.setTime(DateUtil.getCurrentDatetime("-"));
		
		gwRoleServiceImpl.insert(gwRoleModel);
		return baseResultVo;
	}
	/**
	 * 
	 * updateRole:更新角色
	 *
	 * @date 2016年3月5日
	 * @param gwRoleModel       角色信息对象
	 * @return
	 */
	@RequestMapping("/updateRole.do")
	@ResponseBody
	public BaseResultVo updateRole(GwRoleModel gwRoleModel){
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		
		//验证主键是否为空
		if(gwRoleModel.getId()==0){
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		
		//更新时间
		gwRoleModel.setTime(DateUtil.getCurrentDatetime("-"));
		
		//更新角色
		gwRoleServiceImpl.update(gwRoleModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
	/**
	 * 
	 * getRoleList:获取角色集合（分页）
	 *
	 * @date 2016年3月5日
	 * @param page   当前页码数
	 * @param pagesize      每页显示记录数
	 * @param request
	 * @return
	 */
	@RequestMapping("/getRoleList.do")
	@ResponseBody
	public LigerPageDataVo getRoleList(int currentPage,int pageSize,HttpServletRequest request){
		//条件参数
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);
		
		BasePageResultVo baseResultVo=gwRoleServiceImpl.selectPageList(params);
		//liger ui 分页格式数据
		LigerPageDataVo data=new LigerPageDataVo();
		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}
	
	/**
	 * 
	 * getRoleById:根据角色id，获取角色信息
	 *
	 * @date 2016年3月5日
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getRoleById.do")
	@ResponseBody
	public BaseResultVo getRoleById(int id,HttpServletRequest request){
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		
		if(id==0){
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");//提示信息
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		
		//获取角色信息
		GwRoleModel gwRoleModel=gwRoleServiceImpl.selectById(id);
		baseResultVo.setData(gwRoleModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
	/**
	 * 
	 * deleteRoleById:根据角色id，删除角色
	 *
	 * @date 2016年3月5日
	 * @param id                  角色id
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteRoleById.do")
	@ResponseBody
	public BaseResultVo deleteRoleById(int id,HttpServletRequest request){
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		
		if(id==0){
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");//提示信息
			baseResultVo.setStatus(status);
			return baseResultVo;
		}
		
		//获取角色信息
		int num=gwRoleServiceImpl.deleteById(id);
		if(num<0){
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("操作失败");//提示信息
		}
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
	/**
	 * 
	 * getAllRoles:获取所有角色
	 *
	 * @date 2016年3月7日
	 * @return
	 */
	@RequestMapping("/getAllRoles.do")
	@ResponseBody
	public Object getAllRoles(){
		//获取所有角色
		List<GwRoleModel> roles=gwRoleServiceImpl.getAllList();
		List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		for (GwRoleModel role : roles) {
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("id", role.getId());
			map.put("text", role.getCnName());
			list.add(map);
		}
		return list;
	}

	
	/**
	 * getRoleGroupsByRoleId:根据角色id，获取角色权限集合
	 *
	 * @date 2016年3月9日
	 * @param roleId      
	 * @return
	 */
	@RequestMapping("/getRoleGroupsByRoleId.do")
	@ResponseBody
	public BaseResultVo getRoleGroupsByRoleId(int roleId){
		
		if(roleId==0){
			return BaseResultVo.responseFail("数据异常");
		}
		
		//获取所有菜单
		List<GwMenuTreeModel> menuTreeList= new ArrayList<>();
		//是否需要同步数据
		if(synchronize){
		    Map<String,Object> paramMap=new HashMap<>();
		    paramMap.put("synchronizeFlag", "1");//查询不需要同步的功能菜单
		    menuTreeList=gwMenuServiceImpl.selectMenuTreeListBy(paramMap);
		}else{
		    menuTreeList=gwMenuServiceImpl.getAllList();
		}
		//获取角色的权限菜单
		List<GwRoleGroupModel> roleGroupList=gwRoleGroupServiceImpl.getRoleGroupsByRoleId(roleId);
		List<HashMap<String, Object>> treeList=new ArrayList<HashMap<String,Object>>();
		for (GwMenuTreeModel menuTree : menuTreeList) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("id", menuTree.getId());//菜单id
			map.put("pid", menuTree.getFid());//父级菜单id
			map.put("text", menuTree.getName());//菜单名称
			map.put("ischecked", checkIsHasMenuId(menuTree.getId(),roleGroupList));//菜单是否有该权限
			map.put("isExpand", true);
			treeList.add(map);
		}
		
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);
		status.setMsg("获取权限成功");
		baseResultVo.setStatus(status);
		baseResultVo.setData(treeList);
		return baseResultVo;
	}
	/**
	 * 
	 * isHasMenuId:角色权限集合中是否有该菜单id
	 *
	 * @date 2016年3月9日
	 * @param menuId                 菜单id
	 * @param roleGroupList          角色权限集合
	 * @return   true-有该权限，false-没有该权限
	 */
	private boolean checkIsHasMenuId(int menuId,List<GwRoleGroupModel>roleGroupList){
		for (GwRoleGroupModel gwRoleGroupModel : roleGroupList) {
			if(menuId==gwRoleGroupModel.getGwMenuTreeId()){
				return true;
			}
		}
		
		return false;
	}
	/**
	 * 
	 * saveRoleGroups:保存角色权限
	 *
	 * @date 2016年3月9日
	 * @param roleId         角色id
	 * @param addIds         新增的菜单ids   3,6
	 * @param delIds         删除的菜单ids   1,2,4
	 * @return
	 */
	@RequestMapping("/saveRoleGroups.do")
	@ResponseBody
	public BaseResultVo saveRoleGroups(int roleId,String addIds,String delIds){
		
		if(roleId==0){
			return BaseResultVo.responseFail("角色编号为空");
		}
		
		//添加权限
		if(addIds.length()>0){
			String[] addMenuIdStr=addIds.split(",");
			List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
			for (int i = 0; i < addMenuIdStr.length; i++) {
				HashMap<String, Object> map=new HashMap<String,Object>();
				//角色id
				map.put("roleId", roleId);
				//菜单id
				map.put("menuId", addMenuIdStr[i]);
				//时间
				map.put("time", DateUtil.getCurrentDatetime("-"));
				list.add(map);
			}
			//插入权限
			gwRoleGroupServiceImpl.insertRoleGroups(list);
		}
		//删除权限
		if(delIds.length()>0){
			String[] delMenuIdStr=delIds.split(",");
			int[] delMenuIds=new int[delMenuIdStr.length];
			//生成删除的菜单id
			for (int i = 0; i < delMenuIdStr.length; i++) {
				delMenuIds[i]=Integer.parseInt(delMenuIdStr[i]);
			}
			//删除权限
			gwRoleGroupServiceImpl.deleteRoleGroup(roleId, delMenuIds);
		}
		
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);
		status.setMsg("保存权限成功");
		baseResultVo.setStatus(status);
		return baseResultVo;
	}
}
