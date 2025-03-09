package com.example.InventoryManagementSystem.service;

import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.repository.SanPhamCtNhaKhoRepo;

@Service
public class SanPhamCtNkService {
    private final SanPhamCtNhaKhoRepo sanPhamCtNhaKhoRepo;

    public SanPhamCtNkService(SanPhamCtNhaKhoRepo sanPhamCtNhaKhoRepo) {
        this.sanPhamCtNhaKhoRepo = sanPhamCtNhaKhoRepo;
    }
    
}
