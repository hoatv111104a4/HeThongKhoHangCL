package com.example.InventoryManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.NhanVien;
import com.example.InventoryManagementSystem.repository.NhanVienRepoITF;

@Service
public class NhanVienService {
    private final NhanVienRepoITF nhanVienRepoITF;

    public NhanVienService(NhanVienRepoITF nhanVienRepoITF) {
        this.nhanVienRepoITF = nhanVienRepoITF;
    }
    
    public Optional<NhanVien> findByEmail(String email){
        return nhanVienRepoITF.findByEmail(email);
    }

    public List<NhanVien> getAllNhanVien(){
        return nhanVienRepoITF.findAll(Sort.by("ngayTao").descending());
    }
}
