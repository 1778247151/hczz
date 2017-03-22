var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',width:'80'},
	{ display: '认证账号', name: 'account' ,width:'150'},
//	{ display: '令牌', name: 'token',width:'300'},
	{ display: '用户名称或公司名称', name: 'name',width:'200'},
	{ display: '手机号', name: 'phone',width:'120'},
	{ display: '注册类型', name: 'type',width:'120'},
	{ display: '描述', name: 'description',width:'200'},
	{ display: '最近登录时间', name: 'lastLoginTime',width:'150'},
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
	{ display: '创建时间', name: 'createTime',width:'150'},
	{ display: '创建人', name: 'createUserName',width:'150'},
	{ display: '更新时间', name: 'updateTime',width:'150'},
	{ display: '更新人', name: 'updateUserName',width:'150'}
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
	_title = "功能管理|基础积分规则管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "apiAccount/getApiAccountList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
	
});


//添加
function addApiAccount() {
	var url="/manager/gw_api_account/gw_api_account_add.html";
	$.ligerDialog.open({ width:680, height: 500, url: url, isResize: false, title: "添加账号认证信息"});
}

//删除
function deleteApiAccount(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "apiAccount/delApiAccount.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

//修改
function updateApiAccount(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_api_account/gw_api_account_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改账号认证信息"});
	}
}
