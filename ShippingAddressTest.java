package com.niit.designerswear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.designerswear.dao.ShippingAddressDAO;
import com.niit.designerswear.model.ShippingAddress;

public class ShippingAddressTest {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.designerswear");
		context.refresh();
		ShippingAddressDAO shippingaddressDAO = (ShippingAddressDAO) context.getBean("shippingaddressDAO");
		ShippingAddress shippingaddress = (ShippingAddress) context.getBean("shippingaddress");
		shippingaddress.setId("1");
		shippingaddress.setUsers_id("444");
		shippingaddress.setStreet_name("kharghar");
        shippingaddress.setApartment_number("111"); 
        shippingaddress.setCity("navi mumbai");
        shippingaddress.setCountry("india");
        shippingaddress.setState("maharashtra");
        shippingaddress.setZip_code("9090");
		shippingaddressDAO.saveorUpdate(shippingaddress);

}
}
