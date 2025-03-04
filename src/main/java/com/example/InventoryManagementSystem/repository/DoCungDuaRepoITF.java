package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryManagementSystem.entity.DoCungDua;

public interface DoCungDuaRepoITF extends JpaRepository<DoCungDua,Integer>{
    @Query(value = "SELECT * FROM do_cung where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    Page<DoCungDua> getAllDoCungDua(Pageable pageable);

    @Query(value = "SELECT * FROM do_cung where trang_thai =1 order by ngay_tao desc",nativeQuery = true)
    List<DoCungDua> listDoCungDua();

    @Modifying
    @Transactional
    @Query(value = "UPDATE do_cung set trang_thai = 0 , ngay_xoa = GETDATE() where id =?",nativeQuery = true)
    void updateByIdDoCung(Integer id);
}
