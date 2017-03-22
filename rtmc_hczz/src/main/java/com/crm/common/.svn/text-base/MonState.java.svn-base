package com.crm.common;


public class MonState {
	
	public static final int NORESPHOSE = -1;
	public static final int ACTIVE = 1;
	public static final int NOTACTIVE = 0;
	public static final int CAM = 2;
	public static final int DVR = 1;
	public static final int MENU = 0;
	public static final int VAC_SUCCESS = 0;
	public static final int VAC_ERROR = 1;
	public static final String privateKey = "uj5hy6&tha8dhtwnh!2oi%dsjskj-ll@lk%^67*sjdyy64o=8mnch+-874h5jk976267oijt58$l864%&nd&,xbbdawq2140-$09lio86tY98fds35098kkjju890kj";
	//public static final String privateKey = "123456";
	public static final int SUBSCRIBER = 1;
	public static final int UNSUBSCRIBER =2;
	public static final int ORDER =3;
	public static final int CHANGEORDER =4;
	public static final int CHANGENUMBER =5;
	public static final int SMSSUCCESS =20;
	public static final int SMSWAIT =21;
	public static final int SMSFAILE =22;
	/**
	 * 数据类型，0：整型，1：浮点型，2：字符串型
	 */
	public static final int NUM = 0;
	public static final int DOUBLE = 1;
	public static final int STRING = 2;
	/**
	 * 客户端类型，0：PC客户端，1：IPHONE，2：IPAD，3：安卓手机，4：安卓平板
	 * @param type
	 * @return
	 */
	public static final int PC = 1;
	public static final int IPHONE = 2;
	public static final int IPAD = 4;
	public static final int ANDROIDMOBILE = 3;
	public static final int ANDROIDPAD = 5;
	public static final int WEBOCX = 6;
	
	public static String getPCType(String type)
	{
		if(type!=null)
		{
			switch (Integer.parseInt(type)) {
			case PC:
				return "PC客户端";
			case IPHONE:
				return "IPHONE";
			case IPAD:
				return "IPAD";
			case ANDROIDMOBILE:
				return "安卓手机";
			case ANDROIDPAD:
				return "安卓平板";
			case WEBOCX:
				return "WEB控件";
			}
		}
		return "";
	}
	
	public static String getState(int type)
	{
		switch (type) {
		case ACTIVE:
			return "激活";
		case NOTACTIVE:
			return "未激活";
		}
		return "";
	}
	
	public static String getSmovStrus(String type)
	{
		if(type==null)
			return "";
		else if("".equals(type))
			return "";
		else if("1".equals(type))
			return "<span class=\"actives\">正常</span>";
		else if("0".equals(type))
			return "<span class=\"stopd\">暂停</span>";
		return "";
	}
	
	public static String getSmovAdminStrus(String type)
	{
		if(type==null)
			return "";
		else if("".equals(type))
			return "";
		else if("2".equals(type))
			return "<span class=\"actives\">正常</span>";
		else if("1".equals(type))
			return "<span class=\"stopd\">暂停</span>";
		return "";
	}
	
	public static String getSmovFactoryName(String type)
	{
		if(type==null)
			return "";
		else if("".equals(type))
			return "";
		else if("999".equals(type))
			return "大华";
		else if("2000".equals(type))
			return "黄河";
		else if("2001".equals(type))
			return "金三立";
		else if("2001".equals(type))
			return "海康";
		return "";

	}
	
	public static String getSmovAdminType(String type)
	{
		if(type==null)
			return "";
		else if("".equals(type))
			return "";
		else if("1".equals(type))
			return "地市产品经理";
		else if("2".equals(type))
			return "集团客户产品管理员";
		return "";
	}
	
	public static String getOnline(int type)
	{
		switch (type) {
		case ACTIVE:
			return "在线";
		case NOTACTIVE:
			return "离线";
		}
		return "";
	}
	
	public static String getOpType(int type)
	{
		switch (type) {
		case ACTIVE:
			return "删除";
		case NOTACTIVE:
			return "添加";
		}
		return "";
	}
	
	public static String getOrderType(int type)
	{
		switch (type) {
		case ACTIVE:
			return "退订";
		case NOTACTIVE:
			return "订购";
		}
		return "";
	}
	
	public static String getCompanyState(int type)
	{
		switch (type) {
		case ACTIVE:
			return "检测成功";
		case NOTACTIVE:
			return "初始状态";
		case UNSUBSCRIBER:
			return "检测失败";
		}
		return "";
	}
	
	public static String getDataType(String type)
	{
		if(type!=null)
		{
			switch (Integer.parseInt(type)) {
			case NUM:
				return "整型";
			case DOUBLE:
				return "浮点型";
			case STRING:
				return "字符串型";
			}
		}
		return "";
	}
	
	public static String getDevType1(int type)
	{
		switch (type) {
		case ACTIVE:
			return "摄像机";
		case NOTACTIVE:
			return "DVR";
		}
		return "";
	}
	
	public static String getServerState(int type)
	{
		switch (type) {
		case ACTIVE:
			return "启用";
		case NOTACTIVE:
			return "禁用";
		}
		return "";
	}
	
	public static String getDevType(int type)
	{
		switch (type) {
		case CAM:
			return "摄像机";
		case DVR:
			return "DVR";
		}
		return "";
	}
	
	public static String getUpdateDisType(String type)
	{
		if(type==null)
			return "";
		else
		{
			switch (Integer.parseInt(type)) {
			case DVR:
				return "新版本但可以不升级";
			case CAM:
				return "有新版本必须升级才可以使用";
			}
		}
		return "";
	}
	
	public static String getConnectionType(int type)
	{
		switch (type) {
		case ACTIVE:
			return "流媒体服务器模式";
		case NOTACTIVE:
			return "直连模式";
		case UNSUBSCRIBER:
			return "P2P穿透模式";
		case ORDER:
			return "流媒体穿透模式";
		}
		return "";
	}
	
	public static String getPfzType(int type)
	{
		switch (type) {
		case ACTIVE:
			return "支持";
		case NOTACTIVE:
			return "不支持";
		}
		return "";
	}
	
	public static String getLonglatType(int type)
	{
		switch (type) {
		case ACTIVE:
			return "设置";
		case NOTACTIVE:
			return "未设置";
		}
		return "";
	}
	
	public static String getUserPopDiscription(int type)
	{
		switch (type) {
		case ACTIVE:
			return "有";
		case NOTACTIVE:
			return "无";
		}
		return "";
	}
	
	public static String getDevCheckResponse(int value)
	{
		switch (value) {
		case NORESPHOSE:
			return "超时未收到应答包";
		case NOTACTIVE:
			return value+"";
		}
		return "";
	}
	
	public static String getDevIsRealplay(int type)
	{
		switch (type) {
		case ACTIVE:
			return "在预览";
		case NOTACTIVE:
			return "未预览";
		}
		return "";
	}
	
	public static String getDevIfPhone(int type)
	{
		switch (type) {
		case ACTIVE:
			return "是";
		case NOTACTIVE:
			return "否";
		}
		return "";
	}
	
	public static String getDevIsRecording(int type)
	{
		switch (type) {
		case ACTIVE:
			return "在录像";
		case NOTACTIVE:
			return "未录像";
		}
		return "";
	}
	
	public static String getSMSSendStatus(int type)
	{
		switch (type) {
		case NOTACTIVE:
			return "未发送";
		case ACTIVE:
			return "已发送";
		case SMSSUCCESS:
			return "发送成功";
		case SMSWAIT:
			return "等待发送";
		case SMSFAILE:
			return "发送失败";
		}
		return "";
	}
	
	public static String getSMSSendType(String type)
	{
		if(type==null)
			return "";
		if(type.equals("SEC"))
			return "验证码短信";
		if(type.equals("OPEN"))
			return "开机通知";
		if(type.equals("CLOSE"))
			return "关机通知";
		else
			return "";
	}
	
	public static String getIpCompany(String type)
	{
		if(type==null)
			return "";
		if(type.equals("0"))
			return "电信";
		if(type.equals("1"))
			return "联通";
		if(type.equals("2"))
			return "移动";
		else
			return "";
	}
	
	public static String fomartNum(int num)
	{
		return (Double.parseDouble(num+"")/1000000)+"";
	}
	
	public static String getXjsCheckDiscription(String values)
	{
		if(values==null)
			return "";
		if(values.equals("0"))
			return "正常";
		if(!values.equals("0"))
			return "故障";
		else
			return "";
	}
	
	public static String getDevDisciption(String message)
	{
		return message.replace("VendorId=", "设备厂商编号：").replace("DevId=", "设备编号：")
		.replace("DevChNo=", "通道编号：").replace("DevPort=", "设备端口号：")
		.replace("DevUserName=", "连接用户名：").replace("DevUserPwd=", "连接密码：").replace("DevIp=", "设备IP地址：").replace(",", "，");
	}
}
