package com.example.InventoryManagementSystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.XuatXu;
import com.example.InventoryManagementSystem.repository.XuatXuRepoITF;

@Service
public class XuatXuService {
    private final XuatXuRepoITF xuRepoITF;

    public XuatXuService(XuatXuRepoITF xuRepoITF) {
        this.xuRepoITF = xuRepoITF;
    }
    public Page<XuatXu> getAllXuatXu(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return xuRepoITF.getAllXuatXu(pageable);
    }
    public List<XuatXu> listXuatXus(){
        return xuRepoITF.listXuatXu();
    }
}
