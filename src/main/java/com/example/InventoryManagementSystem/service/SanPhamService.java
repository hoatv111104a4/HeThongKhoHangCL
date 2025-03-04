package com.example.InventoryManagementSystem.service;

import com.example.InventoryManagementSystem.entity.SanPham;
import com.example.InventoryManagementSystem.repository.SanPhamRepoITF;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepoITF sanPhamRepoITF;

    public SanPhamService(SanPhamRepoITF sanPhamRepoITF) {
        this.sanPhamRepoITF = sanPhamRepoITF;
    }

    public Page<SanPham> getAllSanPham(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return sanPhamRepoITF.getAllSanPham(pageable);
    }   

    public void addSanPham(SanPham sanPham) {
        if (sanPham.getMaSanPham() == null||sanPham.getMaSanPham().trim().isEmpty()) {
            sanPham.setMaSanPham("SP-"+UUID.randomUUID().toString().substring(0, 8));
        }
        sanPham.setTrangThai(1);
        sanPham.setNgayTao(new Date());        
        sanPhamRepoITF.save(sanPham);
    }
    public void deleteSanPham(Integer id){
        sanPhamRepoITF.updateByIdSanPham(id);
    }

    public List<SanPham> listSanPhams(){
        return sanPhamRepoITF.listSanPham();
    }
}
