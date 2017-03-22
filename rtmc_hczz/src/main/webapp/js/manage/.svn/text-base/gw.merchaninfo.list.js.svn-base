var grid,	//表格
windialog,	//查询框
dataUrl,	//url地址
query_url = baseUrl+"merchaninfo/getMerchanInfo.do",
//table	columns
columns = [
	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
	{ display: '商户编码', 			name: 'bm', 			align: 'center',		width: "10%" },
	{ display: '商户中文名称', 		name: 'cnName', 			align: 'center',	width: "10%" },
	{ display: '商户英文名称', 		name: 'enName', 			align: 'center',	width: "10%" },
	/*{ display: '购物中心', 		name: 'mallName', 			align: 'center',	width: "10%" },*/
	{ display: '品牌', 			name: 'brandName', 			align: 'center',		width: "10%" },
	{ display: '物业性质', 		name: 'proName', 			align: 'center',	width: "10%" },
	{ display: '商户性质', 		name: 'typename', 			align: 'center',	width: "10%" },
	{ display: '租户性质', 		name: 'ztypename', 			align: 'center',	width: "10%" },
	{ display: '地址', 		name: 'address', 			align: 'center',	width: "10%" },
	{ display: '联系电话', 		name: 'phone', 			align: 'center',	width: "10%" },
	{ display: '传真', 		name: 'fax', 			align: 'center',	width: "10%" },
	{ display: '修改时间', 		name: 'time', 			align: 'center',	width: "10%" },
	{ display: '业态', 		name: 'forName', 			align: 'center',	width: "10%" }
	
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
	_title = "基础设置|商户";
	$.fsh.createTitleAndFuncs(_title, menuId);
//创建数据列表
dataUrl = baseUrl+"marketMisBase/getMisFoMerchantsInfoList.do";
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

//修改物业性质信息
function editMerchantsInfo(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	var url="/manager/gw_merchants_info/gw_merchants_info_edit.html?id="+_flag.id;
	$.ligerDialog.open({ width:640, height: 560, url: url, isResize: false, title: "修改商户信息"});
}

}
//添加商户信息
function addMerchantsInfo(){
var url="/manager/gw_merchants_info/gw_merchants_info_add.html";
$.ligerDialog.open({ width:640, height: 560, url: url, isResize: false, title: "添加商户信息"});
} 
//删除商户信息
function deleteMerchanInfo(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag) {
	var url = baseUrl + "merchaninfo/deleMerchanInfo.do?id=" +_flag.id;
	$.fsh.deleteSelectedRow(url, grid,_flag.id);
}
}

//根据条件查询商铺数据
function getMerchantsInfoByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var merchantsInfoName = data.merchantsInfoName;	 
 	var merchantsInfoCode = data.merchantsInfoCode;
	dataUrl = baseUrl+"merchaninfo/getMerchanInfo.do?merchantsInfoName="+merchantsInfoName+'&merchantsInfoCode='+merchantsInfoCode
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}