package com.crm.pojo;

import java.io.Serializable;
/**
 * 
 * GwRoleGroupModel:管理员用户权限组实体类
 *
 * @author yumaochun
 * @date  2016年3月5日
 * @version  jdk1.8
 *
 */
public class GwRoleGroupModel implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -6573878867724316130L;

	private Integer id;

    private Integer gwRoleId;

    private Integer gwMenuTreeId;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGwRoleId() {
        return gwRoleId;
    }

    public void setGwRoleId(Integer gwRoleId) {
        this.gwRoleId = gwRoleId;
    }

    public Integer getGwMenuTreeId() {
        return gwMenuTreeId;
    }

    public void setGwMenuTreeId(Integer gwMenuTreeId) {
        this.gwMenuTreeId = gwMenuTreeId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

	@Override
	public String toString() {
		return "GwRoleGroupModel [id=" + id + ", gwRoleId=" + gwRoleId + ", gwMenuTreeId=" + gwMenuTreeId + ", time="
				+ time + "]";
	}
    
    
}