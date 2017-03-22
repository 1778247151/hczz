//扩展方法
$.fn.extend({ 
	/**
	 * 编辑器
	 */
	kindEditor:function(){
		var obj=this;
		KindEditor.ready(function(K) {
			var id=obj.attr("id");
			if(id==undefined){
				alert("未指定编辑器的id！");
				return;
			}
			var editor = K.create('#'+id, {
				cssPath : 'plugins/kindeditor/plugins/code/prettify.css',
				uploadJson : 'plugins/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'plugins/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true	,
				afterBlur:function(){
					this.sync();
				}
			});
		});
	}
});