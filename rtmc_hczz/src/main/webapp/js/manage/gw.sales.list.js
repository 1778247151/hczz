var grid,	//表格
windialog,	//查询框
dataUrl,	//url地址
query_url = baseUrl+"gwSales/getSalesByPageList.do",
//table	columns
columns = [
    { display: '主键ID', hide:true,		name: 'id', 			align: 'left',width:20},
	{ display: '流水单号', 		name: 'gwTxserial', 			align: 'center',	width: 250 },
	{ display: '会员名称', 		name: 'mermberName', 			align: 'center',	width: 120 },
	{ display: '销售数量', 		name: 'gwSalesnumber', 			align: 'center',	width: 80 },
	{ display: '销售日期', 		name: 'gwTxdate', 			align: 'center',	width: 120},
	{ display: '销售时间', 		name: 'gwTxtime', 			align: 'center',	width: 120 },
	{ display: '收银机编号', 		name: 'gwTillid', 			align: 'center',	width: 120 },
	{ display: '店铺名称', 		name: 'shopName', 			align: 'center',	width: 120 },
//	{ display: '支付方式编号', 		name: 'gwPaymenttendercode', 			align: 'center',	width: 120 },
	
	{ display: '积分数', 		name: 'integralNumber', 			align: 'center',	width:100 ,
		render:function(rowdata){
			
				return "<font class=\"passconfirm\">"+rowdata.integralNumber+"</font>";
			
		}	
	},
	{ display: '创建时间', 		name: 'createTime', 			align: 'center',	width:150}
	
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
dataUrl = baseUrl+"gwSales/getSalesByPageList.do";
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


//根据条件查询
function getSalesByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var startTime = data.startTime;	 
 	var endTime = data.endTime;
 	if(startTime!=""&&endTime!="")
	{
		if(endTime<startTime){
			$.ligerDialog.warn("结束时间不能小于开始时间");
			return;
	 	}
	}
 	var shopCode = data.shopCode;
	dataUrl = baseUrl+"gwSales/getSalesByPageList.do?startTime="+startTime+'&endTime='+endTime+'&shopCode='+shopCode;
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}

function addSales(){
	var url="/manager/gw_sales/gw_sales_add.html";
	$.ligerDialog.open({ width:840, height:580, url: url, isResize: false, title: "销售数据补录"});
}
function deleteSale(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var flag = $.ligerDialog.confirm( "确定删除吗?",function(flag){
			if(flag){
				$.ajax({
					url:"/gwSales/deleteById.do?id=" +_flag.id,
					method:'post',
					type:'json',
					success:function(data){
						if(data.status.code=="10000"){
							  $.ligerDialog.alert(data.status.msg, "提示信息", "success",function(){	
								  reflushData();
							});
						 }else{
							 $.ligerDialog.alert(data.status.msg, "提示信息", "error",function(){
								 
							 });
						 }
					}	
				}); 
			}
		});
	}
}
//function lookSales(){
//	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
//	if(_flag) {
//		var url="/manager/gw_sales/gw_sales_look.html?id="+_flag.id;
//		$.ligerDialog.open({ width:840, height:580, url: url, isResize: false, title: "查阅销售数据"});
//	}
//}