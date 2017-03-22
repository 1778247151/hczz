var grid,

//table	columns
columns = [
        { display: '主键ID', hide:true,		name: 'id', 			align: 'center',		width: "5%"},
     	{ display: '租借单号', 		name: 'zjcode', 			align: 'center',		width: "8%" },
     	{ display: '储物柜编号', 		name: 'lockerCode', 			align: 'center',		width: "8%" },
     	{ display: '会员vip号', 		name: 'vipCode', 			align: 'center',		width: "8%" },
     	{ display: '卡面编号', 		name: 'cardCode', 			align: 'center',	width: "8%" },
     	{ display: '租借方式', 		name: 'rentalMethodName', 			align: 'center',		width: "5%"},
     	{ display: '开始时间', 		name: 'startTime', 			align: 'center',		width: "5%" },
     	{ display: '结束时间', 		name: 'endTime', 			align: 'center',		width: "6%" },
     	{ display: '付款方式', 		name: 'paymentMethodName', 			align: 'center',	width: "5%" },
     	{ display: '金额', 		name: 'money', 			align: 'center',		width: "5%"},
     	{ display: '积分数', 		name: 'integralNum', 			align: 'center',		width: "5%" },
     	{ display: '最长租借天数', 		name: 'rentalDay', 			align: 'center',		width: "6%" },
     	{ display: '状态', 		name: 'statusName', 			align: 'center',	width: "5%" },
     	{ display: '租借时间', 		name: 'rentalTime', 			align: 'center',		width: "6%" },
     	{ display: '归还时间', 		name: 'returnTime', 			align: 'center',	width: "5%" },
      	{ display: '创建人', 		name: 'createUserName', 			align: 'center',	width: "5%" },
      	{ display: '创建时间', 		    name: 'createTime', 			align: 'center',	width: "5%" },
      	{ display: '更新人', 		    name: 'updateUserName', 			align: 'center',	width: "5%" },
      	{ display: '更新时间', 		name: 'updateTime', 			align: 'center',	width: "5%" }
         ],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "客服中心|储物柜维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "lockerRental/getLockerRentalList.do";
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

//修改
function updateLockerRental(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag.status==0 ){
		$.ligerDialog.warn("已经归还的储物柜不能修改!")
	}else{
		var url="/manager/gw_lockerRental/gw_locker_rental_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:840, height: 650, url: url, isResize: false, title: "修改储物柜信息"});
	}
}
//添加
function addLockerRental(){
var url="/manager/gw_lockerRental/gw_locker_rental_add.html";
$.ligerDialog.open({width:840, height: 600, url: url, isResize: false, title: "添加储物柜租借信息"});
}
//删除
function deleteLockerRental(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag.status==1 || _flag.status==2 ){
		$.ligerDialog.warn("已经出租或者逾期的储物柜不能删除!")
	}else{
		var url = baseUrl + "lockerRental/deleteLockerRentalById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

//根据条件查询
function getLockerRentalByCondition(){
var form = new liger.get("form2");
	var data= form.getData();
	var lockerCode= data.lockerCode;	 
	var vipCode= data.vipCode;	 
	var cardCode= data.cardCode;	 
	var status = data.status;	 
	dataUrl = baseUrl+"lockerRental/getLockerRentalList.do?lockerCode="+lockerCode+'&status='+status+'&vipCode='+vipCode+'&cardCode='+cardCode
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}
//导出
function excelData(){
	var flag = $.ligerDialog.confirm( "确定导出吗?",function(flag){
		if(flag){
			var data= form.getData();
			var lockerCode= data.lockerCode;	 
			var vipCode= data.vipCode;	 
			var cardCode= data.cardCode;	 
			var status = data.status;	 
			location.href="/lockerRental/getExcelLockerRentalList.do?lockerCode="+lockerCode+'&status='+status+'&vipCode='+vipCode+'&cardCode='+cardCode
		}
	});
}

//归还信息
function returnLockerRental(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		if(_flag.status==0){
			$.ligerDialog.warn("储物柜已归还！")
		}else{
			var url="/manager/gw_lockerRental/gw_locker_rental_return.html?id="+_flag.id;
			$.ligerDialog.open({ width:950, height: 760, url: url, isResize: false, title: "储物柜归还信息"});
		}	
	}
}