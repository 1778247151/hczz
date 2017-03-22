package com.crm.enums;

public enum CardStateEnum implements NameValueEnum{
	CONFIRM(0,"未使用"),
	PASSCONFIRM(1,"正在使用"),
	UNCONFIRM(2,"挂失"),
	DELETE(3,"失效")
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
		for (CardStateEnum enums : CardStateEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private CardStateEnum(Integer value, String displayName) {
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
