var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址

	//table	columns
	columns = [
		{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
		{ display: '编码', 			name: 'bm', 			align: 'center',		width: "15%" },
		{ display: '区域中文名称', 		name: 'cnName', 			align: 'center',	width: "15%" },
		{ display: '区域英文名称', 		name: 'enName', 			align: 'center',	width: "15%" },
		{ display: '状态', 		name: 'stateName', 			align: 'center',		width: "10%" },
		{ display: '更新时间', 		name: 'time', 			align: 'center',	width: "15%" }
	],

	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),//菜单id
	type = $.fsh.requestParam("type"), //菜单类型
	_title="";//标题
	
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
	_title = "基础设置|区域管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "marketMisBase/getMisFoAresList.do";
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

//修改区域信息
function editAres(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_ares/gw_ares_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改区域信息"});
	}
	
}
//添加区域信息
function addAres(){
	var url="/manager/gw_ares/gw_ares_add.html";
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加区域信息"});
}
//删除区域
function deleteAres(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "ares/deleteAresById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}


