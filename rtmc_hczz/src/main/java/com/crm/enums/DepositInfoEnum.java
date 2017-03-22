package com.crm.enums;

public enum DepositInfoEnum implements NameValueEnum{
	confirm(1,"新增(待审核 )(1)"),
	passconfirm(2,"确认审核(2)"),
	unconfirm(3,"取消审核(3)")
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
		for (DepositInfoEnum enums : DepositInfoEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private DepositInfoEnum(Integer value, String displayName) {
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
