/**
 * func:检查是否是中文名字且长度为2到4个中文字符
 * 
 * @param field
 * @param rules
 * @param i
 * @param options
 * @returns {String}
 */
function checkChinese(field,rules, i, options){
   var reg="/^[\u4e00-\u9fa5]{2,4}$/";
   var flag=/^[\u4e00-\u9fa5]{2,4}$/.test(field.val());
   if(!flag){
      return "请填写您的中文姓名、长度为到个中文字符";
   }  
}
/**
 * 
 
/***********************************自定义方法的调用***************************************/
//示例：class="validate[funcCall[checkIsSubMask]]"

/** 
 * func:只能输入英文、数字、下划线、或者邮箱
 * 
 * @param field
 * @param rules
 * @param i
 * @param options
 * @returns {String}
 */
function checkAccount(field,rules, i, options){
	//var reg = new RegExp(/^\d{4}[\/\-](0?[1-9|30)))(\0?[1-579][26]))$/);
	//var flag=reg.test(field.val());
	var flag=/^[a-zA-Z0-9][a-zA-Z0-9_]*$/.test(field.val());
	if(!flag){
	    return "* 只能输入英文、数字、下划线、或者邮箱";
	}  
}
/**
 * func:验证IP地址格式是否正确
 * 
 * @param field
 * @param rules
 * @param i
 * @param options
 * @returns {String}
 */
function checkIp(field,rules, i, options){
	var reg=new RegExp(/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/);
	var flag=reg.test(field.val());
	if(!flag){
	    return "* IP地址格式不正确";
	}
}
/**
 * func:判断是不是子网掩码
 * 
 * @param field
 * @param rules
 * @param i
 * @param options
 * @returns {String}
 */
function checkIsSubMask(field,rules, i, options){//子网掩码必须是 1 和 0组成的连续的一段 如 11110000
	var reg=new RegExp(/^(254|252|248|240|224|192|128|0)\.0\.0\.0|255\.(254|252|248|240|224|192|128|0)\.0\.0|255\.255\.(254|252|248|240|224|192|128|0)\.0|255\.255\.255\.(254|252|248|240|224|192|128|0)$/); 
	var flag=reg.test(field.val());
	if(!flag){
	    return "* 子网掩码格式不正确";
	}  
}
/**
 * func:验证是不是指定范围的整数
 * 
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function checkIntRang(field,rules, i, options){
	var reg=new RegExp(/^[0-9]*[1-9][0-9]*$/); 
	var minVal=1;
	var maxVal=32;
	//alert(minVal+","+maxVal);
	var flag=reg.test(field.val());
	if(!flag){
	    return "* 请输入正整数";
	}else{
		if(field.val()<minVal||field.val()>maxVal){
			return "* 请输入"+minVal+"-"+maxVal+"的正整数";
		}
	} 
}
/**
 * 不能输入特殊
 * @param field
 * @param rules
 * @param i
 * @param options
 * @returns {String}
 */
function checkIsHasSpecialChar(field,rules, i, options){
	var reg=new RegExp(/[' "#$%&?+？=（）【】｛｝;:"'<>,.\^*]/); 
	var flag=reg.test(field.val());
	if(flag){
		var language=$.sys.getCookie("language")||$.sys.getLanguageType();
		if(language=="zh-cn"){
			return "* 不能输入特殊字符";
		}else{
			return "* Can't enter special characters";
		}
	    
	}
}
/**
 * 验证url
 * @param field
 * @param rules
 * @param i
 * @param options
 * @returns {String}
 */
function checkUrl(field,rules, i, options){
	var strRegex = "^((https|http|ftp|rtsp|mms)://)?[a-z0-9A-Z]{3}\.[a-z0-9A-Z][a-z0-9A-Z]{0,61}?[a-z0-9A-Z]\.com|net|cn|cc (:s[0-9]{1-4})?/$";
	var reg=new RegExp(strRegex); 
	var flag=reg.test(field.val());
	if(!flag){
	    return "* 地址格式不正确";
	}
}


