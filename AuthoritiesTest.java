package com.niit.designerswear.test;

	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import com.niit.designerswear.dao.AuthoritiesDAO;
import com.niit.designerswear.model.Authorities;


	public class AuthoritiesTest {

		public static void main(String[] args) {
			
					AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
					context.scan("com.niit.designerswear");
					context.refresh();
					AuthoritiesDAO authoritiesDAO = (AuthoritiesDAO) context.getBean("authoritiesDAO");
					Authorities authorities = (Authorities) context.getBean("authorities");
					authorities.setAuthority("authority");
                    authorities.setUsername("user");			

					authoritiesDAO.saveOrUpdate(authorities);
			
		}

	}



