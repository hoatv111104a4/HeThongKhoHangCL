package com.example.InventoryManagementSystem.service;

import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.repository.ChucVujRepoITF;

@Service
public class ChucVuService {
    private final ChucVujRepoITF chucVujRepoITF;

    public ChucVuService(ChucVujRepoITF chucVujRepoITF) {
        this.chucVujRepoITF = chucVujRepoITF;
    }
    
}
