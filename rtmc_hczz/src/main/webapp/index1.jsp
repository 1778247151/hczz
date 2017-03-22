<%@ page language="java" import="java.util.*,com.wenhao.sso.client.filter.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>动态痕迹管理平台</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link href="/js/ligerui/lib/ligerUI/skins/Aqua/css/ligerui-all.css"rel="stylesheet" type="text/css" />
<script src="/js/ligerui/lib/jquery/jquery-1.9.0.min.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/core/base.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerGrid.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerForm.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerTree.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerDateEditor.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerComboBox.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerCheckBox.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerButton.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerDialog.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerRadio.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerSpinner.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerTextBox.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerTip.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/plugins/ligerResizable.js"type="text/javascript"></script>
<script type="text/javascript" src="/js/action/sys.common.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<link type="text/css" rel="stylesheet" href="/css/base.css" />
</head>
<body>
<div id="maingrid" style="background:#fff;"></div>
</body>
<script type="text/javascript">
var grid,
windialog,	//查询框
dataUrl,	//url地址
query_url = baseUrl+"archives/getArchivesList.do",
//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width: 1},
	{ display: '档案案情', name: 'caseInformation' ,width: 120},
	{ display: '类型', name: 'type',width: 100},
	{ display: '创建者', name: 'createUser',width: 80},
	{ display: '创建时间', name: 'createTime',width: 120}
],

//所有页面都要获取这两个变量
//menuId = $.fsh.requestParam("menuId"),//菜单id 
menuId =10
_title="",

//参数替换规则
//只要涉及到跳转按钮， 都需要加此参数
//"跳转按钮的ID": "过滤规则"
paramReplace = {
	showDevice: "&userId=$userId$"
};

//$(document).ready();
$(function (){	
//$.fsh.isLogin();
//设置路径
_title = "系统管理|管理员用户管理";
$.fsh.createTitleAndFuncs(_title, menuId);
//创建数据列表
dataUrl = baseUrl + "archives/getArchivesList.do";
grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
//排序跳转至第一页
$("div.l-grid-hd-cell-inner").click(function(){
	if(grid.options.page!=1) grid.changePage("first");
});
});
/**
* 
* reflushData:刷新数据
*
* @author   yumaochun
* @date     2016年8月16日
*
*/
function reflushData(){
grid.loadData();
}

/**
* 
* editAdminUsers:修改管理员用户
*
* @author   yumaochun
* @date     2016年8月16日
*
*/
function editAdminUsers(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	var url="/manager/gw_admin_users/gw_admin_users_edit.html?id="+_flag.id;
	$.ligerDialog.open({ width:900, height: 420, url: url, isResize: false, title: "修改管理员用户"});
}

}


/**
* 
* quit:离职操作
*
* @author   yumaochun
* @date     2016年8月16日
*
*/
function quit(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	var flag = $.ligerDialog.confirm( "确定修改为离职吗?",function(flag){
		if(flag){
			$.ajax({
				url:'/adminUsers/updateStateByid.do?id='+_flag.id,
				method:'post',
				type:'json',
				success:function(data){
					if(data.status.code=="10000"){
						  $.ligerDialog.alert(data.status.msg, "提示信息", "success",function(){	
							  reflushData();
						});
					 }else{
						 $.ligerDialog.alert(data.status.msg, "提示信息", "error",function(){
							
						 });
					 }
				}	
			}); 
		}
	});
}
}
/**
* 
* addAdminUsers:添加管理员用户
*
* @author   yumaochun
* @date     2016年8月16日
*
*/
function addAdminUsers(){
var url="/manager/gw_admin_users/gw_admin_users_add.html";
$.ligerDialog.open({ width:900, height: 450, url: url, isResize: false, title: "添加管理员用户"});
}
/**
* 
* deleteAdminUsers:删除管理员用户
*
* @author   yumaochun
* @date     2016年8月16日
*
*/
function deleteAdminUsers(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag) {
	var url = baseUrl + "adminUsers/deleteseGroup.do?id=" +_flag.id;
	$.fsh.deleteSelectedRow(url, grid,_flag.id);
}
}



 </script>
</html>