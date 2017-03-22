var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id'},
	{ display: '编号', name: 'code' ,width:140},
	{ display: '描述', name: 'description'},
	{ display: '是否永久', name: 'isForeverName'},
	{ display: '开始时间', name: 'startTime'},
	{ display: '结束时间', name: 'endTime'},
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
	_title = "会员管理|促销积分规则管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "promotionIntegral/getPromotionIntegralList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

function addPromotionIntegral() {
//	//生成规则编号
//	var code = "";
//    $.ajax({
// 		url:'/promotionIntegral/generateCode.do',
// 		method:'GET',
// 		success:function(data){
// 			code = data;
// 			var url="/manager/gw_promotion_integral/gw_promotion_integral_add.html?code="+code;
// 			parent.f_addTab("addPromotion","添加促销积分规则",url);
// 		 	
// 		}
// 	});
	var url="/manager/gw_promotion_integral/gw_promotion_integral_add.html?code=1";
	parent.f_addTab("addPromotion","添加促销积分规则",url);

}

function deletePromotionIntegral(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "promotionIntegral/delPromotionIntegral.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

function updatePromotionIntegral(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_promotion_integral/gw_promotion_integral_edit.html?id="+_flag.id;
		parent.f_addTab("editPromotion","修改促销积分规则",url);
//		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改促销积分规则"});
	}
}

function lookPromotionIntegral(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_promotion_integral/gw_promotion_integral_look.html?id="+_flag.id;
		parent.f_addTab("lookPromotion","查阅促销积分规则",url);
//		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改促销积分规则"});
	}
}
