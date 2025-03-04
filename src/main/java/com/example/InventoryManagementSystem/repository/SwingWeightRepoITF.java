package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryManagementSystem.entity.Swingweight;

public interface SwingWeightRepoITF extends JpaRepository<Swingweight ,Integer>{
    @Query(value = "SELECT * FROM swing_weight where trang_thai = 1 order by ngay_tao desc ", nativeQuery = true)
    Page<Swingweight> getAllSwingWeight(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value ="UPDATE swing_weight set trang_thai = 0 , ngay_xoa =GETDATE() where id =?",nativeQuery = true)
    void updateByID(Integer id);
    

    @Query(value = "SELECT * FROM swing_weight where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    List<Swingweight> listSwing();
}
