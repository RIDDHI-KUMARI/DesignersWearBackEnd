package com.niit.designerswear.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.designerswear.model.UserDetails;
import com.niit.designerswear.model.UserDetails;

@Repository("userdetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<UserDetails> list() {
		Session session = (Session) sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		// List<UserDetails> listUserDetails=(List<UserDetails>)
		// sessionFactory.getCurrentSession().createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		List<UserDetails> listUserDetails = session.createQuery("from UserDetails").list();
		return listUserDetails;
	}

	@Transactional
	public UserDetails get(String id) {
		String hql = "from UserDetails where id=" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> listUserDetails = (List<UserDetails>) (query).getResultList();
		if (listUserDetails != null && ! listUserDetails.isEmpty()) {
			return listUserDetails.get(0);
		}
		return null;

		// TODO Auto-generated method stub
	}

	@Transactional
	public void saveOrUpdate(UserDetails userdetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userdetails);
	}

	@Transactional
	public void delete(String id) {
		UserDetails UserDetailsToDelete = new UserDetails();
		UserDetailsToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserDetailsToDelete);
	}

}
