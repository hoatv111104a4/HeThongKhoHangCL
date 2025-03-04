package com.example.InventoryManagementSystem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.example.InventoryManagementSystem.dto.SanPhamChiTietProjection;
import com.example.InventoryManagementSystem.entity.SanPhamChiTiet;
import com.example.InventoryManagementSystem.repository.SanPhamCtRepo;

@Service
public class SanPhamChiTietService {
    private final SanPhamCtRepo sanPhamCtRepo;

    public SanPhamChiTietService(SanPhamCtRepo sanPhamCtRepo) {
        this.sanPhamCtRepo = sanPhamCtRepo;
    }

    public Page<SanPhamChiTietProjection> getAllSanPhamCTDTO(int page , int size){
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamCtRepo.getAllSanPhamCT(pageable);
    }

    public void deleteSanPham (int id){
        sanPhamCtRepo.updateById(id);
    }
    
    public Page<SanPhamChiTietProjection> searchName(int page , int size,String tenSanPham){
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamCtRepo.searchByName(pageable,tenSanPham);
    }

    public Page<SanPhamChiTietProjection> searchGiaTien(int page , int size , Double giaMin,Double giaMax){
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamCtRepo.searchBySalary(pageable, giaMin, giaMax);
    }

    public Page<SanPhamChiTietProjection> searchNameAndKhoangGia(int page,int size,Double giaMin,Double giaMax,String tenSanPham){
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamCtRepo.searcTenSpAndGiaTien(pageable,giaMax,giaMax,tenSanPham);
    }

    public SanPhamChiTiet getIdSPCT(Long id){
        return sanPhamCtRepo.findById(id).get();
    }

}
