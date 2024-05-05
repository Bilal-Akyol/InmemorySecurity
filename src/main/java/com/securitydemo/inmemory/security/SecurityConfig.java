package com.securitydemo.inmemory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails ogrenci= User.builder()
                .username("Öğrenci")
                .password(passwordEncoder().encode("1903"))
                .roles("OGRENCI")
                .build();
        UserDetails ogretmen= User.builder()
                .username("Öğretmen")
                .password(passwordEncoder().encode("1903"))
                .roles("OGRETMEN")
                .build();
        return new InMemoryUserDetailsManager(ogrenci,ogretmen);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
                .headers(x ->x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(x-> x.requestMatchers("/university/lessons/**").permitAll())
                .authorizeHttpRequests(x-> x.requestMatchers("/univesity/assignLesson/**").hasRole("OGRETMEN"))
                .authorizeHttpRequests(x-> x.requestMatchers("/university/removeLesson/**").hasRole("OGRETMEN"))
                .authorizeHttpRequests(x-> x.requestMatchers("/university/addLesson/**q").hasRole("OGRETMEN"));



        return httpSecurity.build();

    }
}
