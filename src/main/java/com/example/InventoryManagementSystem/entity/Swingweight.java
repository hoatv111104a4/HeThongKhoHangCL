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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "swing_weight")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Swingweight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Mức độ không được để trống")
    @Size(max = 50, message = "Mức độ không được quá 50 ký tự")
    private String mucDo;

    @NotNull(message = "Giá trị không được để trống")
    @Min(value = 0, message = "Giá trị phải lớn hơn hoặc bằng 0")
    @Max(value = 100, message = "Giá trị không được vượt quá 100")
    private Integer giaTri;   
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;

    @OneToMany(mappedBy = "swingWeight",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<>();

    public Swingweight(Integer id,
            @NotBlank(message = "Mức độ không được để trống") @Size(max = 50, message = "Mức độ không được quá 50 ký tự") String mucDo,
            @NotNull(message = "Giá trị không được để trống") @Min(value = 0, message = "Giá trị phải lớn hơn hoặc bằng 0") @Max(value = 100, message = "Giá trị không được vượt quá 100") Integer giaTri,
            Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai) {
        this.id = id;
        this.mucDo = mucDo;
        this.giaTri = giaTri;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
    }
    
}
