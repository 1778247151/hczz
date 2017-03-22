var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width:100},
	{ display: '卡面编号', name: 'cardCode',width:160,
		render:function(rowdata){
			if(rowdata.cardCode==""||rowdata.cardCode==null){
				return "<font class=\"columncolor_7\">未绑卡</font>";
		    }else{
		    	return rowdata.cardCode;
		    }
       }
	},
	{ display: '卡类型', name: 'cardTypeName',width:100},
	{ display: 'vip号', name: 'vipCode',width:150},
	{ display: '会员等级', name: 'gradeName',width:100},
	{ display: '当前积分', name: 'credit',width:100},
	{ display: '购物中心', name: 'mallInfoName',width:120},
	{ display: '用户名', name: 'userName',width:100},
	{ display: '注册类型', name: 'type',width:100},
	{ display: '状态', name: 'status',width:100,
		render:function(rowdata){
			if(rowdata.status==0){
				return "<font class=\"columncolor_7\">禁用</font>";
		    }
			if(rowdata.status==1){
		    	return "启用";
		    }
       }
	},
	{ display: '性别', name: 'sexName',width:100},
	{ display: '手机号', name: 'phone',width:100},
	{ display: '电话', name: 'tell',width:100},
	{ display: '邮箱', name: 'email',width:140},
	{ display: '出生日期', name: 'birthTime',width:100},
	{ display: '身份证号', name: 'idCard',width:100},
	{ display: '邮政编码', name: 'postCode',width:100},
	{ display: '地址', name: 'address',width:300},
	{ display: '备注', name: 'description',width:100},
	{ display: '生效日期', name: 'effectiveTime',width:100},
	{ display: '失效日期', name: 'expiryTime',width:100},
	{ display: '创建人', name: 'createUserName',width:100},
	{ display: '创建时间', name: 'createTime',width:100},
	{ display: '更新人', name: 'updateUserName',width:100},
	{ display: '更新时间', name: 'updateTime',width:100},
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
	dataUrl = baseUrl + "members/getMembersListStatusUsing.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	grid.isScroll = true;
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

//绑卡
function bindCardCode(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		$.ajax({
	 		url:'/members/getMembersById.do?id='+_flag.id,
	 		method:'POST',
	 		dataType:'json',
	 		success:function(data){
	 			if(data.status.code=="10000"){
					 if(data.data.cardCode==""||data.data.cardCode==null){
						 var url="/manager/gw_members/gw_vipinfo_bindCardcode_bind.html?id="+_flag.id+"&type=1";
						 $.ligerDialog.open({ width:640, height: 400, url: url, isResize: false, title: "绑定会员卡号"});
					 }else{
						 $.ligerDialog.alert("已有卡号，无需绑定", "提示信息", "error");
						 return;
					 }
					 
				  }else{
					 $.ligerDialog.alert(data.status.msg, "提示信息", "error");
				 }
	 			
	 		}
	 	});
		
	}
}

//换卡
function exchangeCarCode(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		$.ajax({
	 		url:'/members/getMembersById.do?id='+_flag.id,
	 		method:'POST',
	 		dataType:'json',
	 		success:function(data){
	 			if(data.status.code=="10000"){
					 if(data.data.cardCode==""||data.data.cardCode==null){
						 $.ligerDialog.alert("会员无卡号，请先绑卡", "提示信息", "error");
						 return;
					 }else{ 
						 var url="/manager/gw_members/gw_vipinfo_bindCardcode_bind.html?id="+_flag.id+"&type=2";
						 $.ligerDialog.open({ width:640, height: 400, url: url, isResize: false, title: "更换会员卡号"});
					 }
					 
				  }else{
					 $.ligerDialog.alert(data.status.msg, "提示信息", "error");
				 }
	 			
	 		}
	 	});
		
	}
}
//查阅会员信息
function lookMembers(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_members/gw_vipinfo_look.html?id="+_flag.id;
		parent.f_addTab("lookMember","查阅会员信息",url);
	}
}
