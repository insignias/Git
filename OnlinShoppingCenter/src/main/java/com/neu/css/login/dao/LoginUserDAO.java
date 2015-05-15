/**
 * 
 */
package com.neu.css.login.dao;

import java.util.List;

import com.neu.css.login.model.ImplLoginUser;


public interface LoginUserDAO {
	public void addLoginUser(ImplLoginUser implLoginUser);
	public List<ImplLoginUser> listLoginUsers(); 
	public ImplLoginUser getLoginUser(int userId);
	public ImplLoginUser getLoginUser(String email,String password);
	public ImplLoginUser getLoginUser(String email);
	public void deleteLoginUser(ImplLoginUser implLoginUser);
}
