package com.crm.enums;

public enum LeaseMaintenanceEnum implements NameValueEnum{
	type_ENABL(0,"未归还"),
	type_ENABLE(1,"已归还"),

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
		for (LeaseMaintenanceEnum enums : LeaseMaintenanceEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private LeaseMaintenanceEnum(Integer value, String displayName) {
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
