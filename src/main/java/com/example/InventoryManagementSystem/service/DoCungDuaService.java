package com.example.InventoryManagementSystem.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.DoCungDua;
import com.example.InventoryManagementSystem.repository.DoCungDuaRepoITF;

@Service
public class DoCungDuaService {
    private final DoCungDuaRepoITF doCungDuaRepoITF;

    public DoCungDuaService(DoCungDuaRepoITF doCungDuaRepoITF) {
        this.doCungDuaRepoITF = doCungDuaRepoITF;
    }
    
    public Page<DoCungDua> getAllDoCungDua(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return doCungDuaRepoITF.getAllDoCungDua(pageable);
    }
    public void addDoCungDua(DoCungDua doCungDua){
        if (doCungDua.getMaDoCung() == null || doCungDua.getMaDoCung().trim().isEmpty()) {
            doCungDua.setMaDoCung("DC-"+UUID.randomUUID().toString().substring(0,8));
        }
        doCungDua.setNgayTao(new Date());
        doCungDua.setTrangThai(1);
        doCungDuaRepoITF.save(doCungDua);
    }

    public void deleteDoCungDua(Integer id){
        doCungDuaRepoITF.updateByIdDoCung(id);
    }

    public List<DoCungDua> listDoCung(){
        return doCungDuaRepoITF.listDoCungDua();
    }
}
