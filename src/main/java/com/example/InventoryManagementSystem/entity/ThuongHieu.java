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
@Table(name = "thuong_hieu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2,max = 30 ,message = "Mời bạn nhập đầy đủ thông tin thương hiệu nằm từ 2 đến 30 kí tự")
    private String tenThuongHieu;
    @Size(min = 2,max = 1000 ,message = "Mời bạn nhập đầy đủ thông tin đường dẫn ảnh ")
    private String duongDanAnh;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;

    @OneToMany(mappedBy = "thuongHieu",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<>();

    public ThuongHieu(Integer id,
            @Size(min = 2, max = 30, message = "Mời bạn nhập đầy đủ thông tin thương hiệu nằm từ 2 đến 30 kí tự") String tenThuongHieu,
            @Size(min = 2, max = 1000, message = "Mời bạn nhập đầy đủ thông tin đường dẫn ảnh ") String duongDanAnh,
            Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai) {
        this.id = id;
        this.tenThuongHieu = tenThuongHieu;
        this.duongDanAnh = duongDanAnh;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
    }
    
}
