var grid,	//表格
windialog,	//查询框
dataUrl,	//url地址
query_url = baseUrl+"gwTranssalestotalService/getTranssalestotalByPageList.do",
//table	columns
columns = [
    { display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: 1},
	{ display: '商户名称', 		name: 'merchansInfoName', 			align: 'center',	width: "7%" },
	{ display: '店铺名称', 		name: 'shopsLeaseName', 			align: 'center',	width: "7%" },
	{ display: '支付方式', 		name: 'paymentTenderName', 			align: 'center',	width: "5%" },
	{ display: '状态', 		name: 'stateName', 			align: 'center',	width: "5%",
		render:function(rowdata){
			if(rowdata.gwState==0){			
				return "<font class=\"daiconfirm\">"+rowdata.stateName+"</font>";
			}else if(rowdata.gwState==3){
				return "<font class=\"passconfirm\">"+rowdata.stateName+"</font>";
			}
			return "";
		}
	},
	{ display: '会员号', 		name: 'gwMemberCode', 			align: 'center',	width: "5%" },
	{ display: '积分数量', 		name: 'integration', 			align: 'center',	width: "5%" },
	{ display: '收银机编号', 		name: 'gwTillid', 			align: 'center',	width: "7%" },
	{ display: '交易日期', 		name: 'gwTxdate', 			align: 'center',	width: "7%" },
	{ display: '交易时间', 		name: 'gwTxtime', 			align: 'center',	width: "7%" },
	{ display: '交易流水号', 		name: 'gwTxserial', 			align: 'center',	width: "15%" },
	{ display: '销售总数量', 		name: 'gwSalesnumber', 			align: 'center',	width: "7%" },
	{ display: '销售总额', 		name: 'gwSalesamount', 			align: 'center',	width: "7%" }
	
],
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
	//设置路径
	_title = "销售数据|销售数据列表";
	$.fsh.createTitleAndFuncs(_title, menuId);
//$.fsh.isLogin();
//创建数据列表
dataUrl = baseUrl+"gwTranssalestotalService/getTranssalestotalByPageList.do";
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


//根据条件查询待审核合同数据
function getTranssalestotalByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var startTime = data.startTime;	 
 	var endTime = data.endTime;
// 	var merchantsInfoId = data.merchantsInfoId;
// 	var shopsInfoId = data.shopsInfoId;
// 	var goodstreeId = data.goodstreeId;
	dataUrl = baseUrl+"gwTranssalestotalService/getTranssalestotalByPageList.do?startTime="+startTime+'&endTime='+endTime;
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}

function addTranssalestotal(){
	var url="/manager/gw_transsalestotal/gw_transsalestotal_add.html";
	$.ligerDialog.open({ width:640, height: 570, url: url, isResize: false, title: "销售数据补录"});
}