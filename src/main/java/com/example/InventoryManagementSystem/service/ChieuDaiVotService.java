package com.example.InventoryManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.ChieuDaiVot;
import com.example.InventoryManagementSystem.repository.ChieuDaiRepoITF;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ChieuDaiVotService {
    @Autowired
    private final ChieuDaiRepoITF chieuDaiRepoITF;

    public ChieuDaiVotService(ChieuDaiRepoITF chieuDaiRepoITF) {
        this.chieuDaiRepoITF = chieuDaiRepoITF;
    }
    

    public Page<ChieuDaiVot> getAllChieuDaiVot(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return chieuDaiRepoITF.getAllChieuDaiVot(pageable);
    }  

    public void addChieuDaiVot(ChieuDaiVot chieuDai){
        if(chieuDai.getMaChieuDai() == null || chieuDai.getMaChieuDai().trim().isEmpty()){
            chieuDai.setMaChieuDai("CD-"+UUID.randomUUID().toString().substring(0, 8));            
        }
        chieuDai.setNgayTao(new Date());
        chieuDai.setTrangThai(1);
        chieuDaiRepoITF.save(chieuDai);
    }

    public void deleteChieuDai(Integer id){
        chieuDaiRepoITF.updateByIdChieuDai(id);
    }
    
    public List<ChieuDaiVot> listChieuDai(){
        return chieuDaiRepoITF.listChieuDaiVot();
    }
    
}
