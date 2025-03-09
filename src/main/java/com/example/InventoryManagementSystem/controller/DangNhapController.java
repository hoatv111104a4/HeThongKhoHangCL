package com.example.InventoryManagementSystem.controller;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.InventoryManagementSystem.dto.LoginDto;
import com.example.InventoryManagementSystem.entity.NhanVien;
import com.example.InventoryManagementSystem.service.NhanVienService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/dang-nhap")
public class DangNhapController {
    private final NhanVienService nhanVienService;
    private final PasswordEncoder passwordEncoder;
    

    public DangNhapController(NhanVienService nhanVienService, PasswordEncoder passwordEncoder) {
        this.nhanVienService = nhanVienService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/hien-thi")
    public String showFormLogin(Model model) {
        model.addAttribute("loginDTO", new LoginDto());
        return "/Login/DangNhap";
    }

    @PostMapping("/cap-nhat")
    public String dangNhap(@Valid @ModelAttribute("loginDTO") LoginDto loginDto, BindingResult bindingResult,
            HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "/Login/DangNhap";
        }

        Optional<NhanVien> nhanVienOptional = nhanVienService.findByEmail(loginDto.getEmail());
        if (nhanVienOptional.isEmpty()) {
            model.addAttribute("errorEmail", "Email nhân viên không tồn tại");
            return "/Login/DangNhap";
        }

        NhanVien nhanVienDB = nhanVienOptional.get();
        if (!passwordEncoder.matches(loginDto.getMatKhau(), nhanVienDB.getMatKhau())) {
            model.addAttribute("errorPass", "Mật khẩu không đúng");
            return "/Login/DangNhap";
        }

        session.setAttribute("nhanVienDangNhap", nhanVienDB);
        session.setAttribute("tenNhanVien", nhanVienDB.getTenNhanVien());
        return "redirect:/phieu-nhap/hien-thi";
    }

}
