package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryManagementSystem.entity.TrongLuong;

public interface TrongLuongRepoITF extends JpaRepository<TrongLuong ,Integer>{
    @Query(value = "SELECT * FROM trong_luong where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    Page<TrongLuong> getAllTrongLuong(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE trong_luong set trang_thai = 0 ,ngay_xoa = GETDATE() where id =?",nativeQuery = true)
    void updateByIdTrongLuong(Integer id);

    @Query(value = "SELECT * FROM trong_luong where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    List<TrongLuong> listTrongLuong();
}
