/**
 *  ocx基础方法工具
 */

//服务器地址
var serverAddress="app.umeye.cn";
//服务器端口
var serverPort=8300;

var version="v2.4.8.4";

(function($){
	window.ocx = $.ocx = {
		
		 //ocx登录
		login:function(userName,password){
			//alert("username:"+userName);
	        //获取ocx对象
	        var ocxObj = document.getElementById("NpcMonOcx");
	        //客户端ID(可由自己填写,小于32个字符)
	        var clientID="000000";
	        //登录模式：0为通过服务器登录获取列表，1为本地登录
	        var loginType=0;
	        //ocx登录
            var data=ocxObj.OnLogin(serverAddress,serverPort,userName,password,clientID,loginType);
//            $.sys.setCookie("username",userName,1);
//            //alert("cookie:"+$.sys.getCookie("username"));
//            //加密
//            password=$.base64.encode(password);
//	        $.sys.setCookie("password",password,1);
		},
		//已经登录了用户  再次登录
		userLogin:function(){
			var userName=$.sys.getCookie("username");
	        var password=$.sys.getCookie("password");
	        password=$.base64.decode(password);
			if(userName==null||userName==""||userName==undefined){
				location.href="../html/login.html";
				return;
			}
			$.ocx.login(userName,password);
		},
		
		
		//获取登录状态（是否登录成功）
		getLoginState:function(){
			var ocxBox = document.getElementById("NpcMonOcx");
	        var stateObj = ocxBox.OnGetSystemState();
	        var dataObj = eval("(" + stateObj + ")");
	        var state = dataObj.iRet;
	        return state;
		},
		/**
		 * func:注册用户
		 * @param     account      账号
		 * @param     pwd          密码
		 * @param     email        邮箱号
		 * @param     username     用户真实姓名
		 * @param     phone        手机号
		 * @return    返回：成功或失败
		 *
		 */
		regUser:function(account,pwd,email,username,phone){
			
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnRegUser(serverAddress,serverPort,account,pwd,email,username,phone);
		},
		//找回密码
		retrievePwd:function(account,email){
			
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnRetrievePwd(serverAddress,serverPort,account,email);
		},
		//退出ocx
		exit:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
	        ocxObj.onExit();
	        $("#NpcMonOcx").remove();
		},
		//设置的当前显示画面的数量,可以设置为1,4,9,16,25,36.
		setVideoPlayCount:function(count){
			var ocxObj = document.getElementById("NpcMonOcx");
			ocxObj.OnSetVideoPlayCount(count);
		},
		//设置显示界面的宽高
		setRect:function(width,height){
			var ocxObj = document.getElementById("NpcMonOcx");
			ocxObj.OnSetRect(width,height);
		},
		//你要播放的设备的设备ID,这个设备可以是摄像头也可以是DVR,如果是DVR,则会打开DVR下面所有的镜头
		playByDevId:function(deviceId){
			var ocxObj = document.getElementById("NpcMonOcx");
			ocxObj.OnPlayByDevId(deviceId);
		},
		//获取选中的窗口编号
		getChoosedState:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnGetChoosedState();
		},
		//设置显示界面全屏
		setFullScreen:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			ocxObj.OnSetFullScreen();
		},
		//让显示界面重画
		redrawWindow:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			ocxObj.OnRedrawWindow();
		},
		
		//获取用户所有设备
		getDevList:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnGetDevList();
		},
		//根据父级节点id,获取下级设备
		getChildDevListByNodeId:function(parentId){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnGetChildDevListByNodeId(parentId);
		},
		//根据父级节点id,获取下级设备
		getNextLayerDevListByNodeId:function(parentId){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnGetNextLayerDevListByNodeId(parentId);
		},
		/**
		 * 根据设备名称模糊查找设备列表
		 * @param devName               需要查找的设备
		 * @returns
		 */
		getDevListByDevNameEx:function(devName){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnGetDevListByDevNameEx(devName);
		},
		/**
		 * 根据设备名称搜索设备 
		 * @param parentNodeId      父级节点
		 * @param queryMode         查询模式 0:查找当前一级  1:嵌套查询
		 * @param nodeName          结点名(可以是结点名的部分)
		 * @param nodeType          结点类型 0:ALL  1:DIR   2: DVR  3: CAMERA    4:IPC
		 * @returns
		 */
		getDevListFuzzyByName:function(parentNodeId,queryMode,nodeName,nodeType){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnNoteFuzzyQueryByName(parentNodeId,queryMode,nodeName,nodeType);
		},
		/**
		 * func:通过UMID添加P2P镜头
		 * @param     pParentNodeID 父级设备id
		 * @param     pName 父级设备名称
		 * @param     pUserName     用户名称
		 * @param     pUserPwd      密码
		 * @param     iStreamNo     码流
		 * @param     iChNum        通道号
		 *
		 */
		addP2pCloudCamera:function(pParentNodeID,pName,pDevId,pUserName,pUserPwd,iStreamNo,iChNum){
			var ocxObj = document.getElementById("NpcMonOcx");
		    return ocxObj.OnAddP2pCloudCamera(pParentNodeID,pName,pDevId,pUserName,pUserPwd,iStreamNo,iChNum);	
		},
		/**
		 * func:通过UMID添加P2P设备
		 * @param     pParentNodeID 父级设备id
		 * @param     pName 父级设备名称
		 * @param     pUserName     用户名称
		 * @param     pUserPwd      密码
		 * @param     iStreamNo     码流
		 * @param     iChNum        通道号
		 *
		 */
		addP2pCloudCloudDev:function(pParentNodeID,pName,pDevId,pUserName,pUserPwd,iStreamNo,iChNum){
			var ocxObj = document.getElementById("NpcMonOcx");
		    return ocxObj.OnAddP2pCloudDev(pParentNodeID,pName,pDevId,pUserName,pUserPwd,iStreamNo,iChNum);	
		},
		/**
		 * func:通过IP添加直连设备
		 * @param     pParentNodeID 父级设备id
		 * @param     vendorId      厂商id
		 * @param     pName         设备名称
		 * @param     devAddr       设备地址
		 * @param     devPort       设备端口
		 * @param     userName      用户名称
		 * @param     pUserPwd      密码
		 * @param     iStreamNo     码流
		 * @param     iChNum        通道号
		 *
		 */
		addDirectDev:function(pParentNodeID,vendorId,pName,devAddr,devPort,userName,pUserPwd,iStreamNo,iChNum){
			var ocxObj = document.getElementById("NpcMonOcx");
		    return ocxObj.OnAddDirectDev(pParentNodeID,vendorId,pName,devAddr,devPort,userName,pUserPwd,iStreamNo,iChNum);	
		},
		/**
		 * func:通过IP添加直连镜头
		 * @param     pParentNodeID 父级设备id
		 * @param     vendorId      厂商id
		 * @param     pName         设备名称
		 * @param     devAddr       设备地址
		 * @param     devPort       设备端口
		 * @param     userName      用户名称
		 * @param     pUserPwd      密码
		 * @param     iStreamNo     码流
		 * @param     iChNum        通道号
		 *
		 */
		addDirectCamera:function(pParentNodeID,vendorId,pName,devAddr,devPort,userName,pUserPwd,iStreamNo,iChNum){
			var ocxObj = document.getElementById("NpcMonOcx");
		    return ocxObj.OnAddDirectCamera(pParentNodeID,vendorId,pName,devAddr,devPort,userName,pUserPwd,iStreamNo,iChNum);	
		},
		/**
		 * 修改P2P镜头连接参数
		 * @param devId                设备id
		 * @param umid                 umid
		 * @param username             用户名
		 * @param password             密码
		 * @param chNo                 通道号
		 * @param streamNo             码流类型 （0：主码流，1：子码流	）	
		 * @returns
		 */
		onModifyP2pCloudCamera:function(devId,umid,username,password,chNo,streamNo){
			var ocxObj = document.getElementById("NpcMonOcx");
		    return ocxObj.OnModifyP2pCloudCamera(devId,umid,username,password,chNo,streamNo);
		},
		/**
		 * 修改P2P设备连接参数
		 * @param devId              设备id
		 * @param umid               umid
		 * @param username           用户名
		 * @param password           密码
		 * @param streamNo           码流类型 （0：主码流，1：子码流	）	
		 * @returns
		 */
		onModifyP2pCloudDev:function(devId,umid,username,password,streamNo){
			var ocxObj = document.getElementById("NpcMonOcx");
		    return ocxObj.OnModifyP2pCloudDev(devId,umid,username,password,streamNo);
		},
		/**
		 * 修改直连镜头连接参数
		 * @param deviceId              设备id
		 * @param ip                    设备ip地址
		 * @param port                  设备端口号
		 * @param userName              设备用户名
		 * @param userPwd               设备密码
		 * @param chNo                  通道号
		 * @param streamNo              码流类型 （0：主码流，1：子码流	）
		 */	
		onModifyDirectCamera:function(deviceId,ip,port,userName,userPwd,chNo,streamNo){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnModifyDirectCamera(deviceId,ip,port,userName,userPwd,chNo,streamNo);
		},
		/**
		 * 修改直连设备连接参数
		 * @param deviceId          设备id
         * @param ip                设备ip
         * @param port              设备端口
         * @param userName          设备名称
         * @param userPwd           设备密码
         * @param streamNo          码流类型 （0：主码流，1：子码流	）
		 */
		onModifyDirectDev:function(deviceId,ip,port,userName,userPwd,streamNo){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnModifyDirectDev(deviceId,ip,port,userName,userPwd,streamNo);
		},
		
		/**
		 * func:根据设备id 修改设备名称
		 * @param     deviceId      设备id
		 * @param     deviceName    设备名称
		 */
		modifyNodeName:function(deviceId,deviceName){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnModifyNodeName(deviceId,deviceName);
		},
		/**
		 * func:根据设备id  获取设备信息
		 * @param     deviceId      设备id
		 */
		getDevConnParam:function(deviceId){
		    var ocxObj = document.getElementById("NpcMonOcx");
	        var data=ocxObj.OnGetDevConnParam(deviceId);
	        //alert(data);
	        var dataJson=eval("("+data+")");
	        return dataJson;	
		},
		/**
		 * func:根据设备id  删除设备
		 * @param     deviceId      设备id
		 * @return    返回状态
		 */
		delNode:function(deviceId){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnDelNode(deviceId);
		},
		//获取当前ocx的版本号
		getVersion:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnGetVersion();
		},
		//获取是否需要更新设备列表(可以不用)
		needUpdateList:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnNeedUpdateList();
		},
		//搜索本地设备
		getSearchDevInfo:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnGetSearchDevInfo();
		},
		//停止搜索设备
		stopSearchLocalDev:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnStopSearchLocalDev();
		},
		//开启搜索设备
		searchDev:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnSearchDev();
		},
		/**
		 * func:云台控制
		 * @param in_iVideoNum     窗口编号
		 * @param in_nCommand      命令
		 * @param in_nStepLen      步长
		 * @returns
		 */
		pTZControl:function(in_iVideoNum,in_nCommand,in_nStepLen){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnPTZControl(in_iVideoNum,in_nCommand,in_nStepLen);
		},
		/**
		 * 修改用户密码
		 * @param account
		 * @param oldPwd
		 * @param newPwd
		 * @returns
		 */
		modifyUserPwdEx:function(account,oldPwd,newPwd){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnModifyUserPwdEx(account,oldPwd,newPwd);
		},
		/**
		 * 上一页
		 */
		prePage:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			ocxObj.OnPrePage();
		},
		/**
		 * 下一页
		 */
		nextPage:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			ocxObj.OnNextPage();
		},
		/**
		 * 找回密码  验证账户信息是否存在
		 * @param account     需要找回的账号
		 * @param email       找回的邮箱验证
		 * @returns  返回结果集
		 */
		findUserPwdEx:function(account,email){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnFindUserPwdEx(account,email,serverAddress,serverPort);
		},
		/**
		 * 关闭通道号
		 * @param nCloseChannel   0-全关闭，1-1通道，2-2-通道
		 * @returns
		 */
		closeRealPlay:function(nCloseChannel){
			var ocxObj = document.getElementById("NpcMonOcx");
			//nCloseChannel   0-全关闭，1-1通道，2-2-通道
			return ocxObj.OnCloseRealPlay(nCloseChannel);
		},
		/**
		 * 播放DVR
		 * @param devId   设备id
		 * @returns
		 */
		realPlayDvrByNodeId:function(nodeId){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnRealPlayDvrByNodeId(nodeId);
		},
		/**
		 * Dvr全停止
		 * @param in_pDevId          设备id
		 */
		stopPlayByDevId:function(in_pDevId){
			var ocxObj = document.getElementById("NpcMonOcx");
			ocxObj.OnStopPlayByDevId(in_pDevId);
		},
		/**
		 * 获取登录用户的信息
		 */
		getUserData:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnGetUserData();
		},
		/**
		 * 添加设备列表目录
		 * @param parentId   上级节点ID
		 * @param dirName    目录名称
		 * @returns
		 */
		addDir:function(parentId,dirName){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnAddDir(parentId,dirName);
		},
		/**
		 * 删除目录
		 * @param nodeId   节点ID
		 * @returns
		 */
		delDirByNodeID:function(nodeId){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnDelNoteByNoteID(nodeId);
		},
		/**
		 * 修改目录名称
		 * @param nodeId    节点ID
		 * @param dirName   新目录名称
		 * @returns
		 */
		modifyNodeNameByNodeID:function(nodeId,dirName){
			var ocxObj = document.getElementById("NpcMonOcx");
			return ocxObj.OnModifyNodeNameByNodeID(nodeId,dirName);
		},
		/**
		 * 是否需要更新ocx插件
		 * @returns {Boolean}
		 */
		isUpdateVersion:function(){
			var ocxObj = document.getElementById("NpcMonOcx");
			var data=ocxObj.OnGetVersion();
			var dataJson=eval("("+data+")");
			//alert(dataJson.sRet+","+version);
			if(dataJson.sRet==version){
				return false;//不需要更新
			}else{
				return true;//需要更新
			}
			
		},
		
		//********************************************按设备登录方式 ，基本方法开始*************************************************
		/**
		 * 按设备方式登录		
		 * @param umid                       UMID
		 * @param userName                   设备用户
		 * @param password                   设备密码
		 * @returns
		 */
		onDevLogin:function(umid,userName,password){
			var ocxBox = document.getElementById("NpcMonOcx");
			return ocxBox.OnDevLogin(serverAddress,serverPort,umid,userName,password);
		},
		/**
		 * 按URL方式登录
		 * @param serverAddress           服务器地址
		 * @param serverPort              端口
		 * @param umid                    UMID
		 * @param userName                设备名称
		 * @param password                设备密码
		 * @returns
		 */
		urlLogin:function(serverAddress,serverPort,umid,userName,password){
			//alert(serverAddress+","+serverPort+","+umid+","+userName+","+password);
			var ocxBox = document.getElementById("NpcMonOcx");
			return ocxBox.OnDevLogin(serverAddress,serverPort,umid,userName,password);
		},
		/**
		 * 获取登录类型 
		 * @returns   iLoginMode 登录模式 //0:用户登录  1:设备登录	 其它:还未调用登录接口
		 */
		onGetLoginType:function(){
			var ocxBox = document.getElementById("NpcMonOcx");
			return ocxBox.OnGetLoginType();
		},
		/**
		 * 按设备方式登录，获取设备信息
		 * @returns
		 */
		onGetDevInfo:function(){
			var ocxBox = document.getElementById("NpcMonOcx");
			return ocxBox.OnGetDevInfo();
		},
		/**
		 * 按设备方式登录， 启动实时预览
		 * @param devChannle        通道号（从0开始，-1表示全播放）
		 * @param streamType        码流类型（0：主码流，1：子码流	）
		 */
		onDevChannleRealPlay:function(devChannle,streamType){
			var ocxBox = document.getElementById("NpcMonOcx");
			ocxBox.OnDevChannleRealPlay(devChannle,streamType);
		},
		/**
		 * 按设备方式登录， 停止实时预览
		 * @param devChannle        通道号（从0开始，-1表示全停止）
		 */
		onDevChannleRealPlayStop:function(devChannle){
			var ocxBox = document.getElementById("NpcMonOcx");
			ocxBox.OnDevChannleRealPlayStop(devChannle);
		}
		
		
		//********************************************按设备登录方式 ，基本方法结束*************************************************
    };
})(jQuery);