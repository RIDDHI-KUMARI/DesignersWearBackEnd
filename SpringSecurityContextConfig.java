package com.niit.designerswear.config;

	import javax.sql.DataSource;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

	@Configuration
	@EnableWebSecurity
	public class SpringSecurityContextConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		DataSource dataSource;

		@Autowired
		public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		  auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
				"select username,password, enabled from users where username=?")
			.authoritiesByUsernameQuery(
				"select Username, role from authorities where Username=?");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

		  http.authorizeRequests()
			.antMatchers("/Admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/User/**").access("hasRole('ROLE_USER')")
			.and()
			  .formLogin().loginPage("/Login").failureUrl("/Login?error")
			  .usernameParameter("Username").passwordParameter("Password")
			.and()
			  .logout().logoutSuccessUrl("/Login?logout")
			.and()
			  .exceptionHandling().accessDeniedPage("/403")
			.and()
			  .csrf();
		}
		
	}


