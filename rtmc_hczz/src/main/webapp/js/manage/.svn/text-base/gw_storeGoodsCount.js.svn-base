var grid,

//table	columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
     	{ display: '仓库名称', 		name: 'storeName', 			align: 'center',		width: "8%",
       		render:function(rowdata){
       			return rowdata.storeName+"("+rowdata.storeCode+")"
       		}
     	},
     	{ display: '礼品名称', 		name: 'goodsName', 			align: 'center',		width: "8%" },
       	{ display: '礼品编号', 		name: 'goodsCode', 			align: 'center',		width: "12%" },	
       	
       	{ display: '数量', 		name: 'number', 			align: 'center',		width: "8%" },
  ],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|礼品入库维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "storeGoods/getStoreGoodsCountByPageList.do";
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

//根据条件查询礼品入库数据
function getStoreGoodsCountByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var storeCode = data.storeCode;	 
 	var goodsCode = data.goodsCode;
	dataUrl = baseUrl+"storeGoods/getStoreGoodsCountByPageList.do?storeCode="+storeCode+'&goodsCode='+goodsCode
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}