var grid,
windialog,	//查询框
dataUrl,	//url地址
query_url = baseUrl+"memberIntegralDetail/getMemberIntegralDetailList.do",
//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width:100},
	{ display: '会员VIP号', name: 'memberCode',width:150 },
	{ display: '用户名', name: 'userName',width:150 },
	{ display: '会员卡号', name: 'cardCode',width:150},
	{ display: '会员积分数', name: 'intergralNum',width:150},
	{ display: '积分类型', name: 'intergralTypeName',width:150},
	{ display: '积分时间', name: 'intergralTime',width:150},
	{ display: '备注（积分来源信息）', name: 'note',width:150},
],

//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="",

//参数替换规则
//只要涉及到跳转按钮， 都需要加此参数
//"跳转按钮的ID": "过滤规则"
paramReplace = {
	showDevice: "&Id=&Id$"
};
	//$(document).ready();
$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "会员管理|会员积分明细";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "memberIntegralDetail/getMemberIntegralDetailList.do",
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
//查阅会员信息
function lookMemberIntegralDetail(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_member_integral_detail/gw_member_integral_detail_look.html?ids="+_flag.id;
		parent.f_addTab("lookMemberIntegralDetail","查阅会员明细",url);
	}	
}
//导出
function excelData(){
	var flag = $.ligerDialog.confirm( "确定导出吗?",function(flag){
		if(flag){
			location.href="/memberIntegralDetail/exportMemberIntegralDetail.do?";
		}
	});
}
//根据条件查询业主数据
function getMemberIntegralDetailByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var memberCode = data.memberCode;	 
 	var cardCode = data.cardCode;
 	var startTime = data.startTime;	 
 	var endTime = data.endTime;
 	if(startTime!=""&&endTime!="")
 	{
		if(endTime<startTime){
			$.ligerDialog.warn("结束时间必须大于开始时间");
			return;
	 	}
	}
 	dataUrl = baseUrl+"memberIntegralDetail/getMemberIntegralDetailList.do?memberCode="+memberCode+'&startTime='+startTime+'&cardCode='+cardCode+'&endTime='+endTime
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}


function delMemberIntegralDetail(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "memberIntegralDetail/delMemberIntegralDetail.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}
