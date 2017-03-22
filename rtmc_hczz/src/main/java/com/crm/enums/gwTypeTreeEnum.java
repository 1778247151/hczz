package com.crm.enums;
/**
 * 
 * gwTypeTreeStatusEnum:
 * 类型管理表（gw_type_tree）的数据类型枚举
 * @author hemingjun
 * @date  2016年9月6日
 * @version  jdk1.8
 *
 */
public enum gwTypeTreeEnum implements NameValueEnum{
	/**
	 * 01-会员级别
	 */
	type_ONE("01","会员级别"),
	/**
	 * 02-会员注册类型
	 */
	type_TWO("02","会员注册类型"),
	/**
	 * 03-客诉类型
	 */
	type_THREE("03","客诉类型"),
	/**
	 * 04-客诉意见类型
	 */
	type_FOUR("04","客诉意见类型"),
	/**
	 * 05-会员等级
	 */
	type_FIVE("05","会员等级"),
	/**
	 * 06-仓库类型
	 */
	type_SIX("06","仓库类型"),
	;
    /**
     * 数据库对应的值
     */
    private String value;
	/**
	 * 页面显示的值
	 */
	private String displayName;
	
	public static String getDisplayName(String value){
		for (gwTypeTreeEnum enums : gwTypeTreeEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private gwTypeTreeEnum(String value, String displayName) {
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
		return null;
	}
	public String getStringValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
