package com.crm.enums;

/**
 * 
 * LockerRentalMethodEnum:租借方式枚举
 *
 */
public enum LockerRentalMethodEnum implements NameValueEnum{
	
	UNCHECK(0,"先付"),
	ALREADYCHECK(1,"后付"),
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
		for (LockerRentalMethodEnum enums : LockerRentalMethodEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private LockerRentalMethodEnum(Integer value, String displayName) {
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
