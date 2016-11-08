package com.niit.designerswear.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.designerswear.model.Category;
import com.niit.designerswear.model.UserOrder;
@Repository("userorderDAO")
public class UserOrderDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public UserOrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<UserOrder> list() {
		Session session = (Session) sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		// List<Category> listCategory=(List<Category>)
		// sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		List<UserOrder> listUserOrder = session.createQuery("from UserOrder").list();
		return listUserOrder;
	}

	@Transactional
	public UserOrder get(String order) {
		String hql = "from UserOrder where order='" + order + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserOrder> listUserOrder = (List<UserOrder>) (query).getResultList();
		if (listUserOrder != null && !listUserOrder.isEmpty()) {
			return listUserOrder.get(0);
		}
		return null;
/*
		Session session = sessionFactory.openSession();
		Category category = (Category) session.load(Category.class, id);
		return category;*/
	}

	@Transactional
	public void saveOrUpdate(UserOrder userorder) {
		sessionFactory.getCurrentSession().saveOrUpdate(userorder);
	}

	@Transactional
	public void delete(String order) {
		UserOrder UserOrderToDelete = new UserOrder();
		UserOrderToDelete.setOrder(order);
		sessionFactory.getCurrentSession().delete(UserOrderToDelete);
	}

}


