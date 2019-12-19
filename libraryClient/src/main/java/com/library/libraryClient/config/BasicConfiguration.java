package com.library.libraryClient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application-security.properties")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // face enabled anotarea @PreAuthorize la metode
@Component
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
	
	@Value("${security.user.password}")
	private String passwordUser;
	@Value("${security.admin.password}")
	private String passwordAdmin;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {
		auth.inMemoryAuthentication()
        .withUser("user")
          .password(passwordEncoder.encode("user"))
          .roles("USER")
          .and()
        .withUser("admin")
          .password(passwordEncoder.encode("admin"))
          .roles( "ADMIN");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
//			.antMatchers("/hello/girl/**").permitAll() // serviciul rest merge apelat doar daca userul are rol admin
//			.antMatchers("/index*").permitAll()
//			.antMatchers("/login*").permitAll()
//			.antMatchers("/logout*").permitAll()
//			.antMatchers("/results*").permitAll()
//			.antMatchers("/playagame").permitAll()
//			.antMatchers("/studies*").permitAll()
//			.antMatchers("/hello/boy").permitAll()  // serviciul rest merge apelat doar userul este logat
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/home.jsp").permitAll()
//	        .failureUrl("/login-error.html")
	        .and()
	        .logout()
	        .clearAuthentication(true)
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/home.jsp").permitAll();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
 
}