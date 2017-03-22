$(function(){
	//sysInfo
	var sysInfo = $.fsh.isLogin();
	showPage( sysInfo );
});

//显示页面信息
function showPage( sysInfo ){	
	var arr = ["sSysName", "sVersion", "sCopyRight", "sTel", "sDomain"];
	pushData( sysInfo, arr );
}

//添加数据
function pushData( data, arr ){
	for(var i=0, len=arr.length; i<len; i++){
		if(arr[i]=="sDomain"){
			$("#"+arr[i]).html("<a href=\""+data[arr[i]]+"/\" target=\"_blank\">"+data[arr[i]].replace("http:\/\/","")+"</a>");
		}else{
			$("#"+arr[i]).html( data[arr[i]] );
		}
	}
}