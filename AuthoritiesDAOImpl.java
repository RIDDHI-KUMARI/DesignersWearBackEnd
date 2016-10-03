package com.niit.designerswear.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.designerswear.model.Authorities;

@Repository("authoritiesDAO")
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public AuthoritiesDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Authorities> list() {
		Session session = (Session) sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		// List<Authorities> listAuthorities=(List<Authorities>)
		// sessionFactory.getCurrentSession().createCriteria(Authorities.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		List<Authorities> listAuthorities = session.createQuery("from Authorities").list();
		return listAuthorities;
	}

	@Transactional
	public Authorities get(String authority) {
		String hql = "from Authorities where authority='" + authority + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Authorities> listAuthorities = (List<Authorities>) (query).getResultList();
		if (listAuthorities != null && !listAuthorities.isEmpty()) {
			return listAuthorities.get(0);
		}
		return null;
		/*
		 * Session session = sessionFactory.openSession(); Authorities
		 * Authorities = (Authorities) session.load(Authorities.class, id);
		 * return Authorities;
		 */
	}

	@Transactional
	public void saveOrUpdate(Authorities authorities) {
		sessionFactory.getCurrentSession().saveOrUpdate(authorities);
	}

	@Transactional
	public void delete(String authority) {
		Authorities AuthoritiesToDelete = new Authorities();
		AuthoritiesToDelete.setAuthority(authority);
		sessionFactory.getCurrentSession().delete(AuthoritiesToDelete);
	}

}
