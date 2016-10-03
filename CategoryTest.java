package com.niit.designerswear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.designerswear.dao.CategoryDAO;
import com.niit.designerswear.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.scan("com.niit.designerswear");
				context.refresh();
				CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
				Category category = (Category) context.getBean("category");
				category.setId("CG124");
				category.setName("CGName124");
				category.setDescription("CGDescription124");

				categoryDAO.saveOrUpdate(category);
		
	}

}
