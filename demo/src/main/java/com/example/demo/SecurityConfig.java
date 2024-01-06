package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        
           .authorizeHttpRequests((authz)->
            authz.requestMatchers("/api/tasks/**").hasRole("ADMIN")
            
            .anyRequest()
           .authenticated());
          
           return http.build();
    }
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeRequests()
    //             .antMatchers("/api/tasks/**").authenticated()
    //             .anyRequest().permitAll()
    //         .and()
    //         .httpBasic()
    //         .and()
    //         .csrf().disable();
    // }
}
