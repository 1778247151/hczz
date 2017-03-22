package com.crm.enums;

public enum ShopsLeaseStateEnum implements NameValueEnum{
	type_ENABL(0,"删除"),
	type_ENABLE(1,"正常"),
	type_ENAB(2,"锁定"),
	type_ENA(3,"已签约"),
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
		for (ShopsLeaseStateEnum enums : ShopsLeaseStateEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private ShopsLeaseStateEnum(Integer value, String displayName) {
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
