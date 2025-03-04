package com.example.InventoryManagementSystem.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.InventoryManagementSystem.entity.NhanVien;
import com.example.InventoryManagementSystem.service.NhanVienService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dang-nhap")
public class DangNhapController {
    private final NhanVienService nhanVienService;
    
    public DangNhapController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @GetMapping("/hien-thi")
    public String showFormLogin(){
        return "/Login/DangNhap";
    }

    @PostMapping("/cap-nhat")
    public String dangNhap(@RequestParam String emailNhanVien,@RequestParam String matKhau, HttpSession session,Model model){
        Optional<NhanVien> nhanVienOptional = nhanVienService.findByEmail(emailNhanVien);
        if (nhanVienOptional.isEmpty()) {
            model.addAttribute("error", "Email nhân viên không tồn tại");
            return "/Login/DangNhap";
        }

        NhanVien nhanVien = nhanVienOptional.get();
        if (!nhanVien.getMatKhau().equals(matKhau)) {
            model.addAttribute("error", "Mật khẩu không đúng");
            return "/Login/DangNhap";
        }
        session.setAttribute("nhanVienDangNhap", nhanVien);
        session.setAttribute("tenNhanVien", nhanVien.getTenNhanVien());
        return "redirect:/phieu-nhap/hien-thi";
    }
}
