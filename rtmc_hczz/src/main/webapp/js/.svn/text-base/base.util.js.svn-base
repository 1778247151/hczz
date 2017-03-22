/**
 * 系统公共方法
 */

(function($){
	var language=navigator.language || navigator.browserLanguage;
	//资源化文件的加载
	jQuery.i18n.properties({
        name : 'strings', //资源文件名称
        path : '/i18n/', //资源文件路径
        mode : 'map', //用Map的方式使用资源文件中的值
        language:language,//语言
        callback : function() {//加载成功后设置显示内容
        	
        }
	});
 
	
	window.base = $.base = {
	   /**
		* 替换字符串中指定的值
		* @param str 字符串
		* @obj 选中的行数据对象
		*/
		replaceStrByParam: function(str, obj) {
			var urlSplit = str.split("$"),
			len = urlSplit.length,
			arr = [], i=0;
			for( ; i<len; i++ ) {
					var ar = encodeURI(urlSplit[i]);
					arr.push( (i%2!=0) ? obj[ar] : ar );
			}
			return arr.join("");
		},
		/**
		 * 初始化系统名称
		 */
		initSystemName:function(){
			 
			 //document.title=systemName;
		},
		/**
		 * 获取浏览器语言
		 * @returns {Boolean}
		 */
		getLanguageType:function(){
			var language=navigator.language || navigator.browserLanguage;
			return language;
		},
		
	   //*************************参数传递基本方法*************************************	
	   /**
	    * 将URL中传递的参数保存在对象中
	    * @returns {Object}
	    */
	   initUrlParam : function() {
		   var url = location.search; //获取url中"?"符后的字串
		   //URL中参数对象
		   var theRequest = new Object();
		   if (url.indexOf("?") != -1) {
			   //获取"?"后面的字符串
		      var str = url.substr(1);
		      var strs = str.split("&");
		      for(var i = 0; i < strs.length; i ++) {
		    	 var keyValStr=strs[i].split("=");
		    	 if(keyValStr.length==2){
		    		 var key=decodeURIComponent(keyValStr[0]);
			    	 var value=decodeURIComponent(keyValStr[1]);
			         theRequest[key]=value;
		    	 }else{
		    		 alert("URL后面的参数格式错误！");
		    	 }
		      }
		   }
		   return theRequest;
	   },
	   /**
	    * 获取URL中传递的参数值
	    * 
	    * @param key          获取参数值的名称
	    * @returns   string   参数对应的值 
	    */
	   requestParam:function(key){
		   var requestObj = $.base.initUrlParam();
		   return requestObj[key] || "";
	   },
	   
	   //*************************cookie基本方法*************************************	   
	   /**
		 * func:设置cookie信息
		 * @param     name           名称
		 * @param     value          值
		 * @param     expireTime     过期时间（单位：小时）
		 */
		setCookie:function(name,value,expireTime){
			var exdate=new Date();
			exdate.setTime(exdate.getTime() + (expireTime*60*60*1000));
			document.cookie=name + "=" + escape(value) + ((expireTime==null) ? "" : ";expires="+exdate.toGMTString())+";path=/";
		},
		/**
		 * func:获取cookie信息
		 * @param     name           名称
		 * @return    返回：名称对应的值
		 */
		getCookie:function(name){
			var allcookies = document.cookie; 
            var cookie_pos = allcookies.indexOf(name); 
			var value="";
           // 如果找到了索引，就代表cookie存在， 
           // 反之，就说明不存在。 
           if (cookie_pos != -1) 
           { 
              // 把cookie_pos放在值的开始，只要给值加1即可。 
              cookie_pos += name.length + 1; 
              var cookie_end = allcookies.indexOf(";", cookie_pos); 
              if (cookie_end == -1) 
              { 
                 cookie_end = allcookies.length; 
              } 
              value = unescape(allcookies.substring(cookie_pos, cookie_end)); 
           } 
           return value; 
		},
		/**
		 * func:删除cookie信息
		 * @param     name           名称
		 * @return    void
		 */
		removeCookie:function(name){
			var date=new Date(); 
           date.setTime(date.getTime()-1000); 
           document.cookie=name+"='';path=/;expires="+date.toGMTString(); 
		},
		/**
		 * 获取鼠标相对于屏幕的x,y坐标
		 * @param event
		 * @returns {x:10,y:10}
		 */
		getMouseXYByScreen:function(event){
			var e = event || window.event;             
		    return {'x':e.screenX,'y':screenY};
		},
		/**
		 * 获取鼠标相对浏览器窗口的x,y坐标
		 * @param event
		 * @returns {x:10,y:10}
		 */
		getMouseXYByScreen:function(event){
			var e = event || window.event;              
			return {'x':e.clientX,'y':clientY};
		},
		/**
		 * 获取鼠标相对文档的x,y坐标
		 * @param event
		 * @returns {x:10,y:10}
		 */
		getMouseXYByDoc:function(event){
			var e = event || window.event;
            var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
            var scrollY = document.documentElement.scrollTop || document.body.scrollTop;
            var x = e.pageX || e.clientX + scrollX;
            var y = e.pageY || e.clientY + scrollY;
            return { 'x': x, 'y': y };
		},
		/**
		 * 创建进度条
		 * 
		 * @param tipInfo    进度条提示信息
		 * @param width      进度条宽度
		 * @param height     进度条高度
		 */
		createProgressBar:function(tipInfo,width,height){
			
			tipInfo = tipInfo || "数据正在加载中...";
			width = width || "330";
			height = height || "125";
			$("input").blur();
			$(".progress-bar").remove();
			var progressBar=$('<div class="progress-bar" style="width:'+width+'px;height:'+height+'px"><div class="status-ico"></div><div class="status-info">'+tipInfo+'</div></div>');
			$("body").append(progressBar);
			var l = ($(window).width() - $(".progress-bar").width()) / 2  + $(document).scrollLeft();
			var t = ($(window).height() - $(".progress-bar").height()) / 2 + $(document).scrollTop();
			$(".progress-bar").css('left', l + 'px');
			$(".progress-bar").css('top', t + 'px');
			var mask=$('<div class="mask"></div>');
			$("body").append(mask);
			//alert($("body").width());
			$(".mask").width($("body").width());
			$(".mask").height($(window).height()-2);
		},
		/**
		 * 更新进度条提示信息
		 * @param topInfo   提示信息
		 */
		updateProgressBarInfo:function(topInfo){
			$(".progress-bar").find(".status-info").html(topInfo);
		},
		/**
		 * 移除进度条
		 */
		removeProgressBar:function(){
			$(".progress-bar").remove();
			$(".mask").remove();
		}
 
	};
	
	/**
	 * 设置光标聚焦的位置
	 */
//	$.fn.textFocus=function(v){ 
//		var range,len,v=v===undefined?0:parseInt(v); 
//		this.each(function(){ 
//		if($.browser.msie){ 
//		range=this.createTextRange(); //文本框创建范围 
//		v===0?range.collapse(false):range.move("character",v); //范围折叠 
//		range.select(); //选中 
//		}else{ 
//		len=this.value.length; 
//		v===0?this.setSelectionRange(len,len):this.setSelectionRange(v,v); //dom直接设置选区，然后focus 
//		} 
//		this.focus(); 
//		}); 
//		return this; 
//	}; 
})(jQuery);

//扩展方法
$.fn.extend({ 
	//超出指定长度，显示省略号
    displayPart:function () {  
        var displayLength = 18;  
        displayLength = this.attr("displayLength") || displayLength;  
        //alert(displayLength);
        var text = this.text(); 
        if (!text) return "";  
        var result = "";  
        var count = 0;  
        for (var i = 0; i < displayLength; i++) {  
            var _char = text.charAt(i);  
            if (count >= displayLength)  break;  
            if (/[^x00-xff]/.test(_char))  count++;  //双字节字符，//[u4e00-u9fa5]中文  

            result += _char;  
            count++;  
        }  
        if (result.length < text.length) {  
            result += "...";  
        }  
        this.text(result);  
    },
    //动态创建浮动层
    createTipDiv:function(){
    	//省略号处理
    	$.each($(this),function(i,n){
    		$(this).after("<label class='all-name' style='display: none;'>"+$(this).html()+"</label>");
    		$(this).displayPart();
    	});
    	//鼠标放上去显示完整名称
    	$(this).mousemove(
    		function(event){
    			 var pageX = event.pageX;
    		     var pageY = event.pageY;
    		     if(pageX==undefined)
    		    {
    		          pageX=event.clientX+document.body.scrollLeft||document.documentElement.scrollLeft;
    		    }
    		     if(pageY==undefined)
    		     {
    		         pageY = event.clientY+document.body.scrollTop||document.documentElement.scrollTop;
    		     }
    		     var allHtml=$(this).next(".all-name").html();
    		     //创建浮动层
    		     var tipDiv=$('<div class="show-all-name" style="position: absolute;z-index: 20000;'
    		         +' border: 1 solid gray;height: 22px;line-height: 22px;padding:0px 6px 0px 6px;'
    		         +'-webkit-border-radius: 2px;-moz-border-radius: 2px;border-radius: 2px;color: #FFFFFF;'
    		         +'background-color: #314d65;">'+allHtml+'</div>');
    			 $("body").append(tipDiv);
    			 var left=pageX-10;
    			 var top=pageY+20;
    			 $(".show-all-name").css({'left':left,'top':top});
    		}
    	);
    	//鼠标放上去去掉显示的名称
    	$(this).mouseleave(
    		function(e){
    			$(".show-all-name").remove();
    		}
    	);
    },
    /**
     * func:设置光标聚焦的位置
     * 
     * @param v    光标聚焦的位置（在指定字符串长度后面）  默认为文本内容的后面
     * @returns {___anonymous5050_7702}
     */
    textFocus:function(v){
    	var range,len,v=v===undefined?0:parseInt(v); 
		this.each(function(){ 
		if($.browser.msie){ 
		range=this.createTextRange(); //文本框创建范围 
		v===0?range.collapse(false):range.move("character",v); //范围折叠 
		range.select(); //选中 
		}else{ 
		len=this.value.length; 
		v===0?this.setSelectionRange(len,len):this.setSelectionRange(v,v); //dom直接设置选区，然后focus 
		} 
		this.focus(); 
		}); 
		return this; 
    }
    
    
});  