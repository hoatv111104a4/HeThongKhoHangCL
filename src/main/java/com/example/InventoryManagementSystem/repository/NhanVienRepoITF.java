package com.example.InventoryManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.InventoryManagementSystem.entity.NhanVien;
import com.example.InventoryManagementSystem.entity.ThuongHieu;

public interface NhanVienRepoITF extends JpaRepository<NhanVien,Integer>{
    Optional<NhanVien> findByEmail(String email);

    // @Query(value = "SELECT * FROM thuong_hieu where trang_thai = 1 order by ngay_tao desc"  ,nativeQuery = true)
    // Page<ThuongHieu> pageLichSuNhanVien(Pageable pageable);
}
