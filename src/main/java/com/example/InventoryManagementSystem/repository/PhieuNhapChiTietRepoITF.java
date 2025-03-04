package com.example.InventoryManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InventoryManagementSystem.entity.PhieuNhapChiTiet;

public interface PhieuNhapChiTietRepoITF extends JpaRepository<PhieuNhapChiTiet,Integer>{
    
}
