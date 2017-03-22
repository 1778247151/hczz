package com.crm.bean;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * PromotionIntegralInfo:促销积分信息
 *
 * @author yumaochun
 * @date  2016年7月6日
 * @version  jdk1.8
 *
 */
public class PromotionIntegralInfo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 2010984747123731152L;
    
    /**
     * 促销积分规则编号
     */
    private String code;
    
    /**
     * 优先级
     */
    private Integer priority;
    
    /**
     * 是否永久（0-非永久，1-永久）
     */
    private Integer isForever;
    
    /**
     * 开始时间
     */
    private String startTime;
    
    /**
     * 结束时间
     */
    private String endTime;
    
    /**
     * 模式（0-多倍积分，1-全新模式，2-固定积分）
     */
    private Integer model;
    /**
     * 条件类型（0-只满足其中一种类型即可生效，1-必须满足所有勾选条件才能生效）
     */
    private Integer type;
    
    /**
     * 条件组合值：会员等级-01，卡号段-02，性别-03,生日当天-04，生日当月-05，每周-06，每月-07，各值都以“，”分隔
     */
    private String conditionGroup;
    
    /**
     * 会员级别编号
     */
    private String memberGrade;
    /**
     * 起始卡号
     */
    private String startCardCode;
    /**
     * 结束卡号
     */
    private String endCardCode;
    /**
     * 性别（0-women 女，1-man 男）
     */
    private Integer sex;
    /**
     * 每周，周一到星期天（0,1,2,3）
     */
    private String week;
    /**
     * 每月，1号到31号（1,2,3）
     */
    private String month;
    /**
     * 业态编号或商铺编号
     */
    private String typeCode;
    /**
     * 倍数，根据促销积分规则表中的模式来定（多倍积分有值，其余为空）
     */
    private Integer number;
    /**
     * 积分数
     */
    private Integer integralNumber;
    /**
     * 兑换金额，多少金额兑换多少积分
     */
    private BigDecimal exchangeMoney;
    
    /**
     * 会员等级积分数
     */
    private Integer memberIntegralNumber;
    /**
     * 会员等级兑换金额，多少金额兑换多少积分
     */
    private BigDecimal memberExchangeMoney;
    /**
     * 会员等级详细积分数
     */
    private Integer detatilIntegralNumber;
    /**
     * 会员等级详细积兑换金额，多少金额兑换多少积分
     */
    private BigDecimal detatiExchangeMoney;
    /**
     * 会员等级编号
     */
    private String gradeCode;
    
    
    
    
    public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public Integer getMemberIntegralNumber() {
		return memberIntegralNumber;
	}
	public void setMemberIntegralNumber(Integer memberIntegralNumber) {
		this.memberIntegralNumber = memberIntegralNumber;
	}
	public BigDecimal getMemberExchangeMoney() {
		return memberExchangeMoney;
	}
	public void setMemberExchangeMoney(BigDecimal memberExchangeMoney) {
		this.memberExchangeMoney = memberExchangeMoney;
	}
	public Integer getDetatilIntegralNumber() {
		return detatilIntegralNumber;
	}
	public void setDetatilIntegralNumber(Integer detatilIntegralNumber) {
		this.detatilIntegralNumber = detatilIntegralNumber;
	}
	public BigDecimal getDetatiExchangeMoney() {
		return detatiExchangeMoney;
	}
	public void setDetatiExchangeMoney(BigDecimal detatiExchangeMoney) {
		this.detatiExchangeMoney = detatiExchangeMoney;
	}
	public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public Integer getIsForever() {
        return isForever;
    }
    public void setIsForever(Integer isForever) {
        this.isForever = isForever;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public Integer getModel() {
        return model;
    }
    public void setModel(Integer model) {
        this.model = model;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getConditionGroup() {
        return conditionGroup;
    }
    public void setConditionGroup(String conditionGroup) {
        this.conditionGroup = conditionGroup;
    }
    public String getMemberGrade() {
        return memberGrade;
    }
    public void setMemberGrade(String memberGrade) {
        this.memberGrade = memberGrade;
    }
    public String getStartCardCode() {
        return startCardCode;
    }
    public void setStartCardCode(String startCardCode) {
        this.startCardCode = startCardCode;
    }
    public String getEndCardCode() {
        return endCardCode;
    }
    public void setEndCardCode(String endCardCode) {
        this.endCardCode = endCardCode;
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public String getWeek() {
        return week;
    }
    public void setWeek(String week) {
        this.week = week;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getTypeCode() {
        return typeCode;
    }
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public Integer getIntegralNumber() {
        return integralNumber;
    }
    public void setIntegralNumber(Integer integralNumber) {
        this.integralNumber = integralNumber;
    }
    public BigDecimal getExchangeMoney() {
        return exchangeMoney;
    }
    public void setExchangeMoney(BigDecimal exchangeMoney) {
        this.exchangeMoney = exchangeMoney;
    }
}
