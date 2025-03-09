package com.example.InventoryManagementSystem.entity;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "san_pham_ct")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maSanPham;

    @ManyToOne
    @JoinColumn(name = "id_san_pham")
    private SanPham tenSanPham;

    @ManyToOne
    @JoinColumn(name = "id_thuong_hieu")
    private ThuongHieu thuongHieu;

    @ManyToOne
    @JoinColumn(name = "id_xuat_xu")
    private XuatXu xuatXu;

    @ManyToOne
    @JoinColumn(name = "id_trong_luong")
    private TrongLuong trongLuong;

    @ManyToOne
    @JoinColumn(name = "id_swing")
    private Swingweight swingWeight;    

    @ManyToOne
    @JoinColumn(name = "id_do_cung")
    private DoCungDua doCungDua;

    @ManyToOne
    @JoinColumn(name = "id_cong_nghe")
    private CongNghe congNghe ;

    @ManyToOne
    @JoinColumn(name = "id_chieu_dai")
    private ChieuDaiVot chieuDaiVot;

    @OneToMany(mappedBy = "sanPhamChiTiet",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SpctNhaKho> spctNhaKhos = new ArrayList<>();;

    private Double giaTien;

    private Double giaBan;  
    
    
    private Date ngayTao;

    private Date ngaySua;

    private Date ngayXoa;

    private Integer trangThai;

    private String hinhAnh;
    
    @OneToMany(mappedBy = "sanPhamChiTiet",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<PhieuNhapChiTiet> pjChiTiets = new ArrayList<>();

}
