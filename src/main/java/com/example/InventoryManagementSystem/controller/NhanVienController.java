package com.example.InventoryManagementSystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.InventoryManagementSystem.entity.NhanVien;
import com.example.InventoryManagementSystem.service.ChucVuService;
import com.example.InventoryManagementSystem.service.NhanVienService;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {
    private final NhanVienService nhanVienService;
    private final ChucVuService chucVuService;

    public NhanVienController(NhanVienService nhanVienService, ChucVuService chucVuService) {
        this.nhanVienService = nhanVienService;
        this.chucVuService = chucVuService;
    }

    @GetMapping("/hien-thi")
    public String listNhanVien(Model model){
        List<NhanVien> nhanVienList = nhanVienService.getAllNhanVien();
        model.addAttribute("nhanVienList", nhanVienList);
        model.addAttribute("content", "views/NhanVienHienThi");        
        return "Home/TrangChu";
    }
    
}
