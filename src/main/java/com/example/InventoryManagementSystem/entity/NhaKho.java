package com.example.InventoryManagementSystem.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nha_kho")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhaKho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maKho;      
    
    private String khuVucKho;
    private Double sucChua;
    private String soDienThoai;    
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;
    
    @OneToMany(mappedBy = "nhaKho",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<SpctNhaKho> sNhaKhos = new ArrayList<>();
    @OneToMany(mappedBy = "nhaKho",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<PhieuNhapChiTiet> phieuNhapct = new ArrayList<>();

    public NhaKho(Integer id, String maKho, String khuVucKho, Double sucChua, String soDienThoai,
            Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai) {
        this.id = id;
        this.maKho = maKho;
        this.khuVucKho = khuVucKho;
        this.sucChua = sucChua;
        this.soDienThoai = soDienThoai;
        
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
    }

    
    
}
