package com.niit.designerswear.config;

import java.util.Properties;

import javax.mail.Multipart;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.niit.designerswear.dao.CartDAO;
import com.niit.designerswear.dao.CartDAOImpl;
import com.niit.designerswear.dao.CartItemDAO;
import com.niit.designerswear.dao.CartItemDAOImpl;
import com.niit.designerswear.dao.CategoryDAO;
import com.niit.designerswear.dao.CategoryDAOImpl;
import com.niit.designerswear.dao.ProductDAO;
import com.niit.designerswear.dao.ProductDAOImpl;
import com.niit.designerswear.dao.SupplierDAO;
import com.niit.designerswear.dao.SupplierDAOImpl;
import com.niit.designerswear.dao.UserDAO;
import com.niit.designerswear.dao.UserDAOImpl;
import com.niit.designerswear.dao.UserDetailsDAO;
import com.niit.designerswear.dao.UserDetailsDAOImpl;
import com.niit.designerswear.model.Category;
import com.niit.designerswear.model.Product;
import com.niit.designerswear.model.Supplier;
import com.niit.designerswear.model.User;
import com.niit.designerswear.model.UserDetails;

@Configuration
@ComponentScan("com.niit.designerswear")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	properties.put("hibernate.hbm2ddl.auto", "update");
    	return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		return new SupplierDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDao(SessionFactory sessionFactory)
	{
		return new ProductDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDao(SessionFactory sessionFactory)
	{
		return new UserDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="userdetailsDAO")
	public UserDetailsDAO getuserdetailsDao(SessionFactory sessionFactory)
	{
		return new UserDetailsDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="cartDAO")
	public CartDAO getCartDao(SessionFactory sessionFactory)
	{
		return new CartDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="cartitemDAO")
	public CartItemDAO getcartitemDao(SessionFactory sessionFactory)
	{
		return new CartItemDAOImpl(sessionFactory);
	}
	
	
}
