package com.ecommerce.ecommerceProject.security;


import com.ecommerce.ecommerceProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.
            authorizeRequests().antMatchers("/cart").authenticated().and()
            .formLogin().loginPage("/signin")
            .loginProcessingUrl("/signin").and()
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
            .logoutSuccessUrl("/");
    // remove the following before deployment (needed security stuff)
    http.csrf().disable();
    http.headers().frameOptions().disable();
    }
}

