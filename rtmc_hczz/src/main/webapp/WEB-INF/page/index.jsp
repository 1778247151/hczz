<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MIS信息管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	
	<!-- dialog -->
	<link type="text/css" rel="stylesheet" href="/plugins/ligerUi/css/ligerui-dialog.css" />
	<script type="text/javascript" src="/plugins/ligerUi/js/ligerUi.min.js"></script>

    <!-- validate -->
    <link rel="stylesheet" href="/plugins/jqueryValidation/css/validationEngine.jquery.css" />
    <script src="/plugins/jqueryValidation/js/jquery.validationEngine.js"></script> 
    <script src="/plugins/jqueryValidation/js/jquery.validationEngine-zh_CN.js"></script> 
    <script src="/plugins/jqueryValidation/js/jquery.validationEngine-addMethod.js"></script> 
<script type="text/javascript">
	
$(function(){
	
	
	getRandom();
	//session过期窗体处理
	if (window != top) {top.location.href = location.href; }
	      
    $(".login").css({ 
        //left: ($(window).width() - $(".login").outerWidth())/2, 
        top: ($(window).height() - $(".login").outerHeight())/2 
    });  
   
    if($("#username").val().length==0){
    	$("#username").focus();
    }
    
    
    //回车事件
    document.onkeydown = function(e){
        if(!e) e = window.event;//火狐中是 window.event
        if((e.keyCode || e.which) == 13){
            login();
        }
    },
    
    //验证表单
	$('#loginForm').validationEngine('attach', { 
        promptPosition: 'centerRight', 
        scroll: false ,
        validationEventTriggers:"onChange",  
        //校验只显示一个错误提示 
        //maxErrorsPerField: 1,
        //显示校验的记录数
        showOneMessage: true,
        //去掉提示边框和背景颜色
        //addPromptClass: 'formError-noArrow formError-text',
        custom_error_messages: {
          '#username': {
              'required': {
                   'message': '* 用户名，长度为1-31位!'
               }
          },
          '#pwd': {
              'required': {
                   'message': '* 密码，长度为1-20位'
               }
          },
          '#random': {
              'required': {
                   'message': '* 验证码,长度为4位'
               }
          }
       }
    }); 
   
}); 
//获取随机验证码
function getRandom(){
	var dateTime=new Date().getTime();
	$("#code").attr("src","/system/getRand.do?"+dateTime);
}
//登录
function login(){
	var flag=$("#loginForm").validationEngine('validate');
    if(!flag){
        return;
    }
    var manager = $.ligerDialog.waitting( "登录中，请稍后......" );
	$.ajax({
		url:'/adminUsers/login.do',
		type:'POST',
		dataType:'json',
		data:$("#loginForm").serialize(),
		success:function(data){
			manager.close();
			if(data.status.code=="10000"){
				window.location.href="/main.html";
			}else{
				$.ligerDialog.alert(data.status.msg,"提示信息","warn");
			}			
		}
	});
}
</script>
  </head>
  
  <body>
       <form id="loginForm" method="post">
<div class="main">
  <div class="login">
      <div class="loginInput">
        <ul>
          <li><span>用户名</span><span><input class="validate[required]" style="height: 22px;line-height: 22px;width: 155px;" type="text" name="username" id="username"/></span></li>
          <li><span>密　码</span><span><input class="validate[required]" style="height: 22px;line-height: 22px;width: 155px;" type="password" name="pwd" id="pwd"/></span></li>
          <li><span>验证码</span><span><input class="validate[required]" style="height: 24px;line-height: 24px;" type="text" name="random" id="random" size="4" maxlength="4"/></span>
          	  <span><img id="code" alt="点击刷新验证码" onclick="getRandom();"/></span>
          </li>
        </ul>
      </div>
      <div class="loginBtn">
		<input type="button" value="" id="input_submit"  onclick="login();"/>
      </div>
  </div>
</div>

 </form>
  </body>
</html>
