package com.example.InventoryManagementSystem.dto;

import com.example.InventoryManagementSystem.entity.NhaKho;
import com.example.InventoryManagementSystem.entity.PhieuNhapChiTiet;
import com.example.InventoryManagementSystem.entity.SanPhamChiTiet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SanPhamNhapDto {
    private PhieuNhapChiTiet phieuNhapChiTiet;
    private SanPhamChiTiet sanPhamChiTiet;
    private NhaKho nhaKho;
}
