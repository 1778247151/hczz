var grid,	//表格
	windialog,	//查询框
	dataUrl,	//url地址

	//table	columns
	columns = [
		{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
		{ display: '单元号', 		name: 'unitNumber', 			align: 'center',	width: "10%" },
		{ display: '购物中心', 		name: 'mallInfoName', 			align: 'center',	width: "10%" },
		{ display: '状态', 		name: 'stateName', 			align: 'center',		width: "8%",
			render:function(rowdata){
   				if(rowdata.state==1){
   				return "<font class=\"notconfirm\">"+rowdata.stateName+"</font>";
   				}else if(rowdata.state==2){
   					return "<font class=\"columncolor_4\">"+rowdata.stateName+"</font>";
   				}else if(rowdata.state==3){
   					return "<font class=\"passconfirm\">"+rowdata.stateName+"</font>";
   				}
   				return "";
   			}
		},
		/*{ display: '合同号', 		name: 'contractCode', 			align: 'center',	width: "10%" },*/
		{ display: '楼宇', 			name: 'buildingTreeName', 			align: 'center',		width: "10%" },
		{ display: '单元描述', 		name: 'unitInfo', 			align: 'center',	width: "10%" },
		{ display: '物业性质', 		name: 'propertyAttributeName', 			align: 'center',	width: "8%" },
		{ display: '商铺面积(㎡)', 		name: 'area', 			align: 'center',	width: "8%",
			render:function(rowdata){
				return "<font>"+rowdata.area+"  m²"+"</font>";
			}
		},
		{ display: '商铺业态', 		name: 'formatsTreeName', 			align: 'center',	width: "6%"	},
		{ display: '创建时间', 		name: 'createTime', 			align: 'center',	width: "8%" },
		{ display: '创建用户', 		name: 'createUserName', 			align: 'center',	width: "8%" },
		{ display: '更新时间', 		name: 'updateTime', 			align: 'center',	width: "8%" },
		{ display: '更新用户', 		name: 'updateUserName', 			align: 'center',	width: "8%" }
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
	_title = "基础设置|单元管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
	dataUrl = baseUrl + "marketMisBase/getMisForShopsInfoList.do";
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

//修改单元信息
function editShopsInfo(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_shops_info/gw_shops_info_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改单元信息"});
	}
	
}
//添加单元信息
function addShopsInfo(){
	var url="/manager/gw_shops_info/gw_shops_info_add.html";
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加单元信息"});
}
//删除单元信息
function deleteShopsInfo(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	
	if(_flag) {
		if(_flag.state==1){
		var url = baseUrl + "shopsInfo/deleteShopsInfoById.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id)
		}else{
			$.ligerDialog.warn("已经锁定或者已出租的单元不能删除")
		}
	}
}
//根据条件查询商铺数据
function getShopsInfoByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var state = data.state;	 
 	var unitNumber = data.unitNumber;
	dataUrl = baseUrl+"shopsInfo/getShopsInfoPageList.do?state="+state+'&unitNumber='+unitNumber
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}


