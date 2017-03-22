/**
 * 自定义验证js
 */
$(function() {
	//自定义方法（不验证hidden类型的数据）
	$.extend($.validator.defaults,{ignore:":hidden"});

    //添加validate属性
    $.metadata.setType("attr", "validate");
    var v =$.validator.setDefaults({
    	event:"onkeyup",//触发校验的方式，可选值有keyup(每次按键时)，blur(当控件失去焦点时)  
        //调试状态，不会提交数据的
        debug: false,
        errorPlacement: function(lable, element) {
        	if (element.hasClass("l-textarea"))
            {
                element.addClass("l-textarea-invalid");
            }
            else if (element.hasClass("l-text-field"))
            {
                element.parent().addClass("l-text-invalid");
                element.parent().ligerTip({ content: lable.html(), target: element[0] });
            }
            //$(element).removeAttr("title").ligerHideTip();
            //$(element).attr("title", lable.html()).ligerTip();
        },
        success: function(lable) {
        	lable.ligerHideTip();
            lable.remove();
            var element = $("#" + lable.attr("for"));
            var nextCell = element.parents("td:first").next("td");
            if (element.hasClass("l-textarea")) {
                element.removeClass("l-textarea-invalid");
            } else if (element.hasClass("l-text-field")) {
                element.parent().removeClass("l-text-invalid");
            }
            nextCell.find("div.l-exclamation").remove();
            
        }
    });
});
(function($){
	window.validate = $.validate = {
	   /**
	    * 
	    * fun:显示tip提示信息
	    *
	    * @author yumaochun
	    * @date 2016年5月9日
	    * @param id         id
	    * @param content    提示内容
	    * @param width      tip宽度
	    */
	   showTip:function(id,content,width){
		   width=width||'';
		   $("#"+id).ligerTip({ content: content, width: width });
	   },
	   /**
	    * 
	    * fun:隐藏tip
	    *
	    * @author yumaochun
	    * @date 2016年5月9日
	    * @param id     id
	    */
	   hideTip:function(id){
		   $("#"+id).ligerTip().remove();
	   }
			
	};
});
