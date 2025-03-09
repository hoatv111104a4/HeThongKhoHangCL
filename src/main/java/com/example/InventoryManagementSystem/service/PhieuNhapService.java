package com.example.InventoryManagementSystem.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.NhaKho;
import com.example.InventoryManagementSystem.entity.NhanVien;
import com.example.InventoryManagementSystem.entity.PhieuNhap;
import com.example.InventoryManagementSystem.entity.PhieuNhapChiTiet;
import com.example.InventoryManagementSystem.entity.SanPhamChiTiet;
import com.example.InventoryManagementSystem.entity.SpctNhaKho;
import com.example.InventoryManagementSystem.entity.Swingweight;
import com.example.InventoryManagementSystem.repository.PhieuNhapChiTietRepo;
import com.example.InventoryManagementSystem.repository.PhieuNhapRepo;
import com.example.InventoryManagementSystem.repository.SanPhamCtNhaKhoRepo;
import com.example.InventoryManagementSystem.repository.SanPhamCtRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class PhieuNhapService {
    private final PhieuNhapRepo phieuNhapRepo;
    private final SanPhamCtRepo sanPhamCtRepo;
    private final PhieuNhapChiTietRepo phieuNhapChiTietRepo;
    private final SanPhamCtNhaKhoRepo sanPhamCtNhaKhoRepo;

    public PhieuNhapService(PhieuNhapRepo phieuNhapRepo, SanPhamCtRepo sanPhamCtRepo,
            PhieuNhapChiTietRepo phieuNhapChiTietRepo, SanPhamCtNhaKhoRepo sanPhamCtNhaKhoRepo) {
        this.phieuNhapRepo = phieuNhapRepo;
        this.sanPhamCtRepo = sanPhamCtRepo;
        this.phieuNhapChiTietRepo = phieuNhapChiTietRepo;
        this.sanPhamCtNhaKhoRepo = sanPhamCtNhaKhoRepo;
    }

    public PhieuNhap taoPhieuNhap(HttpSession session) {
        PhieuNhap phieuNhap = (PhieuNhap) session.getAttribute("phieuNhap");
        NhanVien nhanVien = (NhanVien) session.getAttribute("nhanVienDangNhap");
        if (phieuNhap == null) {
            phieuNhap = new PhieuNhap();
            phieuNhap.setMaPhieu("PN-" + UUID.randomUUID().toString().substring(0, 8));
            phieuNhap.setNgayNhap(LocalDateTime.now());
            phieuNhap.setNhanVien(nhanVien);
            phieuNhapRepo.save(phieuNhap);
            session.setAttribute("phieuNhap", phieuNhap);
        }
        return phieuNhap;
    }

    public SanPhamChiTiet themSanPhamVaPhieuNhapChiTiet(SanPhamChiTiet sanPhamChiTiet,
        PhieuNhapChiTiet phieuNhapChiTiet, NhaKho nhaKho, PhieuNhap phieuNhap) {
    
    // 1Kiểm tra & tạo mã sản phẩm nếu chưa có
    if (sanPhamChiTiet.getMaSanPham() == null || sanPhamChiTiet.getMaSanPham().trim().isEmpty()) {
        sanPhamChiTiet.setMaSanPham("SPCT-" + UUID.randomUUID().toString().substring(0, 8));
    }
    sanPhamChiTiet.setNgayTao(new Date());
    sanPhamChiTiet.setTrangThai(1);

    // 2 Lưu sản phẩm chi tiết
    SanPhamChiTiet savedSanPham = sanPhamCtRepo.save(sanPhamChiTiet);

    // 3 Thiết lập sản phẩm cho phiếu nhập chi tiết
    phieuNhapChiTiet.setSanPhamChiTiet(savedSanPham);
    phieuNhapChiTiet.setPhieuNhap(phieuNhap);
    phieuNhapChiTiet.setNhaKho(nhaKho);
    phieuNhapChiTiet.setTrangThai(0); // Sản phẩm mới thêm vào, chưa nhập hàng

    // 4 Kiểm tra & cập nhật kho
    Optional<SpctNhaKho> existingSpctNhaKho = sanPhamCtNhaKhoRepo
            .findBySanPhamChiTietIdAndNhaKhoId(savedSanPham.getId(), nhaKho.getId().longValue());

    if (existingSpctNhaKho.isPresent()) {
        // Nếu đã có trong kho, cập nhật số lượng
        SpctNhaKho spctNhaKho = existingSpctNhaKho.get();
        spctNhaKho.setSoLuong(spctNhaKho.getSoLuong() + phieuNhapChiTiet.getSoLuong());
        sanPhamCtNhaKhoRepo.save(spctNhaKho);
    } else {
        // Nếu chưa có, tạo mới
        SpctNhaKho spctNhaKho = new SpctNhaKho();
        spctNhaKho.setSanPhamChiTiet(savedSanPham);
        spctNhaKho.setNhaKho(nhaKho);
        spctNhaKho.setSoLuong(phieuNhapChiTiet.getSoLuong());
        sanPhamCtNhaKhoRepo.save(spctNhaKho);
    }

    // 5 Lưu phiếu nhập chi tiết sau khi đã thiết lập đầy đủ thông tin
    phieuNhapChiTietRepo.save(phieuNhapChiTiet);

    return savedSanPham;
}


    public List<PhieuNhapChiTiet> layDanhSachPhieuNhapChiTiet(PhieuNhap phieuNhap) {
        return phieuNhapChiTietRepo.findByPhieuNhap(phieuNhap);
    }

    public double tinhTongTienGioHang(List<PhieuNhapChiTiet> danhSachChiTiet) {
        return danhSachChiTiet.stream()
                .mapToDouble(PhieuNhapChiTiet::getThanhTien)
                .sum();
    }

    

    public void luuPhieuNhap(PhieuNhap phieuNhap) {
        // Lấy danh sách chi tiết phiếu nhập
        List<PhieuNhapChiTiet> danhSachChiTiet = phieuNhapChiTietRepo.findByPhieuNhap(phieuNhap);
        
        if (danhSachChiTiet.isEmpty()) {
            throw new IllegalStateException("Không có sản phẩm nào trong phiếu nhập!");
        }
    
        // Tính tổng số lượng và tổng tiền
        int tongSoLuong = danhSachChiTiet.stream().mapToInt(PhieuNhapChiTiet::getSoLuong).sum();
        double tongTien = danhSachChiTiet.stream().mapToDouble(PhieuNhapChiTiet::getThanhTien).sum();
    
        // Cập nhật phiếu nhập
        phieuNhap.setSoLuong(tongSoLuong);
        phieuNhap.setTongTienNhap(tongTien);
        phieuNhap.setTrangThai(1); // Đã nhập hàng
        phieuNhapRepo.save(phieuNhap);
    
        // Cập nhật trạng thái của tất cả phiếu nhập chi tiết
        for (PhieuNhapChiTiet chiTiet : danhSachChiTiet) {
            chiTiet.setTrangThai(1);
        }
        phieuNhapChiTietRepo.saveAll(danhSachChiTiet);
    }
    

    public Page<PhieuNhap> getAllPhieuNhap(int page , int size){
        Pageable pageable = PageRequest.of(page, size);
        return phieuNhapRepo.getAllPhieuNhap(pageable);
    }

    public void deletePhieuNhapCtByIdPhieuNhap(Long id){
        phieuNhapRepo.deleteByPhieuNhapId(id);
    }
    public void huyPhieuNhap(Long id){
        phieuNhapRepo.deleteById(id);
    }
    
}
