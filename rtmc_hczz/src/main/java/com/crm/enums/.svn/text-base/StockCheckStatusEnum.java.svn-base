package com.crm.enums;

public enum StockCheckStatusEnum implements NameValueEnum{
	PendingConfirmation(0,"待确认"),
	HasCconfirmed(1,"已确认"),
	ConfirmedNotThrough(2,"确认未通过"),
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
		for (StockCheckStatusEnum enums : StockCheckStatusEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private StockCheckStatusEnum(Integer value, String displayName) {
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
