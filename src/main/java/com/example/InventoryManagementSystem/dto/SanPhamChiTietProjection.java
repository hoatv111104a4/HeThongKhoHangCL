package com.example.InventoryManagementSystem.dto;

import java.util.Date;


public interface SanPhamChiTietProjection {
    Integer getId();
    String getMaSanPhamCt();
    String getTenSanPham();
    Double getChieuDai();
    String getCongNghe();
    String getDoCung();
    String getNhaKho();
    String getSwing();
    String getTrongLuong();
    String getXuatXu();
    Double getGiaTien();
    Double getGiaBan();
    Integer getSoLuong();
    Integer getTrangThai();
    Integer getIdChieuDai();
    Integer getIdCongNghe();
    Integer getIdXuatXu();
    Integer getIdTrongLuong();
    Integer getIdThuongHieu();
    Integer getIdSwing();
    Integer getIdSanPham();
    Integer getIdDoCung();
    Integer getIdNhaKho();
    
    Date getNgayTao();
    Date getNgaySua();
    Date getNgayXoa();
}
