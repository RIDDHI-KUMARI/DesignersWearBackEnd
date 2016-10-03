package com.niit.designerswear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name= "cart")
@Component

public class Cart {
	@Id
	private String Id;
	@Column
	private String  user_id;
	private String grand_total;
	private String number_of_products;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(String grand_total) {
		this.grand_total = grand_total;
	}
	public String getNumber_of_products() {
		return number_of_products;
	}
	public void setNumber_of_products(String number_of_products) {
		this.number_of_products = number_of_products;
	}

}
