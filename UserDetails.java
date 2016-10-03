package com.niit.designerswear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "userdetails")
@Component
public class UserDetails {
	
	// @NotEmpty(message="Please enter UserName")
	// @Length(min=6,max=20,message="Name should be between 6 to 20 characters
	// ")
	@Id
	private String Id;
	private String Name;
	// @NotEmpty(message="Please enter Password")
	// @Length(min=6,max=14,message="Password should be between 6 to 14
	// characters ")
	private String Password;
	// @Pattern(regexp=".+@.+\\..+",message="Wrong email")
	private String Email;
	private String Address;
	private String ContactNumber;
	private String CountryName;
	private boolean Admin;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		this.Admin = admin;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

}
