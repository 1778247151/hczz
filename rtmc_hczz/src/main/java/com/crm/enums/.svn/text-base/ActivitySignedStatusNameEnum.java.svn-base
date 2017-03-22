package com.crm.enums;

/**
 * 
 * AdminUserStatusEnum:管理员用户状态值信息
 *
 * @author yumaochun
 * @date 2016年3月3日 下午3:30:56
 */
public enum ActivitySignedStatusNameEnum implements NameValueEnum{
	FREEZE(0,"未签到"),
	NORMAL(1,"已签到")
	;

	/**
     * 数据库对应的值
     */
    private Integer value;
	/**
	 * 页面显示的值
	 */
	private String displayName;
	
	public static String getDisplayName(Integer value){
		for (ActivitySignedStatusNameEnum enums : ActivitySignedStatusNameEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private ActivitySignedStatusNameEnum(Integer value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Integer getValue() {
		return value;
	}

}
