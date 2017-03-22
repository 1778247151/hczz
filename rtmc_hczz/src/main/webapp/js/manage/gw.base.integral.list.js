var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id'},
	{ display: '会员等级', name: 'memberGradeCode' },
	{ display: '店铺', name: 'shopsName'},
	{ display: '最低消费金额', name: 'lowestMoney'},
	{ display: '金额', name: 'saleMoney'},
	{ display: '积分', name: 'integralNumber'},
	{ display: '比例', name: 'proportion',width:200},
	{ display: '描述', name: 'description'},
	{ display: '创建人', name: 'createUserName'},
	{ display: '创建时间', name: 'createTime'},
	{ display: '更新人', name: 'updateUserName'},
	{ display: '更新时间', name: 'updateTime'},
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
	_title = "功能管理|基础积分规则管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "baseIntegral/getBaseIntegralList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

function alerta(){
	var gridData = grid.getData();   ///表格数据
	for(var i=0;i<gridData.length;i++){		
		var shopsLeaseCode=gridData[i].shopsCode ;///提交数据添加店铺编码
		alert(shopsLeaseCode);
		gridData[i].shopsCode
//		 editor: {
//			 type:'select',
//	           url: '/shoplease/getAllShpoLease.do', ajaxType: 'get',
//	           valueField: 'code', textField: 'name',
//	       }	
	}
}
//添加基础积分规则
function addBaseIntegral() {
	var url="/manager/gw_base_integral/gw_base_integral_add.html";
	$.ligerDialog.open({ width:680, height: 500, url: url, isResize: false, title: "添加基础积分规则"});
}

//删除基础积分规则
function deleteBaseIntegral(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "baseIntegral/delBaseIntegral.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

//修改基础积分规则
function updateBaseIntegral(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_base_integral/gw_base_integral_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改基础积分规则"});
	}
}
