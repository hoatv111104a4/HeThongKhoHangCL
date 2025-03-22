package com.example.InventoryManagementSystem.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.InventoryManagementSystem.entity.ThuongHieu;
import com.example.InventoryManagementSystem.service.ThuongHieuService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/thuong-hieu")
public class ThuongHieuController {
    private final ThuongHieuService thuongHieuService;

    public ThuongHieuController(ThuongHieuService thuongHieuService) {
        this.thuongHieuService = thuongHieuService;
    }

    @GetMapping("/hien-thi")
    public String listThuongHieu(@RequestParam(defaultValue = "0") int page ,Model model){
        loadThuongHieu(model, page);
        model.addAttribute("content", "views/ThuongHieuHienThi");        
        return "Home/TrangChu"; 
    }

    @GetMapping("/xoa-thuong-hieu/{id}")
    public String deleteThuongHieu(@PathVariable("id") Integer id){
        thuongHieuService.deleteThuongHieu(id);
        return "redirect:/thuong-hieu/hien-thi";
    }
    @PostMapping("/them-thuong-hieu")
    public String addThuongHieu(@Valid @ModelAttribute("thuongHieu") ThuongHieu thuongHieu,
                                BindingResult bindingResult,
                                @RequestParam("file") MultipartFile file, 
                                Model model, 
                                @RequestParam(defaultValue = "0") int page) {
        if (bindingResult.hasErrors()) {
            loadThuongHieu(model, page);
            model.addAttribute("content", "views/ThuongHieuHienThi");        
            return "Home/TrangChu";         }

        // Lưu file ảnh vào server
        if (!file.isEmpty()) {
            try {
                String uploadDir = "D:/Java5/PersionProject/InventoryManagementSystem/uploads/thuong-hieu/";
                Files.createDirectories(Paths.get(uploadDir)); 
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                thuongHieu.setDuongDanAnh(fileName); // Lưu tên file vào database
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        thuongHieuService.addThuongHieu(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }
    
    private void loadThuongHieu(Model model , int page){
        Page<ThuongHieu> thuongHieuPage = thuongHieuService.getAllThuongHieu(page,7);
        model.addAttribute("thuongHieuPage",thuongHieuPage.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPage",thuongHieuPage.getTotalPages());
        model.addAttribute("thuongHieu", new ThuongHieu());
    }
}
