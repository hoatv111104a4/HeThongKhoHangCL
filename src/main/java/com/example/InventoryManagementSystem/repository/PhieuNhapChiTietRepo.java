package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryManagementSystem.entity.PhieuNhap;
import com.example.InventoryManagementSystem.entity.PhieuNhapChiTiet;

public interface PhieuNhapChiTietRepo extends JpaRepository<PhieuNhapChiTiet,Integer>{
    List<PhieuNhapChiTiet> findByPhieuNhap(PhieuNhap phieuNhap);

    @Query(value = "SELECT * FROM phieu_nhap_ct where trang_thai = 0 order by ngay_tao desc",nativeQuery = true)
    List<PhieuNhapChiTiet> getAllPhieuNhap();

    @Query(value = "SELECT * FROM phieu_nhap_ct where id_phieu_nhap = ?1 order by ngay_tao desc",nativeQuery = true)
    List<PhieuNhapChiTiet> findByIdPhieuNhap(Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE id_spct  FROM phieu_nhap_ct where id_phieu_nhap = ?1 ",nativeQuery = true)
    void deleteAllSpByIdPhieuNhapCt(Long id);
}
