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
@Table(name = "nha_cung_cap")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maNhaCC;
    private String tenNhaCC;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String website;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;   

    @OneToMany(mappedBy = "nhaCungCap",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<PhieuNhap> phieuNhaps = new ArrayList<>();
        
}
