package com.crm.enums;

import com.crm.enums.AdminUserStatusEnum;
import com.crm.enums.NameValueEnum;

/**
 * 
 * AdminUserStatusEnum:管理员用户状态值信息
 *
 * @author yumaochun
 * @date 2016年3月3日 下午3:30:56
 */
public enum AdminUserStatusEnum implements NameValueEnum{
	HAS_DEL(-1,"删除"),
	FREEZE(0,"冻结"),
	NORMAL(1,"正常"),
	quit(2,"离职")
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
		for (AdminUserStatusEnum enums : AdminUserStatusEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private AdminUserStatusEnum(Integer value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Integer getValue() {
		return value;
	}

}
