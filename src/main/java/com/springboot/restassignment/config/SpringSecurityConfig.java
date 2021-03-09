package com.springboot.restassignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {



           User.UserBuilder users = User.withDefaultPasswordEncoder();

            //roles can by multiple

            auth.inMemoryAuthentication()
                    .withUser(users.username("user1").password("test123").roles("USER"))
                    .withUser(users.username("admin1").password("test123").roles("USER","ADMIN"))
                    .withUser(users.username("provider1").password("test123").roles("USER","PROVIDER"));


        }

        // Secure the endpoints with HTTP Basic authentication
        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http
                    //HTTP Basic authentication
                    .httpBasic()
                    .and()

                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/providers/**").hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.PUT, "/providers/**").hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/providers/**").hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.POST, "/users/**").hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.PUT, "/users/**").hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/users/**").hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.GET, "/providers/**").hasAnyRole("USER", "ADMIN", "PROVIDERS")
                    .antMatchers(HttpMethod.GET, "/users/**").hasAnyRole("USER", "ADMIN", "PROVIDERS")
                    .antMatchers(HttpMethod.GET, "/claims/**").hasAnyRole("USER", "ADMIN", "PROVIDERS")
                    .antMatchers(HttpMethod.DELETE, "/claims/**").hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.POST, "/claims/**").hasAnyRole("ADMIN")
                    .antMatchers(HttpMethod.PUT, "/claims/**").hasAnyRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                    .csrf().disable()
                    .formLogin().disable();
        }


}
