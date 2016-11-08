package com.niit.designerswear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.designerswear.dao.CategoryDAO;
import com.niit.designerswear.dao.UserOrderDAO;
import com.niit.designerswear.model.Category;
import com.niit.designerswear.model.UserOrder;

public class UserOrderTest {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.designerswear");
		context.refresh();
		UserOrderDAO userorderDAO = (UserOrderDAO) context.getBean("userorderDAO");
		UserOrder userorder = (UserOrder) context.getBean("userorder");
		userorder.setGrand_total("3245");
		userorder.setUsers_id("km");
		userorder.setOrder("hij");
        userorder.setShippingaddress_id("14");
        userorder.setBillingaddress_id("12");
		userorderDAO.saveorUpdate(userorder);

}

}


