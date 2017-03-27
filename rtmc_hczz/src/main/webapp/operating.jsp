<%@ page language="java" import="java.util.*,com.wenhao.sso.client.filter.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>案件信息</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <link rel="stylesheet" href="../css/common.css"/>
    <link rel="stylesheet" href="../css/operating.css"/>
</head>
<body>
<div id="all">
    <div id="operating">
        <div class="common">
            <div class="header">
                <img src="../images/img/01-index/logo.png" alt=""  style="margin-top: 24px;">
                <ul class="headerRight">
                    <li class="country">
                        <img src="../images/img/01-index/language.png" alt="语言选择"/>
                    </li>
                    <li class="information">
                        <img src="../images/img/01-index/information.png" alt="消息"/>
                    </li>
                    <li class="user">
                   <img src="../images/img/01-index/avatars.png" alt="用户头像"/>
                  <span class="userName">${sessionScope.ssoUser.username}</span>
                        <a href="<%=basePath%>ssologinout">退出系统</a>
                    </li>
                </ul>
            </div>
            <div class="menu">
                 <ul>
                    <li>  
                        <a href="/user/main.do">首页</a>
                    </li>
                    <li>
                        <img src="../images/img/01-index/nav-operating.png" alt="运营"/>
                        <a href="/user/operating.do">运营</a>
                    </li>
               
                <c:forEach items="${sessionScope.bm}" var="t">
       
      
                    <li>
            
                         <!-- <img src="../images/img/01-index/nav-operating.png" alt="首页"/> -->
                       
                        <a href="${t.url}" target="_blank">${t.name}</a>
                 	 </li>
           
                       
                </c:forEach>
                       
                </ul>
            </div>
        </div>
        
<%--            <div class="content">
            <c:forEach items="${sessionScope.operating_list}" var="t2">
 <c:if test="${t2.name=='salesAssessment'}">
             <div class="frame salesAssessment">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
  </c:if>
 
 <c:if test="${t2.name=='trafficEvaluation'}">
             <div class="frame trafficEvaluation">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
  </c:if>
    
            <c:if test="${t2.name=='metaAnalysis'}">
            <div class="frame metaAnalysis">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
            </c:if>
      <c:if test="${t2.name=='salesTurnover'}">
            <div class="frame salesTurnover">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
            </c:if>
      <c:if test="${t2.name=='salesSummary'}">
            <div class="frame salesSummary">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
            </c:if>

  </c:forEach>
 
        </div> --%>
        
        <div class="content">
               <c:forEach items="${sessionScope.operating_list}" var="t2">
            <div class="frameContainer">
        
 <c:if test="${t2.name=='operate_1'}">
             <div class="frame salesAssessment">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
  </c:if>
 
 <c:if test="${t2.name=='operate_2'}">
             <div class="frame trafficEvaluation">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
  </c:if>
    
            <c:if test="${t2.name=='operate_3'}">
            <div class="frame metaAnalysis">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
            </c:if>
      <c:if test="${t2.name=='operate_4'}">
            <div class="frame salesTurnover">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
            </c:if>
      <c:if test="${t2.name=='operate_5'}">
            <div class="frame salesSummary">
                <iframe src="${t2.url}" frameborder="0"></iframe>
            </div>
            </c:if>
            </div>
              </c:forEach>
        </div>
        <div class="common">
            <div class="poweredBy">
                Copyright © 2016-2050 成都高德唯斯科技股份有限公司
            </div>
        </div>
    </div>
</div>

<script src="../js/jquery-1.10.2.js"></script>
<script src="../js/common.js"></script>
</body>
</html>