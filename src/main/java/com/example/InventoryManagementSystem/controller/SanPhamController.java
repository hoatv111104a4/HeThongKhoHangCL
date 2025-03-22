package com.example.InventoryManagementSystem.controller;

import com.example.InventoryManagementSystem.entity.SanPham;
import com.example.InventoryManagementSystem.service.FileStorageService;
import com.example.InventoryManagementSystem.service.SanPhamService;

import jakarta.validation.Valid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    
    private final SanPhamService sanPhamService;
    private final FileStorageService fileStorageService;    
    public SanPhamController(SanPhamService sanPhamService, FileStorageService fileStorageService) {
        this.sanPhamService = sanPhamService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/hien-thi")
    public String listSanPham(@RequestParam(defaultValue = "0") int page, Model model) {
        loadSanPham(model, page);
        model.addAttribute("content", "views/SanPhamHienThi");
        return "Home/TrangChu";

    }

    @PostMapping("/them-san-pham")
    public String addSanPham(@RequestParam(defaultValue = "0") int page,
            @RequestParam("file") MultipartFile file,
            @Valid @ModelAttribute("sanPham") SanPham sanPham,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            loadSanPham(model, page);
            model.addAttribute("org.springframework.validation.BindingResult.sanPham", bindingResult);
            model.addAttribute("content", "views/SanPhamHienThi");
            return "Home/TrangChu";
        }

        // Lưu file ảnh vào server
        if (!file.isEmpty()) {
            try {
                String uploadDir = "D:/Java5/PersionProject/InventoryManagementSystem/uploads/thuong-hieu/";
                Files.createDirectories(Paths.get(uploadDir)); 
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                sanPham.setHinhAnh(fileName); // Lưu tên file vào database
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        sanPhamService.addSanPham(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/xoa-san-pham/{id}")
    public String deleteSanPham(@PathVariable("id") Integer id) {
        sanPhamService.deleteSanPham(id);
        return "redirect:/san-pham/hien-thi";
    }

    private void loadSanPham(Model model, int page) {
        Page<SanPham> sanPhamPage = sanPhamService.getAllSanPham(page, 7);
        model.addAttribute("sanPhamPage", sanPhamPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", sanPhamPage.getTotalPages());
        model.addAttribute("sanPham", new SanPham());
    }

}
