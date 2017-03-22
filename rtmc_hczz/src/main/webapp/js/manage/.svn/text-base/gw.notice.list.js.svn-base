var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id'},
	{ display: '标题', name: 'title' },
	//{ display: '接收者', name: 'receiver'},
	//{ display: '公告内容', name: 'content'},
	{ display: '创建人', name: 'createUser'},
	{ display: '创建时间', name: 'createTime'},
	{ display: '更新人', name: 'updateUser'},
	{ display: '更新时间', name: 'updateTime'},
	{ display: '发布者', name: 'sendUser'},
	{ display: '发布时间', name: 'sendTime'},
	{ display: '发送状态', name: 'sendStatusName',
		render:function(rowdata){
   				if(rowdata.sendStatus==0){
   					return "<font class=\"daiconfirm\">"+rowdata.sendStatusName+"</font>";
   				}else if(rowdata.sendStatus==1){
   					return "<font class=\"passconfirm\">"+rowdata.sendStatusName+"</font>";
   				}/*else if(rowdata.status==2){
   					return "<font class=\"columncolor_2\">"+rowdata.statusName+"</font>";
   				}*/
   				return "";
   		}
	},
	{ display: '状态', name: 'statusName'}
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
	_title = "功能管理|公告管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "notice/getNoticeList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

function addNotice() {
	var url="/manager/gw_notice/gw_notice_add.html";
	$.ligerDialog.open({ width:640, height: 600, url: url, isResize: false, title: "添加公告"});
}

function delNotice(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "notice/delNotice.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

function updateNotice(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_notice/gw_notice_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 600, url: url, isResize: false, title: "修改公告"});
	}
}
function confimSend(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_notice/gw_notice_send.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 600, url: url, isResize: false, title: "确认发送公告"});
	}
}
function getNoticeInfoByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var startDate = data.startDate;
 	var endDate = data.endDate;
 	var title = data.title;
 	var dataUrl = baseUrl + "notice/getNoticeList.do?title="+title+"&startDate="+startDate+"&endDate="+endDate;
 	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
}
