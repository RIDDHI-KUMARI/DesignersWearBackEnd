package com.niit.designerswear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.designerswear.dao.CategoryDAO;
import com.niit.designerswear.dao.UserDetailsDAO;
import com.niit.designerswear.model.Category;
import com.niit.designerswear.model.UserDetails;

public class UserDetailsTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.designerswear");
		context.refresh();
		UserDetailsDAO userdetailsDAO = (UserDetailsDAO) context.getBean("userdetailsDAO");
		UserDetails userdetails = (UserDetails) context.getBean("userDetails");
		userdetails.setId("UD124");
		userdetails.setName("UDName124");
		userdetails.setAddress("UDThane124");
		userdetails.setAdmin(true);
		userdetails.setContactNumber("767889");
		userdetails.setEmail("abcd@gmail.com");
		userdetails.setPassword("pass@123");
		userdetails.setCountryName("canada");
		userdetailsDAO.saveOrUpdate(userdetails);

	}

}
