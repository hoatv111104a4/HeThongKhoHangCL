package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.InventoryManagementSystem.dto.SanPhamChiTietProjection;
import com.example.InventoryManagementSystem.entity.NhaKho;

public interface NhaKhoRepoITF extends JpaRepository<NhaKho ,Integer>{
    @Query(value = "SELECT * FROM nha_kho where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    Page<NhaKho> getAllNhaKho(Pageable pageable);

    @Query(value = "SELECT * FROM nha_kho where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    List<NhaKho> listNhaKho();

    @Query(value = "SELECT \r\n" + //
                        "    spct.id, spct.ma_san_pham AS maSanPhamCt, sp.ten_san_pham AS tenSanPham,\r\n" + //
                        "    cd.chieu_dai_vot AS chieuDai, cn.ten_cong_nghe AS congNghe, dc.ten_do_cung AS doCung, \r\n"
                        + //
                        "    nk.khu_vuc_kho AS nhaKho, sw.muc_do AS swing, tl.ki_hieu AS trongLuong, xx.xuat_xu AS xuatXu, \r\n"
                        + //
                        "    spct.gia_tien AS giaTien, spct.gia_ban AS giaBan, spn.so_luong AS soLuong, spct.trang_thai AS trangThai,\r\n"
                        + //
                        "    spct.id_chieu_dai AS idChieuDai, spct.id_cong_nghe AS idCongNghe, spct.id_xuat_xu AS idXuatXu, \r\n"
                        + //
                        "    spct.id_trong_luong AS idTrongLuong, spct.id_thuong_hieu AS idThuongHieu, spct.id_swing AS idSwing, \r\n"
                        + //
                        "    spct.id_san_pham AS idSanPham, spct.id_do_cung AS idDoCung, spn.id_nha_kho AS idNhaKho,\r\n"
                        + //
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
                        "WHERE spct.trang_thai = 1 and nk.id = ?1 \r\n" + //
                        "ORDER BY spct.ngay_tao DESC ", nativeQuery = true)
        Page<SanPhamChiTietProjection> getSpTrongKho(Pageable pageable,Integer idNhaKho);

    @Query(value = "SELECT \r\n" + //
                        "    spct.id, spct.ma_san_pham AS maSanPhamCt, sp.ten_san_pham AS tenSanPham,\r\n" + //
                        "    cd.chieu_dai_vot AS chieuDai, cn.ten_cong_nghe AS congNghe, dc.ten_do_cung AS doCung, \r\n"
                        + //
                        "    nk.khu_vuc_kho AS nhaKho, sw.muc_do AS swing, tl.ki_hieu AS trongLuong, xx.xuat_xu AS xuatXu, \r\n"
                        + //
                        "    spct.gia_tien AS giaTien, spct.gia_ban AS giaBan, spn.so_luong AS soLuong, spct.trang_thai AS trangThai,\r\n"
                        + //
                        "    spct.id_chieu_dai AS idChieuDai, spct.id_cong_nghe AS idCongNghe, spct.id_xuat_xu AS idXuatXu, \r\n"
                        + //
                        "    spct.id_trong_luong AS idTrongLuong, spct.id_thuong_hieu AS idThuongHieu, spct.id_swing AS idSwing, \r\n"
                        + //
                        "    spct.id_san_pham AS idSanPham, spct.id_do_cung AS idDoCung, spn.id_nha_kho AS idNhaKho,\r\n"
                        + //
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
                        "WHERE (spct.trang_thai = 1) \r\n" + //
                        "AND (spct.gia_tien BETWEEN ?1 AND ?2) \r\n" + //
                        "AND (COALESCE(?3, '') = '' OR sp.ten_san_pham LIKE CONCAT('%', ?3, '%'))  \r\n" +
                        "AND (COALESCE(?4, 0) = 0 OR th.id = ?4) \r\n" + //
                        " AND (COALESCE(?5, 0) = 0 OR xx.id = ?5)  \r\n" + //
                        "AND (COALESCE(?6, 0) = 0 OR cn.id = ?6) \r\n" + //
                        "AND (COALESCE(?7, 0) = 0 OR sw.id = ?7) \r\n" + //
                        "AND (COALESCE(?8, 0) = 0 OR tl.id = ?8) \r\n" + //
                        "AND (nk.id = ?9) \r\n" + //
                        "ORDER BY spct.ngay_tao DESC ", nativeQuery = true)
        Page<SanPhamChiTietProjection> searchSanPhamTrongKho(
                        Pageable pageable,
                        Double giaMin, Double giaMax, String tenSanPham,
                        Integer thuongHieu, Integer xuatXu, Integer congNghe, Integer swingWeight, Integer trongLuong,Integer idNhaKho);
}
