var grid,

//table	columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
       	{ display: '租借编号', 			name: 'code', 			align: 'center',		width: "10%" },
    	{ display: '租借状态', 		name: 'leaseStatusName', 			align: 'center',		width: "5%",
       		render:function(rowdata){
   				if(rowdata.leaseStatus==0){
   				return "<font class=\"daiconfirm\">"+rowdata.leaseStatusName+"</font>";
   				}else if(rowdata.leaseStatus==1){
   					return "<font class=\"passconfirm\">"+rowdata.leaseStatusName+"</font>";
   				}
   				return "";
   			}
    	},
    	{ display: '会员VIP号', name: 'cardCode',width:150,
			render:function(rowdata){
				if(rowdata.cardCode==""){
					return "<font class=\"columncolor_5\">非会员</font>";
				}else{
					return rowdata.cardCode;
				}
			}
		}, 
       	{ display: '顾客名称', 		name: 'customerName', 			align: 'center',		width: "6%" },
       	{ display: '物品名称', 		name: 'goodsName', 			align: 'center',		width: "6%" },
       	{ display: '物品编号', 		name: 'goodsCode', 			align: 'center',		width: "13%" },
       	{ display: '联系电话', 		name: 'telPhone', 			align: 'center',	width: "8%" },
    	{ display: '身份证号', 		name: 'idCard', 			align: 'center',	width: "10%" },
       	{ display: '性别', 		    name: 'sexName', 			align: 'center',	width: "5%" },
       	
       	{ display: '租借时间', 		name: 'leaseTime', 			align: 'center',	width: "8%" },
    	{ display: '租借位置', 		name: 'leaseLocation', 			align: 'center',	width: "8%" },
    	
    	{ display: '租借数量', 		name: 'leaseNumber', 			align: 'center',	width: "5%" },
    	{ display: '可借时长', 		    name: 'borrowedHour', 			align: 'center',	width: "5%" },
    	{ display: '押金', 		    name: 'deposit', 			align: 'center',	width: "5%" },
    	{ display: '一次费用', 		name: 'cost', 			align: 'center',	width: "5%" },
    	{ display: '过期金额', 		name: 'expiryPrice', 			align: 'center',	width: "5%" },
    	{ display: '归还时间', 		name: 'giveBackTime', 			align: 'center',	width: "10%" },
    	{ display: '归还金额', 		name: 'giveBackMoney', 			align: 'center',	width: "5%" },
    	{ display: '真实归还金额', 	name: 'giveBackRelmoney', 			align: 'center',	width: "5%" },
    	{ display: '创建人', 		name: 'createUserName', 			align: 'center',	width: "7%" },
    	{ display: '创建时间', 		name: 'createTime', 			align: 'center',	width: "10%" },
    	{ display: '修改人', 		name: 'updateUserName', 			align: 'center',	width: "7%" },
    	{ display: '修改时间', 		name: 'updateTime', 			align: 'center',	width: "10%" },
       	
       ],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|租借维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "leaseMaintenance/getLeaseMaintenanceByPageList.do";
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
//修改物品信息
function editGoods(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	var url="/manager/gw_goods/gw_goods_edit.html?id="+_flag.id
	$.ligerDialog.open({ width:760, height: 500, url: url, isResize: false, title: "修改物品信息"});
}

}
//添加租借信息
function addLeaseMaintenance(){
var url="/manager/gw_lease_maintenance/gw_lease_maintenance_add.html";
$.ligerDialog.open({ width:870, height: 640, url: url, isResize: false, title: "添加租借信息"});
}

//更改租借信息
function editLeaseMaintenance(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		if(_flag.leaseStatus==1){
			$.ligerDialog.warn("已归还的租借信息不能修改")
		}else{
			var url="/manager/gw_lease_maintenance/gw_lease_maintenance_edit.html?id="+_flag.id;
			$.ligerDialog.open({ width:950, height: 640, url: url, isResize: false, title: "修改租借信息"});
		}	
	}
}


//查阅租借信息
function consultLeaseMaintenance(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
			var url="/manager/gw_lease_maintenance/gw_lease_maintenance_consult.html?id="+_flag.id;
			$.ligerDialog.open({ width:950, height: 760, url: url, isResize: false, title: "修改租借信息"});	
	}
}
//归还租借信息
function returnMaintenance(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		if(_flag.leaseStatus==1){
			$.ligerDialog.warn("物品已归还")
		}else{
			var url="/manager/gw_lease_maintenance/gw_lease_maintenance_return.html?id="+_flag.id;
			$.ligerDialog.open({ width:950, height: 760, url: url, isResize: false, title: "归还租借信息"});
		}	
	}
}

//删除物品信息
function deleteLease(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag) {
	var url = "/leaseMaintenance/deleteLeaseMaintenanceById.do?id=" +_flag.id;
	$.fsh.deleteSelectedRow(url, grid,_flag.id);
}
}

//根据条件查询物品数据
function getLeaseByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var code = data.code;	 
 	var status = data.status;
 	var goodsCode = data.goodsCode;
 	alert
	dataUrl = baseUrl+"leaseMaintenance/getLeaseMaintenanceByPageList.do?code="+code+'&status='+status+'&goodsCode='+goodsCode
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}

