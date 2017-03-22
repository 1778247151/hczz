/**
 * 描述:jquery validate扩展方法(自定义验证)
 * 
 * @author yumaochun
 * @date   2016-08-29
 */
//验证是否为空
$.validator.addMethod("notnull",function(value, element, regexp) {
    if (!value) return true;
    return ! $(element).hasClass("l-text-field-null");
},"不能为空");

//验证字符只能为字母、数字、下划线
$.validator.addMethod("letters",function(value, element, regexp) {
    //只能输入字母、数字、下划线
    var regLetters = /^[a-zA-Z0-9_]{1,}$/;
    return this.optional(element) || regLetters.test(value);
},"只能输入字母、数字、下划线");

//验证身份证号
$.validator.addMethod("idCard",function(value, element, regexp) {
    //15位和18位身份证号码的正则表达式
    var flag = idCardNoUtil.checkIdCardNo(value);
    return this.optional(element) || flag;
},"身份证号码格式不正确");
//护照编号验证
$.validator.addMethod("passport",function(value, element) {
    return this.optional(element) || checknumber(value);
},"请正确输入您的护照编号");

// 手机号码验证 
$.validator.addMethod("isMobile",function(value, element) {
    var length = value.length;
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
},"请正确填写您的手机号码");

// 电话号码验证 
$.validator.addMethod("isTel",function(value, element) {
    var tel = /^\d{3,4}-?\d{7,9}$/; //电话号码格式010-12345678 
    return this.optional(element) || (tel.test(value));
},"请正确填写您的电话号码");

// 联系电话(手机/电话皆可)验证 
$.validator.addMethod("isPhone",function(value, element) {
    var length = value.length;
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
    var tel = /^\d{3,4}-?\d{7,9}$/;
    return this.optional(element) || (tel.test(value) || mobile.test(value));
},"请正确填写您的联系电话");

// 邮政编码验证 
$.validator.addMethod("isZipCode",function(value, element) {
    var tel = /^[0-9]{6}$/;
    return this.optional(element) || (tel.test(value));
},"请正确填写您的邮政编码");