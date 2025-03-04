package com.example.InventoryManagementSystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.NhaKho;
import com.example.InventoryManagementSystem.repository.NhaKhoRepoITF;

@Service
public class NhaKhoService {
    private final NhaKhoRepoITF nhaKhoRepoITF;

    public NhaKhoService(NhaKhoRepoITF nhaKhoRepoITF) {
        this.nhaKhoRepoITF = nhaKhoRepoITF;
    }
    public Page<NhaKho> getAllNhaKho(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return nhaKhoRepoITF.getAllNhaKho(pageable);
    }
    public List<NhaKho> listNhaKho(){
        return nhaKhoRepoITF.listNhaKho();
    }
}
