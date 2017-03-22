package com.crm.enums;

public enum gwGoodsIsBorrowed implements NameValueEnum{
	type_ENABL(0,"不能外借"),
	type_ENABLE(1,"可以外借"),
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
		for (gwGoodsIsBorrowed enums : gwGoodsIsBorrowed.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private gwGoodsIsBorrowed(Integer value, String displayName) {
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
