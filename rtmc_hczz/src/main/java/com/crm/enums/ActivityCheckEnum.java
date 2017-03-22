package com.crm.enums;

/**
 * 
 * ActivityCheckEnum:活动审核结果枚举
 *
 */
public enum ActivityCheckEnum implements NameValueEnum{
	
	UNCHECK(1,"待审核"),
	ALREADYCHECK(2,"已审核"),
	ENROLLING(3,"活动报名中"),
	BEUNDERWAY(4,"活动结束报名"),
	FINISHED(5,"活动进行中"),
	FINISHE(6,"活动已结束")
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
		for (ActivityCheckEnum enums : ActivityCheckEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private ActivityCheckEnum(Integer value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return displayName;
	}
	public Integer getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
