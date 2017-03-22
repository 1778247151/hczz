var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id'},
	{ display: '编号', name: 'code',width:150 },
	{ display: '标题', name: 'title'},
	{ display: '备注', name: 'content'},
	{ display: '创建人', name: 'createUserName'},
	{ display: '创建时间', name: 'createTime'},
	{ display: '更新人', name: 'updateUserName'},
	{ display: '更新时间', name: 'updateTime'},
	{ display: '状态', name: 'statusName'}
],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

//刷新数据
function reflushData(){
	 var url="/manager/gw_repeatVisit/gw_repeatVisit_list?menuId=239&type=links";
	 parent.f_addTab("239", "回访维护", url);
}

//关闭模态窗体
function closeDialog(){
	//$(".l-dialog,.l-window-mask").remove(); 
	$(".l-dialog,.l-window-mask").css("display","none");
    $.ligerDialog.close();    
}

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|回访管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "repeatVisit/getRepeatVisitList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "orderNum", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

//设置回访详细信息
function setRepeatVisitDetils(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url="/manager/gw_repeatVisit/gw_repeatVisitDetils_set.html?id="+_flag.id;
		parent.f_addTab("239","回访维护",url);
	}
}
//查阅回访详细信息
function lookRepeatVisitDetils(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url="/manager/gw_repeatVisit/gw_repeatVisitDetils_look.html?id="+_flag.id;
		parent.f_addTab("239","回访维护",url);
	}
}

function addRepeatVisit() {
	var url="/manager/gw_repeatVisit/gw_repeatVisit_add.html";
	//parent.f_addTab("239","回访维护",url);
	$.ligerDialog.open({ width:640, height: 400, url: url, isResize: false, title: "添加回访"});
}

function delRepeatVisit(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	var code=_flag.code;
	if(_flag) {
		var url = baseUrl + "repeatVisit/delRepeatVisit.do?id=" +_flag.id+"&code="+code;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

function updateRepeatVisit(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_repeatVisit/gw_repeatVisit_edit.html?id="+_flag.id;
		//parent.f_addTab("239","回访维护",url);
		$.ligerDialog.open({ width:640, height: 400, url: url, isResize: false, title: "修改回访"});
	}
	/*var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_repeatVisit/gw_repeatVisit_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改回访"});
	}*/
}
