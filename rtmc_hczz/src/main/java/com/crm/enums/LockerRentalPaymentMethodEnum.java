package com.crm.enums;

/**
 * 
 * LockerRentalMethodEnum:付款方式枚举
 *
 */
public enum LockerRentalPaymentMethodEnum implements NameValueEnum{
	
	UNCHECK(0,"现金"),
	ALREADYCHECK(1,"积分"),
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
		for (LockerRentalPaymentMethodEnum enums : LockerRentalPaymentMethodEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private LockerRentalPaymentMethodEnum(Integer value, String displayName) {
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
