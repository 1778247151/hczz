var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址
	query_url = baseUrl+"memberCard/getMemberCardList.do",
	//table	columns
	columns = [
		{ display: '会员卡ID', hide:true,	name: 'id',width:1},
		{ display: '会员卡号', name: 'cardCode',width:150 },
		{ display: '卡类型', name: 'cardTypeName',width:150},
		{ display: '会员等级', name: 'gradeName',width:150},
		{ display: '开卡日期', name: 'openDate',width:150},
		{ display: '创建人', name: 'createUserName',width:150},
		{ display: '创建时间', name: 'createTime',width:150},
		{ display: '状态', name: 'statusName',width:150},
	],

	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),//菜单id 
	_title="",
	
	//参数替换规则
	//只要涉及到跳转按钮， 都需要加此参数
	//"跳转按钮的ID": "过滤规则"
	paramReplace = {
		showDevice: "&memberCardId=$memberCardId$"
	};
	
//$(document).ready();
$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "系统管理|会员卡管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "memberCard/getMemberCardList.do";
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

//修改会员卡信息
function editMemberCard(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_member_card/gw_memberCard_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 450, url: url, isResize: false, title: "修改会员卡信息"});
	}
	
}

//添加会员卡信息
function addMemberCard(){
	var url="/manager/gw_member_card/gw_memberCard_add.html";
	$.ligerDialog.open({ width:640, height: 450, url: url, isResize: false, title: "添加会员卡"});
}

//批量添加会员卡信息
function batchaAddMemberCard(){
	var url="/manager/gw_member_card/gw_memberCard_batchAdd.html";
	$.ligerDialog.open({ width:640, height: 450, url: url, isResize: false, title: "添加会员卡"});
}

//删除会员卡
function deleteMemberCard(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "memberCard/deleteMemberCardById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
	
	
}
//导出excel
function exportExcel(){
	window.open("/memberCard/exportsExcel.do","_top");
	
}

