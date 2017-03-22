package com.crm.enums;

/**
 * 
 * LockerEnum:储物柜枚举
 *
 */
public enum LockerEnum implements NameValueEnum{
	
	UNCHECK(0,"空置中"),
	ALREADYCHECK(1,"已出租"),
	ENROLLING(2,"已逾期"),
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
		for (LockerEnum enums : LockerEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private LockerEnum(Integer value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return displayName;
	}
	public Integer getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
