package com.crm.enums;

public enum MerchantsInfoZTypeEnum implements NameValueEnum{
	Ztype_ENABLE(1,"个人"),
	Ztype_FORBIDDEN(2,"企业")
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
		for (MerchantsInfoZTypeEnum enums : MerchantsInfoZTypeEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private MerchantsInfoZTypeEnum(Integer value, String displayName) {
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
