var baseurl = "http://localhost:8080/main.html";
$(function(){
	
	var getTitle = null,
		iframe = $.fsh.requestParam("iframe"),
		btn_submit = $("input#input_submit"),
		login_dom = $("div.login");
	//display
	displayLogin(".login", true);
	$(window).resize(function(){displayLogin(".login", false);});
	
	//submit effect
	btn_submit.hover(function(){$(this).addClass("mouseMove");},function(){	$(this).removeClass("mouseMove");});
	
	//form validate
	initForm("#loginForm");
	$("input[validate]").keyup(function() {
		var thisName = $("input[name=" + this.name.replace(/_v$/, "") + "]");
		thisName.val(new Base64().encode(this.value));
	});
		
	//code
	var $code = $("#code"), realUrl;
	$code.attr("src", realUrl = baseUrl + "rand.shtml?");
	$code.click(function(){
		var $this = $(this), currentTime= new Date().getTime();
        $this.attr("src", realUrl + currentTime);
	});
	
	//title
	getTitle = $.fsh.getAjaxData( baseUrl + "getWebInfo.shtml");
	document.title = getTitle.sSysName;
});

//display
function displayLogin(mode,flag) {
	var $win = $(window), $mode = $(mode),
		winWidth = $win.width(), winHeight = $win.height(),
		modeWidth = $mode.outerWidth(true), modeHeight = $mode.outerHeight(true),
		leftPos = (winWidth-modeWidth)>0 ? (winWidth-modeWidth)/2 : 0,
		topPos = (winHeight-modeHeight)>0 ? (winHeight-modeHeight)/2 : 0;
	flag ? $mode.css({left: leftPos}).animate({ opacity:1, top:topPos }) : $mode.css({left: leftPos, opacity:1, top:topPos });
}

function initForm(formDom){
	var $dom = $(formDom);
	$.fsh.inputValidate(formDom);	//验证表单
	$dom.attr("action", [$dom.attr("action"), "?r=", new Date().getTime()].join("") );
	$dom.find("input[id=input_submit]").click(function(){
		var _flag_ = $.fsh.validateForSubmit(".loginInput");
		if(_flag_){
			var manager = $.ligerDialog.waitting( "登陆中，请稍后......" );
			$dom.ajaxSubmit(function(data){
				var d = typeof data=="object" ? data : $.parseJSON( data );
				if(typeof d.success == "boolean" && d.success==true){
					$.fsh.gotoUrl("main.html");
				}else{
					$.ligerDialog.error(d.message);
				}
				manager.close();
			});
		}
		return false;
	});
//	document.onkeydown=function(event){
//		  e = event ? event :(window.event ? window.event : null);
//		  if(e.keyCode==13){
//		   //执行的方法
//			  $("#login").submit();
//		  }
//	}
}