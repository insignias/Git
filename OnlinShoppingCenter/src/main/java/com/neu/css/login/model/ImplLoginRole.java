/**
 * 
 */
package com.neu.css.login.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class ImplLoginRole {
	@Column(name="ROLE_ID")
	private String roleId;
	@Column(name="ROLE_TYPE")
	private String roleType;
	@Column(name="EMAIL")
	private String email;
	public String getRoleId() {
		return roleId;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
