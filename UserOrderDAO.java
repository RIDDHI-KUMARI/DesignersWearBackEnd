package com.niit.designerswear.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import com.niit.designerswear.model.UserOrder;

public interface UserOrderDAO {
public List<UserOrder> list();
public UserOrder get(String order);
public void saveprUpdate(Order order);
void delete(String order);

}
