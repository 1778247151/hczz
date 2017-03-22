var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width:100},
	{ display: '活动编号', name: 'code',width:150 },
	{ display: '活动标题', name: 'title',width:100},
	{ display: '内容', name: 'content',width:200},
	{ display: '积分', name: 'integration',width:100},
	{ display: '开始时间', name: 'startTime',width:130},
	{ display: '结束时间', name: 'endTime',width:130},
	{ display: '活动状态', name: 'activityStatusName',width:100,
		render:function(rowdata){
				if(rowdata.activityStatus==1){
					return "<font class=\"daiconfirm\">"+rowdata.activityStatusName+"</font>";
				}else if(rowdata.activityStatus==2){
					return "<font class=\"passconfirm\">"+rowdata.activityStatusName+"</font>";
				}else if(rowdata.activityStatus==3){
					return "<font class=\"columncolor_4\">"+rowdata.activityStatusName+"</font>";
				}else if(rowdata.activityStatus==4){
					return "<font class=\"columncolor_5\">"+rowdata.activityStatusName+"</font>";
				}else if(rowdata.activityStatus==5){
					return "<font class=\"daiconfirm\">"+rowdata.activityStatusName+"</font>";
				}
				return "";
		}
	},
	{ display: '创建人', name: 'createUserName',width:100},
	{ display: '创建时间', name: 'createTime',width:130},
	{ display: '更新人', name: 'updateUserName',width:100},
	{ display: '更新时间', name: 'updateTime',width:130},
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
	_title = "会员管理|活动维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "activity/getConfirmActivityList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});


//活动审核
function checkActivity(){
	/*var rows = grid.getSelectedRows();
	var ids = "";
	for (var i = 0; i < rows.length; i++) {
		ids += (rows[i].id+",");
	}
	ids = ids.substring(0,ids.length-1);
	if(ids==null || ids.length==0){
		$.ligerDialog.warn("请选中数据后，再操作");
	}else{
		$.ajax({
	 		url:'/activity/checkActivity.do?ids='+ids,
	 		method:'POST',
	 		dataType:'json',
	 		success:function(data){
	 			if(data.status.code=="10000"){
	 				$.ligerDialog.alert(data.status.msg, "提示信息", "success",function(){
						reflushData();
				    });
				  }else{
					 $.ligerDialog.alert(data.status.msg, "提示信息", "error");
				 }
	 			
	 		}
	 	});
	}*/
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
	var url="/manager/gw_activity/gw_activity_confirm.html?id="+_flag.id;
	$.ligerDialog.open({ width:640, height: 520, url: url, isResize: false, title: "确认活动"});
	}
}

//添加活动界面
function addActivity() {
	var url="/manager/gw_activity/gw_activity_add.html";
	$.ligerDialog.open({ width:640, height: 520, url: url, isResize: false, title: "添加活动"});
}

//删除活动
function delActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "activity/delActivity.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}
//修改活动界面
function updateActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_activity/gw_activity_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改活动"});
	}
}
//查阅活动界面
//活动报名
function lookActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	var url="/manager/gw_activity/gw_activity_look.html?id="+_flag.id;
	//$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "参加活动"});
	parent.f_addTab("266","活动维护",url);
}
