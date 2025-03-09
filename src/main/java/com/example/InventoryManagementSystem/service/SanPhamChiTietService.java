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

    public Page<SanPhamChiTietProjection> searchSanPhamCt(int page,int size,Double giaMin,Double giaMax,String tenSanPham,Integer thuongHieu, Integer xuatXu, Integer congNghe, Integer swingWeight, Integer trongLuong){
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamCtRepo.searchSanPham(pageable, giaMin, giaMax, tenSanPham, thuongHieu, xuatXu, congNghe, swingWeight, trongLuong);
    }

    public SanPhamChiTiet getIdSPCT(Long id){
        return sanPhamCtRepo.findById(id).get();
    }
    public void xoaCungSanPhamChiTiet(Long id){
        sanPhamCtRepo.deleteById(id);
    }

    // public void xoaDanhSachSanPhamTrongGioHang(Integer id){
    //     sanPhamCtRepo.deleteAllSpByIdPhieuNhapCt(id);
    // }

}
