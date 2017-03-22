var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width:100},
	{ display: '卡面编号', name: 'cardCode',width:160 ,
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
	{ display: '购物中心', name: 'mallInfoName',width:100},
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
	{ display: '更新时间', name: 'updateTime',width:100}
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
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true,true);
	grid.isScroll = true;
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

//导出excel
function exportExcel(){
	window.open("/members/exportExcel.do","_top");
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
	 		url:'/members/exportExcel.do?ids='+ids,
	 		method:'POST',
	 		dataType:'json',
	 		success:function(data){
	 			if(data.status.code=="10000"){
	 				$.ligerDialog.alert(data.status.msg, "提示信息", "success",function(){
						parent.reflushData();
				        parent.closeDialog();
				    });
				  }else{
					 $.ligerDialog.alert(data.status.msg, "提示信息", "error");
				 }
	 			
	 		}
	 	});
	}*/
	
}

//修改会员级别
function editGrade(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_members/gw_filterGrade_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "调整会员级别"});
		//parent.f_addTab("425","会员筛选",url);
	}
}

//积分清零
function clearCredit(){
	var rows = grid.getSelectedRows();
	var ids = "";
	for (var i = 0; i < rows.length; i++) {
		ids += (rows[i].id+",");
	}
	ids = ids.substring(0,ids.length-1);
	if(ids==null || ids.length==0){
		$.ligerDialog.warn("请选中数据后，再操作");
	}else{
		$.ligerDialog.confirm("确定清零选中积分数据?",function(yes){
			if(yes){
				$.ajax({
					url:'/members/updateCredits.do?ids='+ids+"&credit=0",
					method:'POST',
					dataType:'json',
					success:function(data){
						if(data.status.code=="10000"){
							$.ligerDialog.alert(data.status.msg, "提示信息", "success",function(){
						          reflushData();
						          closeDialog();
						       });
						}else{
							$.ligerDialog.alert(data.status.msg, "提示信息", "error");
							parent.closeDialog();
						}
					}
				});
			}
		});
	}
}

//修改单个积分
function editSingleCredit(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_members/gw_singleUpdateCredit.html?ids="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改积分"});
	}
}

//批量修改积分
function editCredit(){
	var rows = grid.getSelectedRows();
	var ids = "";
	for (var i = 0; i < rows.length; i++) {
		ids += (rows[i].id+",");
	}
	ids = ids.substring(0,ids.length-1);
	if(ids==null || ids.length==0){
		$.ligerDialog.warn("请选中数据后，再操作");
	}else{
		var url="/manager/gw_members/gw_batchUpdateCredit.html?ids="+ids;
		$.ligerDialog.open({ width:640, height: 300, url: url, isResize: false, title: "批量修改积分"});
	}
}
