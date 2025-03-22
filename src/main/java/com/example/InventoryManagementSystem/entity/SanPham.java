package com.example.InventoryManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "san_pham")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maSanPham;
    @Size(min = 2 ,max = 30,message = "Vui lòng nhập tên sản phầm từ 2 đến 30 kí tự")
    private String tenSanPham;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;   
    private String hinhAnh;  
    
    @OneToMany(mappedBy = "tenSanPham",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<>();

    public SanPham(Integer id, String maSanPham,
            @Size(min = 2, max = 30, message = "Vui lòng nhập tên sản phầm từ 2 đến 30 kí tự") String tenSanPham,
            Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai, String hinhAnh) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
    }

    
}
