package com.sailpoint.interview.atm.security;

import com.sailpoint.interview.atm.domain.Customer;
import com.sailpoint.interview.atm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomerService customerService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
//        http.headers().frameOptions().disable(); // Add this if you want to mess around with the h2 console via browser
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        for(Customer customer : customerService.getAllCustomers()) { // allow any user in the DB to authenticate
            auth.inMemoryAuthentication()
                    .withUser(customer.getName())
                    .password(encoder.encode(Integer.toString(customer.getPin())))
                    .roles("USER");
        }
    }

}
