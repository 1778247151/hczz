var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址
	query_url = baseUrl+"smsRecord/getSmsRecordList.do",
	//table	columns
	columns = [
		{ display: '短信ID', hide:true,	name: 'id',width:1},
		{ display: '电话号码', name: 'phone',width:150 },
		{ display: '内容', name: 'content',width:150},
		{ display: '备注', name: 'note',width:150},
		{ display: '类型', name: 'typeName',width:150},
		{ display: '发送时间', name: 'sendTime',width:150},
		{ display: '状态', name: 'statusName',width:150},
		{ display: '发送人', name: 'sendUser',width:150},
	],

	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),//菜单id 
	_title="",
	
	//参数替换规则
	//只要涉及到跳转按钮， 都需要加此参数
	//"跳转按钮的ID": "过滤规则"
	paramReplace = {
		showDevice: "&memberCardId=$memberCardId$"
	};
	
//$(document).ready();
$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "系统管理|短信管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "smsRecord/getSmsRecordList.do";
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

//查阅短信记录
function lookSmsRecord(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
		var url="/manager/gw_sms_record/gw_smsRcord_look.html?id="+_flag.id;
		parent.f_addTab("lookSmsRecord","查阅短信记录",url);	

}	


}

