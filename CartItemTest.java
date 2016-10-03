//package com.niit.designerswear.test;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.designerswear.dao.CartItemDAO;
//import com.niit.designerswear.model.CartItem;
//
//public class CartItemTest {
//	
//		public static void main(String[] args) {
//			
//					AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//					context.scan("com.niit.designerswear");
//					context.refresh();
//					CartItemDAO CartItemDAO = (CartItemDAO) context.getBean("CartItemDAO");
//					CartItem cartItem = (CartItem) context.getBean("cartItem");
//					cartItem.setId("11");
//					cartItem.setCart_id("123");
//					cartItem.setProduct_id("1234");
//					cartItem.setQuantity("56");
//					cartItem.setTotal_price("2000");
//								
//		}
//
//	}
//
//
//
