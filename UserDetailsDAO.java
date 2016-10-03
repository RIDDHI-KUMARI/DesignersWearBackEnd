package com.niit.designerswear.dao;

import java.util.List;

import com.niit.designerswear.model.UserDetails;

public interface UserDetailsDAO {
	public List<UserDetails> list();

	public UserDetails get(String id);

	public void saveOrUpdate(UserDetails userdetails);

	public void delete(String id);


}
