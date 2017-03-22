package com.crm.enums;

/**
 * 
 * IntergralTypeEnum:积分类型
 *
 * @author hemingjun
 * @date  2016年11月7日
 * @version  jdk1.8
 *
 */
public enum IntergralTypeEnum implements NameValueEnum{
	/**
	 * 1-平台调整
	 */
	ADJUST(1,"平台调整"),
	/**
	 * 2-销售积分
	 */
	SALESINTERGRAL(2,"销售积分"),
	/**
	 * 3-销售退货
	 */
	SALESBACK(3,"销售退货"),
	/**
	 * 4-积分兑换
	 */
	EXCHANGE(4,"积分兑换"),
	/**
	 * 5-微信积分
	 */
	WEIXININTERGRAL(5,"微信积分"),
	/**
	 * 5-积分清零
	 */
	ZEROINTERGRAL(6,"积分清零")
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
		for (IntergralTypeEnum enums : IntergralTypeEnum.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}
	
	private IntergralTypeEnum(Integer value, String displayName) {
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
