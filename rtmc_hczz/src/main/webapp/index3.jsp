<%@ page language="java"
	import="java.util.*,com.wenhao.sso.client.filter.*"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<title>动态档案展示</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- ligerUIcss -->
<link href="/js/ligerui/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link href="/js/ligerui/lib/ligerUI/skins/ligerui-icons.css"
	rel="stylesheet" type="text/css" />


<!-- 引入 Bootstrap -->
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
<script src="/bootstrap/js/jquery.min.js" type="text/javascript"></script>
<!-- 包括所有已编译的插件 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>

<!-- 引入相册使用的css样式 -->
<link href="/xiangce/css/viewer.css" rel="stylesheet" type="text/css" />
<link href="/xiangce/css/main.css" rel="stylesheet" type="text/css" />

<!-- 引入相册使用的js代码 -->
<script src="/xiangce/js/viewer.js" type="text/javascript"></script>
<script src="/xiangce/js/main.js" type="text/javascript"></script>


<!-- ligerUI js -->
<script src="/js/ligerui/lib/ligerUI/js/core/base.js"
	type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/core/ligerDrag.js"
	type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/core/ligerDialog.js"
	type="text/javascript"></script>
<script src="/js/ligerui/lib/ligerUI/js/core/ligerResizable.js"
	type="text/javascript"></script>

<!-- 引入ueditor富文本编辑器代码 -->
<script src="/ueditor/ueditor.config.js" type="text/javascript"></script>
<script src="/ueditor/ueditor.all.js" type="text/javascript"></script>

</head>
<body>


	<div class="row">

		<div class="col-xs-8 col-sm-offset-2" style="border: solid 1px red">

			<div class="row"
				style="border: solid 1px red; text-align: center; color: red;">
				<h1>某某案件在侦动态</h1>
			</div>
			
		<%-- 	<jsp:include page="/manager/rt_Archives/rt_Archives_look.html"></jsp:include> --%>
			<!-- 下面部分的内容为 案件详情展示页面 -->
			<div class="row">
				<div class="col-xs-4">
					<label for="inputfile">案件编号：</label> <input type="text"
						value="2017-XX-03">

				</div>

				<div class="col-xs-8">
					<label for="inputfile">主侦人员：</label> <input type="text" size="68"
						value="张某某、王某某、邓某某、刘某某">
				</div>

				<div class="col-xs-4">
					<label for="inputfile">案件名称：</label> <input type="text"
						value="手机公交车被盗案">
				</div>

				<div class="col-xs-4">
					<label for="inputfile">案件时间：</label> <input type="text"
						value="2017-3-24 10:25:30">
				</div>
				<div class="col-xs-4">
					<label for="inputfile">案件类型：</label> <input type="text" value="偷窃案">
				</div>
				<div class="col-xs-4">
					<label for="inputfile">案件状态：</label> <input type="text" value="已结案">
				</div>
				<div class="col-xs-4">
					<label for="inputfile">发布者&nbsp;&nbsp;&nbsp;&nbsp;：</label> <input
						type="text" value="X站警">
				</div>
				<div class="col-xs-4">
					<label for="inputfile">发布时间：</label> <input type="text"
						value="2017-03-24">
				</div>

				<div class="col-xs-12">
					<div class="col-xs-2">
						<label for="form-label">案件简介：</label>
					</div>
					<div class="col-xs-10">
						<textarea class="col-xs-12" rows="3" value="这里面填写案件描述的具体内容信息"></textarea>
					</div>
				</div>

				<div class="col-xs-12" style="margin-top: 1%">
					<div class="col-xs-2">
						<label for="inputfile">专案人员：</label>
					</div>
					<input type="text"  size="120"  value="张某某、王某某、邓某某、刘某某、张某某、王某某、邓某某、刘某某、钱某某、范某某"  >
				
					<div class="col-xs-10">
						<ul class="list-group">
							<li class="list-group-item list-group-item-success col-xs-2"> <image src="/bootstrap/img/av1.jpg">  张某某   </li>
							<li class="list-group-item list-group-item-success col-xs-2"> <image src="/bootstrap/img/av1.jpg">  张某某   </li>
						 		<li class="list-group-item list-group-item-success col-xs-2"> <image src="/bootstrap/img/av1.jpg">  张某某   </li>
						
						</ul>
					</div>
				</div> 
		<hr>

				<!-- 在侦动态 -->
				<div class="col-xs-12 ">
					<h2>侦查动态</h2>

					<div class="col-xs-12">

						<div class="col-xs-7  ">
							<p style="display: block;">
								<img src="/bootstrap/img/av1.jpg" alt>
							</p>

							<div class="msg_show" id="msg_show">
								<span> <Strong>小A:</Strong><br> 
								<span  class="msg_content">正式的文本内容文件</span>
									<P>时间:19:53 &nbsp;&nbsp;&nbsp;&nbsp;地址：XX街道XX小区</p>
								</span>
								<P>
									<a onclick="f_tip()"> 赞:<span id="zan">25</span></a>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<a onclick="f_comment()"> 评论：<span
										id="count_comment">30 </span>
									</a>&nbsp;&nbsp;&nbsp;&nbsp;转发：20&nbsp;&nbsp;&nbsp;&nbsp; 
									<a onClick="f_collect()"> 收藏：<span id="collect_num">15</span> </a>&nbsp;&nbsp;&nbsp;&nbsp; 
									 <a  onClick="f_guide()">指示：<span id="guide_num"> 1</span></a>
								</p>
								
									<!-- 评论功能代码 -->
				                   <div  class="tab-pane " id="show_comment" > 
									<!-- 添加自己的评论 -->
									<div id="add_content">
										
									</div>
									
									<!-- 提交评论按钮 -->
									<button type="button"   class="btn btn-success" onclick="fn_commit()">评论</button>
									
									<!-- 展示别人的评论列表 -->
									<div id="content_list"  >
										<!-- <p  style="color:#EE5C42"> 下面是展示别人评论的消息，且能对别人的评论进行回复和点赞功能的实现 </p> -->
										<ul class="list-unstyled" id="list_comment">
										
									      <li id="001"> 
									      	<span  class="memeber" >侦查员B:</span>
									      	<span >这是B对A内容发表的一个评论展示</span><br> 
									      	<span class="showTime" >时间：11:58</span>	&nbsp;&nbsp;&nbsp;&nbsp;
									      	<span  class="moreContent" > <a onclick="f_comment_other()" >回复 :</a></span> <span id="comment_other_1">12</span>&nbsp;&nbsp;&nbsp;&nbsp;
									      	<span  class="moreContent"  > <a onclick="f_tip2()"> 赞 : </a></span> <span id="tip2_1"> 12</span>
									      	<!-- 这里面展示的是对别人评论的评论内容 -->
									      	<div id="f_comment_other"  >
									      		<ul class="list-unstyled" id="comment_other_list">
												  		<li><span  class="memeber" > &nbsp;&nbsp;&nbsp;&nbsp;侦查员c:</span>对B的评论再发表评论</li>
												</ul>
									      	 </div>
									      </li>
									   
									    </ul>
										
									</div>	
								</div> 
								
								<!-- 展示领导指示的列表 -->
									<div  id="list_guide"  class="tab-pane "   >
										<ul class="list-unstyled" >
									    	 <li id="guide_001"> 
									    	 <span  class="memeber" >领导A:</span>
									    	 <span >A领导的第一条指示</span><br> 
									    	 <span class="showTime" >时间：11:58</span>	
									    	 &nbsp;&nbsp;&nbsp;&nbsp;
									    	 <span  class="moreContent" > <a onclick="f_an_guide()" >回复 </a></span>
									    	 &nbsp;&nbsp;&nbsp;&nbsp;
									    	 </li>
									    	   <div id="an_guide"> 
									    	    </div> 
									    	    
									    	     <div id="fn_an_guide" > 
									    	   		<input type="text" value="" name="response" id="response_guide">
									    	   		<button type="button"   class="btn btn-success "   onclick="fn_an_guide()">回复</button>
									    	    </div> 
											<!-- <button type="button"  id="fn_an_guide" class="btn btn-success "  style="display:none" onclick="fn_an_guide()">回复</button>
									   -->
									    </ul>
									    
									  
										
									</div>
								
							</div>
						</div>


						<div class="col-xs-6 pull-right text-right "
							style="margin-top: 10px">
							<p style="display: block;">
								<img src="/bootstrap/img/av2.jpg" alt> <span
									class="msg_mana_show"> <Strong>领导1:</Strong><br> <span
									class="msg_content">领导1的指示内容,现场现在是什么样子？</span>
								</span>
							</p>
						</div>


						<div class="col-xs-7">
							<p style="display: block;">
								<img src="/bootstrap/img/av1.jpg" alt>
							</p>
							<div class="msg_show">
								<span> <Strong>小B:</Strong><br> <span
									class="msg_content"> 到了案发现场，现场的图片如下几张
										<div class="docs-galley">
											<ul class="docs-pictures clearfix">
												<li><img
													data-original="./xiangce/assets/img/emma-watson-1.jpg"
													src="./xiangce/assets/img/thumbnails/emma-watson-1.jpg"></li>
												<li><img
													data-original="./xiangce/assets/img/emma-watson-2.jpg"
													src="./xiangce/assets/img/thumbnails/emma-watson-2.jpg"></li>
												<li><img
													data-original="./xiangce/assets/img/emma-watson-3.jpg"
													src="./xiangce/assets/img/thumbnails/emma-watson-3.jpg"></li>
												<li><img
													data-original="./xiangce/assets/img/emma-watson-4.jpg"
													src="./xiangce/assets/img/thumbnails/emma-watson-4.jpg"></li>
												<li><img
													data-original="./xiangce/assets/img/emma-watson-3.jpg"
													src="./xiangce/assets/img/thumbnails/emma-watson-3.jpg"></li>
												<li><img
													data-original="./xiangce/assets/img/emma-watson-4.jpg"
													src="./xiangce/assets/img/thumbnails/emma-watson-4.jpg"></li>

											</ul>
										</div>
								</span>
								</span>
							</div>
						</div>



						
					</div>


				</div>


			</div>



		</div>

	</div>


   
	

</body>

<style type="text/css">
.msg_show {
	background: none repeat scroll 0 0 #FFFFFF;
	border: 1px solid #cccccc;
	box-shadow: 1px 1px 0 1px rgba(0, 0, 0, 0.05);
	display: block;
	padding: 10px;
	position: relative;
	margin-top: -50px;
	margin-left: 45px;
}

.msg_content {
	font-size: 18px;
}

.msg_mana_show {
	background: none repeat scroll 0 0 #FFF5F5;
	border: 1px solid #cccccc;
	box-shadow: 1px 1px 0 1px rgba(0, 0, 0, 0.05);
	display: block;
	margin-right: 45px;
	padding: 10px;
	position: relative;
	margin-top: -40px;
}

.memeber{
	color:#EE5c42;
}

.showTime{
	color:#969696;
}

.moreContent{
	color:#8B8989;
}

</style>



<script type="text/javascript">
	//用于隐藏别人的评论列表
	$('#show_comment').hide();
	
	//隐藏领导的指示 "list_guide"
	$('#list_guide').hide();
	$('#fn_an_guide').hide(); 

	//用于判断是否已经点赞
	var i = parseInt(1);
	
	//用于判断用户是否已经收藏
	var collect = parseInt(1);
	
	var comment_num = parseInt(1);
	
	/* 模拟实现 点赞功能 */
	function f_tip() {
		var a = 'success';
		var b = 'error';
		if (i == 1) {
			$.ligerDialog.alert('点赞成功', '提示', a);
			var zan = parseInt($("#zan").text());
			$("#zan").text(zan + 1);
			i++;
		} else {
			var zan = parseInt($("#zan").text());
			$("#zan").text(zan - 1);
			i = 1;
			$.ligerDialog.alert('已取消点赞', '提示', b);
		}
	};
	
	
	/* 模拟实现  对 别人的 评论 点赞功能 */
	var bb=  parseInt(1); 
	function f_tip2() {
		var a = 'success';
		var b = 'error';
		var zan = parseInt($("#tip2_1").text());
		if (bb == 1) {
			$.ligerDialog.alert('点赞成功', '提示', a);
			
			$("#tip2_1").text(zan + 1);
			bb++;
		} else {
			$("#tip2_1").text(zan - 1);
			bb = 1;
			$.ligerDialog.alert('已取消点赞', '提示', b);
		}
	};
	

	/* 模拟实现评论功能 */
	function f_comment() {
		 $('#list_guide').hide();
		if(comment_num==1){
			var ue = UE.getEditor('editor', {
				toolbars: [
				    ['bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'blockquote', 'pasteplain', '|', 'forecolor',   'cleardoc']
				]
			});
			
			// 显示评论div 
			$('#show_comment').show();
			
			/*在页面上添加输入框控件*/
			 var insertHtml='<div id=\"editor\" type=\"text/plain\" style=\" height: 2%;\"></div> ' ; 
			$('#add_content').after(insertHtml); 
			
			comment_num ++;
		}else{
			//隐藏评论区
			$('#show_comment').hide();
			
			comment_num  =1 ;
		}
	};
	
	// 提交评论模拟实现
	function fn_commit(isAppendTo){
		//获得编辑器中内容
		var arr = [];
        arr.push(UE.getEditor('editor').getContentTxt());
        var a = arr.join("\n");
		var insertHtml = "<li> <span  class=\"memeber\" >侦查员A:</span> " + a + "<br> <span class=\"showTime\" >时间：11:58</span>	&nbsp;&nbsp;&nbsp;&nbsp; "+"<span  class=\"moreContent\" > <a onclick=\"f_comment_other()\" >回复</a></span>	&nbsp;&nbsp;&nbsp;&nbsp; "+"<span  class=\"moreContent\"  > <a onclick=\"f_tip2()\"> 赞11</a></span>  "+" </li>";
       $('#list_comment').prepend(insertHtml); 
       
       //清空编辑器中内容
       UE.getEditor('editor').setContent('', isAppendTo); 
       
       // 将页面上的评论数 +１　count_comment
       var comment = parseInt($("#count_comment").text());
		$("#count_comment").text(comment + 1);
	};
	
	/* 模拟实现对别人的评论进行评论功能*/
	function f_comment_other(){
		/* <li><span  class="memeber" > &nbsp;&nbsp;&nbsp;&nbsp;侦查员c:</span>对B的评论再发表评论</li> */
		var a = '<input type=\"text\" value=\"\" name=\"response\" id=\"response\"> <button type=\"button\"   class=\"btn btn-success \"   onclick=\"fn_add_guide()\">回复</button>';
		 $('#f_comment_other').append(a); 
	};
	
	//将对别人的评论追加到上面去
	function fn_add_guide(){
		var a = $('#response').val();
		var b = "<li><span  class=\"memeber\" > &nbsp;&nbsp;&nbsp;&nbsp;侦查员D:</span> "+a +"</li>";
		$('#response').val("");
		 $('#comment_other_list').append(b); 
		 var c = parseInt($("#comment_other_1").text());
		 $("#comment_other_1").text(c+1);
	}
	
	
	
	//点击收藏
	function f_collect(){
		var a = 'success';
		var b = 'error';
		
		var collect_num = parseInt($("#collect_num").text());
		if (collect == 1) {
			$.ligerDialog.alert('收藏成功', '提示', a);
			$("#collect_num").text(collect_num + 1);
			collect++;
		} else {
			$("#collect_num").text(collect_num - 1);
			collect = 1;
			$.ligerDialog.alert('已取消收藏', '提示', b);
		}
	};
	
	//领导指示功能
	function f_guide(){
	    //显示领导的指示
	   $('#list_guide').show();
	   $('#show_comment').hide();
	    
	}
	
	//回复领导的指示
	function f_an_guide(){
		 
		 $('#fn_an_guide').show();
	
	}
	
	//将回复内容添加到页面中
	function fn_an_guide(isAppendTo){
	    var a = $('#response_guide').val(); 
		var addButton = " <li id=\"guide_001\"> <span  class=\"memeber\" >侦查A:</span><span > " +a +"</span><br> <span class=\"showTime\" >时间：17:01</span>	</li>";
		//清空input里面的值
		$('#response_guide').val(""); 
		$('#an_guide').append(addButton); 
	}
	
	
	
</script>

 
</html>

