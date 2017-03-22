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
			display : '主键ID',
			hide : true,
			name : 'status',
			align : 'left',
			width : "5%"
		},
		{
			display : '报失编号',
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
		},
		{ display: '会员VIP号', name: 'cardCode',width:150,
			render:function(rowdata){
				if(rowdata.cardCode==""){
					return "<font class=\"columncolor_5\">非会员</font>";
				}else{
					return rowdata.cardCode;
				}
			}
		}, 
		{
			display : '报失人',
			name : 'loseUser',
			align : 'center',
			width : "7%"
		}, {
			display : '联系电话',
			name : 'phone',
			align : 'center',
			width : "10%"
		}, {
			display : '身份证号',
			name : 'idCard',
			align : 'center',
			width : "13%"
		}, {
			display : '性别',
			name : 'sexName',
			align : 'center',
			width : "5%"
		}, {
			display : '丢物名称',
			name : 'name',
			align : 'center',
			width : "10%"
		}, {
			display : '丢物描述',
			name : 'description',
			align : 'center',
			width : "20%"
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
	_title = "功能管理|报失维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	// 创建数据列表
	dataUrl = baseUrl + "loseMaintenance/getLostMaintenanceByPageList.do";
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
// 修改报失维护信息
function editLoseMaintenance() {
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if (_flag) {
		if (_flag.status == 1) {
			$.ligerDialog.warn("已领取的报失信息不能修改")
		} else {
			var url = "/manager/gw_lose_maintenance/gw_lose_maintenance_edit.html?id="
					+ _flag.id + '&code=' + _flag.code;
			parent.f_addTab("loseMaintenanceEdit", "修改报失维护信息", url);
		}
	}
}
// 查阅报失维护信息
function consultLoseMaintenance() {
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if (_flag) {
		var url = "/manager/gw_lose_maintenance/gw_lose_maintenance_consult.html?id="
				+ _flag.id + '&code=' + _flag.code;
		parent.f_addTab("loseMaintenanceEdit", "修改报失维护信息", url);
	}
}
// 添加报失维护信息
function addLoseMaintenance() {
	var url = "/manager/gw_lose_maintenance/gw_lose_maintenance_add.html";
	$.ligerDialog.open({
		width : 640,
		height : 590,
		url : url,
		isResize : false,
		title : "添加报失维护信息"
	});
}

// 删除报失维护信息
function deleteLoseMaintenance() {
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if (_flag) {
		if (_flag.status == 0) {
			var url = baseUrl + "loseMaintenance/deleteLoseMaintenance.do?id="
					+ _flag.id;
			$.fsh.deleteSelectedRow(url, grid, _flag.id);
		} else {
			$.ligerDialog.warn("已领取的报失信息不能删除")
		}
	}
}

// 根据条件查询报失维护数据
function getLoseMaintenanceByCondition() {
	var form = new liger.get("form2");
	var data = form.getData();
	var code = data.code;
	var name = data.name;
	var status = data.status;
	dataUrl = baseUrl + "loseMaintenance/getLostMaintenanceByPageList.do?code="
			+ code + '&name=' + name + '&status=' + status
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);
}