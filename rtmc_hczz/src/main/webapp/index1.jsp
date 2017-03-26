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
<style>
	.btn a{
		float: left;
	}
</style>
</head>
<body>
<div id="maingrid" style="background:#fff;"></div>
    <div class="topInfo">
         <div class="rbContents">
              <div class="rbConInfo">
                  <div class="btn">
	                  <a href="javascript:addArchives();" id="addArchives" class="add">添加</a>
	                <!--   <a href="javascript:addArchives();" id="addArchives" class="add">添加案情</a> -->
	                  <a href="javascript:editArchives();" id="updateArchives" class="update">修改</a>
	                  <a href="javascript:lookArchives();" id="lookArchives" class="look">查看</a>
             	  </div>
           	  </div>
       </div>
       </div>
             <div style="border:1px solid #cccccc;height:160px;width:780px;margin-left:6px">
		<form id="form2" style="margin-top: 60px; margin-left: -50px;  border: 1px solid #FFFFFF;"></form>
	</div>
	<div class="btn" style="margin-left: 400px; margin-top: -50px;">
		<a class="search" href="javascript:getArchivesByCondition()">搜索</a>
	</div>
</body>
<script type="text/javascript">
var grid,
windialog,	//查询框
dataUrl,	//url地址
query_url = baseUrl+"archives/getArchivesList.do",
//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width: 1},
	{ display: '案件名称', name: 'name' ,width: 120},
	{ display: '案件编号', name: 'code' ,width: 120},
	/* { display: '状态', name: 'caseInformation' ,width: 120}, */	
	{ display: '类型', name: 'type',width: 100},
	{ display: '创建者', name: 'createUser',width: 80},
	{ display: '创建时间', name: 'createTime',width: 120},
	{ display: '操作', name: 'operation',width: 120}
],

//所有页面都要获取这两个变量
//menuId = $.fsh.requestParam("menuId"),//菜单id 
menuId =221,//菜单id 


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
* editArchives:修改案件
*
* @author   meishengjun
* @date     2017年3月22日
*
*/
function editArchives(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	var url="/manager/rt_Archives/rt_Archives_edit.html?id="+_flag.id;
	$.ligerDialog.open({ width:400, height: 450, url: url, isResize: false, title: "修改案件基本信息"});
}

}


/**
* 
* addArchives:添加案件
*
* @author   meishengjun
* @date      2017年3月22日
*
*/
function addArchives(){
	
var url="/manager/rt_Archives/rt_Archives_add.html";
$.ligerDialog.open({ width:400, height: 450, url: url, isResize: false, title: "添加案件基本信息"});
}
function InvitationPeople(){
	var dd= grid.getSelected();
	var _flag = $.fsh.noteForNotSelected("选中案件进行操作");
 	var url="/manager/rt_Archives/rt_Archives_Invitation.html?id="+_flag.id;
   	$.ligerDialog.open({
   			width : 500,
   			height :500,
   			url : url,
   			isResize : false,
   			title : "人员列表"
   		});
}
/**
* 
* lookArchives:查看案件详情
*
* @author   meishengjun
* @date     2017年3月22日
*
*/
function lookArchives(){
	//window.location.href="/demo.jsp?id="+_flag.id;;
	//window.open('/demo.jsp','_blank','')
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	var url="/manager/rt_Archives/rt_Archives_look.html?id="+_flag.id;
	$.ligerDialog.open({ width:500, height: 550, url: url, isResize: false, title: "修改案件基本信息"});
}
	
	

}

var form;
$(function() {
	//创建表单结构 
	form = $("#form2").ligerForm({
		inputWidth : 100,
		labelWidth : 100,
		space : 0,
		labelAlign : 'right',
		fields : [  {
			 display : "名称",name : "name",newline : false,type : "text"},
			 { display: "类型", name: "type", newline: false, type: "select",validate:{required:true},
					editor: {
		                url: '/data/archives.txt', ajaxType: 'get',
		                valueField: 'id', textField: 'text',
		            }	
				}, 
			 { display: "状态", name: "status", newline: false, type: "select",validate:{required:true},
					editor: {
		                url: '/data/status1.txt', ajaxType: 'get',
		                valueField: 'id', textField: 'text',
		            }	
				}, 
			{display : "时间",name : "date",newline : false,type : "date"}
		]
	});

});


function getArchivesByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var name = data.name;
 	var date = data.date;
 	//alert(cardCode+","+cardType+","+userName+","+grade)
 	dataUrl = baseUrl + "archives/getArchivesList.do?name="+name+"&date="+date;
 	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
}

 </script>
</html>