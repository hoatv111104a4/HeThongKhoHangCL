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

import com.example.InventoryManagementSystem.entity.Swingweight;
import com.example.InventoryManagementSystem.service.SwingWeightService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/swing-weight")
public class SwingWeightController {

    private final SwingWeightService swingWeightService;
    

    public SwingWeightController(SwingWeightService swingWeightService) {
        this.swingWeightService = swingWeightService;
    }

    @GetMapping("/hien-thi")
    public String listSwingWeight(Model model,@RequestParam(defaultValue = "0") int page){
        loadSwingWeight(model, page);
        model.addAttribute("content", "views/SwingWeightHienThi");        
        return "Home/TrangChu"; 
        
    }

    @GetMapping("/xoa-swing-weight/{id}")
    public String deleteSwingWeight(@PathVariable("id") int id ){
        swingWeightService.deleteByIdSwingWeight(id);
        return "redirect:/swing-weight/hien-thi";
    }

    @PostMapping("/them-swing-weight")
    public String addSwingWeight(@Valid @ModelAttribute("swingWeight2") Swingweight swingweight , BindingResult bindingResult ,@RequestParam(defaultValue = "0") int page,Model model ){
        if (bindingResult.hasErrors()) {
            loadSwingWeight(model, page);
            model.addAttribute("org.springframework.validation.BindingResult.swingWeight2", bindingResult);
            model.addAttribute("content", "views/SwingWeightHienThi");        
        return "Home/TrangChu"; 
        }
        swingWeightService.addSwingWeight(swingweight);
        return "redirect:/swing-weight/hien-thi"; 
    }

    private void loadSwingWeight(Model model , int page){
        Page<Swingweight> swingWeightPage = swingWeightService.getAllSwingWeight(page,7);
        model.addAttribute("swingWeightPage",swingWeightPage.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPage",swingWeightPage.getTotalPages());
        model.addAttribute("swingWeight2", new Swingweight());
    }
}
