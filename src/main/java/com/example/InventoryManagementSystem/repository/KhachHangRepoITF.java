package com.example.InventoryManagementSystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.InventoryManagementSystem.entity.KhachHang;

public interface KhachHangRepoITF extends JpaRepository<KhachHang, Long> {
    
    @Query(value = "SELECT * FROM khach_hang where trang_thai = 1 order by ngay_tao desc", nativeQuery = true)
    Page<KhachHang> PageKhachHang(Pageable pageable);
}
