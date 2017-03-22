package com.crm.pojo;

import java.io.Serializable;

public class GwarchivesModel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String createUser;

    private String type;

    private String createTime;

    private String caseInformation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCaseInformation() {
        return caseInformation;
    }

    public void setCaseInformation(String caseInformation) {
        this.caseInformation = caseInformation == null ? null : caseInformation.trim();
    }
}