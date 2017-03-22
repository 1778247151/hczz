var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址
	query_url = baseUrl+"adminUsers/getAdminUsersList.do",
	//table	columns
	columns = [
		{ display: '主键ID', hide:true,	name: 'id'},
		{ display: '账号', name: 'username' },
		{ display: '管理员姓名', name: 'name'},
		{ display: '角色名称', name: 'gwRoleName'},
		{ display: '联系电话', name: 'phone'},
		{ display: '身份证', name: 'sfz'},
		{ display: '住址', name: 'address'},
		{ display: '状态', name: 'stateName'},
		{ display: '最后登录时间', name: 'dtime'}
	],

	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),//菜单id 
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
	dataUrl = baseUrl + "adminUsers/getAdminUsersList.do";
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

//重置密码
function resetPwd(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_admin_users/gw_admin_users_resetPwd.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "重置密码"});
	}
}

//根据条件查询用户
function getUserByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var name = data.name;	 
 	var sfz = data.sfz;
 	var username = data.username;
	dataUrl = baseUrl+"adminUsers/getAdminUsersByCondition.do?name="+name+'&sfz='+sfz+'&username='+username
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}

