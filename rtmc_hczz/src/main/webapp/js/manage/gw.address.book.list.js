var grid,

//table	columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
       	{ display: '姓名', 		name: 'name', 			align: 'center',		width: "5%" },
       	{ display: '手机号', 		name: 'phone', 			align: 'center',		width: "6%" },
       	{ display: '固定电话', 		name: 'fixedPhone', 			align: 'center',	width: "5%" },
    	{ display: '分机号', 		name: 'suffixPhone', 			align: 'center',	width: "5%" },
    	{ display: '性别', name: 'sexName',width:100},
       	{ display: '部门名称', 		name: 'departmentName', 			align: 'center',	width: "8%" },
    	{ display: '邮箱号', 		name: 'email', 			align: 'center',	width: "8%" },
    	{ display: 'QQ号', 		name: 'qq', 			align: 'center',	width: "5%" },
    	{ display: '创建人', 		name: 'createUserName', 			align: 'center',	width: "5%" },
    	{ display: '创建时间', 		    name: 'createTime', 			align: 'center',	width: "5%" },
    	{ display: '更新人', 		    name: 'updateUserName', 			align: 'center',	width: "5%" },
    	{ display: '更新时间', 		name: 'updateTime', 			align: 'center',	width: "7%" }
    	
       ],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "客服中心|通讯录维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "addressBook/getAddressBookList.do";
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

//修改通讯录信息
function editAddressBook(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_address_book/gw_address_book_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:840, height: 650, url: url, isResize: false, title: "修改业主信息"});
	}
}
//添加通讯录信息
function addAddressBook(){
var url="/manager/gw_address_book/gw_address_book_add.html";
$.ligerDialog.open({width:840, height: 600, url: url, isResize: false, title: "添加业主信息"});
}
//删除通讯录信息
function deleteAddressBook(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url = baseUrl + "addressBook/deleteAddressBookById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}
//根据条件查询通讯录信息
function getAddressBookByCondition(){
var form = new liger.get("form2");
	var data= form.getData();
	var name = data.name;	 
	var phone = data.phone;	 
	var departmentCode = data.departmentCode;	 
	dataUrl = baseUrl+"addressBook/getAddressBookList.do?departmentCode="+departmentCode+'&name='+name+'&phone='+phone
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}
