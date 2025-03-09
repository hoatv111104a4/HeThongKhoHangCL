package com.example.InventoryManagementSystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryManagementSystem.entity.PhieuNhap;

public interface PhieuNhapRepo extends JpaRepository<PhieuNhap ,Long>{

    @Query(value = "SELECT * FROM phieu_nhap  order by ngay_nhap desc",nativeQuery = true)
    Page<PhieuNhap> getAllPhieuNhap(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO phieu_nhap(ngay_tao,trang_thai) values (GETDATE(),0)",nativeQuery = true)
    void taoPhieuNhap(PhieuNhap phieuNhap);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM phieu_nhap_ct  where id_phieu_nhap = ?1",nativeQuery = true)
    void deleteByPhieuNhapId(Long id);
}
