var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址
	query_url = baseUrl+"role/getRoleList.do",
	//table	columns
	columns = [
		{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		},
		{ display: '中文名称', 			name: 'cnName', 			align: 'center',		minWidth: 250 },
		{ display: '英文名称', 		name: 'enName', 			align: 'center',	minWidth: 250 },
		{ display: '描述', 		name: 'note', 			align: 'center',		minWidth: 400 },
		{ display: '状态', 		name: 'stateName', 			align: 'center',	minWidth: 200 },
		{ display: '时间', 		name: 'time',			align: 'center',		minWidth: 250 },
		{ display: '排序', 	name: 'orderNum',			align: 'center',		minWidth: 250 },
		
	],

	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),
	_title="";

//$(document).ready();
$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "系统管理|角色管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "role/getRoleList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});
//刷新数据
function reflushData(){
	grid.loadData();
}

//修改角色
function editRole(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_role/gw_role_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改角色"});
	}
	
}
//添加角色
function addRole(){
	var url="/manager/gw_role/gw_role_add.html";
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加角色"});
}
//删除角色
function deleteRole(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "role/deleteRoleById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}
//给角色，设置权限组
function saveRoleGroup(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		
		var url="/manager/gw_role/gw_role_group.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "角色名称：【"+_flag.cnName+"】权限设置"});
	}
}

