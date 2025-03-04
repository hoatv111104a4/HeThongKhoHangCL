package com.example.InventoryManagementSystem.controller;

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

import com.example.InventoryManagementSystem.entity.CongNghe;
import com.example.InventoryManagementSystem.service.CongNgheService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cong-nghe")
public class CongNgheController {
    private final CongNgheService congNgheService;

    public CongNgheController(CongNgheService congNgheService) {
        this.congNgheService = congNgheService;
    }

    @GetMapping("hien-thi")
    public String listCongNghe(@RequestParam(defaultValue = "0") int page,Model model){
        loadCongNghe(model, page);
        model.addAttribute("content", "views/CongNgheHienThi");        
        return "Home/TrangChu"; 
        
    }

    @GetMapping("xoa-cong-nghe/{id}")
    public String deleteCongNghe(@PathVariable("id") Integer id){
        congNgheService.deleteCongNghe(id);
        return "redirect:/cong-nghe/hien-thi";
    }
    @PostMapping("/them-cong-nghe")
    public String addCongNghe(@Valid @ModelAttribute("congNghe") CongNghe congNghe ,BindingResult bindingResult ,@RequestParam(defaultValue = "0") int page,Model model){
        if (bindingResult.hasErrors()) {
            loadCongNghe(model, page);
            model.addAttribute("org.springframework.validation.BindingResult.congNghe",bindingResult);
            model.addAttribute("content", "views/CongNgheHienThi");        
            return "Home/TrangChu"; 
        }
        congNgheService.addCongNghe(congNghe);
        return "redirect:/cong-nghe/hien-thi";
    }
    private void loadCongNghe(Model model,int page){
        Page<CongNghe> congNghePage = congNgheService.getAllCongNghe(page, 7);
        model.addAttribute("congNghePage", congNghePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", congNghePage.getTotalPages());
        model.addAttribute("congNghe", new CongNghe());
    }
}
