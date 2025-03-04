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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "do_cung")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoCungDua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    private String maDoCung;
    
    @NotBlank(message = "Độ cứng không được để trống")
    @Size(min = 2 , max = 30, message = "Vui lòng nhập độ cứng muốn thêm từ 2 đến 30 kí tự")
    private String tenDoCung;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;

    @OneToMany(mappedBy = "doCungDua",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<>();

    public DoCungDua(Integer id, String maDoCung,
            @NotBlank(message = "Độ cứng không được để trống") @Size(min = 2, max = 30, message = "Vui lòng nhập độ cứng muốn thêm từ 2 đến 30 kí tự") String tenDoCung,
            Date ngayTao, Date ngaySua, Date ngayXoa, Integer trangThai) {
        this.id = id;
        this.maDoCung = maDoCung;
        this.tenDoCung = tenDoCung;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayXoa = ngayXoa;
        this.trangThai = trangThai;
    }
    
}
