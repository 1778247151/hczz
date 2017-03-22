var grid,

//table	columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
       	{ display: '俱乐部编号', 		name: 'code', 			align: 'center',		width: "10%" },
       	{ display: '描述', 		name: 'description', 			align: 'center',	width: "20%" },
       	{ display: '生效日期', 		name: 'startDate', 			align: 'center',	width: "8%" },
       	{ display: '加入标准（元）', 		name: 'entryCriteria', 			align: 'center',	width: "8%" },
       	{ display: '备注', 		name: 'note', 			align: 'center',		width: "20%" },
    	{ display: '创建人', 		name: 'createUserName', 			align: 'center',	width: "5%" },
    	{ display: '创建时间', 		    name: 'createTime', 			align: 'center',	width: "8%" },
    	{ display: '更新人', 		    name: 'updateUserName', 			align: 'center',	width: "5%" },
    	{ display: '更新时间', 		name: 'updateTime', 			align: 'center',	width: "8%" }
       ],
       
       
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "会员管理|俱乐部维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "club/getClubList.do";
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
function updateClub(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_club/gw_club_edit.html?id="+_flag.id;
		parent.f_addTab("updateClub", "修改俱乐部信息", url);
	}
}
//添加
function addClub(){
	var url="/manager/gw_club/gw_club_add.html";
	parent.f_addTab("addClub", "添加俱乐部信息", url);
}
//删除
function deleteClub(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url = baseUrl + "club/deleteClubById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

//根据条件查询
function getClubByCondition(){
var form = new liger.get("form2");
	var data= form.getData();
	var code= data.code;	 
	var description= data.description;	 
	var startDate= data.startDate;	 
	dataUrl = baseUrl+"club/getClubList.do?code="+code+'&startDate='+startDate+'&description='+description
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}
