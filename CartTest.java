package com.niit.designerswear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.designerswear.dao.CartDAO;
import com.niit.designerswear.model.Cart;

public class CartTest {
	
		public static void main(String[] args) {
			
					AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
					context.scan("com.niit.designerswear");
					context.refresh();
					CartDAO CartDAO = (CartDAO) context.getBean("CartDAO");
					com.niit.designerswear.model.Cart cart = (Cart) context.getBean("cart");
					cart.setId("123");
					cart.setGrand_total("24");
					cart.setNumber_of_products("14");
					cart.setUser_id("10");
		}

	}


