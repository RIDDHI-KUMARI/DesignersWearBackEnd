package com.niit.designerswear.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.designerswear.model.BillingAddress;
import com.niit.designerswear.model.ShippingAddress;
@Repository("billingaddressDAO")
public class BillingAddressDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public BillingAddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<BillingAddress> list() {
		Session session = (Session) sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		// List<Category> listCategory=(List<Category>)
		// sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		List<BillingAddress> listBillingAddress = session.createQuery("from BillingAddress").list();
		return listBillingAddress;
	}

	@Transactional
	public BillingAddress get(String id) {
		String hql = "from BillingAddress where id='" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BillingAddress> listBillingAddress = (List<BillingAddress>) (query).getResultList();
		if (listBillingAddress != null && !listBillingAddress.isEmpty()) {
			return listBillingAddress.get(0);
		}
		return null;
/*
		Session session = sessionFactory.openSession();
		Category category = (Category) session.load(Category.class, id);
		return category;*/
	}

	@Transactional
	public void saveOrUpdate(BillingAddress billingaddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(billingaddress);
	}

	@Transactional
	public void delete(String id) {
		BillingAddress BillingAddressToDelete = new BillingAddress();
		BillingAddressToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(BillingAddressToDelete);
	}

}




