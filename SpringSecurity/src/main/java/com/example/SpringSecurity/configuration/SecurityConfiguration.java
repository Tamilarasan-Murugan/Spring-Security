package com.example.SpringSecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customizer -> customizer.disable());
        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
//        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetails> users=new ArrayList<>();

        UserDetails user1=User.withDefaultPasswordEncoder()
                .username("Tharun")
                .password("1234")
                .roles("USER")
                .build();

        UserDetails user2=User.withDefaultPasswordEncoder()
                .username("Vinith")
                .password("9999")
                .roles("USER")
                .build();

        UserDetails user3=User.withDefaultPasswordEncoder()
                .username("Surya")
                .password("2027")
                .roles("USER")
                .build();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        return new InMemoryUserDetailsManager(users);
//        return new InMemoryUserDetailsManager(user1,user2,user3); //Varargs
    }
}