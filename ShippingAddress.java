package com.niit.designerswear.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "shippingaddress")
@Component 
public class ShippingAddress {
@Id
private String id;
private String users_id;
@NotNull
private String street_name;
@NotNull
private String apartment_number;
@NotNull
private String country;
@NotNull
private String state;
@NotNull
private String city;
@NotNull
private String zip_code;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getStreet_name() {
	return street_name;
}
public String getUsers_id() {
	return users_id;
}
public void setUsers_id(String users_id) {
	this.users_id = users_id;
}
public void setStreet_name(String street_name) {
	this.street_name = street_name;
}
public String getApartment_number() {
	return apartment_number;
}
public void setApartment_number(String apartment_number) {
	this.apartment_number = apartment_number;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getZip_code() {
	return zip_code;
}
public void setZip_code(String zip_code) {
	this.zip_code = zip_code;
}
}
