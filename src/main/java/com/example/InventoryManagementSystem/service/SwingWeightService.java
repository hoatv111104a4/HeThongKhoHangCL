package com.example.InventoryManagementSystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.InventoryManagementSystem.entity.Swingweight;
import com.example.InventoryManagementSystem.repository.SwingWeightRepoITF;

@Service
public class SwingWeightService {
    private final SwingWeightRepoITF swingWeightRepoITF;

    public SwingWeightService(SwingWeightRepoITF swingWeightRepoITF) {
        this.swingWeightRepoITF = swingWeightRepoITF;
    }
    
    public Page<Swingweight> getAllSwingWeight(int page , int size){
        Pageable pageable = PageRequest.of(page, size);
        return swingWeightRepoITF.getAllSwingWeight(pageable);
    }

    public void addSwingWeight(Swingweight swingweight){
        swingweight.setNgayTao(new Date());
        swingweight.setTrangThai(1);
        swingWeightRepoITF.save(swingweight);

    }

    public void deleteByIdSwingWeight(int id){
        swingWeightRepoITF.updateByID(id);
    }

    public List<Swingweight> listSwingweights(){
        return swingWeightRepoITF.listSwing();
    }
}
