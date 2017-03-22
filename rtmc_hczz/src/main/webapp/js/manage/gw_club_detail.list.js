var grid,

//table	columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
       	{ display: '俱乐部编号', 		name: 'gwClubCode', 			align: 'center',		width: "10%" },
       	{ display: '类型', 		name: 'type', 			align: 'center',		width: "10%" },
       	{ display: '业态或店铺', 		name: 'typeCode', 			align: 'center',		width: "10%" },
       	{ display: '折扣比例', 		name: 'discountRate', 			align: 'center',		width: "10%" },
       	{ display: '兑换金额', 		name: 'exchangeMoney', 			align: 'center',		width: "10%" },
       	{ display: '积分数', 		name: 'integralNumber', 			align: 'center',		width: "10%" },
       ],
       
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "会员管理|俱乐部明细";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "clubDetail/getClubDetailList.do";
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

//修改
function updateClubDetail(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_club_detail/gw_club_detail_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:840, height: 650, url: url, isResize: false, title: "修改俱乐部明细信息"});
	}
}
//添加
function addClubDetail(){
var url="/manager/gw_club_detail/gw_club_detail_add.html";
$.ligerDialog.open({width:840, height: 600, url: url, isResize: false, title: "添加俱乐部明细信息"});
}
//删除
function deleteClubDetail(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url = baseUrl + "clubDetail/deleteClubDetailById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

//根据条件查询
function getClubDetailByCondition(){
var form = new liger.get("form2");
	var data= form.getData();
	var type= data.type;	 
	dataUrl = baseUrl+"clubDetail/getClubDetailList.do?type="+type
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}
