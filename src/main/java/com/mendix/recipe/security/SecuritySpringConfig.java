package com.mendix.recipe.security;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecuritySpringConfig extends WebSecurityConfigurerAdapter {

	 private static final String[] ALLOWED_ENDPOINTS = {
				"/", "/swagger-ui/**", "/api-docs/**", "/v3/api-docs/**", "/swagger-resources/**", "/h2-console/**" };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //swagger endpoints
        String[] allowedEndpoints = ArrayUtils.addAll(
                // here you can add API anonymous endpoints
                ALLOWED_ENDPOINTS
        );

		http.httpBasic().disable();
		http.authorizeRequests().antMatchers(allowedEndpoints).permitAll().antMatchers("/console/*")
				.fullyAuthenticated().and().formLogin().permitAll();
		http.csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers(HttpMethod.OPTIONS, "/**");
        // ignore swagger
        web.ignoring().mvcMatchers(ALLOWED_ENDPOINTS);
    }

}
