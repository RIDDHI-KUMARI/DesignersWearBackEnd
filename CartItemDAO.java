package com.niit.designerswear.dao;

import java.util.List;

import com.niit.designerswear.model.Cart;
import com.niit.designerswear.model.CartItem;

public interface CartItemDAO {
	public List<CartItem> list();

	public CartItem get(String id);

	public void saveOrUpdate(CartItem cartitem);

	public void delete(String id);

}


