var grid,

// table columns
columns = [
       	{ display: '主键ID', hide:true,		name: 'id', 			align: 'left',		width: "5%"},
       	{ display: '名称', 			name: 'goodsName', 			align: 'center',		width: "10%" },
       	{ display: '编号', 			name: 'code', 			align: 'center',		width: "10%" },
       	{ display: '标题', 			name: 'title', 			align: 'center',		width: "10%" },
       	{ display: '礼品已兑换数量', 			name: 'exchageMemberNum', 			align: 'center', type:"int",		width: "10%" },
       	{ display: '总数量', 		name: 'goodsNumber', 			align: 'center',		width: "5%" },
    	{ display: '可兑换数量', 			align: 'center',		width: "7%",type:"int",
    		render:function(rowdata){
    			if(rowdata.goodsNumber - rowdata.exchageMemberNum>0){
    				return rowdata.goodsNumber - rowdata.exchageMemberNum;
    			}else{
    				return "0";
    			}
    			
    		}
    	},
       	{ display: '状态', 		name: 'statusName', 			align: 'center',	width: "5%",
       		render:function(rowdata){
    			if(rowdata.status==1){			
    				return "<font class=\"notconfirm\">"+rowdata.statusName+"</font>";
    			}else if(rowdata.status==3){
    				return "<font class=\"passconfirm\">"+rowdata.statusName+"</font>";
    			}else if(rowdata.status==0){
    				return "<font class=\"daiconfirm\">"+rowdata.statusName+"</font>";
    			}else if(rowdata.status==2){
    				return "<font class=\"columncolor_4\">"+rowdata.statusName+"</font>";
    			}else if(rowdata.status==4){
    				return "<font class=\"notconfirm\">"+rowdata.statusName+"</font>";
    			}else if(rowdata.status==5){
    				return "<font class=\"daiconfirm\">"+rowdata.statusName+"</font>";
    			}
    			return "";
    		}
       	},
       	{ display: '活动所需积分', 		name: 'integralNumber', 			align: 'center',		width: "6%" },
       	{ display: '开始时间', 		name: 'startTime', 			align: 'center',	width: "8%" },
    	{ display: '结束时间', 		name: 'endTime', 			align: 'center',	width: "8%" },
    	{ display: '创建人', 		name: 'createUserName', 			align: 'center',	width: "7%" },
    	{ display: '创建时间', 		name: 'createTime', 			align: 'center',	width: "10%" },
    	{ display: '修改人', 		name: 'updateUserName', 			align: 'center',	width: "7%" },
    	{ display: '修改时间', 		name: 'updateTime', 			align: 'center',	width: "10%" },
       	
       ],
// 所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),// 菜单id
_title="";

$(function (){	
	// $.fsh.isLogin();
	// 设置路径
	_title = "功能管理|积分兑换礼品活动规则";
	$.fsh.createTitleAndFuncs(_title, menuId);
	// 创建数据列表
	dataUrl = baseUrl + "integralExchangeGoods/getIntegralExchangeGoodsByPageList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "orderNum", true);
	// 排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});
// 刷新数据
function reflushData(){
grid.loadData();
}
// 修改积分兑换礼品规则信息
function editIntegralExchangeGoods(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
if(_flag){
	if(_flag.status==0|| _flag.status==2||_flag.status==3 || _flag.status==4 || _flag.status==5){
		$.ligerDialog.warn("此状态不能修改")
	}else{
		var url="/manager/gw_integralexchange_goods/gw_integralExchangeGoods_edit.html?id="+_flag.id
		$.ligerDialog.open({ width:680, height: 500, url: url, isResize: false, title: "修改积分兑换礼品活动规则信息"});
	}
	
}

}
// 查阅
function consultGift(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
			 var url="/manager/gw_integralexchange_goods/gw_integralExchangeGoods_consult.html?id="+_flag.id+"&code="+_flag.code;
			 parent.f_addTab("308","查阅积分兑换礼品信息",url);
		}
	}


// 礼品兑换
function exchangeGift(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		$.ajax({
			url:'/integralExchangeGoods/getIntegralExchangeGoodsById.do?id='+_flag.id,
			method:'POST',
			dataType:'json',
			success:function(data){
			 if(data.status.code=="10000"){
				 if(data.data.status==3){
					 var url="/manager/gw_integralexchange_goods/gw_integralExchangeGift.html?id="+_flag.id+"&code="+_flag.code;
					 parent.f_addTab("308","积分兑换礼品",url);
				 }else{
					 $.ligerDialog.warn("活动未开始，不能兑换礼品");
				 }
			  }else{
				 $.ligerDialog.alert(data.status.msg, "提示信息", "error");
			 }
			}
		});
	}
}

// 添加积分兑换礼品规则信息
function addIntegralExchangeGoods(){
var url="/manager/gw_integralexchange_goods/gw_integralExchangeGoods_add.html";
$.ligerDialog.open({ width:680, height: 500, url: url, isResize: false, title: "添加积分兑换礼品活动规则信息"});
} 

// 删除积分兑换礼品信息
function deleteIntegralExchangeGoods(){
var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
var code=_flag.code;
if(_flag) {
	if(_flag.status==3 || _flag.status==4 || _flag.status==5){
		$.ligerDialog.warn("此状态不能删除")
	}else{
		var url ="/integralExchangeGoods/deleteIntegralExchangeGoodsById.do?id=" +_flag.id+"&code="+code;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);	
	}	
}
}
// 禁用积分兑换礼品信息
function disabledIntegralExchangeGoods(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		if(_flag.status==3 || _flag.status==4 || _flag.status==5){
			$.ligerDialog.warn("活动已开始不能禁用")
		}else if(_flag.status==0){
			$.ligerDialog.warn("此活动已被禁用")
		}else{
			var url ="/integralExchangeGoods/updateStatusById.do?id=" +_flag.id+'&disableStatus=0';
			$.fsh.disableSelectedRow(url, grid,_flag.id);	
		}	
	}
}

// 开始此活动
function startThisActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var startTime = $.date.getTimestamp(_flag.startTime);
		var newStartTime = $.date.getTimestamp($.date.formatDate(new Date(),"-"));
		var endTime = $.date.getTimestamp(_flag.endTime);
		var flag = _flag.status;
		if(newStartTime<startTime){
			$.ligerDialog.warn("开始时间未到不能开始此规则")
		}else if(newStartTime>endTime){
			$.ligerDialog.warn("活动时间已过不能开始此规则")
		}else if(flag==0 || flag==3 || flag==4 || flag==5){
			$.ligerDialog.warn("此条活动的状态的不能进行开始活动操作")
		}else{
			var url ="/integralExchangeGoods/updateStatusById.do?id=" +_flag.id+'&startStatus=3';
			$.fsh.startThisActivitySelectedRow(url, grid,_flag.id);	
		}	
	}
}

// 强制终止此活动
function stopThisActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		if(_flag.status==0 || _flag.status==1 || _flag.status == 2){
			$.ligerDialog.warn("活动未开始不能进行强制终止操作")
		}else if(_flag.status==5){
			$.ligerDialog.warn("此活动已被强制终止")
		}else{
			var url ="/integralExchangeGoods/updateStatusById.do?id=" +_flag.id+'&stopStatus=5';
			$.fsh.stopThisActivity(url, grid,_flag.id);	
		}
	}
}

// 启用该活动
function enableThisActivity(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		if(_flag.status!=0){
			$.ligerDialog.warn("此条活动的状态不能进行启用操作")
		}else{
			var url ="/integralExchangeGoods/updateStatusById.do?id=" +_flag.id+'&enableStatus=1';
			$.fsh.enbleThisActivity(url, grid,_flag.id);	
		}
	}
}

// 根据条件查询礼品入库数据
function getIntegralExchangeGoodsByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var status = data.status;	 
 	var goodsCode = data.goodsCode;
 	var startTime = data.startTime;
 	var endTime = data.endTime;
 	if(startTime!=""&&endTime!="")
	{
		if(endTime<startTime){
			$.ligerDialog.warn("结束时间不能小于开始时间");
			return;
	 	}
	}
	dataUrl = baseUrl+"integralExchangeGoods/getIntegralExchangeGoodsByPageList.do?status="+status+'&goodsCode='+goodsCode+'&startTime='+startTime+'&endTime='+endTime
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}
