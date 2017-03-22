var grid,

//table	columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
       	{ display: '收款方式编号', 			name: 'code', 			align: 'center',		width: "10%" },
       	/*{ display: '购物中心名称', 		name: 'mallName', 			align: 'center',	width: "10%" },*/
       	{ display: '付款方式', 		name: 'paymentname', 			align: 'center',		width: "10%" },
       	{ display: '兑换率', 		name: 'exchrate', 			align: 'center',		width: "10%" },
       	{ display: '预留手续费', 		name: 'chargerate', 			align: 'center',	width: "10%" },
       	{ display: '备注', 		name: 'beizhu', 			align: 'center',	width: "10%" },
       	{ display: '最后修改用户', 		name: 'lastmodbyuserName', 			align: 'center',	width: "10%" },
       	{ display: '最后修改时间', 		name: 'lasttime', 			align: 'center',	width: "10%" }
       	
       ],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|店铺管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "marketMisBase/getMisPaymentTenderByPageList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "orderNum", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

//刷新数据
function reflushData(){
grid.loadData();
}

//修改结算收款方式信息
function editSettlementPayment(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	var url="/manager/gw_mispayment_tender/gw_settlement_paymenttender_edit.html?id="+_flag.id;
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改结算收款方式"});
}

}
//添加结算收款方式数据
function addSettlementPayment(){
var url="/manager/gw_mispayment_tender/gw_settlement_paymenttender_add.html";
$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加结算收款方式"});
} 
//删除结算收款方式信息(假删除)
function deleteSettlementPayment(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag) {
	var url = baseUrl + "settlementPaymentTender/deleSettlementPaymentByFake.do?id=" +_flag.id;
	$.fsh.deleteSelectedRow(url, grid,_flag.id);
}
}