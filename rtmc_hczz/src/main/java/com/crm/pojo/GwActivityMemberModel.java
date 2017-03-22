package com.crm.pojo;

import com.crm.enums.ActivitySignedStatusNameEnum;
import com.crm.enums.ActivityStatusEnum;

public class GwActivityMemberModel {
    private Integer id;

    private String activityCode;

    private String memberCode;

    private String enrolTime;

    private Integer status;

    private Integer signedStatus;

    private Integer createUserId;

    private String createTime;

    private Integer updateUserId;

    private String updateTime;
    
    private String createUserName;
    
    private String updateUserName;
    
    private String statusName;

    private String signedStatusName;
    
    private String memberName;
    
    
    public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getSignedStatusName() {
		return ActivitySignedStatusNameEnum.getDisplayName(getSignedStatus());
	}

	public void setSignedStatusName(String signedStatusName) {
		this.signedStatusName = signedStatusName;
	}

	public String getStatusName() {
		return ActivityStatusEnum.getDisplayName(getStatus());
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode == null ? null : activityCode.trim();
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getEnrolTime() {
        return enrolTime;
    }

    public void setEnrolTime(String enrolTime) {
        this.enrolTime = enrolTime == null ? null : enrolTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSignedStatus() {
        return signedStatus;
    }

    public void setSignedStatus(Integer signedStatus) {
        this.signedStatus = signedStatus;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}