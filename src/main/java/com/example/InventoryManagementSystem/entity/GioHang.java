package com.example.InventoryManagementSystem.entity;

import java.time.LocalDateTime;

public class GioHang {
    private Integer sanPhamChiTietId; 
    private Integer soLuong; 
    private Double giaNhap; 
    private Double thanhTien; 
    private LocalDateTime ngayTao; 

    public GioHang() {
        this.ngayTao = LocalDateTime.now(); 
    }

    public GioHang(Integer sanPhamChiTietId, Integer soLuong, Double giaNhap) {
        this.sanPhamChiTietId = sanPhamChiTietId;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.ngayTao = LocalDateTime.now();
        updateThanhTien();
    }

    public Integer getSanPhamChiTietId() {
        return sanPhamChiTietId;
    }

    public void setSanPhamChiTietId(Integer sanPhamChiTietId) {
        this.sanPhamChiTietId = sanPhamChiTietId;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
        updateThanhTien();
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
        updateThanhTien();
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    // Cập nhật tổng tiền khi thay đổi số lượng hoặc giá nhập
    private void updateThanhTien() {
        if (soLuong != null && giaNhap != null) {
            this.thanhTien = soLuong * giaNhap;
        }
    }
}
