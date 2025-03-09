package com.example.InventoryManagementSystem.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "nhan_vien")
@NoArgsConstructor
@Getter
@Setter
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maNhanVien;
    private String tenNhanVien;
    private LocalDate ngaySinh;
    private Boolean gioiTinh;
    
    private String email;
    private String soDienThoai;
    @ManyToOne
    @JoinColumn(name = "id_chuc_vu")
    private ChucVu chucVu;
    
    private String matKhau;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayXoa;
    private Integer trangThai;   

    @OneToMany(mappedBy = "nhanVien",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<PhieuNhap> phieuNhaps = new ArrayList<>();
    

    
}
