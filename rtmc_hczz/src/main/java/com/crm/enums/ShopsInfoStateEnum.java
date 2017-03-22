package com.crm.enums;
import com.crm.enums.ShopsInfoStateEnum;
import com.crm.enums.NameValueEnum;

/**
 * 
 * ShopsInfoStateEnum:单元信息状态枚举
 *
 * @author hemingjun
 * @date  2016年9月13日
 * @version  jdk1.8
 *
 */
public enum ShopsInfoStateEnum implements NameValueEnum{
	delete(0,"删除"),
	new_checkPending(1,"新增(待审核)"),
	Approve(2,"空置"),
	cancel_approve(3,"取消确认"),
	lock(4,"预定"),
	readonly(5,"使用中"),
	failure(6,"失效"),
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
		for (ShopsInfoStateEnum enums : ShopsInfoStateEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private ShopsInfoStateEnum(Integer value, String displayName) {
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
