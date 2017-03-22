package com.crm.pojo;

import java.io.Serializable;

import com.crm.enums.ActivityStatusEnum;

/**
 * 
 * GwRoleModel:管理员角色组实体类
 *
 * @author yumaochun
 * @date 2016年3月5日
 * @version jdk1.8
 *
 */
public class GwRoleModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1660939013764098280L;

	private Integer id;

	private String cnName;

	private String enName;

	private String note;

	private Integer state;

	private String stateName;

	private String time;

	private Integer orderNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time == null ? null : time.trim();
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getStateName() {
		return ActivityStatusEnum.getDisplayName(getState());
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GwRoleModel)) {
			return false;
		}
		GwRoleModel role = (GwRoleModel) obj;
		if (role.getId().equals(this.getId()) && role.getCnName().equals(this.cnName)
				&& role.getEnName().equals(this.enName) && role.getNote().equals(this.note)
				&& role.getState().equals(this.state) && role.getTime().equals(this.time)
				&& role.getOrderNum().equals(this.orderNum)) {
			return true;
		} else {
			return false;
		}

	}
}