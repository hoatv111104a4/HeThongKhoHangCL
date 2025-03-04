package com.example.InventoryManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.NhaCungCap;
import com.example.InventoryManagementSystem.repository.NhaCungCapRepoITF;

@Service
public class NhaCungCapService {
    private final NhaCungCapRepoITF nhaCungCapRepoITF; 
    public NhaCungCapService(NhaCungCapRepoITF nhaCungCapRepoITF) {
        this.nhaCungCapRepoITF = nhaCungCapRepoITF;
    }

    public List<NhaCungCap> listNhaCungCap(){
        return nhaCungCapRepoITF.listNCC();
    }
}
