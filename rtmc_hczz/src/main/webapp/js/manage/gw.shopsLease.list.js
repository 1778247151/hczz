var grid,

//table	columns
columns = [
   		{ display: '主键ID', hide:true,		name: 'id', 	align: 'left',	    width: "1%"},	
   		{ display: '商户ID', hide:true,		name: 'gwMerchantsInfoId', 	align: 'left',	    width: "7%"},		
   		{ display: '店铺名称', 		name: 'name', 			align: 'center',	width: "7%" },
   		{ display: '店铺编号', 		name: 'code', 			align: 'center',	width: "15%" },
   		{ display: '店铺状态', 		name: 'stateName', 	align: 'center',	width: "7%",
   			render:function(rowdata){
   				if(rowdata.state==1){
   				return "<font class=\"notconfirm\">正常</font>";
   				}else if(rowdata.state==2){
   					return "<font class=\"columncolor_4\">锁定</font>";
   				}else if(rowdata.state==3){
   					return "<font class=\"passconfirm\">已签约</font>";
   				}
   				return "";
   			}
   		},
   		/*{ display: '合同号', 		name: 'contractCode', 			align: 'center',	width: "10%" },*/
   		/*{ display: '商户名称', 		name: 'merchantsName', 	align: 'center',	width: "7%" },*/
   		{ display: '店铺类型', 		name: 'storetypeName', 	align: 'center',	width: "7%" },
   		{ display: '是否主力店铺', 	name: 'mainshopName', 	align: 'center',	width: "10%" },
   		{ display: '收银POS机数', 	name: 'posnum', 	    align: 'center',	width: "10%" },
   		{ display: '创建时间', 		name: 'createTime', 	align: 'center',	width: "10%" },
   		{ display: '创建用户', 		name: 'createUserName', align: 'center',	width: "7%" },
   		{ display: '修改时间', 		name: 'updateTime', 	align: 'center',	width: "10%" },
   		{ display: '修改用户', 		name: 'updateUserName', align: 'center',	width: "7%" }
   	],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|店铺管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "marketMisBase/getMisShopsLeaseByPageList.do";
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
//修改店铺信息
function editShopsLease(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_shops_lease/gw_shops_lease_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改店铺信息"});
	}
	
}
//添加店铺信息
function addShopLease(){
	var url="/manager/gw_shops_lease/gw_shops_lease_add.html";
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加店铺信息"});
}
//删除单元信息
function deleteShopLease(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		if(_flag.state==1){
		var url = baseUrl + "shoplease/deleteShopsLeaseById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
		}else{
			$.ligerDialog.warn("已经锁定和已经出租的店铺不能删除")
		}
	}
}

//根据条件查询商铺数据
function getShopsLeaseByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var shopsLeaseName = data.shopsLeaseName;	 
 	var merchantsInfoId = data.merchantsInfoId;
 	var shopsLeaseCode = data.shopsLeaseCode;
 	var state = data.state;
	dataUrl = baseUrl+"marketMisBase/getMisShopsLeaseByPageList.do?shopsLeaseName="+shopsLeaseName+'&merchantsInfoId='+merchantsInfoId+'&shopsLeaseCode='+shopsLeaseCode+'&state='+state
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}
//查阅店铺单元信息
function getShopsLeaseConsult(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_shops_lease/gw_shops_lease_consult.html?id="+_flag.id
		parent.removeTab("consultShopsLease");
		parent.f_addTab("consultShopsLease","查阅店铺单元信息",url);
		
	}
}
//查阅店铺货品信息
function getShopsLeaseConsultByGoodsInfo(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_shops_lease/gw_shops_lease_consultGoods.html?id="+_flag.id+'&code='+_flag.code
		parent.removeTab("consultShopsLease");
		parent.f_addTab("consultShopsLeaseGoods","查阅店铺货品信息",url);
		
	}
}
