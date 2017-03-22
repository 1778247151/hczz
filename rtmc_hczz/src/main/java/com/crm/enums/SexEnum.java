package com.crm.enums;

public enum SexEnum implements NameValueEnum {
	
	MALE(0,"男"),
	FEMALE(1,"女");
	
    /**
     * 数据库对应的值
     */
    private Integer value;
	/**
	 * 页面显示的值根据id的值来显示 相应的状态 
	 */
	private String displayName;
	
	public static String getDisplayName(Integer value){
		for (SexEnum enums : SexEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private SexEnum(Integer value, String displayName) {
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
