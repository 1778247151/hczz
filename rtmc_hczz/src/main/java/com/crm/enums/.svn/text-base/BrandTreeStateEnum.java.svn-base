package com.crm.enums;

public enum BrandTreeStateEnum implements NameValueEnum{
	CONFIRM(1,"新增(待审核 )(1)"),
	PASSCONFIRM(2,"确认审核(2)"),
	UNCONFIRM(3,"取消审核(3)"),
	DELETE(0,"删除")
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
		for (BrandTreeStateEnum enums : BrandTreeStateEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private BrandTreeStateEnum(Integer value, String displayName) {
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
