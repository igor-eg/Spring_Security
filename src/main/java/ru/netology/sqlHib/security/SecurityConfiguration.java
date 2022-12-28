package ru.netology.sqlHib.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Admin").password("{noop}password1").authorities("read", "write")
                .and()
                .withUser("Writer").password("{noop}password2").authorities("read", "write")
                .and()
                .withUser("Reader").password("{noop}password3").authorities("read");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/city/read/all", "/persons/person/read/all")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/city/create" ).hasAuthority("write")
                .and()
                .authorizeRequests().antMatchers("/persons/city/read").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers().authenticated();
    }
}
