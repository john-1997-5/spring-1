package com.johnson.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // permitir acceso a todas las requests
/*        return http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();*/

        // denegar acceso a todas las requests
/*        return http.authorizeHttpRequests(auth -> auth.anyRequest().denyAll())
                .httpBasic(Customizer.withDefaults())
                .build();*/

        // se permite el acceso a unas páginas, pero para otras se necesita autenticarse
        return http.csrf().disable().authorizeHttpRequests(auth -> auth
                .antMatchers("/home").permitAll()
                // acceso a holidays y todas sus subpáginas
                .antMatchers("/holidays/**").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/saveMsg").permitAll()
                .antMatchers("/courses").authenticated() // necesita autenticarse
                .antMatchers("/about").permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
