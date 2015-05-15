/**
 * 
 */
package com.neu.css.login.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;


@Entity  
@Table(name="TABLE_USER")
public class ImplLoginUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name="USERNAME")
	private String username;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name="EMAIL",unique = true)
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name="ENABLED")
	private Integer enabled;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="TABLE_ROLE",joinColumns=@JoinColumn(name="USER_ID"))
	private List<ImplLoginRole> role =  new ArrayList<ImplLoginRole>();
	
	public List<ImplLoginRole> getRole() {
		return role;
	}
	public void setRole(List<ImplLoginRole> role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}	
	
}
