/**
 * 
 */
package com.neu.css.login.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neu.css.login.model.ImplLoginUser;

@Repository("loginUserDAO")
public class ImplLoginUserDAO implements LoginUserDAO{
	@Autowired  
	 private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.neu.css.login.dao.LoginUserDAO#addLoginUser(com.neu.css.login.model.ImplLoginUser)
	 */
	@Override
	public void addLoginUser(ImplLoginUser implLoginUser) {
		sessionFactory.getCurrentSession().saveOrUpdate(implLoginUser);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.dao.LoginUserDAO#listLoginUsers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ImplLoginUser> listLoginUsers() {
		return (List<ImplLoginUser>) sessionFactory.getCurrentSession().createCriteria(ImplLoginUser.class).list();
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.dao.LoginUserDAO#getLoginUser(int)
	 */
	@Override
	public ImplLoginUser getLoginUser(int userId) {
		return (ImplLoginUser) sessionFactory.getCurrentSession().get(ImplLoginUser.class, userId);
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.dao.LoginUserDAO#deleteLoginUser(com.neu.css.login.model.ImplLoginUser)
	 */
	@Override
	public void deleteLoginUser(ImplLoginUser implLoginUser) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM TABLE_USER WHERE email = " + implLoginUser.getEmail()).executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.dao.LoginUserDAO#getLoginUser(java.lang.String, java.lang.String)
	 */
	@Override
	public ImplLoginUser getLoginUser(String email, String password) {
		try {
	            Query q = sessionFactory.getCurrentSession().createQuery("from ImplLoginUser where email = :email and password = :password");
	            q.setString("email", email);
	            q.setString("password", password);
	            ImplLoginUser implLoginUser = (ImplLoginUser) q.uniqueResult();
	            return implLoginUser;
	        } catch (HibernateException e) {	         
				e.printStackTrace();
	        }
		return null;
	}

	/* (non-Javadoc)
	 * @see com.neu.css.login.dao.LoginUserDAO#getLoginUser(java.lang.String)
	 */
	@Override
	public ImplLoginUser getLoginUser(String email) {
		try {
            Query q = sessionFactory.getCurrentSession().createQuery("from ImplLoginUser where email = :email");
            q.setString("email", email);
            ImplLoginUser implLoginUser = (ImplLoginUser) q.uniqueResult();
            return implLoginUser;
        } catch (HibernateException e) {	         
			e.printStackTrace();
        }
		return null;
	}

}
