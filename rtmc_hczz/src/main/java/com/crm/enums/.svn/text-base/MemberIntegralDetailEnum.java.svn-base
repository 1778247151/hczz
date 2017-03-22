package com.crm.enums;


public enum MemberIntegralDetailEnum  implements NameValueEnum{
    PLATFORM(1,"平台调整"),
    SALEROOM(2,"销售积分"),	
    SELLRETURN(3,"销售退货"),
    CREDITSEXCHANGE(4,"购物中心积分兑换"),
    WECHATINTEGRAL(5,"微信积分"),
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
		for (MemberIntegralDetailEnum enums : MemberIntegralDetailEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private MemberIntegralDetailEnum(Integer value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}
	
	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return displayName;
	}

	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		return value;
	}
}
