package com.crm.enums;

public enum ConstoretypeEnum implements NameValueEnum{
	type_ENABL(0,"无销售"),
	type_ENABLE(1,"租用pos机"),
	type_FORBIDDEN(2,"接口对接"),
	type_FORBIDDE(3,"手工录入或提交"),
	type_FORBIDD(4,"其他"),
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
		for (ConstoretypeEnum enums : ConstoretypeEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private ConstoretypeEnum(Integer value, String displayName) {
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
