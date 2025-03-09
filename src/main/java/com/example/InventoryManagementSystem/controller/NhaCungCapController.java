package com.example.InventoryManagementSystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.InventoryManagementSystem.entity.NhaCungCap;
import com.example.InventoryManagementSystem.service.NhaCungCapService;

@Controller
@RequestMapping("/nha-cung-cap")
public class NhaCungCapController {
    private final NhaCungCapService nhaCungCapService;

    public NhaCungCapController(NhaCungCapService nhaCungCapService) {
        this.nhaCungCapService = nhaCungCapService;
    }
    
    @GetMapping("/hien-thi")
    public String listNhaCungCap(Model model){
        List<NhaCungCap> nhaCungCapList = nhaCungCapService.listNhaCungCap();
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("content", "views/NhaCungCapHienThi");        
        return "Home/TrangChu";
    }
}
