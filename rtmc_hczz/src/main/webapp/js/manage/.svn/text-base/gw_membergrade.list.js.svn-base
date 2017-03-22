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
			display : '会员等级编号',
			name : 'code',
			align : 'center',
			width : "10%"
		},
		{
			display : '会员等级名称',
			name : 'memberGradeName',
			align : 'center',
			width : "10%"
		},
		{
			display : '是否永久',
			name : 'isFoveverName',
			align : 'center',
			width : "5%"
		},
		{
			display : '生效日期',
			name : 'effectiveTime',
			align : 'center',
			width : "10%"
		},
		{
			display : '失效日期',
			name : 'expiryTime',
			align : 'center',
			width : "10%"
		},
//		{
//			display : '排序',
//			name : 'orderNum',
//			align : 'center',
//			width : "5%"
//		},
//		{
//			display : '折扣比例',
//			name : 'discount',
//			align : 'center',
//			width : "5%"
//		},
		{
			display : '兑换比例',
			name : 'expiryTime',
			align : 'center',
			width : "11%",
			render : function(rowdata) {
				return rowdata.exchangeMoney + " 金额兑换 "
						+ rowdata.exchageIntegral + " 积分"
			}
		}, 
		{
			display : '备注',
			name : 'description',
			align : 'center',
			width : "15%"
		},
		{
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
		},

],
// 所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"), // 菜单id
_title = "";

$(function() {
	// $.fsh.isLogin();
	// 设置路径
	_title = "功能管理|会员等级设置维护";
	$.fsh.createTitleAndFuncs(_title, menuId);
	// 创建数据列表
	dataUrl = baseUrl + "memberGrade/getMemberGradeByPageList.do";
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
// 修改物品信息
function editMemberGrade() {
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if (_flag) {
		var url = "/manager/gw_member_grade/gw_member_grade_edit.html?id="
				+ _flag.id + '&code=' + _flag.code;
		parent.f_addTab("editMemberGrade", "修改会员等级设置", url);
	}

}
//查阅信息
function consultMemberGrade() {
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if (_flag) {
		var url = "/manager/gw_member_grade/gw_member_grade_consult.html?id="
				+ _flag.id + '&code=' + _flag.code;
		parent.f_addTab("consultMemberGrade", "查阅会员等级", url);
	}
}

// 添加会员等设置信息
function addMemberGrade() {
	var url = "/manager/gw_member_grade/gw_member_grade_add.html?code=1";
	parent.f_addTab("addMemberGrade", "添加会员等级设置", url);
}

// 删除租借物品信息
function deleteGoods() {
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if (_flag) {
		var url = baseUrl + "gwLeaseGoods/deleteGoodsById.do?id=" + _flag.id
				+ '&goodsCode=' + _flag.code;
		$.fsh.deleteSelectedRow(url, grid, _flag.id);
	}
}

//根据条件查询会员等级设置数据
function getMemberGradeByCondition(){
	var form = new liger.get("form2");
 	var data= form.getData();
 	var isFovever = data.isFovever;
	var code = data.code;
	var startTime = data.startTime;
	var endTime = data.endTime;
 	if(startTime!=""&&endTime!="")
 	{
		if(endTime<startTime+1){
			$.ligerDialog.warn("结束时间必须大于开始时间");
			return;
	 	}
	}
 	dataUrl = baseUrl+"memberGrade/getMemberGradeByPageList.do?isFovever="+isFovever+'&startTime='+startTime+'&code='+code+'&endTime='+endTime
	grid = $.fsh.createTable(columns, dataUrl, $.fsh.options.page(), "", true);	
}
