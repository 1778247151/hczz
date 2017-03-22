$(function(){
	
	//初始化系统名称
	
	
});

//关闭模态窗体
function closeDialog(){
	//$(".l-dialog,.l-window-mask").remove(); 
	$(".l-dialog,.l-window-mask").css("display","none");
    $.ligerDialog.close();    
}



/*******************公共方法***************************/

//退出系统
function exitSystem(){
	$.ligerDialog.confirm($.i18n.prop("main.alert.exitMsg"), $.i18n.prop("alert.title"), function(yes) {
		if (yes) {
			$.ocx.exit();
			 if ($.sys.getCookie("rmbUser") != "true") { 	
			    $.sys.removeCookie("username");
			    $.sys.removeCookie("password");
			 }
			location.href="/";
		}
	});
}


/**
 * func:修改密码
 * 
 * @param account        账号
 * @param oldPwd         旧密码
 * @param newPwd         新密码
 * @returns
 */
function resetUserPwd(account,oldPwd,newPwd){
	//alert(account+","+oldPwd+","+newPwd);
	var data=$.ocx.modifyUserPwdEx(account,oldPwd,newPwd);
    return data;
}

/**
 * 
 * des: 提示框
 * 
 * @param content
 *            提示信息
 * @param title
 *            提示标题
 * @param type
 *            提示类型：success，warn，question，error，confirm，warning，prompt，waitting
 * @param callback
 *            回调方法
 */
function dialogAlert(content, title, type, callback) {
	$.ligerDialog.alert(content, title, type, callback);
}
/**
 * des:成功提示框
 * 
 * @param content
 *            提示内容
 * @param callback
 *            回调方法
 */
function dialogSuccess(content, callback) {
	$.ligerDialog.alert(content, "提示信息", "success", callback);
}
/**
 * des:失败提示框
 * 
 * @param content
 *            提示内容
 * @param callback
 *            回调方法
 */
function dialogError(content, callback) {
	$.ligerDialog.alert(content, "提示信息", "error", callback);
}
/**
 * des:提问提示框
 * 
 * @param content
 *            提示内容
 * @param callback
 *            回调方法
 */
function dialogQuestion(content, callback) {
	$.ligerDialog.alert(content, "提示信息", "question", callback);
}
/**
 * des:警告提示框
 * 
 * @param content
 *            提示内容
 * @param callback
 *            回调方法
 */
function dialogWarn(content, callback) {
	$.ligerDialog.alert(content, "提示信息", "warn", callback);
}
/**
 * des:确认提示框
 * 
 * @param content
 *            提示内容
 * @param callback
 *            回调方法
 */
function dialogConfirm(content, callback) {
	$.ligerDialog.confirm(content, '提示信息', function(yes) {
		if (yes) {
			callback();
		}
	});
}
/**
 * des:加载提示框
 * 
 * @param content
 *            提示内容
 * @param time
 *            显示时间
 */
function dialogWaitting(content, time) {
	$.ligerDialog.waitting(content);
	setTimeout(function() {
		$.ligerDialog.closeWaitting();
	}, time);
}
function dialogTop(content,callback){
	var option={top:0};
	$.ligerDialog.alert(content, "提示信息", "warn", callback,option);
}

