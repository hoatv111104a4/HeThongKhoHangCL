package com.example.InventoryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SanPhamChiTietDto {
    private Integer id;
    private String maSanPhamCt;
    private String tenSanPham;
    private Double chieuDai;
    private String congNghe;
    private String doCung;
    private String nhaKho;
    private String swing;
    private String trongLuong;
    private String xuatXu;
    
    private Double giaTien;
    private Double giaBan;
    private Integer soLuong;
    private Integer trangThai;
    
    private Integer idChieuDai;
    private Integer idCongNghe;
    private Integer idXuatXu;
    private Integer idTrongLuong;
    private Integer idThuongHieu;
    private Integer idSwing;
    private Integer idSanPham;
    private Integer idDoCung;
    
    private Integer idNhaKho;
    
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;
    private LocalDateTime ngayXoa;
}
