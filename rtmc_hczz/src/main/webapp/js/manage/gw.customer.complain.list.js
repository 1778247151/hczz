var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width:100},
	{ display: '客户投诉编号', name: 'code' ,width:140},
	{ display: '会员VIP号', name: 'cardCode',width:150,
		render:function(rowdata){
			if(rowdata.cardCode==""){
				return "<font class=\"columncolor_5\">非会员</font>";
			}else{
				return rowdata.cardCode;
			}
		}
	},
	{ display: '顾客名称', name: 'customerName',width:100},
	{ display: '联系电话', name: 'phone',width:100},
	{ display: '性别', name: 'sexName',width:100},
	{ display: '联系地址', name: 'telAddress',width:100},
	{ display: '客诉对象', name: 'subject',width:100},
	{ display: '事情描述', name: 'description',width:100},
	{ display: '发生地', name: 'happenAddress',width:100},
	{ display: '发生时间', name: 'happenTime',width:100},
	{ display: '客诉级别', name: 'level',width:100,
		render:function(rowdata){
			if(rowdata.level==0){
				return "普通";
			}else if(rowdata.level==1){
				return "<font class=\"columncolor_7\">重大</font>";
			}
		}
	},
	{ display: '申诉方式', name: 'method',width:100,
		render:function(rowdata){
			if(rowdata.method==0){
				return "现场";
			}else if(rowdata.method==1){
				return "电话";
			}else if(rowdata.method==3){
				return "其他";
			}
		}	
	},
	{ display: '意见类型', name: 'opinionTypeName',width:100},
	{ display: '处理时间', name: 'handleTime',width:100},
	{ display: '处理结果备注', name: 'handleResult',width:100},
	{ display: '处理人', name: 'handleUser',width:100},
	{ display: '创建人', name: 'createUserName',width:100},
	{ display: '创建时间', name: 'createTime',width:100},
	{ display: '修改人', name: 'createUserName',width:100},
	{ display: '创建时间', name: 'createTime',width:100},
	{ display: '处理状态', name: 'statusName',width:100}
],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|客户投诉管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "customerComplain/getCustomerComplainList.do";
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

//关闭模态窗体
function closeDialog(){
	//$(".l-dialog,.l-window-mask").remove(); 
	$(".l-dialog,.l-window-mask").css("display","none");
    $.ligerDialog.close();    
}

function addCustomerComplain() {
	var url="/manager/gw_customer_complain/gw_customer_complain_add.html";
	parent.f_addTab("246","客诉维护",url);
//	var url="/manager/gw_customer_complain/gw_customer_complain_add.html";
//	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加客户投诉"});
}

function delCustomerComplain(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "customerComplain/delCustomerComplain.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

function updateCustomerComplain(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_customer_complain/gw_customer_complain_edit.html?id="+_flag.id;
		parent.f_addTab("246","客诉维护",url);
		
//		var url="/manager/gw_customer_complain/gw_customer_complain_edit.html?id="+_flag.id;
//		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改客户投诉"});
	}
}
function lookCustomerComplain(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_customer_complain/gw_customer_complain_look.html?id="+_flag.id;
		parent.f_addTab("246","客诉维护",url);
		
//		var url="/manager/gw_customer_complain/gw_customer_complain_edit.html?id="+_flag.id;
//		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改客户投诉"});
	}
}
