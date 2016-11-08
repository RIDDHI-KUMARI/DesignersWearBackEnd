package com.niit.designerswear.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.designerswear.model.Category;
import com.niit.designerswear.model.ShippingAddress;
@Repository("shippingaddressDAO")
public class ShippingAddressDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public ShippingAddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<ShippingAddress> list() {
		Session session = (Session) sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		// List<Category> listCategory=(List<Category>)
		// sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		List<ShippingAddress> listShippingAddress = session.createQuery("from ShippingAddress").list();
		return listShippingAddress;
	}

	@Transactional
	public ShippingAddress get(String id) {
		String hql = "from ShippingAddress where id='" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ShippingAddress> listShippingAddress = (List<ShippingAddress>) (query).getResultList();
		if (listShippingAddress != null && !listShippingAddress.isEmpty()) {
			return listShippingAddress.get(0);
		}
		return null;
/*
		Session session = sessionFactory.openSession();
		Category category = (Category) session.load(Category.class, id);
		return category;*/
	}

	@Transactional
	public void saveOrUpdate(ShippingAddress shippingaddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingaddress);
	}

	@Transactional
	public void delete(String id) {
		ShippingAddress ShippingAddressToDelete = new ShippingAddress();
		ShippingAddressToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ShippingAddressToDelete);
	}

}


