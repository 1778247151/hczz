var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id'},
	{ display: '编号', name: 'code' },
	{ display: '名称', name: 'name'},
	{ display: '描述', name: 'description'},
	{ display: '创建人', name: 'createUser'},
	{ display: '创建时间', name: 'createTime'},
	{ display: '更新人', name: 'updateUser'},
	{ display: '更新时间', name: 'updateTime'}
],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

//刷新数据
function reflushData(){
	grid.loadData();
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
	_title = "功能管理|客诉类型规则管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "customertype/getCustomerTypeList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

//添加客诉类型规则
function addCustomerType() {
	var url="/manager/gw_customer_complain/gw_customer_complainType_add.html";
	$.ligerDialog.open({ width:640, height: 400, url: url, isResize: false, title: "添加客诉类型"});
}

//删除客诉类型规则
function deleteCustomerType(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "customertype/delCustomerType.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

//修改客诉类型规则
function updateCustomerType(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_customer_complain/gw_customer_complainType_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 400, url: url, isResize: false, title: "修改客诉类型"});
	}
}
