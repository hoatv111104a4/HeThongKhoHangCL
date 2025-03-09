package com.example.InventoryManagementSystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.InventoryManagementSystem.entity.NhaKho;
import com.example.InventoryManagementSystem.service.NhaKhoService;
import com.example.InventoryManagementSystem.service.SanPhamCtNkService;

@Controller
@RequestMapping("/nha-kho")
public class NhaKhoController {
    private final NhaKhoService nhaKhoService;
    private final SanPhamCtNkService SanPhamCtNkService;
    

    public NhaKhoController(NhaKhoService nhaKhoService,
            com.example.InventoryManagementSystem.service.SanPhamCtNkService sanPhamCtNkService) {
        this.nhaKhoService = nhaKhoService;
        SanPhamCtNkService = sanPhamCtNkService;
    }


    @GetMapping("/hien-thi")
    public String listNhaKho(Model model){
        List<NhaKho> nhaKhoList = nhaKhoService.listNhaKho();
        model.addAttribute("nhaKhoList", nhaKhoList);
        model.addAttribute("content", "views/NhaKhoHienThi");        
        return "Home/TrangChu";
    }

}
