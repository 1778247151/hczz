package com.crm.pojo;

import com.crm.enums.ActivityStatusEnum;

public class GwDepartmentPositionModel {
	private Integer id;

	private String code;

	private String cnName;

	private String enName;

	private String departmentCode;

	private String departmentName;

	private Integer orderNum;

	private String description;

	private Integer status;

	private String statusName;

	private Integer createUserId;

	private String createUserName;

	private String createTime;

	private Integer updateUserId;

	private String updateUserName;

	private String updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName == null ? null : cnName.trim();
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName == null ? null : enName.trim();
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode == null ? null : departmentCode.trim();
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusName() {
		return ActivityStatusEnum.getDisplayName(status);
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GwDepartmentPositionModel)) {
			return false;
		}
		GwDepartmentPositionModel position = (GwDepartmentPositionModel) obj;
		if (position.getId().equals(this.getId()) && position.getCode().equals(this.code)
				&& position.getCnName().equals(this.cnName) && position.getEnName().equals(this.enName)
				&& position.getDepartmentCode().equals(this.departmentCode)
				&& position.getOrderNum().equals(this.orderNum) && position.getDescription().equals(this.description)
				&& position.getStatus().equals(this.status) && position.getCreateUserId().equals(this.createUserId)
				&& position.getCreateTime().equals(this.createTime)
				&& position.getUpdateUserId().equals(this.updateUserId)
				&& position.getUpdateUserId().equals(this.updateTime)) {
			return true;
		} else {
			return false;
		}

	}
}