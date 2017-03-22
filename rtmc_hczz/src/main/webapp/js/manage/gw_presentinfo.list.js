var grid,

//table	columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
       	{ display: '礼品编号', 			name: 'code', 			align: 'center',		width: "10%" },
       	{ display: '礼品名称', 		name: 'name', 			align: 'center',		width: "5%" },
    	{ display: '采购成本', 		name: 'price', 			align: 'center',		width: "5%" },
    	{ display: '状态', 		name: 'statusName', 			align: 'center',		width: "5%" },
    	{ display: '兑换积分', 		name: 'exchangeIntegral', 			align: 'center',		width: "6%" },
       	{ display: '生效日期', 		name: 'effectiveTime', 			align: 'center',	width: "8%" },
    	{ display: '失效日期', 		name: 'expiryTime', 			align: 'center',	width: "8%" },
    	{ display: '备注', 		name: 'description', 			align: 'center',	width: "16%" },
    	{ display: '物品图片地址', 		name: 'pictureImage', 			align: 'center',	width: "10%" },
    	{ display: '创建人', 		name: 'createUserName', 			align: 'center',	width: "7%" },
    	{ display: '创建时间', 		name: 'createTime', 			align: 'center',	width: "10%" },
    	{ display: '修改人', 		name: 'updateUserName', 			align: 'center',	width: "7%" },
    	{ display: '修改时间', 		name: 'updateTime', 			align: 'center',	width: "10%" },
       	
       ],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|物品维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "presentInfo/getPresentInfoByPageList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "orderNum", true);
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});
//刷新数据
function reflushData(){
grid.loadData();
}
//修改礼品信息
function editPresent(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	var url="/manager/gw_present_info/gw_presentinfo_edit.html?id="+_flag.id
	$.ligerDialog.open({ width:640, height: 600, url: url, isResize: false, title: "修改礼品信息"});
}

}
//添加租借物品信息
function addPresent(){
var url="/manager/gw_present_info/gw_presentinfo_add.html";
$.ligerDialog.open({ width:680, height: 560, url: url, isResize: false, title: "添加礼品信息"});
} 

//删除租借物品信息
function deletePresent(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag) {
	var url = baseUrl + "presentInfo/deletePresentInfoById.do?id=" +_flag.id+'&goodsCode='+_flag.code;
	$.fsh.deleteSelectedRow(url, grid,_flag.id);
}
}

//根据条件查询租借物品数据
function getPresentByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var code = data.code;	 
 	var name = data.name;
	dataUrl = baseUrl+"presentInfo/getPresentInfoByPageList.do?code="+code+'&name='+name
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}

