package com.niit.designerswear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.designerswear.dao.UserDAO;
import com.niit.designerswear.model.User;

public class UserTest {

	public static void main(String[] args) {
		
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.scan("com.niit.designerswear");
				context.refresh();
				UserDAO userDAO = (UserDAO) context.getBean("userDAO");
				User user = (User) context.getBean("user");
				user.setId("14");
				user.setPassword("riddhi");
				user.setIsadmin(true);
                user.setUsername("user");
				userDAO.saveOrUpdate(user);
		
	}

}
