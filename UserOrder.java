package com.niit.designerswear.model;

import org.springframework.stereotype.Service;
@Service
public class UserOrder {
private String order;
private String grand_total;
private String shippingaddress_id;
private String billingaddress_id;
private String users_id;
public String getUsers_id() {
	return users_id;
}
public void setUsers_id(String users_id) {
	this.users_id = users_id;
}
public String getOrder() {
	return order;
}
public String getShippingaddress_id() {
	return shippingaddress_id;
}
public void setShippingaddress_id(String shippingaddress_id) {
	this.shippingaddress_id = shippingaddress_id;
}
public String getBillingaddress_id() {
	return billingaddress_id;
}
public void setBillingaddress_id(String billingaddress_id) {
	this.billingaddress_id = billingaddress_id;
}
public void setOrder(String order) {
	this.order = order;
}
public String getGrand_total() {
	return grand_total;
}
public void setGrand_total(String grand_total) {
	this.grand_total = grand_total;
}
}
