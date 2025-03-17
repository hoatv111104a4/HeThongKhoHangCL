package com.example.InventoryManagementSystem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.KhachHang;
import com.example.InventoryManagementSystem.repository.KhachHangRepoITF;

@Service
public class KhacHangService {
    private final KhachHangRepoITF khachHangRepoITF;

    public KhacHangService(KhachHangRepoITF khachHangRepoITF) {
        this.khachHangRepoITF = khachHangRepoITF;
    }

    public Page<KhachHang> PageKhachHang(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);        
        return khachHangRepoITF.PageKhachHang(pageable);        

    }
}