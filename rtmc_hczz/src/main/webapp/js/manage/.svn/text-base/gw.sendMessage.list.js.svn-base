var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id'},
	{ display: '会员等级编号', name: 'code' },
	{ display: '会员等级', name: 'name'},
	{ display: '描述', name: 'description'},
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
	{ display: '创建人', name: 'createUser'},
	{ display: '创建时间', name: 'createTime'},
	{ display: '更新人', name: 'updateUser'},
	{ display: '更新时间', name: 'updateTime'}
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
	_title = "功能管理|会员级别规则管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "membersIntegral/getMembersGradeManageList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true,true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});


function sendALL() {
	var url="/manager/gw_sendMessage/gw_sendALL.html";
	parent.f_addTab("sendALL","发送所有会员",url);
}

function sendByGrade() {
	var rows = grid.getSelectedRows();
	var grades = new Array();
	for (var i = 0; i < rows.length; i++) {
		grades.push(rows[i].code);
	}
	if(grades.length==0){
		$.ligerDialog.warn("请选中数据后，再操作");
	}else{
		var url="/manager/gw_sendMessage/gw_sendByGrade.html?grades="+grades;
		parent.f_addTab("sendByGrade","按会员等级发送",url); 
	}
}

function sendByNumber() {
	var url="/manager/gw_sendMessage/gw_sendByNumber.html";
	parent.f_addTab("sendByNumber","输入手机号发送",url);
}
