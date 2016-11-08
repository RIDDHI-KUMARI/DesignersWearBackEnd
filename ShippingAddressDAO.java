package com.niit.designerswear.dao;

import java.util.List;

import com.niit.designerswear.model.ShippingAddress;

public interface ShippingAddressDAO {
public	List<ShippingAddress> list();
void saveorUpdate(ShippingAddress shippingaddress);
ShippingAddress get(String id);
void delete(String id);


}
