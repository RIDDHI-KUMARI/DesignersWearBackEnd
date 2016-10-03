package com.niit.designerswear.dao;

import java.util.List;

import com.niit.designerswear.model.Authorities;

public interface AuthoritiesDAO {
	public List<Authorities> list();

	public Authorities get(String authority);

	public void saveOrUpdate(Authorities authorities);

	public void delete(String authority);

}



