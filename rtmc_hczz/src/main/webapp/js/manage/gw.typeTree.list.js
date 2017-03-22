var grid,

//table	columns
columns = [
	{ display: '主键ID', hide:true,	name: 'id',editor: { type: 'int' }},
	{ display: '类型名称', name: 'name',id:"tree_name",width:200,align:'left'},
	{ display: '类型编号', name: 'code',editor: { type: 'text' }},
	{ display: '描述', name: 'description',editor: { type: 'text' }},
	/*{ display: '创建人', name: 'createUser',editor: { type: 'text' }},
	{ display: '创建时间', name: 'createTime',editor: { type: 'text' }},
	{ display: '更新人', name: 'updateUser',editor: { type: 'text' }},
	{ display: '更新时间', name: 'updateTime',editor: { type: 'text' }},*/
	{ display: '排序', name: 'orderNum',editor: { type: 'text' }},
	{ display: '状态', name: 'statusName',editor: { type: 'text' }},
	{ display: '功能', render: function (rowdata, rowindex, value)
        {
			var id = grid.getRow(rowindex).id;
	        var h = "";
	        if(id!=-1){
	        	if (!rowdata._editing)
	        	{
	        		//h += "<a href='javascript:beginEdit(" + rowindex + ")'>修改</a> ";
	        		h += "<a href='javascript:addRow(" + rowindex + ")'>添加</a> ";
	        		h += "<a href='javascript:updateRow(" + rowindex + ")'>修改</a> ";
	        		h += "<a href='javascript:deleteRow(" + rowindex + ")'>删除</a> "; 
	        	}
	        	else
	        	{
	        		h += "<a href='javascript:endEdit(" + rowindex + ")'>提交</a> ";
	        		h += "<a href='javascript:cancelEdit(" + rowindex + ")'>取消</a> "; 
	        	}
	        }else{
	        	h += "<a href='javascript:addRow(" + rowindex + ")'>添加</a> ";
	        }
	        return h;
        }
	}
],
//所有页面都要获取这两个变量
menuId = $.fsh.requestParam("menuId"),//菜单id 
_title="";

//刷新数据
function reflushData(){
	grid.loadData();
}

//关闭模态窗体
function closeDialog(){
	//$(".l-dialog,.l-window-mask").remove(); 
	$(".l-dialog,.l-window-mask").css("display","none");
    $.ligerDialog.close();    
}

$(function (){	
	//$.fsh.isLogin();
	//设置路径
	_title = "功能管理|维度管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	//创建数据列表
//	dataUrl = baseUrl + "typetree/getRootTypeTree.do";
	dataUrl = baseUrl + "typetree/getAllTypeTree.do";
	
	var container = "body";
	var dom = "userDataList";
	$(container).append("<div id='"+dom+"' style='margin-left:4px; margin-top:23px; float:left;'></div>");
	dataDom = $("div#"+dom);
	grid = dataDom.ligerGrid({
         columns: columns, width: '100%',height: '97%',pageSizeOptions: [5, 10, 15, 20],
         url:dataUrl, alternatingRow: true,root:'rows',
		 record:'total', sortName: "orderNum",
		 tree: { 
			 columnId: 'tree_name'
		 },
		 usePager:false,isScroll:false
         //checkbox:true,enabledEdit: false,clickToEdit:false, isScroll: false,
        /* onBeforeShowData: function ()
         {
        	 //加载数据前
         },
         onTreeCollapse: function (data,e){
        	 loadChildData(data,e);
         },
         onTreeExpand: function (data,e)
         {
        	 loadChildData(data,e);
         }*/
     });
	
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

/**
 * 加载子节点数据
 * @param data
 */
function loadChildData(data,e){
	 var pId = data.id;
	 if (!data.loaded && pId!=0){
		 var cData = [];
		 $.ajax({
    		 url:baseUrl+'typetree/getTypeTreeByPid.do?pId='+pId,
    		 method:'POST',
    		 async:false,
    		 dataType:'json',  
    		 success:function(data){
    			 cData = data.rows;
    		 }
    	 }); 
    	 grid.append(cData, data);
    	 e.update();
    	 data.loaded = true;
     }
}

function beginEdit(rowid) { 
    grid.beginEdit(rowid);
}
function cancelEdit(rowid) { 
	grid.cancelEdit(rowid);
}
function endEdit(rowid)
{
	var row = grid.getRow(rowid);
	grid.endEdit(rowid);
}


function addRow(rowid) { 
	var id = grid.getRow(rowid).id;
	var url="/manager/gw_typeTree/gw_typeTree_add.html?id="+id;
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加子节点"});
}
function updateRow(rowid) { 
	var id = grid.getRow(rowid).id;
	var url="/manager/gw_typeTree/gw_typeTree_edit.html?id="+id;
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改类型树"});
}

function deleteRow(rowid)
{
	var row = grid.getRow(rowid);
	var id = row.id;
	var flag = true;
	$.ligerDialog.confirm("确定要删除数据？", function( r ){
		if(r){
			var url = baseUrl + "typetree/delTypeTree.do?id=" +id;
			var re_info = $.fsh.getAjaxData(url);
			if(re_info.status.code="10000"){
				grid.deleteRow(rowid);
				$.ligerDialog.success(re_info.status.msg+"!");
			}else{
				$.ligerDialog.error(re_info.status.msg+"!");
				flag = false;
			}
		}
	});
	return flag;
}

function addTypeTree() {
	var url="/manager/gw_typeTree/gw_typeTree_add.html";
	$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "添加类型树"});
}

function delTypeTree(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag) {
		var url = baseUrl + "typeTree/delTypeTree.do?id=" +_flag.id;
		$.fsh.deleteSelectedRow(url, grid,_flag.id);
	}
}

function updateTypeTree(){
	var _flag = $.fsh.noteForNotSelected("请选中数据后，再操作！");
	if(_flag){
		var url="/manager/gw_typeTree/gw_typeTree_edit.html?id="+_flag.id;
		$.ligerDialog.open({ width:640, height: 500, url: url, isResize: false, title: "修改类型树"});
	}
}
