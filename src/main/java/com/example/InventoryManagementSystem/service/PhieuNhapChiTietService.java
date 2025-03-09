package com.example.InventoryManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.PhieuNhapChiTiet;
import com.example.InventoryManagementSystem.repository.PhieuNhapChiTietRepo;

@Service
public class PhieuNhapChiTietService {
    private final PhieuNhapChiTietRepo phieuNhapChiTietRepo;

    public PhieuNhapChiTietService(PhieuNhapChiTietRepo phieuNhapChiTietRepo) {
        this.phieuNhapChiTietRepo = phieuNhapChiTietRepo;
    }
    public List<PhieuNhapChiTiet> getAllPhieuNhaps(){
        return phieuNhapChiTietRepo.getAllPhieuNhap();
    }

    public void deletePhieuNhapCt(int id){
        phieuNhapChiTietRepo.deleteById(id);        
    }
    public PhieuNhapChiTiet getByIdPhieuNhapCt(Integer id){
        return phieuNhapChiTietRepo.findById(id).get();
    }
    public List<PhieuNhapChiTiet> chiTietPhieuNhap(Long id){
        return phieuNhapChiTietRepo.findByIdPhieuNhap(id);
    }
}
