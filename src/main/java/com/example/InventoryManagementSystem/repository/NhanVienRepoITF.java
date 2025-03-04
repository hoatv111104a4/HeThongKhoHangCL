package com.example.InventoryManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InventoryManagementSystem.entity.NhanVien;

public interface NhanVienRepoITF extends JpaRepository<NhanVien,Integer>{
    Optional<NhanVien> findByEmail(String email);
}
