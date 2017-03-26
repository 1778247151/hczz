package com.crm.pojo;

import java.io.Serializable;

public class GwarchivesModel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8088648972972733776L;

	private Integer id;
	private String name;
    private String createUser;
    private String type;
    private String createTime;
    private String caseInformation;
    private String operation;
    private String code;	
    private int status;
    private String userList;
    public String getUserList() {
		return userList;
	}

	public void setUserList(String userList) {
		this.userList = userList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

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