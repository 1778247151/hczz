package com.crm.bean;

import java.io.Serializable;
/**
 * 
 * MemberIntegralInfo:会员积分信息
 *
 * @author yumaochun
 * @date  2016年7月6日
 * @version  jdk1.8
 *
 */
public class MemberIntegralInfo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -1791297974178376267L;
    
    /**
     * 会员号
     */
    private String memberCode;
    
    /**
     * 会员卡号
     */
    
    private String memberCardCode;
    
    /**
     * 会员等级
     */
    private String grade;
    
    /**
     * 等级名称
     */
    private String gradeName;
    
    /**
     * 会员名
     */
    private String username;
    
    /**
     * 本次积分
     */
    private int theIntegral;
    
    /**
     * 以前积分
     */
    private int previousIntegral;

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberCardCode() {
        return memberCardCode;
    }

    public void setMemberCardCode(String memberCardCode) {
        this.memberCardCode = memberCardCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTheIntegral() {
        return theIntegral;
    }

    public void setTheIntegral(int theIntegral) {
        this.theIntegral = theIntegral;
    }

    public int getPreviousIntegral() {
        return previousIntegral;
    }

    public void setPreviousIntegral(int previousIntegral) {
        this.previousIntegral = previousIntegral;
    }
    

}
