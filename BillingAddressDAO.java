package com.niit.designerswear.dao;

import java.util.List;

import com.niit.designerswear.model.BillingAddress;

public interface BillingAddressDAO {
	public List<BillingAddress> list();
	void saveorUpdate(BillingAddress billingaddress);
	void delete(String id);
	BillingAddress get(String id);
	
	

}
