package com.example.InventoryManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name =  "chuc_vu")
@NoArgsConstructor
@Getter
@Setter
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenChucVu;

    @OneToMany(mappedBy = "chucVu",cascade ={CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<NhanVien> nhanViens = new ArrayList<>();

    public ChucVu(Integer id, String tenChucVu) {
        this.id = id;
        this.tenChucVu = tenChucVu;
    }
    
}
