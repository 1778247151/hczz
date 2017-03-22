var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width:100},
	{ display: '卡面编号', name: 'cardCode',width:100 },
	{ display: '卡类型', name: 'cardTypeName',width:100},
	{ display: 'vip号', name: 'vipCode',width:100},
	{ display: '会员等级', name: 'gradeName',width:100},
	{ display: '当前积分', name: 'credit',width:100},
	{ display: '购物中心', name: 'mallInfoName',width:100},
	{ display: '用户名', name: 'userName',width:100},
	{ display: '密码', name: 'password',width:100},
	{ display: '性别', name: 'sexName',width:100},
	{ display: '手机号', name: 'phone',width:100},
	{ display: '电话', name: 'tell',width:100},
	{ display: '邮箱', name: 'email',width:100},
	{ display: '出生日期', name: 'birthTime',width:100},
	{ display: '身份证号', name: 'idCard',width:100},
	{ display: '邮政编码', name: 'postCode',width:100},
	/*{ display: '省份', name: 'provinceName',width:100},
	{ display: '城市', name: 'cityName',width:100},
	{ display: '县或区', name: 'countyName',width:100},*/
	{ display: '地址', name: 'address',width:300},
	{ display: '备注', name: 'description',width:100},
	{ display: '生效日期', name: 'effectiveTime',width:100},
	{ display: '失效日期', name: 'expiryTime',width:100},
	{ display: '创建人', name: 'createUserName',width:100},
	{ display: '创建时间', name: 'createTime',width:100},
	{ display: '更新人', name: 'updateUserName',width:100},
	{ display: '更新时间', name: 'updateTime',width:100},
	{ display: '状态', name: 'statusName',width:100}
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
	_title = "功能管理|vip管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "members/getMembersList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	grid.isScroll = true;
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

//导出excel
function exportExcel(){
	var flag = $.ligerDialog.confirm( "确定导出吗?",function(flag){
		if(flag){
			window.open("/members/exportExcel.do","_top");
		}
	});
}
