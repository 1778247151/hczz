var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址
	query_url = baseUrl+"mallInfo/getMallInfoPageList.do",
	//table	columns
	columns = [
		{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
		{ display: '购物中心编码', 			name: 'bm', 			align: 'center',		width: "10%" },
		{ display: '购物中心名称', 			name: 'name', 			align: 'center',		width: "10%" },
		/*{ display: '区域', 		name: 'aresName', 			align: 'center',	width: "10%" },
		{ display: '集团', 		name: 'groupInfoName', 			align: 'center',		width: "15%" },*/
		{ display: '电话', 		name: 'phone', 			align: 'center',		width: "10%" },
		{ display: '传真', 		name: 'fax', 			align: 'center',		width: "10%" },
		{ display: '购物中心地址', 		name: 'address', 			align: 'center',	width: "20%" },
		{ display: '购物中心面积', 		name: 'area',			align: 'center',		width: "7%",
			render:function(rowdata){
				if(rowdata.area!=null){
				return "<font>"+rowdata.area+"  m²"+"</font>"
				}
			}
		},
		{ display: '状态', 		name: 'stateName',			align: 'center',		width: "7%" }
		
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
	_title = "基础设置|购物中心管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "marketMisBase/getMisFoMallInfoList.do";
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

//修改购物中心
function editMallInfo(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_mall_info/gw_mall_info_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改购物中心"});
	}
	
}
//添加购物中心
function addMallInfo(){
	var url="/manager/gw_mall_info/gw_mall_info_add.html";
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加购物中心"});
}
//删除购物中心
function deleteMallInfo(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "mallInfo/deleteMallInfoById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}
//编辑购物中心楼宇
function editBuildingTree(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		parent.f_addTab("24","楼宇设置","/manager/gw_building_tree/gw_building_tree.html?gwMallInfoId?="+_flag.id+'&menuId=24');
	}
	
}

