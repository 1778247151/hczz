package com.crm.enums;

/**
 * 
 * LockerEnum:储物柜枚举
 *
 */
public enum LockerRentalEnum implements NameValueEnum{
	
	UNCHECK(0,"已归还"),
	ALREADYCHECK(1,"租借中"),
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
		for (LockerRentalEnum enums : LockerRentalEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private LockerRentalEnum(Integer value, String displayName) {
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
