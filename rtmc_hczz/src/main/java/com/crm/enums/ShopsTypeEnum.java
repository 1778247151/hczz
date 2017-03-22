package com.crm.enums;

public enum ShopsTypeEnum implements NameValueEnum{
	normal(1,"正常"),
	meger(2,"合并单元"),
	split(3,"拆分单元"),
	AREA_CHANGE(4,"面积变更单元"),
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
		for (ShopsTypeEnum enums : ShopsTypeEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private ShopsTypeEnum(Integer value, String displayName) {
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
