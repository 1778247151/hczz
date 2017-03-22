package com.crm.bean;
import java.io.Serializable;


public class TMonPopManagerBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 213108907455590425L;
	private String sMnId;
	private String sMnPwd;
	private String sMnName;
	private String sContactPhone;
	private String sEmail;
	private String sQq;
	
	
	public String getSMnId() {
		return sMnId;
	}
	public void setSMnId(String sMnId) {
		this.sMnId = sMnId;
	}
	public String getSMnPwd() {
		return sMnPwd;
	}
	public void setSMnPwd(String sMnPwd) {
		this.sMnPwd= sMnPwd;
	}
	public String getSMnName() {
		return sMnName;
	}
	public void setSMnName(String sMnName) {
		this.sMnName= sMnName;
	}
	public String getSContactPhone() {
		return sContactPhone;
	}
	public void setSContactPhone(String sContactPhone) {
		this.sContactPhone= sContactPhone;
	}
	public String getSEmail() {
		return sEmail;
	}
	public void setSEmail(String sEmail) {
		this.sEmail= sEmail;
	}
	public String getSQq() {
		return sQq;
	}
	public void setSQq(String sQq) {
		this.sQq= sQq;
	}

}
