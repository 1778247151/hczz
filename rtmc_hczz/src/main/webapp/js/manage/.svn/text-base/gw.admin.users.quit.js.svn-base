var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址
	query_url = baseUrl+"adminUsers/getAdminUsersList.do",
	//table	columns
	columns = [
		{ display: '主键ID', hide:true,	name: 'id',width: 1},
		{ display: '账号', name: 'username' ,width: 120},
		{ display: '管理员姓名', name: 'name',width: 100},
		{ display: '性别', name: 'sex',width: 80},
		{ display: '角色名称', name: 'gwRoleName',width: 120},
		{ display: '职位', name: 'departmentPositionName',width: 120},
		{ display: '联系电话', name: 'phone',width: 120},
		{ display: 'qq', name: 'qq',width: 120},
		{ display: 'email', name: 'email',width: 120},
		{ display: '身份证', name: 'sfz',width: 150},
		{ display: '住址', name: 'address',width: 150},
		{ display: '创建人', name: 'createUserName',width: 100},
		{ display: '创建时间', name: 'createTime',width: 120},
		{ display: '更新人', name: 'updateUserName',width: 100},
		{ display: '更新时间', name: 'updateTime',width: 120},
		{ display: '状态', name: 'stateName',width: 100},
		{ display: '最后登录时间', name: 'dtime',width: 120}
	],

	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),//菜单id 
	_title="",
	
	//参数替换规则
	//只要涉及到跳转按钮， 都需要加此参数
	//"跳转按钮的ID": "过滤规则"
	paramReplace = {
		showDevice: "&userId=$userId$"
	};
	
//$(document).ready();
$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "系统管理|管理员用户管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "adminUsers/getAdminUsersList.do";
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

//离职操作
function quit(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var flag = $.ligerDialog.confirm( "确定修改为离职吗?",function(flag){
			if(flag){
				$.ajax({
					url:'/adminUsers/updateStateByid.do?id='+_flag.id,
					method:'post',
					type:'json',
					success:function(data){
						if(data.status.code=="10000"){
							  $.ligerDialog.alert(data.status.msg, "提示信息", "success",function(){	
								  reflushData();
							});
						 }else{
							 $.ligerDialog.alert(data.status.msg, "提示信息", "error",function(){
								
							 });
						 }
					}	
				}); 
			}
		});
	}
}

//根据条件查询用户
function getUserByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var name = data.name;	 
 	var sfz = data.sfz;
 	var state = data.state;
	dataUrl = baseUrl+"adminUsers/getAdminUsersByCondition.do?name="+name+'&sfz='+sfz+'&state='+state
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}

