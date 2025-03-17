package com.example.InventoryManagementSystem.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.InventoryManagementSystem.entity.KhachHang;
import com.example.InventoryManagementSystem.service.KhacHangService;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    private final KhacHangService khacHangService;
    public KhachHangController(KhacHangService khacHangService) {
        this.khacHangService = khacHangService;
    }

    @GetMapping("/hien-thi")
    public String pageKhachHang(@RequestParam(defaultValue = "0") int page,Model model){
        loadKhachHang(model, page);
        model.addAttribute("content", "views/KhachHangHienThi");
        return "Home/TrangChu";
    }
    private void loadKhachHang(Model model,int page){
        int size = 6;
        Page<KhachHang> khachHangPage = khacHangService.PageKhachHang(page, size);
        model.addAttribute("khachHangPage", khachHangPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", khachHangPage.getTotalPages());
        model.addAttribute("khachhang", new KhachHang());
    }
}
