package com.crm.enums;
/**
 * 
 * gwTypeTreeStatusEnum:
 * 类型管理表（gw_type_tree）的状态枚举
 * @author hemingjun
 * @date  2016年9月6日
 * @version  jdk1.8
 *
 */
public enum gwTypeTreeStatusEnum implements NameValueEnum{
	type_delete(0,"禁用"),
	type_normal(1,"正常"),
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
		for (gwTypeTreeStatusEnum enums : gwTypeTreeStatusEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private gwTypeTreeStatusEnum(Integer value, String displayName) {
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
