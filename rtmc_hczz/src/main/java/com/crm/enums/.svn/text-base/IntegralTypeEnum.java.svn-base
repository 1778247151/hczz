package com.crm.enums;
/**
 * 
 * IntegralTypeEnum:积分类型枚举
 *
 * @author hemingjun
 * @date  2016年9月20日
 * @version  jdk1.8
 *
 */
public enum IntegralTypeEnum implements NameValueEnum{
	/**
	 * 1-销售积分
	 */
	SALES(1,"销售积分"),
	/**
	 * 2-礼品兑换(扣分)
	 */
	GIFTEXCHANGE(2,"礼品兑换(扣分)"),
	/**
	 * 3-活动兑换(扣分)
	 */
	ACTIVECHANGE(3,"活动兑换(扣分)"),
	/**
	 * 4-第三方平台(增减积分)
	 */
	THIRDPARTY(4,"第三方平台(增减积分)")
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
		for (IntegralTypeEnum enums : IntegralTypeEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private IntegralTypeEnum(Integer value, String displayName) {
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
