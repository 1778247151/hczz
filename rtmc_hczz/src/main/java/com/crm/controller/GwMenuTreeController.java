package com.crm.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.AdminUser;
import com.crm.common.BaseResultVo;
import com.crm.common.SecurityUtil;
import com.crm.common.Status;
import com.crm.common.TreeNode;
import com.crm.interceptor.exception.BaseException;
import com.crm.pojo.GwMenuTreeModel;
import com.crm.service.GwMenuService;
import com.crm.service.GwRoleGroupService;
import com.crm.util.DateUtil;
/**
 * 
 * GwMenuTreeController:系统菜单访问控制层
 *
 * @author yumaochun
 * @date  2016年3月3日
 * @version  jdk1.8
 *
 */
@Controller
@RequestMapping("/gw_menu_tree")
public class GwMenuTreeController extends BaseException{
    
    /**
     * 数据同步标志
     */
    @Value("${crm.synchronize.flag}")
    private Boolean synchronize;
	
	@Autowired
	private GwMenuService gwMenuServiceImpl;
	
	@Autowired
	private GwRoleGroupService gwRoleGroupServiceImpl;
	
	

    /**
	 * 
	 * addMenuTree:添加菜单
	 *
	 * @date 2016年3月4日
	 * @param menuTreeModel       菜单信息对象
	 * @return
	 */
	@RequestMapping(value="/addMenuTree.do")
	@ResponseBody
	public BaseResultVo addMenuTree(GwMenuTreeModel menuTreeModel){
		
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode("10000");//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		baseResultVo.setStatus(status);
		menuTreeModel.setTime(DateUtil.getCurrentDatetime("-"));
		//添加菜单
		gwMenuServiceImpl.insert(menuTreeModel);
		return baseResultVo;
	}
	
	/**
	 * 
	 * deleteMenuTreeById:根据菜单ID，删除菜单信息
	 *
	 * @date 2016年3月4日
	 * @param id        菜单ID
	 * @return
	 */
	@RequestMapping(value="/deleteMenuTreeById.do")
	@ResponseBody
	public BaseResultVo deleteMenuTreeById(int id){
		
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode("10000");//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		baseResultVo.setStatus(status);
		
		//根据菜单ID，删除菜单
		gwMenuServiceImpl.deleteById(id);
		return baseResultVo;
	}
	/**
	 * 
	 * getMenuTreeListByFId:根据父级ID，获取下级菜单list集合
	 *
	 * @date 2016年3月4日
	 * @param fid          父级ID
	 * @return
	 */
	@RequestMapping("/getMenuTreeListByFid.do")
	@ResponseBody
	public BaseResultVo getMenuTreeListByFId(int fid){
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode("10000");//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		baseResultVo.setStatus(status);
		//根据父级ID，获取下级菜单
		List<GwMenuTreeModel> list=gwMenuServiceImpl.getGwMenuListByPid(fid);
		baseResultVo.setData(list);
		return baseResultVo;
	}
	
	/**
	 * 
	 * getMenuTrees:登录，获取系统菜单
	 *
	 * @date 2016年3月4日
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/getMenuTrees.do")
	public void getMenuTrees(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		/*AdminUser adminUser=SecurityUtil.getAdminUser(request);
		if(adminUser==null){
			return;
		}
		//获取角色
		int roleId=adminUser.getGwRoleId();
		//System.out.println("==========="+synchronize);
		if(roleId==0){
			List<GwMenuTreeModel> list=gwMenuServiceImpl.getGwMenuListByPid(0);
			StringBuffer sb=new StringBuffer();
			for (GwMenuTreeModel gwMenuTreeModel : list) {
				sb.append("<div icon='"+gwMenuTreeModel.getIcon()+"' title='"+gwMenuTreeModel.getName()+"' class='l-scroll'>");
				List<GwMenuTreeModel> childList=gwMenuServiceImpl.getGwMenuListByPid(gwMenuTreeModel.getId());
				sb.append("<div class='menu_list'>");
				for (GwMenuTreeModel child : childList) {	
					if(child.getType().equals("links")){
						String url=child.getUrladdress()+"?menuId="+child.getId()+"&type="+child.getType();
						sb.append("<div class='two_menu_links'><a href=javascript:f_addTab('"+child.getId()+"','"+child.getName()+"','"+url+"')><i class='three_icon'></i>"+child.getName()+"</a></div>");
					}
					else{
						//三级菜单
						List<GwMenuTreeModel> myClilds=gwMenuServiceImpl.getGwMenuListByPid(child.getId());
						
						if(myClilds.size()>0){
							sb.append("<div class='menu_module menu_module_hide'><i class='two_icon'></i>"+child.getName()+"</div>");
							sb.append("<ul class='menu_module_hide'>");
							for (GwMenuTreeModel nextChild : myClilds) {
								String url=nextChild.getUrladdress()+"?menuId="+nextChild.getId()+"&type="+nextChild.getType();
								sb.append("<li class='menu_links'><a href=javascript:f_addTab('"+nextChild.getId()+"','"+nextChild.getName()+"','"+url+"')><i class='three_icon'></i><span>"+nextChild.getName()+"</span></a></li>");
							}
							sb.append("</ul>");
						}else{
							String url=child.getUrladdress()+"?menuId="+child.getId()+"&type="+child.getType();
							sb.append("<div class='two_menu_links'><a href=javascript:f_addTab('"+child.getId()+"','"+child.getName()+"','"+url+"')><i class='three_icon'></i><span>"+child.getName()+"</span></a></div>");
						}
					}
				}
				sb.append("</div>");
				sb.append("</div>");
			}
			//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
			response.setHeader("content-type", "text/html;charset=UTF-8");
			String data=sb.toString();
			OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流

			byte[] dataByteArr = data.getBytes("UTF-8");//将字符转换成字节数组，指定以UTF-8编码进行转换
			outputStream.write(dataByteArr);//使用OutputStream流向客户端输出字节数组
			
		}else{
			List<GwMenuTreeModel> list=gwMenuServiceImpl.getGwMenuListByPid_roleId(0, roleId);
			StringBuffer sb=new StringBuffer();
			for (GwMenuTreeModel gwMenuTreeModel : list) {
				sb.append("<div icon='"+gwMenuTreeModel.getIcon()+"' title='"+gwMenuTreeModel.getName()+"' class='l-scroll'>");
				List<GwMenuTreeModel> childList=gwMenuServiceImpl.getGwMenuListByPid_roleId(gwMenuTreeModel.getId(),roleId);
				sb.append("<div class='menu_list'>");
				for (GwMenuTreeModel child : childList) {	
					if(child.getType().equals("links")){
						String url=child.getUrladdress()+"?menuId="+child.getId()+"&type="+child.getType();
						sb.append("<div class='two_menu_links'><a href=javascript:f_addTab('"+child.getId()+"','"+child.getName()+"','"+url+"')><i class='three_icon'></i>"+child.getName()+"</a></div>");
					}
					else{
						//三级菜单
						List<GwMenuTreeModel> myClilds=gwMenuServiceImpl.getGwMenuListByPid_roleId(child.getId(),roleId);
						
						if(myClilds.size()>0){
							sb.append("<div class='menu_module menu_module_hide'><i class='two_icon'></i>"+child.getName()+"</div>");
							sb.append("<ul class='menu_module_hide'>");
							for (GwMenuTreeModel nextChild : myClilds) {
								String url=nextChild.getUrladdress()+"?menuId="+nextChild.getId()+"&type="+nextChild.getType();
								sb.append("<li class='menu_links'><a href=javascript:f_addTab('"+nextChild.getId()+"','"+nextChild.getName()+"','"+url+"')><i class='three_icon'></i><span>"+nextChild.getName()+"</span></a></li>");
							}
							sb.append("</ul>");
						}else{
							String url=child.getUrladdress()+"?menuId="+child.getId()+"&type="+child.getType();
							sb.append("<div class='two_menu_links'><a href=javascript:f_addTab('"+child.getId()+"','"+child.getName()+"','"+url+"')><i class='three_icon'></i><span>"+child.getName()+"</span></a></div>");
						}
					}
				}
				sb.append("</div>");
				sb.append("</div>");
			}
			//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
			response.setHeader("content-type", "text/html;charset=UTF-8");
			String data=sb.toString();
			OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流

			byte[] dataByteArr = data.getBytes("UTF-8");//将字符转换成字节数组，指定以UTF-8编码进行转换
			outputStream.write(dataByteArr);//使用OutputStream流向客户端输出字节数组
		}
		//根据父级ID和角色id，获取下级菜单
		//List<GwMenuTreeModel> list=gwMenuServiceImpl.getGwMenuListByPid(0);
*/		
		
		AdminUser adminUser=SecurityUtil.getAdminUser(request);
		if(adminUser==null){
			return;
		}
		
		//菜单html
		String menuHtml="";
		//菜单树形结构集合
		List<GwMenuTreeModel> list=new ArrayList<>();
	    //开始时间
		long startTime=System.currentTimeMillis();
		//获取所有菜单集合
		List<GwMenuTreeModel> menuList=new ArrayList<>();
		
		//获取角色
		int roleId=adminUser.getGwRoleId();
		if(roleId==0){
			//获取所有菜单集合
			menuList=gwMenuServiceImpl.getAllList();	
		}else{
			//根据角色，获取角色的所有菜单集合
			menuList=gwMenuServiceImpl.selectMeneTreeListByRoleId(roleId);	
		}
		//找到所有一级菜单
		for (GwMenuTreeModel menuTree : menuList) {
			//一级菜单
			if(menuTree.getFid()==0){
				//获取菜单的子集菜单信息
				GwMenuTreeModel menu=getChildMenu(menuList,menuTree);
				list.add(menu);
			}
		}
		menuHtml=getMenuTreeHtml(list);
		//结束时间
		long endTime=System.currentTimeMillis();
		//花费时间
		long time=endTime-startTime;
		
		//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
		response.setHeader("content-type", "text/html;charset=UTF-8");
		OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流
		byte[] dataByteArr = menuHtml.getBytes("UTF-8");//将字符转换成字节数组，指定以UTF-8编码进行转换
		outputStream.write(dataByteArr);//使用OutputStream流向客户端输出字节数组
	}
	
	/**
	 * 
	 * getMenuTreeHtml:生成菜单的html代码
	 *
	 * @author   yumaochun
	 * @date     2016年9月28日
	 *
	 * @param list     菜单集合（树形结构）
	 * @return   返回：生成的菜单html
	 */
	public String getMenuTreeHtml(List<GwMenuTreeModel> list){
		StringBuffer sb=new StringBuffer();
		for (GwMenuTreeModel menuTree : list) {
			//一级菜单
			sb.append("<div icon='"+menuTree.getIcon()+"' title='"+menuTree.getName()+"' class='l-scroll'>");
			sb.append("<div class='menu_list'>");
			//获取下级菜单
            List<GwMenuTreeModel> childList=menuTree.getChildList();
			if(childList!=null){
            	for (GwMenuTreeModel twoMenu : childList) {
            		//功能菜单（url）
            		if(twoMenu.getType().equals("links")){
						String url=twoMenu.getUrladdress()+"?menuId="+twoMenu.getId()+"&type="+twoMenu.getType();
						sb.append("<div class='two_menu_links'><a href=javascript:f_addTab('"+twoMenu.getId()+"','"+twoMenu.getName()+"','"+url+"')><i class='three_icon'></i>"+twoMenu.getName()+"</a></div>");
					}
            		//功能目录
            		else if(twoMenu.getType().equals("module")) {
            			sb.append("<div class='menu_module menu_module_hide'><i class='two_icon'></i>"+twoMenu.getName()+"</div>");
						sb.append("<ul class='menu_module_hide'>");
            			List<GwMenuTreeModel> twoMenuChildList=twoMenu.getChildList();
						if(twoMenuChildList!=null){
							//功能目录下的菜单（url）
							for (GwMenuTreeModel nextChild : twoMenuChildList) {
								String url=nextChild.getUrladdress()+"?menuId="+nextChild.getId()+"&type="+nextChild.getType();
								sb.append("<li class='menu_links'><a href=javascript:f_addTab('"+nextChild.getId()+"','"+nextChild.getName()+"','"+url+"')><i class='three_icon'></i><span>"+nextChild.getName()+"</span></a></li>");
							}
							sb.append("</ul>");
						}
					}
				}
            }
			sb.append("</div>");
			sb.append("</div>");
		}
		return sb.toString();
	}
	
	public String createMenuTree(){
		
		return "";
	}
	
	/**
	 * 
	 * getChildMenu:获取子菜单信息
	 *
	 * @author   yumaochun
	 * @date     2016年9月28日
	 *
	 * @param menuList        所有菜单集合
	 * @param menu            菜单信息
	 * @return   返回：菜单信息及子菜单信息
	 */
	public GwMenuTreeModel getChildMenu(List<GwMenuTreeModel> menuList,GwMenuTreeModel menu){
		
		for (GwMenuTreeModel menuTree : menuList) {
			int fid=menuTree.getFid();
			int id=menu.getId();
			if(fid==id){
				
				GwMenuTreeModel child=getChildMenu(menuList,menuTree);
				List<GwMenuTreeModel> list=menu.getChildList();
				if(list==null){
					menu.setChildList(new ArrayList<>());
				}
				menu.getChildList().add(child);
			}
		}
		return menu;
	}
	
	/**
	 * 
	 * updateMenuTree:根据ID，更新菜单信息
	 *
	 * @date 2016年3月4日
	 * @param menuTreeModel                需要更新的菜单信息对象
	 * @return
	 */
	@RequestMapping("/updateMenuTree.do")
	@ResponseBody
	public BaseResultVo updateMenuTree(GwMenuTreeModel menuTreeModel){
		
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode("10000");//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		baseResultVo.setStatus(status);
		menuTreeModel.setTime(DateUtil.getCurrentDatetime("-"));
		gwMenuServiceImpl.update(menuTreeModel);
		
		return baseResultVo;
	}
	/**
	 * 
	 * getMenuTreeList:
	 *
	 * @date 2016年3月4日
	 * @return
	 */
	@RequestMapping("/getMenuTreeList.do")
	@ResponseBody
	public BaseResultVo getMenuTreeList(){
		
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode("10000");//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		baseResultVo.setStatus(status);
		
		List<GwMenuTreeModel> list=gwMenuServiceImpl.getAllList();
		
		List<TreeNode> listTree=new ArrayList<TreeNode>();
		
		for (GwMenuTreeModel gwMenuTreeModel : list) {
			TreeNode treeNode=new TreeNode();
			treeNode.setId(gwMenuTreeModel.getId());
			treeNode.setPid(gwMenuTreeModel.getFid());
			treeNode.setText(gwMenuTreeModel.getName()+"("+gwMenuTreeModel.getOrderNum()+")");
			treeNode.setExpand(false);
			treeNode.setType(gwMenuTreeModel.getType());
			treeNode.setAttribute("['id','url','type']");
			listTree.add(treeNode);
		}
		
		baseResultVo.setData(listTree);
		
		return baseResultVo;
	}
	/**
	 * 
	 * getMenuTreeById:根据菜单ID，获取菜单信息
	 *
	 * @date 2016年3月4日
	 * @param id         菜单ID
	 * @return
	 */
	@RequestMapping("/getMenuTreeById.do")
	@ResponseBody
	public BaseResultVo getMenuTreeById(int id){
		BaseResultVo baseResultVo=new BaseResultVo();
		Status status=new Status();
		status.setCode("10000");//提示代码
		status.setMsg("操作成功");//提示信息
		status.setDebugMsg("");//bug信息
		status.setUrl("");//url
		baseResultVo.setStatus(status);
		GwMenuTreeModel menuTreeModel = gwMenuServiceImpl.selectById(id);
		baseResultVo.setData(menuTreeModel);
		return baseResultVo;
	}
	
	/**
	 * 
	 * getAllMenuList:获取所有菜单
	 *
	 * @author yumaochun
	 * @date 2016年5月17日
	 * @return
	 */
	@RequestMapping("/getAllMenuList.do")
	@ResponseBody
	public List<Map<String,Object>> getAllMenuList(){
		List<GwMenuTreeModel> menuList=gwMenuServiceImpl.getAllList();
		
		List<Map<String,Object>> list=new ArrayList<>();
		Map<String, Object> mapTop=new HashMap<>();
		mapTop.put("id", 0);
		mapTop.put("pid",-1);
		mapTop.put("text", "顶级菜单");
		mapTop.put("isExpand", false);
		list.add(mapTop);
		for (GwMenuTreeModel menuTree : menuList) {
			Map<String, Object> map=new HashMap<>();
			map.put("id", menuTree.getId());
			map.put("pid", menuTree.getFid());
			map.put("text", menuTree.getName());
			map.put("isExpand", false);
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 
	 * getMenuFuncsByMenuId:根据菜单id，获取菜单下面的功能集合
	 *
	 * @author yumaochun
	 * @date 2016年5月18日
	 * @param menuId            菜单id
	 * @return
	 */
	@RequestMapping("/getMenuFuncsByMenuId.do")
	@ResponseBody
	public BaseResultVo getMenuFuncsByMenuId(int menuId,HttpServletRequest request){
		
		
		AdminUser user=SecurityUtil.getAdminUser(request);
		if(user==null){
			return BaseResultVo.responseFail("用户session已过期！");
		}
		List<GwMenuTreeModel> funcList=new ArrayList<>();
		int roleId=user.getGwRoleId();//角色id
		if(roleId==0){
		    //超级管理员
		    if(synchronize){
		        funcList=gwMenuServiceImpl.selectSynMenuTreeByParentId(menuId);
		    }else{
	            funcList=gwMenuServiceImpl.getGwMenuListByPid(menuId);
		    }
			
		}else{
			HashMap<String,Object> params=new HashMap<>();
			params.put("roleId", roleId);//角色id
			params.put("menuId", menuId);//菜单id
			if(synchronize){
			    params.put("synchronizeFlag", "1");//同步
			}else{
			    params.put("synchronizeFlag", "0");//不同步
			}
			
            funcList=gwRoleGroupServiceImpl.getMenuFuncListByMenuId(params);
           
		}

		BaseResultVo baseResultVo=BaseResultVo.responseSuccess("获取菜单功能成功！");
		baseResultVo.setData(funcList);//设置菜单功能集合
		return baseResultVo;
				
	}
}
