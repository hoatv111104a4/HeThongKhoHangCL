package com.example.InventoryManagementSystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "phieu_nhap_ct")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhieuNhapChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_phieu_nhap")
    private PhieuNhap phieuNhap;

    @ManyToOne
    @JoinColumn(name = "id_spct")
    private SanPhamChiTiet sanPhamChiTiet;

    @ManyToOne
    @JoinColumn(name =  "id_nha_kho")
    private NhaKho nhaKho;
    
    private Integer soLuong;
    private Double giaNhap;
    private Double thanhTien;
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;
    private Integer trangThai;

    // Setter tự động tính thanhTien khi thay đổi số lượng hoặc giá nhập
    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
        updateThanhTien();
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
        updateThanhTien();
    }

    private void updateThanhTien() {
        if (soLuong != null && giaNhap != null) {
            this.thanhTien = soLuong * giaNhap;
        }
    }

    @PrePersist
    public void prePersist() {
        this.ngayTao = LocalDateTime.now();
        this.updateThanhTien(); // Đảm bảo thanhTien được tính trước khi lưu
    }

    @PreUpdate
    public void preUpdate() {
        this.ngaySua = LocalDateTime.now();
        this.updateThanhTien(); // Đảm bảo thanhTien được cập nhật khi sửa dữ liệu
    }
}
