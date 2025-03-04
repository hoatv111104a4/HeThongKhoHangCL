package com.example.InventoryManagementSystem.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.InventoryManagementSystem.dto.SanPhamNhapDto;
import com.example.InventoryManagementSystem.entity.NhaCungCap;
import com.example.InventoryManagementSystem.entity.NhaKho;
import com.example.InventoryManagementSystem.entity.NhanVien;
import com.example.InventoryManagementSystem.entity.PhieuNhap;
import com.example.InventoryManagementSystem.entity.PhieuNhapChiTiet;
import com.example.InventoryManagementSystem.entity.SanPhamChiTiet;
import com.example.InventoryManagementSystem.entity.TrongLuong;
import com.example.InventoryManagementSystem.service.ChieuDaiVotService;
import com.example.InventoryManagementSystem.service.CongNgheService;
import com.example.InventoryManagementSystem.service.DoCungDuaService;
import com.example.InventoryManagementSystem.service.NhaCungCapService;
import com.example.InventoryManagementSystem.service.NhaKhoService;
import com.example.InventoryManagementSystem.service.NhanVienService;
import com.example.InventoryManagementSystem.service.PhieuNhapChiTietService;
import com.example.InventoryManagementSystem.service.PhieuNhapService;
import com.example.InventoryManagementSystem.service.SanPhamChiTietService;
import com.example.InventoryManagementSystem.service.SanPhamService;
import com.example.InventoryManagementSystem.service.SwingWeightService;
import com.example.InventoryManagementSystem.service.ThuongHieuService;
import com.example.InventoryManagementSystem.service.TrongLuongService;
import com.example.InventoryManagementSystem.service.XuatXuService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/phieu-nhap")
public class PhieuNhapController {
    private final PhieuNhapService phieuNhapService;
    private final SanPhamService sanPhamService;
    private final ChieuDaiVotService chieuDaiVotService;
    private final DoCungDuaService doCungDuaService;
    private final SwingWeightService swingWeightService;
    private final ThuongHieuService tHieuService;
    private final TrongLuongService trongLuongService;
    private final CongNgheService congNgheService;
    private final NhaKhoService nhaKhoService;
    private final XuatXuService xuatXuService;
    private final NhaCungCapService nhaCungCapService;
    private final SanPhamChiTietService sanPhamChiTietService;
    private final PhieuNhapChiTietService phieuNhapChiTietService;
    private final NhanVienService nhanVienService;
    

    public PhieuNhapController(PhieuNhapService phieuNhapService, SanPhamService sanPhamService,
            ChieuDaiVotService chieuDaiVotService, DoCungDuaService doCungDuaService,
            SwingWeightService swingWeightService, ThuongHieuService tHieuService, TrongLuongService trongLuongService,
            CongNgheService congNgheService, NhaKhoService nhaKhoService, XuatXuService xuatXuService,
            NhaCungCapService nhaCungCapService, SanPhamChiTietService sanPhamChiTietService,
            PhieuNhapChiTietService phieuNhapChiTietService,NhanVienService nhanVienService) {
        this.phieuNhapService = phieuNhapService;
        this.sanPhamService = sanPhamService;
        this.chieuDaiVotService = chieuDaiVotService;
        this.doCungDuaService = doCungDuaService;
        this.swingWeightService = swingWeightService;
        this.tHieuService = tHieuService;
        this.trongLuongService = trongLuongService;
        this.congNgheService = congNgheService;
        this.nhaKhoService = nhaKhoService;
        this.xuatXuService = xuatXuService;
        this.nhaCungCapService = nhaCungCapService;
        this.sanPhamChiTietService = sanPhamChiTietService;
        this.phieuNhapChiTietService = phieuNhapChiTietService;
        this.nhanVienService = nhanVienService;
    }

    @GetMapping("/hien-thi")
    public String listPhieuNhap(Model model,@RequestParam(defaultValue = "0" )int page) {            
        loadPhieuNhap(model, page);
        model.addAttribute("content", "views/PhieuNhapHienThi");        
        return "Home/TrangChu";
    }

    @GetMapping("/tao-phieu-nhap")
    public String taoPhieuNhap(Model model,HttpSession session) {
        
        model.addAttribute("phieuNhap", new PhieuNhap());
        model.addAttribute("sanPhamNhap", new SanPhamNhapDto());
        model.addAttribute("sanPham", sanPhamService.listSanPhams());
        model.addAttribute("chieuDai", chieuDaiVotService.listChieuDai());
        model.addAttribute("doCung", doCungDuaService.listDoCung());
        model.addAttribute("swing", swingWeightService.listSwingweights());
        model.addAttribute("thuongHieu", tHieuService.listThuongHieu());
        model.addAttribute("trongLuong", trongLuongService.listTrongLuongs());
        model.addAttribute("congNghe", congNgheService.listCongNghe());
        model.addAttribute("nhaKho", nhaKhoService.listNhaKho());
        model.addAttribute("xuatXu", xuatXuService.listXuatXus());
        model.addAttribute("nhaCungCap", nhaCungCapService.listNhaCungCap());
        model.addAttribute("nhanViens", nhanVienService.getAllNhanVien());
        List<PhieuNhapChiTiet> listPhieuNhapChiTiets = phieuNhapChiTietService.getAllPhieuNhaps();
        model.addAttribute("listPhieuNhapChiTiets", listPhieuNhapChiTiets);

        model.addAttribute("content", "adds/ThemPhieuNhap");        
        return "Home/TrangChu";
        

    }

    @PostMapping("/them-san-pham-vao-gio")
    public String themSanPhamVaoGio(@ModelAttribute("sanPhamNhap") SanPhamNhapDto sanPhamNhapDTO,
            RedirectAttributes redirectAttributes,HttpSession session ) {

        SanPhamChiTiet sanPhamChiTiet = sanPhamNhapDTO.getSanPhamChiTiet();
        PhieuNhapChiTiet phieuNhapChiTiet = sanPhamNhapDTO.getPhieuNhapChiTiet();
        NhaKho nhaKho = sanPhamNhapDTO.getNhaKho();
        PhieuNhap phieuNhap = phieuNhapService.taoPhieuNhap(session);
        phieuNhapService.themSanPhamVaPhieuNhapChiTiet(sanPhamChiTiet, phieuNhapChiTiet, nhaKho,phieuNhap);
        // Lấy danh sách sản phẩm trong giỏ hàng
        List<PhieuNhapChiTiet> danhSachChiTiet = phieuNhapService.layDanhSachPhieuNhapChiTiet();

        // Tính tổng tiền từ danh sách trên
        double tongTien = phieuNhapService.tinhTongTienGioHang(danhSachChiTiet);

        // Lưu tổng tiền vào RedirectAttributes để hiển thị
        redirectAttributes.addFlashAttribute("tongTien", tongTien);
        return "redirect:/phieu-nhap/tao-phieu-nhap";
    }
    

    @PostMapping("/nhap-hang")
    public String nhapHang(@ModelAttribute("phieuNhap") PhieuNhap phieuNhap,HttpSession session,NhaCungCap nhaCungCap){
        phieuNhap =(PhieuNhap)session.getAttribute("phieuNhap");  
        phieuNhap.setNhaCungCap(nhaCungCap);      
        phieuNhapService.luuPhieuNhap(phieuNhap);
        session.removeAttribute("phieuNhap");
        return "redirect:/phieu-nhap/hien-thi";   
    }

    private void loadPhieuNhap(Model model , int page){
        int size = 7;
        Page<PhieuNhap> phieuNhapPage = phieuNhapService.getAllPhieuNhap(page, size);
        model.addAttribute("phieuNhapPage", phieuNhapPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", phieuNhapPage.getTotalPages());
        model.addAttribute("phieuNhap", new PhieuNhap());
    }
}
