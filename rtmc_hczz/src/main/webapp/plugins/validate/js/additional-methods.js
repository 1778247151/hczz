// 中文字两个字节
jQuery.validator.addMethod(
    "byteRangeLength", 
    function(value, element, param) {
        var length = value.length;
        for(var i = 0; i < value.length; i++){
            if(value.charCodeAt(i) > 127){
                length++;
            }
        }
        return this.optional(element) || (length >= param[0] && length <= param[1]);   
    }, 
    $.validator.format("请确保输入的值在{0}-{1}个字节之间(一个中文字算2个字节)")
);
/**
 * 验证手机号码格式
 */
jQuery.validator.addMethod(
    "phone", 
    function(value, element, param) {
    	var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
        return this.optional(element) ||(reg.test(value)); 
    }, 
    $.validator.format("手机号码格式不正确")
);
/**
 * 验证是否包含中文
 */
jQuery.validator.addMethod(
    "isHasChinese", 
    function(value, element, param) {
    	var reg = /.*[\u4e00-\u9fa5]+.*$/;
        return this.optional(element) ||(!reg.test(value)); 
    }, 
    $.validator.format("用户账号不能包含中文")
);
/**
 * 户名只能由字母数字下划线和@组成
 */
jQuery.validator.addMethod(
    "checkAccount", 
    function(value, element, param) {
    	var reg = /^[a-zA-Z0-9_@.]{1,}$/;
        return this.optional(element) ||(reg.test(value)); 
    }, 
    $.validator.format("用户账号只能由字母、数字、下划线@.组成")
);