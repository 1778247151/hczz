<%@ page language="java" import="java.util.*,com.wenhao.sso.client.filter.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%-- <%response.setContentType("application/msword;charset=UTF-8");
     
    response.setHeader("Content-Disposition","attachment;filename=test.doc");    //用word打开页面
%> --%>

<!--

//-->

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>案件信息</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link href="/js/ligerui/lib/ligerUI/skins/Aqua/css/ligerui-all.css"rel="stylesheet" type="text/css" />
<script src="/js/ligerui/lib/jquery/jquery-1.9.0.min.js"type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/core/base.js"type="text/javascript"></script>
     <style type="text/css">
body{
	text-align:center;
	margin-left:auto;
	margin-right:auto;
}

              </style>
</head>
<body>

<div id="dy">
<div>
<img src="../images/demo1.png">
</div>
<div>
<img src="../images/demo.png">
</div>
</div>
<embed pluginspage="http://www.macromedia.com/go/getflashplayer"  menu="true" loop="true" play="true" type="application/x-shockwave-flash" width="50%" height="450px" src="http://player.youku.com/player.php/sid/XMjI0MDIwNDc2/v.swf"></embed>


<input type="button" onclick="return PrintTable(dy)" value="打 印">

</body>
<script language="javascript"> 
function PrintTable(Id){ 
/* 	urlinfo=window.location.href; //获取当前页面的url 
	len=urlinfo.length;//获取url的长度 
	offset=urlinfo.indexOf("?");//设置参数字符串开始的位置 
	newsidinfo=urlinfo.substr(offset,len)//取出参数字符串 这里会获得类似“id=1”这样的字符串 
	newsids=newsidinfo.split("=");//对获得的参数字符串按照“=”进行分割 
	newsid=newsids[1];//得到参数值 
	alert("您要传递的参数值是"+newsid);  */
var mStr; 
mStr = window.document.body.innerHTML ; 
var mWindow = window; 
window.document.body.innerHTML =Id.innerHTML; 
mWindow.print(); 
window.document.body.innerHTML = mStr; 
} 
</script> 
</html>