package com.example.InventoryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.InventoryManagementSystem.entity.ChieuDaiVot;
import com.example.InventoryManagementSystem.service.ChieuDaiVotService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/chieu-dai-vot")
public class chieuDaiVotController {
    @Autowired
    private  ChieuDaiVotService chieuDaiVotService;

    public chieuDaiVotController(ChieuDaiVotService chieuDaiVotService) {
        this.chieuDaiVotService = chieuDaiVotService;
    }

    @GetMapping("/hien-thi")
    public String listChieuDaiVot(@RequestParam(defaultValue = "0") int page, Model model){
        loadChieuDaiVot(model, page);
        model.addAttribute("content", "views/ChieuDaiVotHienThi");        
        return "Home/TrangChu";        
    }
    
    @PostMapping("/them-chieu-dai")    
    public String addChieuDai(@Valid @ModelAttribute("chieudai") ChieuDaiVot chieuDaiVot ,BindingResult bindingResult,@RequestParam(defaultValue = "0") int page ,Model model ){
        if (bindingResult.hasErrors()) {
            loadChieuDaiVot(model, page);
            model.addAttribute("org.springframework.validation.BindingResult.chieudai", bindingResult); 
            model.addAttribute("content", "views/ChieuDaiVotHienThi");        
        return "Home/TrangChu"; 
        }
        chieuDaiVotService.addChieuDaiVot(chieuDaiVot);
        return "redirect:/chieu-dai-vot/hien-thi";
    }
    @GetMapping("/xoa-chieu-dai/{id}")
    public String deleteChieuDaiVot(@PathVariable("id") Integer id){
        chieuDaiVotService.deleteChieuDai(id);
        return "redirect:/chieu-dai-vot/hien-thi";
    }
    private void loadChieuDaiVot(Model model,int page){
        Page<ChieuDaiVot> chieuDaiPage = chieuDaiVotService.getAllChieuDaiVot(page, 6);
        model.addAttribute("chieuDaiPage", chieuDaiPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", chieuDaiPage.getTotalPages());
        model.addAttribute("chieudai", new ChieuDaiVot());
    }
    
}
