package com.example.InventoryManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.InventoryManagementSystem.service.NhanVienService;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeHttpRequests(auth -> auth
    //             .requestMatchers("/dang-nhap/**", "/css/**", "/js/**", "/images/**").permitAll()
    //             .anyRequest().authenticated()
    //         )
    //         .formLogin(login -> login
    //             .loginPage("/dang-nhap/hien-thi")
    //             .loginProcessingUrl("/dang-nhap/xu-ly")
    //             .defaultSuccessUrl("/phieu-nhap/hien-thi")
    //             .permitAll()
    //         )
    //         .logout(logout -> logout
    //             .logoutUrl("/dang-xuat")
    //             .logoutSuccessUrl("/dang-nhap/hien-thi")
    //             .permitAll()
    //         )
    //         .csrf(csrf -> csrf.disable()); // Hoặc kích hoạt CSRF và thêm token vào form

    //     return http.build();
    // }
}

