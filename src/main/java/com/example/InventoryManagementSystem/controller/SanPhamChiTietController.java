package com.example.InventoryManagementSystem.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.InventoryManagementSystem.dto.SanPhamChiTietDto;
import com.example.InventoryManagementSystem.dto.SanPhamChiTietProjection;
import com.example.InventoryManagementSystem.service.SanPhamChiTietService;

@Controller
@RequestMapping("/san-pham-ct")
public class SanPhamChiTietController {
    private final SanPhamChiTietService sanPhamChiTietService;

    public SanPhamChiTietController(SanPhamChiTietService sanPhamChiTietService) {
        this.sanPhamChiTietService = sanPhamChiTietService;
    }

    @GetMapping("/hien-thi")
    public String listSanPhamCt(Model model,@RequestParam(defaultValue = "0") int page){
        loadSanPhamChiTietGetSP(model, page);
        model.addAttribute("content", "views/SanPhamChiTietHienThi");        
        return "Home/TrangChu";
        

    }

    @GetMapping("/xoa-san-pham/{id}")
    public String deleteSanPham(@PathVariable("id") int id){
        sanPhamChiTietService.deleteSanPham(id);
        return "redirect:/san-pham-ct/hien-thi";
    }

    @GetMapping("/tim-kiem-theo-ten")
    public String searchName(Model model,@RequestParam(defaultValue = "0") int page,String tenSanPham){        
        loadSanPhamChiTietSearchName(model, page, tenSanPham);        
        return "/views/SanPhamChiTietHienThi";
    }

    @GetMapping("/tim-kiem-khoang-gia")
    public String searchKhoangGia(@RequestParam(defaultValue = "0") int page,Model model,Double giaMin,Double giaMax){
        loadSanPhamChiTietSearchGiaTien(model, page, giaMin, giaMax);
        return "/views/SanPhamChiTietHienThi";
    }

    @GetMapping("/tim-kiem")
    public String search(
        @RequestParam(defaultValue = "0") int page,
        Model model,
        @RequestParam(required = false) Double giaMin,
        @RequestParam(required = false) Double giaMax,
        @RequestParam(required = false) String tenSanPham) {

    loadSanPhamChiTiet(model, page, tenSanPham, giaMin, giaMax);
     // Truyền lại tham số để giữ dữ liệu khi chuyển trang
     model.addAttribute("tenSanPham", tenSanPham);
     model.addAttribute("giaMin", giaMin);
     model.addAttribute("giaMax", giaMax);
     model.addAttribute("content", "views/SanPhamChiTietHienThi");        
     return "Home/TrangChu";
    }

    private void loadSanPhamChiTietGetSP(Model model,int page){
        loadSanPhamChiTiet(model, page, null, null, null);;
    }
    private void loadSanPhamChiTietSearchName(Model model , int page , String tenSanPham){
        loadSanPhamChiTiet(model, page, tenSanPham, null, null);
    }
    private void loadSanPhamChiTietSearchGiaTien(Model model ,int page,Double giaMin,Double giaMax){
        loadSanPhamChiTiet(model, page, null, giaMin, giaMax);
    }
    
    private void loadSanPhamChiTiet(Model model , int page,String tenSanPham,Double giaMin,Double giaMax){

        Page<SanPhamChiTietProjection> sanPhamCtPage ;
        if (tenSanPham == null && giaMin == null && giaMax == null) {
            sanPhamCtPage =sanPhamChiTietService.getAllSanPhamCTDTO(page, 7);
        }else if(giaMin == null && giaMax == null){
            sanPhamCtPage = sanPhamChiTietService.searchName(page, 7, tenSanPham);
        }else if(tenSanPham == null){
            sanPhamCtPage = sanPhamChiTietService.searchGiaTien(page, 7, giaMin, giaMax);
        }else{
            sanPhamCtPage = sanPhamChiTietService.searchNameAndKhoangGia(page,7,giaMin,giaMax,tenSanPham);
        }
        model.addAttribute("sanPhamCtPage", sanPhamCtPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", sanPhamCtPage.getTotalPages());
        model.addAttribute("sanPhamCt", new SanPhamChiTietDto());
    }
    
}
