package com.example.InventoryManagementSystem.service;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.CongNghe;
import com.example.InventoryManagementSystem.repository.CongNgheRepoITF;

@Service
public class CongNgheService {
    private final CongNgheRepoITF congNgheRepoITF;

    public CongNgheService(CongNgheRepoITF congNgheRepoITF) {
        this.congNgheRepoITF = congNgheRepoITF;
    }

    public Page<CongNghe> getAllCongNghe(int page ,int size){
        Pageable pageable = PageRequest.of(page, size);
        return congNgheRepoITF.getAllCongNghe(pageable);
    }

    public void addCongNghe(CongNghe congNghe){
        if (congNghe.getMaCongNghe()==null|| congNghe.getMaCongNghe().trim().isEmpty()) {
            congNghe.setMaCongNghe("CN-"+UUID.randomUUID().toString().substring(0,8));
        }
        congNghe.setNgayTao(new Date());
        congNghe.setTrangThai(1);
        congNgheRepoITF.save(congNghe);
    }

    public void deleteCongNghe(Integer id){
        congNgheRepoITF.updateByIdCongNghe(id);
    }

    public List<CongNghe> listCongNghe(){
        return congNgheRepoITF.listCongNghe();
    }
    

}
