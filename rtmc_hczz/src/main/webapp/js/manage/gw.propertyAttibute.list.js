var grid,	//表格
windialog,	//查询框
dataUrl,	//url地址
query_url = baseUrl+"properAttibute/getProperAttribute.do",
//table	columns
columns = [
	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
	{ display: '物业性质编码', 			name: 'bm', 			align: 'center',		width: "10%" },
	{ display: '物业性质名称', 		name: 'name', 			align: 'center',	width: "10%" },
	{ display: '修改时间', 		name: 'time', 			align: 'center',	width: "10%" }
	
],
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";
//参数替换规则
//只要涉及到跳转按钮， 都需要加此参数
//"跳转按钮的ID": "过滤规则"
paramReplace = {
	showDevice: "&userId=$userId$"
};

//$(document).ready();
$(function (){	
	_title = "基础设置|物业性质管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
//$.fsh.isLogin();
//创建数据列表
dataUrl = baseUrl+"marketMisBase/getMisFoPropertyList.do";
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
function editProperAttribute(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	var url="/manager/gw_property_attribute/gw_property_attribute_edit.html?id="+_flag.id;
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改物业性质信息"});
}

}
//添加物业性质
function addProperAttribute(){
var url="/manager/gw_property_attribute/gw_property_attribute_add.html";
$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加物业性质"});
} 
//删除物业性质
function deleteProperAttribute(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag) {
	var url = baseUrl + "properAttibute/delesePropertyAttribute.do?id=" +_flag.id;
	$.fsh.deleteSelectedRow(url, grid,_flag.id);
}
}