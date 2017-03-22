var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width:1},
	{ display: '活动状态', hide:true,	name: 'activityStatus',width:1},
	{ display: '活动状态', hide:true,	name: 'status',width:1},
	{ display: '活动编号', name: 'code',width:150 },
	{ display: '活动标题', name: 'title',width:100},
	{ display: '内容', name: 'content',width:200},
	{ display: '积分', name: 'integration',width:100},
	{ display: '活动人数', name: 'activityMemberNum',width:100},
	{ display: '已参加人数', name: 'joinMemberNum',width:100},
	{ display: '开始时间', name: 'startTime',width:130},
	{ display: '结束时间', name: 'endTime',width:130},
	{ display: '活动状态', name: 'activityStatus',width:100,
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
				}else if(rowdata.activityStatus==6){
					return "<font class=\"passconfirm\">"+rowdata.activityStatusName+"</font>";
				}
				return "";
		}
	},
	{ display: '状态', name: 'status',width:100,
		render:function(rowdata){
			if(rowdata.status==1){
				return "<font class=\"notconfirm\">启用</font>";
			}else if(rowdata.status==0){
				return "<font class=\"daiconfirm\">禁用</font>";
			}
			return "";
	}	
	},
	{ display: '审核人', name: 'approveUserName',width:100},
	{ display: '审核时间', name: 'approveTime',width:100},
	{ display: '审核意见', name: 'approveInfo',width:180},
	{ display: '创建人', name: 'createUserName',width:100},
	{ display: '创建时间', name: 'createTime',width:130},
	{ display: '更新人', name: 'updateUserName',width:100},
	{ display: '更新时间', name: 'updateTime',width:130}
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
	dataUrl = baseUrl + "activity/getActivityList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

//活动报名
//function enrollActivity(){
//	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
//	$.ajax({
// 		url:'/activity/getEnrollStatusActivity.do?id='+_flag.id,
// 		method:'POST',
// 		dataType:'json',
// 		success:function(data){
// 			if(data.status.code=="10000"){
//				if(_flag){
//					var url="/manager/gw_activity/gw_activity_enroll.html?id="+_flag.id;
//					//$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "参加活动"});
//					parent.f_addTab("266","活动维护",url);
//				}
//			  }else{
//				 $.ligerDialog.alert(data.status.msg, "提示信息", "error");
//			 }
// 			
// 		}
// 	});
//}

//活动审核
function checkActivity(){
	var rows = grid.getSelectedRows();
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
	}
}

//添加活动界面
function addActivity() {
	var url="/manager/gw_activity/gw_activity_add.html";
	$.ligerDialog.open({ width:680, height: 520, url: url, isResize: false, title: "添加活动"});
}

//删除活动
function delActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	var code=_flag.code;
	if(_flag) {
		if(_flag.activityStatus!=1){
			$.ligerDialog.warn("此活动的状态不能删除")
		}else{
			var url = baseUrl + "activity/delActivity.do?id=" +_flag.id+"&code="+code;
			$.fsh.deleteSelectedRow(url, grid,_flag.id);
		}
		
	}
}
//修改活动界面
function updateActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		if(_flag.status==0 || _flag.activityStatus!=1){
			$.ligerDialog.warn("此活动的状态不能修改")
		}else{
			var url="/manager/gw_activity/gw_activity_edit.html?id="+_flag.id;
			$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改活动"});
		}
		
	}
}
//查阅活动界面
function lookActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		if(_flag.activityStatus==1){
			$.ligerDialog.warn("此活动未确认不能查阅")
		}else{
			var url="/manager/gw_activity/gw_activity_signedmember.html?id="+_flag.id+'&code='+_flag.code+'&status=7';
			//$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "参加活动"});
			parent.f_addTab("consultActivity","查阅活动",url);	
		}
	}
	
}

////开始报名
//function startEnter(){
//	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
//	var startTime = $.date.getTimestamp(_flag.startTime);
//	var newStartTime = $.date.getTimestamp($.date.formatDateTime(new Date(),"-"));
//	var endTime = $.date.getTimestamp(_flag.endTime);
//	if(_flag) {
//		if(_flag.status==0){
//			$.ligerDialog.warn("此活动已禁用，不能开始报名")
//		}else if(_flag.activityStatus!=2){
//			$.ligerDialog.warn("此活动的状态不能开始报名")
//		}else if(newStartTime>startTime){
//			$.ligerDialog.warn("活动开始时间已过，不能开始报名")
//		}else if(newStartTime>endTime){
//			$.ligerDialog.warn("活动结束时间已到，不能开始报名")
//		}else{
//			var url = baseUrl + "activity/startEnter.do?id=" +_flag.id;
//			$.fsh.startEnter(url, grid,_flag.id);
//		}
//	}
//}

////结束报名
//function stopEnter(){
//	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
//	var startTime = $.date.getTimestamp(_flag.startTime);
//	var newStartTime = $.date.getTimestamp($.date.formatDateTime(new Date(),"-"));
//	var endTime = $.date.getTimestamp(_flag.endTime);
//	if(_flag) {
//		if(_flag.status==0){
//			$.ligerDialog.warn("此活动已禁用，不能结束报名")
//		}else if(_flag.activityStatus!=3){
//			$.ligerDialog.warn("此活动的状态不能结束报名")
//		}else{
//			var url = baseUrl + "activity/stopEnter.do?id=" +_flag.id;
//			$.fsh.stopEnter(url, grid,_flag.id);
//		}
//	}
//}

////开始活动
//function startActivity(){
//	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
//	var startTime = $.date.getTimestamp(_flag.startTime);
//	var newStartTime = $.date.getTimestamp($.date.formatDateTime(new Date(),"-"));
//	var endTime = $.date.getTimestamp(_flag.endTime);
//	if(_flag) {
//		if(_flag.status==0){
//			$.ligerDialog.warn("此活动已禁用，不能操作")
//		}else if(_flag.activityStatus!=3 && _flag.activityStatus!=4){
//			$.ligerDialog.warn("此活动的状态不能开始活动")
//		}else if(newStartTime<startTime){
//			$.ligerDialog.warn("活动开始时间未到，不能开始活动")
//		}else if(newStartTime>endTime){
//			$.ligerDialog.warn("活动结束时间已到，不能开始活动")
//		}else{
//			var url = baseUrl + "activity/startActivity.do?id=" +_flag.id;
//			$.fsh.startActivity(url, grid,_flag.id);
//		}
//	}
//}

//强制结束活动
function stopActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		if(_flag.status==0){
			$.ligerDialog.warn("此活动已禁用，不能操作")
		}else if(_flag.activityStatus!=5){
			$.ligerDialog.warn("此活动状态不能结束活动")
		}else{
			var url = baseUrl + "activity/stopActivity.do?id=" +_flag.id;
			$.fsh.stopActivity(url, grid,_flag.id);
		}
	}
}

//禁用
function fibidActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		if(_flag.activityStatus==3 || _flag.activityStatus==4 || _flag.activityStatus==5|| _flag.activityStatus==6){
			$.ligerDialog.warn("此状态不能禁用")
		}else if(_flag.status==0){
			$.ligerDialog.warn("此活动已被禁用")
		}else{
			var url ="/activity/updateStatusById.do?id=" +_flag.id+'&status=0';
			$.fsh.disableSelectedRow(url, grid,_flag.id);	
		}	
	}
}

//启用
function usingActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		if(_flag.status==1){
			$.ligerDialog.warn("活动已启用")
		}else{
			var url ="/activity/updateStatusById.do?id=" +_flag.id+'&status=1';
			$.fsh.enbleThisActivity(url, grid,_flag.id);	
		}
	}
}