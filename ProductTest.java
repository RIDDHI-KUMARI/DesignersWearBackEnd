package com.niit.designerswear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.designerswear.dao.ProductDAO;
import com.niit.designerswear.model.Product;

public class ProductTest {

	public static void main(String[] args) {
		
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.scan("com.niit.designerswear");
				context.refresh();
				ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
				Product product = (Product) context.getBean("product");
				product.setId("PRDId2");
				product.setName("PRDNameWESTERN");
				product.setPrice(500);
				product.setQuantity(14);
				product.setSupplier_id("SUP124");
				product.setCategory_id("CG124");
				product.setOut_off_stock(true);
				productDAO.saveOrUpdate(product);
		
	}

}
