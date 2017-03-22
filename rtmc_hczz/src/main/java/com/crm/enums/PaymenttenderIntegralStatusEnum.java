package com.crm.enums;

/**
 * 
 * PaymenttenderIntegralStatusEnum:支付方式是否积分枚举
 *
 */
public enum PaymenttenderIntegralStatusEnum implements NameValueEnum{
	/**
	 * 积分：1
	 */
	YES(1,"积分"),
	/**
	 * 不积分：0
	 */
	NO(0,"不积分")
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
		for (PaymenttenderIntegralStatusEnum enums : PaymenttenderIntegralStatusEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private PaymenttenderIntegralStatusEnum(Integer value, String displayName) {
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
