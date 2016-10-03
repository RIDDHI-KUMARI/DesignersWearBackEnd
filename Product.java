package com.niit.designerswear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Product {

	
	@Id
	private String id;
	@Column
	private String name;
	private int price;
	private int quantity;
	private String supplier_id;
	private String category_id;
	boolean out_off_stock;

	public boolean isOut_off_stock() {
		return out_off_stock;
	}

	public void setOut_off_stock(boolean out_off_stock) {
		this.out_off_stock = out_off_stock;
	}

	@Transient
	private MultipartFile productimage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public MultipartFile getProductimage() {
		return productimage;
	}

	public void setProductimage(MultipartFile productimage) {
		this.productimage = productimage;
	}
	
	
	
}
