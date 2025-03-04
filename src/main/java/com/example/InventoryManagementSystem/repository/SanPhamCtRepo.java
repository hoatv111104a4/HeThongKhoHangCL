package com.example.InventoryManagementSystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryManagementSystem.dto.SanPhamChiTietProjection;
import com.example.InventoryManagementSystem.entity.SanPhamChiTiet;

public interface SanPhamCtRepo extends JpaRepository<SanPhamChiTiet,Long>{
    
    @Query(value="SELECT \r\n" + //
            "    spct.id, spct.ma_san_pham AS maSanPhamCt, sp.ten_san_pham AS tenSanPham,\r\n" + //
            "    cd.chieu_dai_vot AS chieuDai, cn.ten_cong_nghe AS congNghe, dc.ten_do_cung AS doCung, \r\n" + //
            "    nk.khu_vuc_kho AS nhaKho, sw.muc_do AS swing, tl.ki_hieu AS trongLuong, xx.xuat_xu AS xuatXu, \r\n" + //
            "    spct.gia_tien AS giaTien, spct.gia_ban AS giaBan, spn.so_luong AS soLuong, spct.trang_thai AS trangThai,\r\n" + //
            "    spct.id_chieu_dai AS idChieuDai, spct.id_cong_nghe AS idCongNghe, spct.id_xuat_xu AS idXuatXu, \r\n" + //
            "    spct.id_trong_luong AS idTrongLuong, spct.id_thuong_hieu AS idThuongHieu, spct.id_swing AS idSwing, \r\n" + //
            "    spct.id_san_pham AS idSanPham, spct.id_do_cung AS idDoCung, spn.id_nha_kho AS idNhaKho,\r\n" + //
            "    spct.ngay_tao AS ngayTao, spct.ngay_sua AS ngaySua, spct.ngay_xoa AS ngayXoa\r\n" + //
            "FROM san_pham_ct spct\r\n" + //
            "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id\r\n" + //
            "LEFT JOIN chieu_dai cd ON spct.id_chieu_dai = cd.id\r\n" + //
            "LEFT JOIN cong_nghe cn ON spct.id_cong_nghe = cn.id\r\n" + //
            "LEFT JOIN do_cung dc ON spct.id_do_cung = dc.id\r\n" + //
            "LEFT JOIN swing_weight sw ON spct.id_swing = sw.id\r\n" + //
            "LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id\r\n" + //
            "LEFT JOIN trong_luong tl ON spct.id_trong_luong = tl.id\r\n" + //
            "LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id\r\n" + //
            "LEFT JOIN sanphamct_nhakho spn ON spct.id = spn.id_sp_ct\r\n" + //
            "LEFT JOIN nha_kho nk ON spn.id_nha_kho = nk.id\r\n" + //
            "WHERE spct.trang_thai = 1 \r\n" + //
            "ORDER BY spct.ngay_tao DESC ", nativeQuery = true)
    Page<SanPhamChiTietProjection> getAllSanPhamCT(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE san_pham_ct set trang_thai = 0 , ngay_xoa = GETDATE() where id = ? ",nativeQuery = true)
    void updateById(int id);

    @Query(value="SELECT \r\n" + //
            "    spct.id, spct.ma_san_pham AS maSanPhamCt, sp.ten_san_pham AS tenSanPham,\r\n" + //
            "    cd.chieu_dai_vot AS chieuDai, cn.ten_cong_nghe AS congNghe, dc.ten_do_cung AS doCung, \r\n" + //
            "    nk.khu_vuc_kho AS nhaKho, sw.muc_do AS swing, tl.ki_hieu AS trongLuong, xx.xuat_xu AS xuatXu, \r\n" + //
            "    spct.gia_tien AS giaTien, spct.gia_ban AS giaBan, spn.so_luong AS soLuong, spct.trang_thai AS trangThai,\r\n" + //
            "    spct.id_chieu_dai AS idChieuDai, spct.id_cong_nghe AS idCongNghe, spct.id_xuat_xu AS idXuatXu, \r\n" + //
            "    spct.id_trong_luong AS idTrongLuong, spct.id_thuong_hieu AS idThuongHieu, spct.id_swing AS idSwing, \r\n" + //
            "    spct.id_san_pham AS idSanPham, spct.id_do_cung AS idDoCung, spn.id_nha_kho AS idNhaKho,\r\n" + //
            "    spct.ngay_tao AS ngayTao, spct.ngay_sua AS ngaySua, spct.ngay_xoa AS ngayXoa\r\n" + //
            "FROM san_pham_ct spct\r\n" + //
            "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id\r\n" + //
            "LEFT JOIN chieu_dai cd ON spct.id_chieu_dai = cd.id\r\n" + //
            "LEFT JOIN cong_nghe cn ON spct.id_cong_nghe = cn.id\r\n" + //
            "LEFT JOIN do_cung dc ON spct.id_do_cung = dc.id\r\n" + //
            "LEFT JOIN swing_weight sw ON spct.id_swing = sw.id\r\n" + //
            "LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id\r\n" + //
            "LEFT JOIN trong_luong tl ON spct.id_trong_luong = tl.id\r\n" + //
            "LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id\r\n" + //
            "LEFT JOIN sanphamct_nhakho spn ON spct.id = spn.id_sp_ct\r\n" + //
            "LEFT JOIN nha_kho nk ON spn.id_nha_kho = nk.id\r\n" + //
            "WHERE spct.trang_thai = 1 and sp.ten_san_pham LIKE CONCAT('%', :tenSanPham, '%') \r\n" + //
            "ORDER BY spct.ngay_tao DESC ", nativeQuery = true)
    Page<SanPhamChiTietProjection> searchByName(Pageable pageable,@Param("tenSanPham") String tenSanPham);

    @Query(value="SELECT \r\n" + //
            "    spct.id, spct.ma_san_pham AS maSanPhamCt, sp.ten_san_pham AS tenSanPham,\r\n" + //
            "    cd.chieu_dai_vot AS chieuDai, cn.ten_cong_nghe AS congNghe, dc.ten_do_cung AS doCung, \r\n" + //
            "    nk.khu_vuc_kho AS nhaKho, sw.muc_do AS swing, tl.ki_hieu AS trongLuong, xx.xuat_xu AS xuatXu, \r\n" + //
            "    spct.gia_tien AS giaTien, spct.gia_ban AS giaBan, spn.so_luong AS soLuong, spct.trang_thai AS trangThai,\r\n" + //
            "    spct.id_chieu_dai AS idChieuDai, spct.id_cong_nghe AS idCongNghe, spct.id_xuat_xu AS idXuatXu, \r\n" + //
            "    spct.id_trong_luong AS idTrongLuong, spct.id_thuong_hieu AS idThuongHieu, spct.id_swing AS idSwing, \r\n" + //
            "    spct.id_san_pham AS idSanPham, spct.id_do_cung AS idDoCung, spn.id_nha_kho AS idNhaKho,\r\n" + //
            "    spct.ngay_tao AS ngayTao, spct.ngay_sua AS ngaySua, spct.ngay_xoa AS ngayXoa\r\n" + //
            "FROM san_pham_ct spct\r\n" + //
            "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id\r\n" + //
            "LEFT JOIN chieu_dai cd ON spct.id_chieu_dai = cd.id\r\n" + //
            "LEFT JOIN cong_nghe cn ON spct.id_cong_nghe = cn.id\r\n" + //
            "LEFT JOIN do_cung dc ON spct.id_do_cung = dc.id\r\n" + //
            "LEFT JOIN swing_weight sw ON spct.id_swing = sw.id\r\n" + //
            "LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id\r\n" + //
            "LEFT JOIN trong_luong tl ON spct.id_trong_luong = tl.id\r\n" + //
            "LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id\r\n" + //
            "LEFT JOIN sanphamct_nhakho spn ON spct.id = spn.id_sp_ct\r\n" + //
            "LEFT JOIN nha_kho nk ON spn.id_nha_kho = nk.id\r\n" + //
            "WHERE spct.trang_thai = 1 and spct.gia_tien BETWEEN :giaMin and :giaMax\r\n" + //
            "ORDER BY spct.ngay_tao DESC ", nativeQuery = true)
    Page<SanPhamChiTietProjection> searchBySalary(Pageable pageable, Double giaMin,Double giaMax);


    @Query(value="SELECT \r\n" + //
            "    spct.id, spct.ma_san_pham AS maSanPhamCt, sp.ten_san_pham AS tenSanPham,\r\n" + //
            "    cd.chieu_dai_vot AS chieuDai, cn.ten_cong_nghe AS congNghe, dc.ten_do_cung AS doCung, \r\n" + //
            "    nk.khu_vuc_kho AS nhaKho, sw.muc_do AS swing, tl.ki_hieu AS trongLuong, xx.xuat_xu AS xuatXu, \r\n" + //
            "    spct.gia_tien AS giaTien, spct.gia_ban AS giaBan, spn.so_luong AS soLuong, spct.trang_thai AS trangThai,\r\n" + //
            "    spct.id_chieu_dai AS idChieuDai, spct.id_cong_nghe AS idCongNghe, spct.id_xuat_xu AS idXuatXu, \r\n" + //
            "    spct.id_trong_luong AS idTrongLuong, spct.id_thuong_hieu AS idThuongHieu, spct.id_swing AS idSwing, \r\n" + //
            "    spct.id_san_pham AS idSanPham, spct.id_do_cung AS idDoCung, spn.id_nha_kho AS idNhaKho,\r\n" + //
            "    spct.ngay_tao AS ngayTao, spct.ngay_sua AS ngaySua, spct.ngay_xoa AS ngayXoa\r\n" + //
            "FROM san_pham_ct spct\r\n" + //
            "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id\r\n" + //
            "LEFT JOIN chieu_dai cd ON spct.id_chieu_dai = cd.id\r\n" + //
            "LEFT JOIN cong_nghe cn ON spct.id_cong_nghe = cn.id\r\n" + //
            "LEFT JOIN do_cung dc ON spct.id_do_cung = dc.id\r\n" + //
            "LEFT JOIN swing_weight sw ON spct.id_swing = sw.id\r\n" + //
            "LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id\r\n" + //
            "LEFT JOIN trong_luong tl ON spct.id_trong_luong = tl.id\r\n" + //
            "LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id\r\n" + //
            "LEFT JOIN sanphamct_nhakho spn ON spct.id = spn.id_sp_ct\r\n" + //
            "LEFT JOIN nha_kho nk ON spn.id_nha_kho = nk.id\r\n" + //
            "WHERE (spct.trang_thai = 1) and (spct.gia_tien BETWEEN :giaMin and :giaMax) and (sp.ten_san_pham LIKE CONCAT('%', :tenSanPham, '%')) \r\n" + //
            "ORDER BY spct.ngay_tao DESC ", nativeQuery = true)
    Page<SanPhamChiTietProjection> searcTenSpAndGiaTien(Pageable pageable, Double giaMin,Double giaMax,String tenSanPham);


}

    
