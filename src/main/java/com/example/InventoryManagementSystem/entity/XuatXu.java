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
@Table(name = "xuat_xu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class XuatXu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String xuatXu;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;

    @OneToMany(mappedBy = "xuatXu",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<>();

    public XuatXu(Integer id, String xuatXu, Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai) {
        this.id = id;
        this.xuatXu = xuatXu;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
    }

    
}
