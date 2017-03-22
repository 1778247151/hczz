var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址

	//table	columns
	columns = [
		{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
		{ display: '编码', 			name: 'bm', 			align: 'center',		width: "15%" },
		{ display: '集团名称', 		name: 'name', 			align: 'center',	width: "30%" },
		{ display: '状态', 		name: 'stateName', 			align: 'center',		width: "10%" },
		{ display: '更新时间', 		name: 'time', 			align: 'center',	width: "20%" }
	],
	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),//菜单id
	_title="";//标题
$(function (){	
	$.fsh.isLogin();
	//设置路径
	_title = "基础设置|集团管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "marketMisBase/getMisFoGroupInfoList.do";
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

//修改集团信息
function editGroupInfo(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_group_info/gw_group_info_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改集团信息"});
	}
	
}
//添加集团信息
function addGroupInfo(){
	var url="/manager/gw_group_info/gw_group_info_add.html";
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加集团信息"});
}
//删除集团
function deleteGroupInfo(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "groupInfo/deleteGroupInfoById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}


