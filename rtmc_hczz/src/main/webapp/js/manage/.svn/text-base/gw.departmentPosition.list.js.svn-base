var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址
	query_url = baseUrl+"departmentPosition/getDepartmentPositionList.do",
	//table	columns
	columns = [
		{ display: '职位ID', hide:true,	name: 'id'},
		{ display: '职位编号', name: 'code' },
		{ display: '中文名称', name: 'cnName'},
		{ display: '英文名称', name: 'enName'},
		{ display: '所属部门', name: 'departmentName'},
		{ display: '描述', name: 'description'},
		{ display: '创建人', name: 'createUserName'},
		{ display: '创建时间', name: 'createTime'},
		{ display: '更新人', name: 'updateUserName'},
		{ display: '更新时间', name: 'updateTime'},
		{ display: '排序号码', name: 'orderNum'},
		{ display: '状态', name: 'statusName',
			options: { valueFieldID: "status" ,url:"/data/state.txt"}	
		},
	],

	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),//菜单id 
	_title="",
	
	//参数替换规则
	//只要涉及到跳转按钮， 都需要加此参数
	//"跳转按钮的ID": "过滤规则"
	paramReplace = {
		showDevice: "&departmentPositionId=$departmentPositionId$"
	};
	
//$(document).ready();
$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "系统管理|职位管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "departmentPosition/getDepartmentPositionList.do";
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

//修改职位信息
function editDepartmentPosition(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_department_position/gw_department_position_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改职位信息"});
	}
	
}

//添加职位信息
function addDepartmentPosition(){
	var url="/manager/gw_department_position/gw_department_position_add.html";
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加职位"});
}

//删除职位
function deleteDepartmentPosition(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "departmentPosition/deleteDepartmentPositionById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}


