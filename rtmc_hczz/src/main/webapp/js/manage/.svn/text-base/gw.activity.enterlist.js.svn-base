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


$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "会员管理|活动维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "activity/getEnterActivityList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});


//活动报名
function enterActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
	var url="/manager/gw_activity/gw_activity_enroll.html?id="+_flag.id+'&code='+_flag.code;
	parent.f_addTab("enterActivity","活动报名",url);
	}
}

//查阅
function consultActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
	var url="/manager/gw_activity/gw_activity_consult.html?id="+_flag.id+'&code='+_flag.code;
	parent.f_addTab("enterActivity","活动报名",url);
	}
}
//
////会员签到
//function signedMember() {
//	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
//	if(_flag){
//	var url="/manager/gw_activity/gw_activity_signedmember.html?id="+_flag.id+'&code='+_flag.code;
//	parent.f_addTab("signedActivity","会员签到",url);
//	}
//}


