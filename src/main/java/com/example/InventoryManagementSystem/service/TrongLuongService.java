package com.example.InventoryManagementSystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.TrongLuong;
import com.example.InventoryManagementSystem.repository.TrongLuongRepoITF;

@Service
public class TrongLuongService {
    private final TrongLuongRepoITF trongLuongRepoITF;

    public TrongLuongService(TrongLuongRepoITF trongLuongRepoITF) {
        this.trongLuongRepoITF = trongLuongRepoITF;
    }

    public Page<TrongLuong> getAllTrongLuong(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return trongLuongRepoITF.getAllTrongLuong(pageable);
    }

    public void addTrongLuong(TrongLuong trongLuong){
        trongLuong.setNgayTao(new Date());
        trongLuong.setTrangThai(1);
        trongLuongRepoITF.save(trongLuong);
    }    
    public void deleteTrongLuong(Integer id){        
        trongLuongRepoITF.updateByIdTrongLuong(id);
    }    
    
    public List<TrongLuong> listTrongLuongs(){
        return trongLuongRepoITF.listTrongLuong();
    }
}
