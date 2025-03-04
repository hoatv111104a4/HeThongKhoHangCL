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


import com.example.InventoryManagementSystem.entity.DoCungDua;
import com.example.InventoryManagementSystem.service.DoCungDuaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/do-cung")
public class DoCungController {
    private final DoCungDuaService doCungDuaService;

    public DoCungController(DoCungDuaService doCungDuaService) {
        this.doCungDuaService = doCungDuaService;
    }
    
    @GetMapping("/hien-thi")
    public String listDoCung(@RequestParam(defaultValue = "0") int page,Model model){
        loadDoCung(model, page);
        model.addAttribute("content", "views/DoCungHienThi");        
        return "Home/TrangChu"; 
        
    }

    @GetMapping("/xoa-do-cung/{id}")
    public String deleteDoCung(@PathVariable("id") int id){
        doCungDuaService.deleteDoCungDua(id);
        return "redirect:/do-cung/hien-thi";
    }
    @PostMapping("/them-do-cung")
    public String addDoCung(@Valid @ModelAttribute("doCung2") DoCungDua doCungDua,BindingResult bindingResult , @RequestParam(defaultValue = "0") int page ,Model model){
        if (bindingResult.hasErrors()) {
            loadDoCung(model, page);
            model.addAttribute("org.springframework.validation.BindingResult.doCung2", bindingResult);
            model.addAttribute("content", "views/DoCungHienThi");        
        return "Home/TrangChu"; 
        }
        doCungDuaService.addDoCungDua(doCungDua);
        return "redirect:/do-cung/hien-thi";
    }

    private void loadDoCung(Model model , int page){
        Page<DoCungDua> doCungPage = doCungDuaService.getAllDoCungDua(page, 7);
        model.addAttribute("doCungPage", doCungPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", doCungPage.getTotalPages());
        model.addAttribute("doCung2", new DoCungDua());
    }
}
