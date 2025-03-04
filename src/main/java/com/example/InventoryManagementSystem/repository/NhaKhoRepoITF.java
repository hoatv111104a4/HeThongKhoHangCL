package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.InventoryManagementSystem.entity.NhaKho;

public interface NhaKhoRepoITF extends JpaRepository<NhaKho ,Integer>{
    @Query(value = "SELECT * FROM nha_kho where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    Page<NhaKho> getAllNhaKho(Pageable pageable);

    @Query(value = "SELECT * FROM nha_kho where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    List<NhaKho> listNhaKho();
}
