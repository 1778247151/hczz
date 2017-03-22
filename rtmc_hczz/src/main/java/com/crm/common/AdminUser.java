package com.crm.common;

import java.io.Serializable;
/**
 * 
 * AdminUser:用户登录信息实体对象
 *
 * @author yumaochun
 * @date  2016年3月7日
 * @version  jdk1.8
 *
 */
public class AdminUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8291113722520230592L;
	/**
	 * 用户id
	 */
	private Integer userId;
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 用户账号
	 */
	private String username;
	/**
	 * token
	 */
	private String token;
	
	/**
	 * 角色id
	 */
	private Integer gwRoleId;
	
	/**
	 * 角色名称
	 */
	private String gwRoleName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getGwRoleId() {
		return gwRoleId;
	}

	public void setGwRoleId(Integer gwRoleId) {
		this.gwRoleId = gwRoleId;
	}

	public String getGwRoleName() {
		return gwRoleName;
	}

	public void setGwRoleName(String gwRoleName) {
		this.gwRoleName = gwRoleName;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	

}
