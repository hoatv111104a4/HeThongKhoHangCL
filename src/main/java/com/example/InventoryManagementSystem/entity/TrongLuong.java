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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "trong_luong")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrongLuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, max = 3, message = "Vui lòng nhập thông tin từ 2 đến 3 kí tự")
    private String kiHieu;

    @NotNull(message = "Cân nặng tối thiểu không được để trống")
    @DecimalMin(value = "0.01", message = "Cân nặng tối thiểu phải >= 0.01")
    private Double canNangMin;

    @NotNull(message = "Cân nặng tối đa không được để trống")
    @DecimalMin(value = "0.01", message = "Cân nặng tối đa phải >= 0.01")
    private Double canNangMax;

    @NotNull(message = "Đơn vị không được để trống")
    @Size(min = 1, max = 3, message = "Đơn vị phải từ 1 đến 3 ký tự")
    @Pattern(regexp = "g|kg|lb", message = "Đơn vị phải là 'g', 'kg' hoặc 'lb'")
    private String donVi;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;

    @OneToMany(mappedBy = "trongLuong",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<>();

    public TrongLuong(Integer id,
            @Size(min = 2, max = 3, message = "Vui lòng nhập thông tin từ 2 đến 3 kí tự") String kiHieu,
            @NotNull(message = "Cân nặng tối thiểu không được để trống") @DecimalMin(value = "0.01", message = "Cân nặng tối thiểu phải >= 0.01") Double canNangMin,
            @NotNull(message = "Cân nặng tối đa không được để trống") @DecimalMin(value = "0.01", message = "Cân nặng tối đa phải >= 0.01") Double canNangMax,
            @NotNull(message = "Đơn vị không được để trống") @Size(min = 1, max = 3, message = "Đơn vị phải từ 1 đến 3 ký tự") @Pattern(regexp = "g|kg|lb", message = "Đơn vị phải là 'g', 'kg' hoặc 'lb'") String donVi,
            Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai) {
        this.id = id;
        this.kiHieu = kiHieu;
        this.canNangMin = canNangMin;
        this.canNangMax = canNangMax;
        this.donVi = donVi;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
    }
    
}
