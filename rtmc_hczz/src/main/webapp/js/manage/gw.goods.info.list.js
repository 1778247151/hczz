var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址

	//table	columns
	columns = [
		{ display: '主键ID', hide:true,		name: 'id', 	align: 'left',	    width: "5%"},		
		{ display: '货物编号', 		name: 'code', 			align: 'center',	width: "10%" },
		{ display: '货物名称', 		name: 'name', 			align: 'center',	width: "10%" },
		{ display: '货物单价', 		name: 'money', 			align: 'center',	width: "10%" },
		{ display: '货物组别名', 		name: 'goodsTypeName', 			align: 'center',	width: "10%" },
		{ display: '货物小类名', 		name: 'goodTreeFName', 			align: 'center',	width: "10%" },
		{ display: '店铺名称', 		name: 'shopsLeaseName', 			align: 'center',	width: "10%" },
		{ display: '店铺编号', 		name: 'shopsLeaseCode', 			align: 'center',	width: "10%" },
		{ display: '货物描述', 		name: 'remark', 			align: 'center',	width: "15%" },
		{ display: '创建时间', 		name: 'createTime', 	align: 'center',	width: "12%" },
		{ display: '创建用户', 		name: 'createUserName', align: 'center',	width: "10%" },
		{ display: '修改时间', 		name: 'updateTime', 	align: 'center',	width: "12%" },
		{ display: '修改用户', 		name: 'updateUserName', align: 'center',	width: "10%" }
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
	_title = "基础设置|货物信息管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "marketMisBase/getMisFoGoodsInfoList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
	
	var form;
	//创建表单结构 
	form = $("#form").ligerForm({
		inputWidth : 150,
		labelWidth : 100,
		space : 0,
		labelAlign : 'right',
		fields : [ {
			display : "货物编号",
			name : "code",
			newline : false,
			type : "text"
		},
		{
			display : "货物名",
			name : "name",
			newline : false,
			type : "text"
		}, 
		
		]
	});
});
//刷新数据
function reflushData(){
	grid.loadData();
}

//修改货物信息
function editGoodsInfo(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_goods_info/gw_goods_info_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改货物信息"});
	}
	
}
//添加货物信息
function addGoodsInfo(){
	var url="/manager/gw_goods_info/gw_goods_info_add.html";
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加货物信息"});
}
//删除单元信息
function deleteShopLease(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "goodsInfo/deleteGoodsInfoById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

//根据条件查询货物数据
function getGoodsInfoByCondition(){
	var form = new liger.get("form");
 	var data= form.getData();
 	var name = data.name;	 
 	var code = data.code;


	dataUrl = baseUrl+"marketMisBase/getMisFoGoodsInfoList.do?name="+name+"&code="+code;
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}


