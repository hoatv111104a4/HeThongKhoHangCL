package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.InventoryManagementSystem.entity.XuatXu;

public interface XuatXuRepoITF extends JpaRepository<XuatXu,Integer>{
    @Query(value = "SELECT * FROM xuat_xu where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    Page<XuatXu> getAllXuatXu(Pageable pageable);

    @Query(value = "SELECT * FROM xuat_xu where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    List<XuatXu> listXuatXu();
}
