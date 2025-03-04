package com.example.InventoryManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trang-chu")
public class TrangChuController {
    @GetMapping("/hien-thi")
    public String hienThiTrangChu(){
        return "/Home/TrangChu";
    }
}
