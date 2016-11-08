package com.niit.designerswear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.designerswear.dao.BillingAddressDAO;
import com.niit.designerswear.dao.CategoryDAO;
import com.niit.designerswear.model.BillingAddress;
import com.niit.designerswear.model.Category;

public class BillingAddressTest {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.designerswear");
		context.refresh();
		BillingAddressDAO billingaddressDAO = (BillingAddressDAO) context.getBean("billingaddressDAO");
		BillingAddress billingaddress = (BillingAddress) context.getBean("billingaddress");
		billingaddress.setId("77");
		billingaddress.setUsers_id("678");
		billingaddress.setApartment_number("99090");
		billingaddress.setCity("mumbai");
		billingaddress.setState("maharashtra");
		billingaddress.setCountry("india");
		billingaddress.setZip_code("898998");
		billingaddress.setStreet_name("bandra");

		billingaddressDAO.saveorUpdate(billingaddress);

}
}
