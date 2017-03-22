var grid,

// table columns
columns = [
		{
			display : '主键ID',
			hide : true,
			name : 'id',
			align : 'left',
			width : "5%"
		},
		{
			display : '拾物编号',
			name : 'code',
			align : 'center',
			width : "10%"
		},
		{
			display : '领取状态',
			name : 'statusName',
			align : 'center',
			width : "7%",
			render : function(rowdata) {
				if (rowdata.status == 0) {
					return "<font class=\"daiconfirm\">" + rowdata.statusName
							+ "</font>";
				} else if (rowdata.status == 1) {
					return "<font class=\"passconfirm\">" + rowdata.statusName
							+ "</font>";
				}
				return "";
			}
		}, {
			display : '拾物名称',
			name : 'name',
			align : 'center',
			width : "8%"
		}, {
			display : '拾获人',
			name : 'pickupUser',
			align : 'center',
			width : "7%"
		}, {
			display : '拾获时间',
			name : 'pickupTime',
			align : 'center',
			width : "7%"
		}, {
			display : '联系电话',
			name : 'phone',
			align : 'center',
			width : "10%"
		}, {
			display : '图片地址',
			name : 'pickupImg',
			align : 'center',
			width : "10%"
		}, {
			display : '创建人',
			name : 'createUserName',
			align : 'center',
			width : "7%"
		}, {
			display : '创建时间',
			name : 'createTime',
			align : 'center',
			width : "10%"
		}, {
			display : '修改人',
			name : 'updateUserName',
			align : 'center',
			width : "7%"
		}, {
			display : '修改时间',
			name : 'updateTime',
			align : 'center',
			width : "10%"
		}

],
// 所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"), // 菜单id
_title = "";

$(function() {
	// $.fsh.isLogin();
	// 设置路径
	_title = "功能管理|拾物维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	// 创建数据列表
	dataUrl = baseUrl + "pickupMaintenance/getPickupMaintenanceByPageList.do";
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(),
			"orderNum", true);
	// 排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function() {
		if (grid.options.page != 1)
			grid.changePage("first");
	});
});
// 刷新数据
function reflushData() {
	grid.loadData();
}
// 修改拾物维护信息
function editPickupMaintenance() {
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if (_flag) {
		if(_flag.status==1){
			$.ligerDialog.warn("已领取的拾物不能修改");
			return;
		}
		var url = "/manager/gw_pickup_maintenance/gw_pickup_maintenance_edit.html?id="
				+ _flag.id;
		$.ligerDialog.open({
			width : 640,
			height : 520,
			url : url,
			isResize : false,
			title : "修改拾物维护信息"
		});
	}

}

//查阅拾物信息
function consultPickupMaintenance() {
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if (_flag) {
		var url = "/manager/gw_pickup_maintenance/gw_pickup_maintenance_consult.html?id="
				+ _flag.id;
		$.ligerDialog.open({
			width : 640,
			height : 520,
			url : url,
			isResize : false,
			title : "查阅拾物信息"
		});
	}

}
// 添加拾物维护信息
function addPickupMaintenance() {
	var url = "/manager/gw_pickup_maintenance/gw_pickup_maintenance_add.html";
	$.ligerDialog.open({
		width : 640,
		height : 520,
		url : url,
		isResize : false,
		title : "添加拾物维护信息"
	});
}

// 删除拾物维护信息
function deletePickupMaintenance() {
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if (_flag) {
		if (_flag.status == 0) {
			var url = baseUrl
					+ "pickupMaintenance/deletePickupMaintenance.do?id="
					+ _flag.id;
			$.fsh.deleteSelectedRow(url, grid, _flag.id);
		} else {
			$.ligerDialog.warn("已领取的拾物不能删除")
		}
	}
}
// 根据条件查询拾物维护数据
function getPickupMaintenanceByCondition() {
	var form = new liger.get("form2");
	var data = form.getData();
	var code = data.code;
	var name = data.name;
	var status = data.status;
	dataUrl = baseUrl
			+ "pickupMaintenance/getPickupMaintenanceByPageList.do?code="
			+ code + '&name=' + name + '&status=' + status
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
}