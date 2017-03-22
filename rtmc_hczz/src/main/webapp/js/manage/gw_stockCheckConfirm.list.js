var grid,

//table	columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
       	{ display: '盘点单号', 			name: 'code', 			align: 'center',		width: "12%" },
       	{ display: '状态', 			name: 'statusName', 			align: 'center',		width: "6%",
       	/*	render:function(rowdata){
   				if(rowdata.status==0){
   				return "<font class=\"daiconfirm\">"+rowdata.statusName+"</font>";
   				}else if(rowdata.status==1){
   					return "<font class=\"passconfirm\">"+rowdata.statusName+"</font>";
   				}else if(rowdata.status==2){
   					return "<font class=\"notconfirm\">"+rowdata.statusName+"</font>";
   				}
   				return "";
   			}*/
       	},
     	{ display: '盘点日期', 		name: 'date', 			align: 'center',		width: "6%" },
       	{ display: '仓库编号', 		name: 'storeCode', 			align: 'center',		width: "6%" },	
       	{ display: '备注', 		name: 'note', 			align: 'center',		width: "16%" },
       	{ display: '创建人', 		name: 'createUserName', 			align: 'center',	width: "5%" },
       	{ display: '创建时间', 		name: 'createTime', 			align: 'center',	width: "10%" },
       	{ display: '更新人', 		name: 'updateUserName', 			align: 'center',	width: "5%" },
    	{ display: '更新时间', 		name: 'updateTime', 			align: 'center',	width: "10%" },
    	{ display: '审核人', 		name: 'confirmUserName', 			align: 'center',	width: "13%" },
    	{ display: '审核时间', 		name: 'confirmTime', 			align: 'center',	width: "10%" },
    	{ display: '取消审核人', 		name: 'unconfirmUserName', 			align: 'center',	width: "10%" },
    	{ display: '取消审核时间', 		name: 'unconfirmTime', 			align: 'center',	width: "10%" },
  ],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|物品盘点";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "stockCheck/getStockCheckCoufirmByPageList.do";
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

//新增盘点计划
function addStockCheck(){
var url="/manager/gw_stock_check/gw_stock_check_add.html";
parent.f_addTab("stockCheckAdd","添加物品盘点信息",url);
} 

//删除盘点计划
function deleteStockCheck(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		if(_flag.status == 1){
			$.ligerDialog.warn("已确认的物品不能删除")
		}else{
			var url = baseUrl + "stockCheck/deleteStockCheckById.do?id=" +_flag.id+'&checkCode='+_flag.code;
			$.fsh.deleteSelectedRow(url, grid,_flag.id);
		}
		
	}
}
//修改盘点计划
function editStockCheck(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	if(_flag.status == 1){
		$.ligerDialog.warn("已确认的物品盘点信息不能修改")
	}else{
		var url="/manager/gw_stock_check/gw_stock_check_edit.html?id="+_flag.id+'&code='+_flag.code
		parent.f_addTab("stockCheckEdit","修改物品盘点信息",url);
	}
	
}
	
}

//查阅盘点信息
function lookStockCheck(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
		var url="/manager/gw_stock_check/gw_stock_check_consult.html?id="+_flag.id+'&code='+_flag.code;
		parent.f_addTab("stockCheckConfirm","查阅物品盘点信息",url);	
}
}

//根据条件查询物品盘点信息
function getStockCheckCountByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var code = data.code;	 
 	var date = data.date;
 	var date = data.date;
 	var storeCode = data.storeCode;
	dataUrl = baseUrl+"stockCheck/getStockCheckCoufirmByPageList.do?code="+code+'&date='+date+'&status='+status+'&storeCode='+storeCode
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}