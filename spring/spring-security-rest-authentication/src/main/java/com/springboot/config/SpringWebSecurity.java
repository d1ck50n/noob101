package com.springboot.config;

import com.springboot.authentication.RestAuthorizationFilter;
import com.springboot.authentication.RestAuthenticationEntryPoint;
import com.springboot.store.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

/**
 *
 * @author dicksonk
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true) // to allow secure annotation on method to control access
public class SpringWebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.anonymous().and()
                .antMatcher("/**")
                .csrf().disable()
                .logout().disable()
                .sessionManagement().disable()
                .headers().disable()
                .requestCache().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
                .addFilterAfter(new RestAuthorizationFilter(userService), SecurityContextPersistenceFilter.class);
    }
}
