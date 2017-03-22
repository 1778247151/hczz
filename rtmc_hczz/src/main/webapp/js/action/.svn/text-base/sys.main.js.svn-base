$(function(){
	//sysInfo
	//var sysInfo = $.fsh.isLogin();
	//showPage( sysInfo );
});

//显示帮助信息
function showHelp(){
	$.ligerDialog.open({ width:400, height: 190, url: "help.html", title: "关于"});
}

//退出系统
function exit() {
	$.ligerDialog.confirm("确定要退出系统？", function(r){
		if(r){
			var exitData = $.fsh.getAjaxData($.fsh.options.sysUrl + "loginOut.shtml");
			if(exitData.success){
				top.location.href=$.fsh.options.sysUrl + "index.jsp";
			}	
		}											
	});
}

//显示页面信息
function showPage( sysInfo ){
	//layOut
	$("#frameLayOut").ligerLayout({ leftWidth: 210, heightDiff:-31, space:4});
	
	//tree
	
	$("#treeList").ligerTree({
		data: $.fsh.getAjaxData($.fsh.options.sysUrl + "leftMenu.shtml") ,
		checkbox: false,
		btnClickToToggleOnly :false,
		nodeWidth: 135,
		onSelect : function( node ){
			var url = node.data.url;
			if(url!=undefined){
				$("#rightContents").attr("src", url);
			}
		}
	}).expandAll();
	
	//size setting
	var mainInit = function(){
		var $laymode = $("#framecenter");
			layHeight = $laymode.height(),
			layWidth = $laymode.width();
		$("#frameLeft").height(layHeight-26);
		$("#rightContents").width(layWidth).height(layHeight);
	};	
	
	mainInit();
	
	$(window).resize(function(){ mainInit(); });
	var _flag_ = false;
	$(".l-layout-drophandle-left").mousedown(function(){
		_flag_ = true;
	}).mousemove(function(){
		if(_flag_){ mainInit(); }	
	}).mouseup(function(){_flag_ = false});
	
	$(".l-layout-header-toggle, .l-layout-collapse-left-toggle").click(function(){ mainInit(); });
	
	$("b#sysInfo_userID").html(sysInfo.userId);
	$("b#sysInfo_userName").html(sysInfo.userName);
	//print time
	$("#printTime").html($.fsh.printTime());
	
	document.title = sysInfo.sSysName;
	$("div.binfoCopyright").html(sysInfo.sCopyRight);
}



























