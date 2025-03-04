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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "chieu_dai")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChieuDaiVot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maChieuDai;    
    @NotNull(message = "Mời nhập chiều dài vợt")
    @Min(value = 0,message = "Chiều dài phải >=0")
    private Double chieuDaiVot;
    @NotBlank(message = "Đơn vị không được bỏ trống")
    @Pattern(regexp = "^(mm|cm|m)$", message = "Chiều dài kết thúc bằng 'mm', 'cm' hoặc 'm' (VD: 200mm, 32cm, 1m)")
    private String donVi;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;   
    
    @OneToMany(mappedBy = "chieuDaiVot",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<>();

    public ChieuDaiVot(Integer id, String maChieuDai,
            @NotNull(message = "Mời nhập chiều dài vợt") @Min(value = 0, message = "Chiều dài phải >=0") Double chieuDaiVot,
            @NotBlank(message = "Đơn vị không được bỏ trống") @Pattern(regexp = "^(mm|cm|m)$", message = "Chiều dài kết thúc bằng 'mm', 'cm' hoặc 'm' (VD: 200mm, 32cm, 1m)") String donVi,
            Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai) {
        this.id = id;
        this.maChieuDai = maChieuDai;
        this.chieuDaiVot = chieuDaiVot;
        this.donVi = donVi;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
    }

    
    
}
