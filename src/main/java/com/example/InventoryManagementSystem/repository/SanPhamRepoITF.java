package com.example.InventoryManagementSystem.repository;

import com.example.InventoryManagementSystem.entity.SanPham;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SanPhamRepoITF extends JpaRepository<SanPham,Integer> {
    @Query(value = "select * from san_pham sp " +
            "where sp.trang_thai = 1 order by sp.ngay_tao desc",
            countQuery = "SELECT COUNT(*) FROM san_pham where trang_thai =1 ",
            nativeQuery = true)
    Page<SanPham> getAllSanPham(Pageable pageable);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE san_pham set trang_thai = 0 , ngay_xoa = GETDATE() where id = ?",nativeQuery = true)
    void updateByIdSanPham(Integer id);

    @Query(value = "SELECT * FROM san_pham where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    List<SanPham> listSanPham();
}
