package com.niit.designerswear.dao;

import java.util.List;

import com.niit.designerswear.model.Cart;
import com.niit.designerswear.model.Product;

public interface CartDAO {
	public List<Cart> list();

	public Cart get(String id);

	public void saveOrUpdate(Cart cart);

	public void delete(String id);

}



