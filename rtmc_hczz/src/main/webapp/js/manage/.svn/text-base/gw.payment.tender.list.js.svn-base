var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id'},
	{ display: '支付方式', name: 'paymentTenderCode' },
	{ display: '是否积分', name: 'whetherIntegralName'},
	{ display: '创建人', name: 'createUserName'},
	{ display: '创建时间', name: 'createTime'},
	{ display: '更新人', name: 'updateUserName'},
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
	_title = "功能管理|支付方式积分管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "paymentTender/getPaymentTenderList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "orderNum", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

function addPaymentTender() {
	var url="/manager/gw_payment_tender/gw_payment_tender_add.html";
	$.ligerDialog.open({ width:680, height: 300, url: url, isResize: false, title: "添加支付方式积分"});
}

function deletePaymentTender(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "paymentTender/delPaymentTender.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

function updatePaymentTender(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_payment_tender/gw_payment_tender_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 300, url: url, isResize: false, title: "修改支付方式积分"});
	}
}
