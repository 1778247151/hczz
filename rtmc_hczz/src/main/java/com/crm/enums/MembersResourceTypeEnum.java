package com.crm.enums;
/**
 * 
 * MembersResourceTypeEnum:会员来源类型
 *
 * @author hemingjun
 * @date  2016年9月20日
 * @version  jdk1.8
 *
 */
public enum MembersResourceTypeEnum implements NameValueEnum{
	/**
	 * 1-购物中心
	 */
	type_MALLINFO(1,"购物中心"),
	/**
	 * 2-猫酷
	 */
	type_CATKU(2,"猫酷")
	
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
		for (MembersResourceTypeEnum enums : MembersResourceTypeEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private MembersResourceTypeEnum(Integer value, String displayName) {
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
