package com.example.projecttracker.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("SELECT username, password, enabled FROM account")
//                .au
    	
    	//-- from the github
    	System.out.println("in configure");
        auth.jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(passwordEncoder())
        .usersByUsernameQuery("SELECT username, password, enabled "
        		+ "FROM account "
        		+ "WHERE username = ?")
        .authoritiesByUsernameQuery("select account.username, usr_type.utype_descr "
        		+ "from users "
        		+ "inner join account on users.id = account.user_id "
        		+ "inner join usr_type on users.user_type = usr_type.id "
        		+ "where account.username = ?");
        
        
        
        
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic();
//    }
	// --- working with angular
    @Override
    protected void configure(HttpSecurity http) throws Exception {        
        http.csrf(). disable()
//        	.antMatcher("/api/v1/faq").
            .authorizeRequests()
            .antMatchers(HttpMethod.GET,"/api/v1/faq").permitAll()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
        
    }
}
