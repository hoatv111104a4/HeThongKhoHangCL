package com.example.InventoryManagementSystem.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phieu_nhap")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maPhieu;

    @ManyToOne
    @JoinColumn(name =  "id_nha_cc")
    private NhaCungCap nhaCungCap;

    @ManyToOne
    @JoinColumn(name =  "id_nhan_vien")
    private NhanVien nhanVien;    
    private Double tongTienNhap;
    private Integer soLuong;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayNhap;
    private LocalDateTime ngaySua;
    private LocalDateTime ngayXoa;
    private Integer trangThai;

    @OneToMany(mappedBy = "phieuNhap",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<PhieuNhapChiTiet> pjChiTiets = new ArrayList<>();
}
