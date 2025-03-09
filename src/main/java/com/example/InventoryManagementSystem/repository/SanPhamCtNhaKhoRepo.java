package com.example.InventoryManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InventoryManagementSystem.entity.SpctNhaKho;

public interface SanPhamCtNhaKhoRepo extends JpaRepository<SpctNhaKho,Long>{
    Optional<SpctNhaKho> findBySanPhamChiTietIdAndNhaKhoId(Long sanPhamChiTiet,Long nhaKho);

    
}
