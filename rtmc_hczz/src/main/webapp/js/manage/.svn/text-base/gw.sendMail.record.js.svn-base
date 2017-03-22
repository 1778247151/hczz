var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址
	query_url = baseUrl+"mailRecord/getMailRecordList.do",
	//table	columns
	columns = [
		{ display: '邮件ID', hide:true,	name: 'id',width:1},
		{ display: '收件人', name: 'addressee',width:150 },
		{ display: '邮件主题', name: 'title',width:150},
		{ display: '邮件内容', name: 'content',width:150},
		{ display: '备注', name: 'note',width:150},
		{ display: '类型', name: 'typeName',width:150},
		{ display: '发送时间', name: 'sendTime',width:150},
		{ display: '发送人', name: 'sendUser',width:150},
		{ display: '状态', name: 'statusName',width:150},
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
	_title = "会员管理|邮件发送";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "mailRecord/getMailRecordList.do";
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
//删除邮件记录
function deleteMailRecord(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {

	var url = baseUrl + "mailRecord/deleteMailRecordByid.do?id=" +_flag.id;
	$.fsh.deleteSelectedRow(url, grid,_flag.id);
		
		
	}
}

function setData(){

	$("#addressee").val("123@qq.com");
	
	
}

//查阅邮件记录
function lookMailRecord(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
		var url="/manager/gw_mail_record/gw_sendMail_look.html?id="+_flag.id;
		parent.f_addTab("lookMailRecord","查阅邮件信息",url);	
	/*	$.ligerDialog.open({
			width : 640,
			height : 520,
			url : url,
			isResize : false,
			title : "查阅邮件信息"
		});*/
}
	
}


//根据条件查询物品盘点信息
function getSendMaiRecordCountByCondition(){
	var form = new liger.get("form2");
	var data= form.getData();
	var sendUser = data.sendUser;
	var status = data.status;	 
	var type = data.type;
	dataUrl = baseUrl+"mailRecord/getMailRecordList.do?status="+status+'&sendUser='+sendUser+'&type='+type;
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}
