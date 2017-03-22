package com.crm.enums;

public enum IntegralExchangeGoodsStatusEnum implements NameValueEnum{
	type_ENABL(0,"禁用"),
	type_ENABLE(1,"启用"),
	type_ENAB(2,"活动待开始"),
	type_ENA(3,"活动进行中"),
	type_EN(4,"活动结束"),
	type_E(5,"强制终止"),
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
		for (IntegralExchangeGoodsStatusEnum enums : IntegralExchangeGoodsStatusEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private IntegralExchangeGoodsStatusEnum(Integer value, String displayName) {
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
