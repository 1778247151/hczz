package com.crm.enums;

/**
 * 注册类型
 * RegisterTypeEnum:
 *
 */
public enum RegisterTypeEnum implements NameValueEnum{
	/**
	 * 1-汇金广场
	 */
	TYPE_ONE(1,"汇金广场"),
	/**
	 * 2-猫酷
	 */
	TYPE_TWO(2,"猫酷")
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
		for (RegisterTypeEnum enums : RegisterTypeEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private RegisterTypeEnum(Integer value, String displayName) {
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
