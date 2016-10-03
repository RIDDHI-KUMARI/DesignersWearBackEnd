package com.niit.designerswear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.designerswear.dao.SupplierDAO;
import com.niit.designerswear.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.scan("com.niit.designerswear");
				context.refresh();
				SupplierDAO SupplierDAO = (SupplierDAO) context.getBean("supplierDAO");
				Supplier Supplier = (Supplier) context.getBean("supplier");
				Supplier.setId("SUP124");
				Supplier.setName("SUPName124");
				Supplier.setAddress("fhf");

				SupplierDAO.saveOrUpdate(Supplier);
		
	}

}
