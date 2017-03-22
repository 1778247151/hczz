package com.crm.pojo;

import java.io.Serializable;

import com.crm.enums.AdminUserStatusEnum;
import com.crm.enums.SexEnum;

/**
 * 
 * GwAdminUsersModel:管理员信息实体类
 *
 * @author yumaochun
 * @date 2016年3月6日
 * @version jdk1.8
 *
 */
public class GwAdminUsersModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5890882442829570266L;

	private Integer id;

	private String username;

	private String password;

	private String name;

	private String dtime;

	private Integer gwRoleId;

	/**
	 * 角色名称
	 */
	private String gwRoleName;

	private String phone;

	private String sfz;

	private String address;

	private Integer state;

	/**
	 * 状态名称
	 */
	private String stateName;

	private Integer sex;

	private String sexName;

	private String departmentCode;

	private String departmentName;

	private String positions;

	private String departmentPositionName;

	private String email;

	private String qq;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime == null ? null : dtime.trim();
	}

	public Integer getGwRoleId() {
		return gwRoleId;
	}

	public void setGwRoleId(Integer gwRoleId) {
		this.gwRoleId = gwRoleId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz == null ? null : sfz.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getGwRoleName() {
		return gwRoleName;
	}

	public void setGwRoleName(String gwRoleName) {
		this.gwRoleName = gwRoleName;
	}

	public String getStateName() {
		this.stateName = AdminUserStatusEnum.getDisplayName(getState());
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSexName() {
		return SexEnum.getDisplayName(sex);
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getDepartmentPositionName() {
		return departmentPositionName;
	}

	public void setDepartmentPositionName(String departmentPositionName) {
		this.departmentPositionName = departmentPositionName;
	}

	/**
	 * 对比2个对象是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GwAdminUsersModel)) {
			return false;
		}
		GwAdminUsersModel adminUsers = (GwAdminUsersModel) obj;
		if (adminUsers.getId().equals(this.getId()) 
				&& adminUsers.getUsername().equals(this.getUsername())
				&& adminUsers.getPassword().equals(this.getPassword()) 
				&& adminUsers.getName().equals(this.getName())
				&& adminUsers.getDtime().equals(this.getDtime()) 
				&& adminUsers.getGwRoleId().equals(this.getGwRoleId())
				&& adminUsers.getPhone().equals(this.getPhone()) 
				&& adminUsers.getSfz().equals(this.getSfz())
				&& adminUsers.getAddress().equals(this.getAddress()) 
				&& adminUsers.getState().equals(this.getState())
				&& adminUsers.getSex().equals(this.getSex())
				&& adminUsers.getDepartmentCode().equals(this.getDepartmentCode())
				&& adminUsers.getPositions().equals(this.getPositions())
				&& adminUsers.getEmail().equals(this.getEmail()) 
				&& adminUsers.getQq().equals(this.getQq())
				&& adminUsers.getCreateUserId().equals(this.getCreateUserId())
				&& adminUsers.getCreateTime().equals(this.getCreateTime())
				&& adminUsers.getUpdateUserId().equals(this.getUpdateUserId())
				&& adminUsers.getUpdateTime().equals(this.getUpdateTime())) {
			return true;
		} else {
			return false;
		}

	}

}