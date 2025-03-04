package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.InventoryManagementSystem.entity.NhaCungCap;

public interface NhaCungCapRepoITF extends JpaRepository<NhaCungCap,Integer>{
    @Query(value = "select * from nha_cung_cap where trang_thai = 1 order by ngay_tao desc",nativeQuery =true )
    List<NhaCungCap> listNCC();
}
