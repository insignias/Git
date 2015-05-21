/**
 * 
 */
package com.neu.css.login.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neu.css.login.dao.LoginUserDAO;
import com.neu.css.login.model.ImplLoginUser;

@Service("loginUserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ImplLoginUserService implements LoginUserService{
	
	@Autowired  
	private LoginUserDAO loginUserDAO;
	/* (non-Javadoc)
	 * @see com.neu.css.login.service.LoginUserService#addLoginUser(com.neu.css.login.model.ImplLoginUser)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addLoginUser(ImplLoginUser implLoginUser) {
		loginUserDAO.addLoginUser(implLoginUser);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.service.LoginUserService#listLoginUsers()
	 */
	@Override
	public List<ImplLoginUser> listLoginUsers() {
		return loginUserDAO.listLoginUsers();
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.service.LoginUserService#getLoginUser(int)
	 */
	@Override
	public ImplLoginUser getLoginUser(int userId) {
		return loginUserDAO.getLoginUser(userId);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.service.LoginUserService#deleteLoginUser(com.neu.css.login.model.ImplLoginUser)
	 */
	@Override
	public void deleteLoginUser(ImplLoginUser implLoginUser) {
		loginUserDAO.deleteLoginUser(implLoginUser);	
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.service.LoginUserService#getLoginUser(java.lang.String, java.lang.String)
	 */
	@Override
	public ImplLoginUser getLoginUser(String email, String password) {
		return loginUserDAO.getLoginUser(email, password);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.service.LoginUserService#getLoginUser(java.lang.String)
	 */
	@Override
	public ImplLoginUser getLoginUser(String email) {
		return loginUserDAO.getLoginUser(email);
	}

}
