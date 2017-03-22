var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址
	query_url = baseUrl+"department/getDepartmentList.do",
	//table	columns
	columns = [
		{ display: '部门ID', hide:true,	name: 'id'},
		{ display: '部门编号', name: 'code' },
		{ display: '中文名称', name: 'cnName'},
		{ display: '英文名称', name: 'enName'},
		{ display: '描述', name: 'description'},
		{ display: '创建人', name: 'createUserName'},
		{ display: '创建时间', name: 'createTime'},
		{ display: '更新人', name: 'updateUserName'},
		{ display: '更新时间', name: 'updateTime'},
		{ display: '排序号码', name: 'orderNum'},
		{ display: '状态', name: 'statusName'},
	],

	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),//菜单id 
	_title="",
	
	//参数替换规则
	//只要涉及到跳转按钮， 都需要加此参数
	//"跳转按钮的ID": "过滤规则"
	paramReplace = {
		showDevice: "&departmentId=$departmentId$"
	};
	
//$(document).ready();
$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "系统管理|部门管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "department/getDepartmentList.do";
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

//修改部门信息
function editDepartment(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_department/gw_department_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 450, url: url, isResize: false, title: "修改部门信息"});
	}
	
}

//添加部门信息
function addDepartment(){
	var url="/manager/gw_department/gw_department_add.html";
	$.ligerDialog.open({ width:640, height: 450, url: url, isResize: false, title: "添加部门"});
}

//删除部门
function deleteDepartment(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "department/deleteDepartmentById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}


