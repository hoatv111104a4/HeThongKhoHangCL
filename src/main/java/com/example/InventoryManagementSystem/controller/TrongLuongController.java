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


import com.example.InventoryManagementSystem.entity.TrongLuong;
import com.example.InventoryManagementSystem.service.TrongLuongService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/trong-luong")
public class TrongLuongController {
    private final TrongLuongService trongLuongService;

    public TrongLuongController(TrongLuongService trongLuongService) {
        this.trongLuongService = trongLuongService;
    }

    @GetMapping("/hien-thi")
    public String listTrongLuong(Model model,@RequestParam(defaultValue = "0" )int page){
        loadTrongLuong(model, page);
        model.addAttribute("content", "views/TrongLuongHienThi");        
        return "Home/TrangChu"; 
        
    }
    @GetMapping("xoa-trong-luong/{id}")
    public String deleteTrongLuong(@PathVariable("id") Integer id){
        trongLuongService.deleteTrongLuong(id);
        return "redirect:/trong-luong/hien-thi";
    }
    @PostMapping("/them-trong-luong")
    public String addTrongLuong(@Valid @ModelAttribute("trongLuong") TrongLuong trongLuong,BindingResult bindingResult,Model model,@RequestParam(defaultValue = "0" ) int size){
        if (bindingResult.hasErrors()) {
            loadTrongLuong(model,size);
            model.addAttribute("org.springframework.validation.BindingResult.trongLuong", bindingResult);
            model.addAttribute("content", "views/TrongLuongHienThi");        
            return "Home/TrangChu";         }
        trongLuongService.addTrongLuong(trongLuong);
        return "redirect:/trong-luong/hien-thi";
    }
    

    private void loadTrongLuong(Model model , int page){
        Page<TrongLuong> trongLuongPage = trongLuongService.getAllTrongLuong(page, 7);
        model.addAttribute("trongLuongPage", trongLuongPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", trongLuongPage.getTotalPages());
        model.addAttribute("trongLuong", new TrongLuong());
    }
}
