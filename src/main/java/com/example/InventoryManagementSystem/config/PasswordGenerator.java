package com.example.InventoryManagementSystem.config;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "hoa@123A4"; // Mật khẩu gốc
        String encodedPassword = passwordEncoder.encode(rawPassword); // Mã hóa mật khẩu
        System.out.println("Mật khẩu đã mã hóa: " + encodedPassword);
    }
}
