var grid,

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
	_title = "功能管理|vip管理";
	$.fsh.createTitleAndFuncs(_title, menuId);
	
	//排序跳转至第一页
	$("div.l-grid-hd-cell-inner").click(function(){
		if(grid.options.page!=1) grid.changePage("first");
	});
});

function synchronizeMisData(){
//	$(".messageInfo").html("正在同步MIS数据到CRM系统，请耐心等待几分钟......");
	$("#synchronizeMisData").css('display','none');
	$("#sysMis").css('display','none');
	$("#sysMisGif").css('display','block');
	$.ajax({
		url:'/syschronizeMis/synchronizeMisData.do',
		type:'POST',
		success:function(data){
			if(data.status.code=="10000"){
//				$(".messageInfo").html("<span style='margin-left:120px;'>"+"同步MIS数据到CRM系统成功！"+"</span>");
				$.ligerDialog.alert("同步MIS数据到CRM系统成功！","提示信息","success");
				$("#synchronizeMisData").css('display','block');
				$("#sysMis").css('display','block');
				$("#sysMisGif").css('display','none');
			}else if((data.status.msg!="")&&(data.status.msg!=null)){
//				$(".messageInfo").html("<span style='margin-left:150px;'>"+data.status.msg+"</span>");
				$.ligerDialog.alert(data.status.msg,"提示信息","error");
				$("#synchronizeMisData").css('display','block');
				$("#sysMis").css('display','block');
				$("#sysMisGif").css('display','none');
			}else{
//				$(".messageInfo").html("<span style='margin-left:150px;'>"+"网络异常，请稍后再试！"+"</span>");
				$.ligerDialog.alert(data.status.msg,"提示信息","warn");
				$("#synchronizeMisData").css('display','block');
				$("#sysMis").css('display','block');
				$("#sysMisGif").css('display','none');
			}			
		}
	});
}