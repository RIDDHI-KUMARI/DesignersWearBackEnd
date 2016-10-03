package com.niit.designerswear.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.designerswear.model.CartItem;

@Repository("cartitemDAO")
public class CartItemDAOImpl implements CartItemDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public CartItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
	public List<CartItem> list() {
		@SuppressWarnings("unchecked")
		List<CartItem> listCartItem=(List<CartItem>) sessionFactory.getCurrentSession().createCriteria(CartItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCartItem;
	}

	@Transactional
	public CartItem get(String id) {
		String hql = "from CartItem where id=" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> listCartItem = (List<CartItem>) query.getResultList();
		if (listCartItem != null && ! listCartItem.isEmpty()) {
			return listCartItem.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(CartItem cartitem) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartitem);
	}

	@Transactional
	public void delete(String id) {
		CartItem CartItemToDelete = new CartItem();
		CartItemToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(CartItemToDelete);
	}

}
