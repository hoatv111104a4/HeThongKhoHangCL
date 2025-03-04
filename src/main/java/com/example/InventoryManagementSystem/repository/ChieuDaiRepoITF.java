package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryManagementSystem.entity.ChieuDaiVot;

public interface ChieuDaiRepoITF extends JpaRepository<ChieuDaiVot , Integer>{
    @Query(value = "select * from chieu_dai where trang_thai = 1 order by ngay_tao desc",nativeQuery =true )
    Page<ChieuDaiVot> getAllChieuDaiVot(Pageable pageable);
    
    @Query(value = "select * from chieu_dai where trang_thai = 1 order by ngay_tao desc",nativeQuery =true )
    List<ChieuDaiVot> listChieuDaiVot();

    @Modifying
    @Transactional
    @Query(value = "UPDATE chieu_dai set trang_thai = 0 , ngay_xoa = GETDATE() where id =?",nativeQuery = true)
    void updateByIdChieuDai(Integer id);
}
