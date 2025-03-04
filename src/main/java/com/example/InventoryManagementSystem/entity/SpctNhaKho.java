package com.example.InventoryManagementSystem.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sanphamct_nhakho")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpctNhaKho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_sp_ct")
    private SanPhamChiTiet sanPhamChiTiet;
    @ManyToOne
    @JoinColumn(name = "id_nha_kho")
    private NhaKho nhaKho;
    private Integer soLuong;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;
}
