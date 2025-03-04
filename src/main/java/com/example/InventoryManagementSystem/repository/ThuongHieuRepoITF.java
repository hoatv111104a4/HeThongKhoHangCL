package com.example.InventoryManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryManagementSystem.entity.ThuongHieu;

public interface ThuongHieuRepoITF extends JpaRepository<ThuongHieu,Integer> {
    @Query(value = "SELECT * FROM thuong_hieu where trang_thai = 1 order by ngay_tao desc"  ,nativeQuery = true)
    Page<ThuongHieu> getAllThuongHieu(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE thuong_hieu set trang_thai = 0 ,ngay_xoa=GETDATE() where id =? ",nativeQuery = true)
    void updateByIdThuongHieu(Integer id);

    @Query(value = "SELECT * FROM thuong_hieu where trang_thai = 1 order by ngay_tao desc"  ,nativeQuery = true)
    List<ThuongHieu> listThuongHieu();
}
