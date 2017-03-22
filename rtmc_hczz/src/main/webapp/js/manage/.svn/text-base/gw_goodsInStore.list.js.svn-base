var grid,

//table	columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
       	{ display: '入库单号', 			name: 'code', 			align: 'center',		width: "12%" },
       	{ display: '状态', 			name: 'statusName', 			align: 'center',		width: "6%",
       		render:function(rowdata){
   				if(rowdata.status==0){
   				return "<font class=\"daiconfirm\">"+rowdata.statusName+"</font>";
   				}else if(rowdata.status==1){
   					return "<font class=\"passconfirm\">"+rowdata.statusName+"</font>";
   				}else if(rowdata.status==2){
   					return "<font class=\"notconfirm\">"+rowdata.statusName+"</font>";
   				}
   				return "";
   			}
       	},
     	{ display: '总金额', 		name: 'totalMoney', 			align: 'center',		width: "6%" },
       	{ display: '总数量', 		name: 'totalNumber', 			align: 'center',		width: "6%" },	
       	{ display: '备注', 		name: 'description', 			align: 'center',		width: "16%" },
       	{ display: '入库时间', 		name: 'inTime', 			align: 'center',		width: "8%" },
       	{ display: '创建人', 		name: 'createUserName', 			align: 'center',	width: "5%" },
       	{ display: '创建时间', 		name: 'createTime', 			align: 'center',	width: "10%" },
       	{ display: '修改人', 		name: 'updateUserName', 			align: 'center',	width: "5%" },
    	{ display: '修改时间', 		name: 'updateTime', 			align: 'center',	width: "10%" },
    	{ display: '审核意见', 		name: 'approveView', 			align: 'center',	width: "13%" },
    	{ display: '审核人', 		name: 'approveUserName', 			align: 'center',	width: "5%" },
    	{ display: '审核时间', 		name: 'approveTime', 			align: 'center',	width: "10%" },
  ],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|物品入库维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "goodsInfoStore/getGoodsInStoreByPageList.do";
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
//修改物品入库信息
function editGoodsInStore(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	if(_flag.status == 1){
		$.ligerDialog.warn("已确认的物品入库单不能修改")
	}else{
		var url="/manager/gw_goods_in_store/gw_goods_in_store_edit.html?id="+_flag.id+'&code='+_flag.code
		parent.f_addTab("goodsInStoreEdit","修改物品入库信息",url);
	}
	
}
	
}
//添加物品入库信息
function addGoodsInStore(){
var url="/manager/gw_goods_in_store/gw_goods_in_store_add.html";
parent.f_addTab("goodsInStoreAdd","添加物品入库信息",url);
} 

//删除物品入库单信息
function deleteGoodsInStore(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		if(_flag.status == 1){
			$.ligerDialog.warn("已确认的物品入库单不能删除")
		}else{
			var url = baseUrl + "goodsInfoStore/deleteGoodsInStoreById.do?id=" +_flag.id+'&goodsCode='+_flag.code;
			$.fsh.deleteSelectedRow(url, grid,_flag.id);
		}
		
	}
}
//查阅物品入库信息
function consultGoodsInStore(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
		var url="/manager/gw_goods_in_store/gw_goods_in_store_consult.html?id="+_flag.id+'&code='+_flag.code+'&status='+_flag.status+'&temp=1';
		parent.f_addTab("goodsInStoreConfirm","查阅物品入库信息",url);	
}
}

//根据条件查询物品入库数据
function getGoodsInStoreByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var code = data.code;	 
 	var inTime = data.inTime;
 	var status = data.status;
	dataUrl = baseUrl+"goodsInfoStore/getGoodsInStoreByPageList.do?code="+code+'&inTime='+inTime+'&status='+status
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}