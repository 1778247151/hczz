var grid,	//表格
	//table	columns
	columns = [
		{ display: '参数名称', 		name: 'SParamName', 	align: 'left',		width: "15%" },
		{ display: '参数类型', 		name: 'NDataType', 		align: 'center',	width: "10%" },
		{ display: '参数值', 			name: 'SValue', 		align: 'left',		width: "35%" },
		{ display: '参数说明', 		name: 'SParamRemark', 	align: 'left',		width: "40%" }
	],
	//从url地址获取userid
	query_url = baseUrl + "monPramas.shtml",
	
	//从url地址获取userid
	//所有页面都要获取这两个变量
	menuId = $.fsh.requestParam("menuId"),//菜单id
	
//$(document).ready();
$(function (){
	//判断是否登陆
	$.fsh.isLogin();
	//创建头部信息（路径，按钮等）
	$.fsh.createTitleAndFuncs("系统管理|参数管理", menuId);
	//create table
	var dataUrl = query_url + "?method=search";
	grid = $.fsh.createTable( columns, dataUrl, $.fsh.options.page(), "SParamName", true);
});

//修改
function update_param(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！"),
		d, _class, _grid;
	if( _flag ) {
		//查询弹出框参数
		var formParam =  {
			title: "修改参数",
			formaction: query_url + "?method=modify",
			methodtype: "post",
			filds: [
				{display: "参数名称", input: [{type: "text", name: "sParamName", id:"SParamName", readOnly:true}]},
				{display: "参数类型", input: [
				   {type: "select", name: "nDataType", id:"NDataType", opt: [
					  {display:"字符型", p_val: "1"},
					  {display:"数字型", p_val: "0"}
				   ]}
				]},
				{display: "参数值", input: [{type: "text", name: "sValue", id:"SValue", validate: "length1_256||", isvalidate: true, light: true}]},
				{display: "参数说明", input: [{type: "text", name: "sParamRemark", id:"SParamRemark"}]}
			],
			button: [
				{btype: "submit", val: "保存", handler: "submit", funs: function(){grid.loadData();}}
			]
		};
		_grid = $.fsh.createForm(formParam);
		//加载数据至表单
		d = $.fsh.getAjaxData( query_url + "?method=getModify&sParamName="+ _flag.SParamName );
		_class = _grid.source.divClass;
		$.fsh.addDataToForm("div."+_class+" input, div."+_class+" select", d);
	}
}