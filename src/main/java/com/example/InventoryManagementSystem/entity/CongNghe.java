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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "cong_nghe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CongNghe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maCongNghe;
    @Size(min = 2, max = 100,message = "Xin vui lòng nhập tên công nghệ muốn thêm")
    private String tenCongNghe;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;

    @OneToMany(mappedBy = "congNghe",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<>();

    public CongNghe(Integer id, String maCongNghe,
            @Size(min = 2, max = 100, message = "Xin vui lòng nhập tên công nghệ muốn thêm") String tenCongNghe,
            Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai) {
        this.id = id;
        this.maCongNghe = maCongNghe;
        this.tenCongNghe = tenCongNghe;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
    }
    
}
