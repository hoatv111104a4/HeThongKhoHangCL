package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryManagementSystem.entity.CongNghe;

public interface  CongNgheRepoITF extends JpaRepository<CongNghe,Integer>{
    @Query(value = "SELECT * FROM cong_nghe where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    Page<CongNghe> getAllCongNghe(Pageable pageable);

    @Query(value = "SELECT * FROM cong_nghe where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    List<CongNghe> listCongNghe();

    @Modifying
    @Transactional
    @Query(value = "UPDATE cong_nghe set trang_thai = 0 , ngay_xoa=GETDATE() where id=?",nativeQuery = true)
    void updateByIdCongNghe(Integer id);
}
