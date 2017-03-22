package com.crm.controller;

import java.util.ArrayList;
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
import com.crm.common.QueryConditon;
import com.crm.common.ResponseCode;
import com.crm.common.SecurityUtil;
import com.crm.common.Status;
import com.crm.enums.gwTypeTreeEnum;
import com.crm.interceptor.exception.BaseException;
import com.crm.pojo.GwRoleModel;
import com.crm.pojo.GwTypeTreeModel;
import com.crm.service.GwTypeTreeService;
import com.crm.util.DateUtil;
import com.crm.util.QueryConditionUtil;

/**
 * 
 * GwTypeTreeController:类型树访问控制层
 *
 * @author xiangtao
 * @date 2016年6月20日
 * @version jdk.8
 *
 */
@Controller
@RequestMapping("/typetree")
public class GwTypeTreeController extends BaseException {

	// 日志
	private Logger logger = LoggerFactory.getLogger(GwTypeTreeController.class);

	/**
	 * 类型树业务逻辑
	 */
	@Resource(name = "gwTypeTreeServiceManage")
	private GwTypeTreeService gwTypeTreeServiceImpl;
	
	/**
	 * 
	 * getAllRoles:获取所有节点
	 *
	 * @date 2016年6月20日
	 * @return
	 */
	@RequestMapping("/getAllTypeTree.do")
	@ResponseBody
	public Object getAllTypeTree(){
		//获取所有节点
		List<GwTypeTreeModel> nodes=gwTypeTreeServiceImpl.getAllList();
		
		List<GwTypeTreeModel> list=new ArrayList<>();
//		for (GwTypeTreeModel node : nodes) {
//			HashMap<String,Object> map=new HashMap<String,Object>();
//			map.put("id", node.getId());
//			map.put("text", node.getName());
//			list.add(map);
//		}
		list=getTypeTrees(nodes,0);
		
		List<GwTypeTreeModel> ROOT = new ArrayList<GwTypeTreeModel>();
		GwTypeTreeModel rootNode = new GwTypeTreeModel();
        rootNode.setId(-1);
        rootNode.setpId(0);
        rootNode.setName("根节点");
        rootNode.setCode("root");
        rootNode.setChidren(list);
        
        ROOT.add(rootNode);
        
        LigerPageDataVo lpd = new LigerPageDataVo();
        lpd.setRows(ROOT);
		return lpd;
	}
	
	/**
	 * 
	 * getTypeTrees:获取类型树
	 *
	 * @author yumaochun
	 * @date 2016年6月24日
	 * @param list         所有类型
	 * @param parentId     父级类型id
	 * @return    返回：返回层级关系的list
	 */
	public List<GwTypeTreeModel> getTypeTrees(List<GwTypeTreeModel> list,int parentId){
	    List<GwTypeTreeModel> typeTrees=new ArrayList<>();  
	    

	    for (GwTypeTreeModel gwTypeTreeModel : list) {
	        int id = gwTypeTreeModel.getId(); //类型id
	        int pId = gwTypeTreeModel.getpId();//父级类型id
	        if(parentId==pId){
	            List<GwTypeTreeModel>  childTypeTree=getTypeTrees(list,id);
	            //设置子类型
	            gwTypeTreeModel.setChidren(childTypeTree);
	            typeTrees.add(gwTypeTreeModel);
	        }
        }
	    return typeTrees;
	}
	
	/**
	 * 获取根节点
	 * @return
	 */
	@RequestMapping("/getRootTypeTree.do")
	@ResponseBody
	public LigerPageDataVo getRootTypeTree() {
		LigerPageDataVo ligerPageDataVo = new LigerPageDataVo();
		List<GwTypeTreeModel> list = gwTypeTreeServiceImpl.getTypeTreeByPid(0);
		GwTypeTreeModel root = new GwTypeTreeModel();
		root.setId(0);
		root.setName("根节点");
		root.setChidren(list);
		List<GwTypeTreeModel> roots = new ArrayList<GwTypeTreeModel>();
		roots.add(root);
		ligerPageDataVo.setRows(roots);
		ligerPageDataVo.setTotal(list.size());
		return ligerPageDataVo;
	}
	/**
	 * 根据父节点code获取子节点
	 * @return
	 */
//	@RequestMapping("/getTypeTreeByPcode.do")
//	@ResponseBody
//	public List<GwTypeTreeModel> getTypeTreeByPcode(String code) {
//		List<GwTypeTreeModel> list = gwTypeTreeServiceImpl.getTypeTreeByPcode(code);
//		return list;
//	}
	
	/**
	 * 根据type获取类型信息
	 * @return
	 */
	@RequestMapping("/getTypeTreeByType.do")
	@ResponseBody
	public List<GwTypeTreeModel> getTypeTreeByPid(String type) {
		List<GwTypeTreeModel> list = gwTypeTreeServiceImpl.getTypeTreeByType(type);
		return list;
	}
	
	
	/**
	 * 获取会员级别类型
	 * @return
	 */
	@RequestMapping("/getMembersGrade.do")
	@ResponseBody
	public List<GwTypeTreeModel> getMembersGrade() {
		List<GwTypeTreeModel> list = gwTypeTreeServiceImpl.getTypeTreeByType("01");
		return list;
	}
	
	
	
	/**
	 * 根据父节点获取节点
	 * @return
	 */
	@RequestMapping("/getTypeTreeByPid.do")
	@ResponseBody
	public LigerPageDataVo getTypeTreeByPid(int pId) {
		LigerPageDataVo ligerPageDataVo = new LigerPageDataVo();
		List<GwTypeTreeModel> list = gwTypeTreeServiceImpl.getTypeTreeByPid(pId);
		ligerPageDataVo.setRows(list);
		ligerPageDataVo.setTotal(list.size());
		return ligerPageDataVo;
	}
	
	/**
	 * 
	 * getTypeTreeById:根据类型树id，获取类型树信息
	 *
	 * @date 206年3月5日
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getTypeTreeById.do")
	@ResponseBody
	public BaseResultVo getTypeTreeById(int id, HttpServletRequest request) {
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

		// 获取类型树信息
		GwTypeTreeModel gwTypeTreeModel = gwTypeTreeServiceImpl.selectById(id);
		baseResultVo.setData(gwTypeTreeModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * addTypeTree 添加类型树
	 * 
	 * @date 2016年6月20日
	 * @param
	 * @return
	 */
	@RequestMapping("/addTypeTree.do")
	@ResponseBody
	public BaseResultVo addTypeTree(int pId,GwTypeTreeModel gwTypeTreeModel, HttpServletRequest request) {
		
		GwTypeTreeModel gtm = gwTypeTreeServiceImpl.getTypeTreeByCode(gwTypeTreeModel.getCode());
		if(gtm!=null){
			return BaseResultVo.responseFail("编号已经存在");
		}
		
		Integer userid = SecurityUtil.getAdminUser(request).getUserId();
		gwTypeTreeModel.setCreateUserId(userid);
		gwTypeTreeModel.setCreateTime(DateUtil.getCurrentDatetime("-"));
		gwTypeTreeModel.setUpdateUserId(userid);
		gwTypeTreeModel.setUpdateTime(DateUtil.getCurrentDatetime("-"));
		
		gwTypeTreeModel.setpId(pId);

		gwTypeTreeServiceImpl.insert(gwTypeTreeModel);

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
	 * delTypeTreeById:根据类型树id，删除类型树
	 *
	 * @date 2016年6月20日
	 * @param id
	 *            类型树id
	 * @param request
	 * @return
	 */
	@RequestMapping("/delTypeTree.do")
	@ResponseBody
	public BaseResultVo delTypeTreeById(int id, HttpServletRequest request) {
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

		GwTypeTreeModel gwTypeTreeModel = gwTypeTreeServiceImpl.selectById(id);
		if (gwTypeTreeModel != null) {
			gwTypeTreeModel.setStatus(0);
		}

		int num = gwTypeTreeServiceImpl.update(gwTypeTreeModel);
		if (num < 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("操作失败");// 提示信息
		}
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * updateTypeTree:更新类型树
	 *
	 * @date 2016年6月20日
	 * @param gwTypeTreeModel
	 *            类型树信息对象
	 * @return
	 */
	@RequestMapping("/updateTypeTree.do")
	@ResponseBody
	public BaseResultVo updateTypeTree(GwTypeTreeModel gwTypeTreeModel, HttpServletRequest request) {
		BaseResultVo baseResultVo = new BaseResultVo();
		Status status = new Status();
		status.setCode(ResponseCode.OPR_SUCCESS);// 提示代码
		status.setMsg("操作成功");// 提示信息
		status.setDebugMsg("");// bug信息
		status.setUrl("");// url

		// 验证主键是否为空
		if (gwTypeTreeModel.getId() == 0) {
			status.setCode(ResponseCode.OPR_FAIL);
			status.setMsg("数据异常");
			baseResultVo.setStatus(status);
			return baseResultVo;
		}

		// 更新时间
		gwTypeTreeModel.setUpdateTime(DateUtil.getCurrentDatetime("-"));
		int userid = SecurityUtil.getAdminUser(request).getUserId();
		gwTypeTreeModel.setUpdateUserId(userid);
		
		// 更新类型树信息
		gwTypeTreeServiceImpl.update(gwTypeTreeModel);
		baseResultVo.setStatus(status);
		return baseResultVo;
	}

	/**
	 * 
	 * getTypeTreeList:获取类型树集合（分页）
	 *
	 * @date 2016年6月20日
	 * @param page
	 *            当前页码数
	 * @param pagesize
	 *            每页显示记录数
	 * @param request
	 * @return
	 */
	@RequestMapping("/getTypeTreeList.do")
	@ResponseBody
	public LigerPageDataVo getTypeTreeList(int currentPage, int pageSize, String startDate, String endDate, String title,
			HttpServletRequest request) {
		// 条件参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);

		params.put("title", title);
		params.put("startDate", startDate);
		params.put("endDate", endDate);

		BasePageResultVo baseResultVo = gwTypeTreeServiceImpl.selectPageList(params);
		// liger ui 分页格式数据
		LigerPageDataVo data = new LigerPageDataVo();
		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}
	
	/**
	 * 获取下拉列表仓库类分页List
	 * @param queryCondition 查询参数
	 * @return
	 */
	@RequestMapping("/getStoreHouseByComBoBoxList.do")
	@ResponseBody
	public LigerPageDataVo getStoreHouseByComBoBoxList(QueryConditon queryCondition){
		//查询条件数组字符串（前端传递的字符串名称需和xml查询名称一致）
		String[] queryParamArr=new String[]{"name"};
		//获取分页参数信息map
		Map<String, Object> params=QueryConditionUtil.getParamsMap(queryParamArr, queryCondition);
		BasePageResultVo baseResultVo=gwTypeTreeServiceImpl.getStoreHouseByPageList(params);
		LigerPageDataVo data=new LigerPageDataVo();
		data.setRows(baseResultVo.getRows());
		data.setTotal(baseResultVo.getPageInfo().getTotalRecord());
		return data;
	}
}
