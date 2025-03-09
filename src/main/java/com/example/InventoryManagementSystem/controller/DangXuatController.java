package com.example.InventoryManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DangXuatController {
    @GetMapping("/dang-xuat")
    public String dangXuat(HttpSession session){
        session.removeAttribute("nhanVienDangNhap");
        session.removeAttribute("tenNhanVien");
        return "redirect:/dang-nhap/hien-thi";
    }
}
