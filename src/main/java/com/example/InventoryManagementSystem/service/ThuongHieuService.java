package com.example.InventoryManagementSystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.ThuongHieu;
import com.example.InventoryManagementSystem.repository.ThuongHieuRepoITF;

@Service
public class ThuongHieuService {
    private final ThuongHieuRepoITF thuongHieuRepoITF;

    public ThuongHieuService(ThuongHieuRepoITF thuongHieuRepoITF) {
        this.thuongHieuRepoITF = thuongHieuRepoITF;
    }
    
    public Page<ThuongHieu> getAllThuongHieu(int page , int size){
        Pageable pageable = PageRequest.of(page, size);
        return thuongHieuRepoITF.getAllThuongHieu(pageable);
    }

    public void addThuongHieu(ThuongHieu thuongHieu){
        thuongHieu.setNgayTao(new Date());
        thuongHieu.setTrangThai(1);
        thuongHieuRepoITF.save(thuongHieu);
    }
    public void deleteThuongHieu(Integer id){
        thuongHieuRepoITF.updateByIdThuongHieu(id);
    }

    public List<ThuongHieu> listThuongHieu(){
        return thuongHieuRepoITF.listThuongHieu();
    }
}
