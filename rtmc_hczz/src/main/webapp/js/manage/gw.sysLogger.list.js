var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id'},
	{ display: '日志操作人', name: 'operateUser' },
	{ display: '操作时间', name: 'operateTime' },
	{ display: '描述', name: 'description',width:'500'},
	{ display: 'ip地址', name: 'ip'},
	{ display: '日志类型', name: 'type'},
//	{ display: '状态', name: 'statusName'}
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
	_title = "功能管理|系统日志管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "sysLogger/getSysLoggerList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true,true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});


function delSysLogger(){
//	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	//多选
	var idArr= $.fsh.getMuiltySelected("请选中数据后，再操作！");
//	alert (idArr);return;
	if(idArr) {
		var url = baseUrl + "sysLogger/delSysLogger.do?ids=" +idArr;
		$.fsh.deleteSelectedRow(url, grid,idArr.id);
	}
}

function confimSend(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_sysLogger/gw_sysLogger_send.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 600, url: url, isResize: false, title: "确认发送系统日志"});
	}
}

