INSERT INTO san_pham (hinh_anh,ma_san_pham, ten_san_pham, ngay_tao, ngay_sua, ngay_xoa, trang_thai)
VALUES
    (NULL,'VT001', 'Yonex Astrox 99', '2024-12-15', NULL, NULL, 1),
    (NULL,'VT002', 'Yonex Astrox 88D Pro', '2025-01-10', NULL, NULL, 1),
    (NULL,'VT003', 'Yonex Astrox 88S Pro', '2024-11-25', NULL, NULL, 1),
    (NULL,'VT004', 'Yonex Nanoflare 800', '2025-02-02', NULL, NULL, 1),
    (NULL,'VT005', 'Yonex Nanoflare 1000Z', '2024-12-30', NULL, NULL, 1),
    (NULL,'VT006', 'Yonex Duora Z Strike', '2024-11-28', NULL, NULL, 1),
    (NULL,'VT007', 'Yonex Arcsaber 11 Pro', '2025-01-15', NULL, NULL, 1),
    (NULL,'VT008', 'Yonex Voltric Z Force II', '2025-01-05', NULL, NULL, 1),
    (NULL,'VT009', 'Lining Aeronaut 9000', '2024-12-10', NULL, NULL, 1),
    (NULL,'VT010', 'Lining Turbo Charging 75', '2025-02-01', NULL, NULL, 1),
    (NULL,'VT011', 'Lining Windstorm 72', '2024-11-20', NULL, NULL, 1),
    (NULL,'VT012', 'Lining 3D Calibar 900', '2025-01-25', NULL, NULL, 1),
    (NULL,'VT013', 'Victor Thruster Ryuga II', '2024-12-05', NULL, NULL, 1),
    (NULL,'VT014', 'Victor Brave Sword 12', '2025-02-10', NULL, NULL, 1),
    (NULL,'VT015', 'Victor Auraspeed 100X', '2024-11-30', NULL, NULL, 1),
    (NULL,'VT016', 'Mizuno Altius 03 Feel', '2025-01-20', NULL, NULL, 1),
    (NULL,'VT017', 'Mizuno Fortius 10 Power', '2025-02-05', NULL, NULL, 1),
    (NULL,'VT018', 'Kawasaki King K9', '2024-12-08', NULL, NULL, 1),
    (NULL,'VT019', 'Forza Power 988 S', '2025-01-28', NULL, NULL, 1),
    (NULL,'VT020', 'Forza Precision 10.000', '2025-02-07', NULL, NULL, 1);

INSERT INTO chieu_dai (ma_chieu_dai, chieu_dai_vot, don_vi,ngay_tao, ngay_sua, ngay_xoa, trang_thai)
VALUES 
('CD001', 660,'mm', '2025-01-13', NULL, NULL, 1),
('CD002', 675,'mm', '2025-02-01', NULL, NULL, 1),
('CD003', 680,'mm', '2025-01-28', NULL, NULL, 1),
('CD004', 665,'mm', '2025-02-10', NULL, NULL, 1),
('CD005', 690,'mm', '2025-01-15', NULL, NULL, 1),
('CD006', 670,'mm', '2025-02-07', NULL, NULL, 1);

INSERT INTO cong_nghe (ma_cong_nghe, ten_cong_nghe, ngay_tao, ngay_sua, ngay_xoa, trang_thai)
VALUES 
('CN001', 'Isometric Frame', '2024-01-10', NULL, NULL, 1),
('CN002', 'Aero+Box Frame', '2023-12-15', NULL, NULL, 1),
('CN003', 'Tri-Voltage System', '2023-11-20', NULL, NULL, 1),
('CN004', 'Sonic Flare System', '2023-10-05', NULL, NULL, 1),
('CN005', 'Nanomesh Neo', '2023-09-25', NULL, NULL, 1),
('CN006', 'Rotational Generator System', '2023-08-30', NULL, NULL, 1),
('CN007', 'Nanometric DR', '2023-07-12', NULL, NULL, 1),
('CN008', 'Rexis Shaft', '2023-06-18', NULL, NULL, 1),
('CN009', 'Super HMG', '2023-05-22', NULL, NULL, 1),
('CN010', 'Extra Slim Shaft', '2023-04-10', NULL, NULL, 1),
('CN011', 'Control Support Cap', '2023-03-05', NULL, NULL, 1),
('CN012', 'Energy Boost Cap', '2023-02-15', NULL, NULL, 1),
('CN013', 'Box Frame', '2023-01-20', NULL, NULL, 1),
('CN014', 'Aero Frame', '2022-12-12', NULL, NULL, 1),
('CN015', 'T-Joint Technology', '2022-11-25', NULL, NULL, 1),
('CN016', 'Nanoscience Technology', '2022-10-08', NULL, NULL, 1),
('CN017', 'Muscle Power Frame', '2022-09-18', NULL, NULL, 1),
('CN018', 'Power Assist Bumper', '2022-08-28', NULL, NULL, 1),
('CN019', 'Solid Feel Core', '2022-07-30', NULL, NULL, 1),
('CN020', 'Ultra PEF Shaft', '2022-06-10', NULL, NULL, 1);

INSERT INTO trong_luong (ki_hieu, can_nang_min, can_nang_max, don_vi, ngay_tao, ngay_sua, ngay_xoa, trang_thai) 
VALUES
('2U', 90.00, 94.00, 'g', '2024-02-16', NULL, NULL, 1),
('3U', 85.00, 89.00, 'g', '2024-02-16', NULL, NULL, 1),
('4U', 80.00, 84.00, 'g', '2024-02-16', NULL, NULL, 1),
('5U', 75.00, 79.00, 'g', '2024-02-16', NULL, NULL, 1),
('F', 70.00, 74.00, 'g', '2024-02-16', NULL, NULL, 1),
('2F', 65.00, 69.00, 'g', '2024-02-16', NULL, NULL, 1),
('1U', 95.00, 99.00, 'g', '2024-02-16', NULL, NULL, 1);

INSERT INTO thuong_hieu (ten_thuong_hieu, duong_dan_anh, ngay_tao, ngay_sua, ngay_xoa, trang_thai)
VALUES
('Yonex',NULL, '2024-01-10', NULL, NULL, 1),
('Lining',NULL, '2023-12-15', NULL, NULL, 1),
('Victor', NULL, '2023-11-20', NULL, NULL, 1),
('Apacs', NULL, '2023-10-05', NULL, NULL, 1),
('Kawasaki', NULL, '2023-09-25', NULL, NULL, 1),
('Forza', NULL, '2023-08-18', NULL, NULL, 1),
('Fleet', NULL, '2023-07-30', NULL, NULL, 1),
('Babolat',NULL, '2023-06-12', NULL, NULL, 1),
('Carlton',NULL, '2023-05-22', NULL, NULL, 1),
('Gosen', NULL, '2023-04-05', NULL, NULL, 1);


INSERT INTO do_cung (ma_do_cung, ten_do_cung, ngay_tao, ngay_sua, ngay_xoa, trang_thai)
VALUES
(1, 'Stiff', '2025-02-18', NULL, NULL, 1),
(2, 'Medium', '2025-02-18', NULL, NULL, 1),
(3, 'Flexible', '2025-02-18', NULL, NULL, 1),
(4, 'Extra Stiff', '2025-02-18', NULL, NULL, 1),
(5, 'Super Flexible', '2025-02-18', NULL, NULL, 1),
(6, 'Very Stiff', '2025-02-18', NULL, NULL, 1),
(7, 'Semi Stiff', '2025-02-18', NULL, NULL, 1),
(8, 'Ultra Stiff', '2025-02-18', NULL, NULL, 1),
(9, 'Medium-Flex', '2025-02-18', NULL, NULL, 1);

INSERT INTO swing_weight (muc_do, gia_tri, ngay_tao, ngay_sua, ngay_xoa, trang_thai)  
VALUES  
('Light', 80, '2024-12-01 10:15:00', NULL, NULL, 1),  
('Medium-Light', 85,  '2024-12-05 14:30:00', NULL, NULL, 1),  
('Medium', 90, '2024-12-10 09:45:00', NULL, NULL, 1),  
('Medium-Heavy', 95, '2024-12-15 16:20:00', NULL, NULL, 1),  
('Heavy', 100, '2024-12-20 18:10:00', NULL, NULL, 1);

INSERT INTO nha_cung_cap (ma_nhacc, ten_nhacc, dia_chi, so_dien_thoai, email, website, ngay_tao, ngay_sua, ngay_xoa, trang_thai)  
VALUES  
('NCC001', 'Cong ty TNHH Cau Long Viet', '123 Duong Nguyen Trai, Ha Noi', '0987654321', 'info@caulongviet.com', 'www.caulongviet.com', GETDATE(), '', '', 1),  
('NCC002', 'Cong ty CP The Thao Nam Viet', '456 Duong Le Loi, TP Ho Chi Minh', '0976543210', 'contact@namviet.com', 'www.namviet.com', GETDATE(), '', '', 1),  
('NCC003', 'Cong ty TNHH SportKing', '789 Duong Hoang Hoa Tham, Da Nang', '0901234567', 'support@sportking.com', 'www.sportking.com', GETDATE(), '', '', 1),  
('NCC004', 'Nha Phan Phoi Yonex Viet Nam', '159 Duong Vo Van Kiet, Can Tho', '0934567890', 'sales@yonexvietnam.com', 'www.yonexvietnam.com', GETDATE(), '', '', 1),  
('NCC005', 'Cong ty TNHH Victor Sports', '321 Duong Tran Phu, Hai Phong', '0912345678', 'info@victorsports.com', 'www.victorsports.com', GETDATE(), '', '', 1);  


INSERT INTO nha_kho(ma_kho,khu_vuc_kho,suc_chua,so_dien_thoai,ngay_tao,ngay_sua,ngay_xoa,trang_thai)
VALUES ('NK001','kho A',100,'0362810928',GETDATE(),NULL,NULL,1),
		('NK002','kho B',100,'0369173905',GETDATE(),NULL,NULL,1),
		('NK003','kho C',150,'0361239583',GETDATE(),NULL,NULL,1);

INSERT INTO xuat_xu(xuat_xu, ngay_tao, ngay_sua, ngay_xoa, trang_thai)
VALUES 
('Nhat Ban', GETDATE(), NULL, NULL, 1),
('Han Quoc', GETDATE(), NULL, NULL, 1),
('Trung Quoc', GETDATE(), NULL, NULL, 1),
('Dai Loan', GETDATE(), NULL, NULL, 1),
('Indonesia', GETDATE(), NULL, NULL, 1);

INSERT INTO san_pham_ct (ma_san_pham, id_san_pham, id_cong_nghe, id_chieu_dai, id_do_cung, id_swing, id_thuong_hieu, id_trong_luong, id_xuat_xu, gia_tien, ngay_tao, ngay_sua, ngay_xoa, trang_thai, gia_ban)
VALUES
('SPCT001', 1, 1, 3, 4, 3, 1, 2, 1, 3500000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT002', 2, 2, 2, 3, 2, 1, 3, 1, 3200000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT003', 3, 3, 1, 2, 1, 1, 4, 1, 3000000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT004', 4, 4, 4, 5, 5, 1, 1, 1, 4000000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT005', 5, 5, 5, 6, 4, 1, 2, 1, 4200000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT006', 6, 6, 6, 1, 3, 2, 3, 2, 3100000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT007', 7, 7, 1, 4, 2, 2, 4, 2, 3300000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT008', 8, 8, 2, 3, 1, 2, 1, 2, 3400000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT009', 9, 9, 3, 5, 5, 2, 2, 2, 3700000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT010', 10, 10, 4, 2, 4, 2, 3, 2, 3100000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT011', 11, 11, 5, 6, 3, 3, 4, 3, 3900000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT012', 12, 12, 6, 1, 2, 3, 1, 3, 2950000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT013', 13, 13, 1, 4, 1, 3, 2, 3, 3050000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT014', 14, 14, 2, 3, 5, 3, 3, 3, 3150000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT015', 15, 15, 3, 5, 4, 3, 4, 3, 3250000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT016', 16, 16, 4, 2, 3, 4, 1, 4, 3450000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT017', 17, 17, 5, 6, 2, 4, 2, 4, 3650000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT018', 18, 18, 6, 1, 1, 4, 3, 4, 3800000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT019', 19, 19, 1, 4, 5, 4, 4, 4, 3950000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT020', 20, 20, 2, 3, 4, 4, 1, 4, 4150000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT021', 1, 5, 3, 5, 3, 5, 2, 5, 3500000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT022', 2, 6, 4, 2, 2, 5, 3, 5, 3300000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT023', 3, 7, 5, 6, 1, 5, 4, 5, 3200000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT024', 4, 8, 6, 1, 5, 5, 1, 5, 3000000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT025', 5, 9, 1, 4, 4, 5, 2, 5, 3100000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT026', 6, 10, 2, 3, 3, 5, 3, 5, 2900000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT027', 7, 11, 3, 5, 2, 5, 4, 5, 2800000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT028', 8, 12, 4, 2, 1, 5, 1, 5, 2700000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT029', 9, 13, 5, 6, 5, 5, 2, 5, 2600000, GETDATE(), NULL, NULL, 1, NULL),
('SPCT030', 10, 14, 6, 1, 4, 5, 3, 5, 2500000, GETDATE(), NULL, NULL, 1, NULL);


INSERT INTO sanphamct_nhakho (id_nha_kho, id_sp_ct, so_luong, ngay_tao, trang_thai)
VALUES 
(1, 1, 10, GETDATE(), 1), (1, 2, 8, GETDATE(), 1), (1, 3, 12, GETDATE(), 1), (1, 4, 7, GETDATE(), 1), (1, 5, 5, GETDATE(), 1), 
(1, 6, 9, GETDATE(), 1), (1, 7, 11, GETDATE(), 1), (1, 8, 6, GETDATE(), 1), (1, 9, 8, GETDATE(), 1), (1, 10, 10, GETDATE(), 1),  
(2, 11, 7, GETDATE(), 1), (2, 12, 12, GETDATE(), 1), (2, 13, 9, GETDATE(), 1), (2, 14, 6, GETDATE(), 1), (2, 15, 8, GETDATE(), 1), 
(2, 16, 7, GETDATE(), 1), (2, 17, 5, GETDATE(), 1), (2, 18, 10, GETDATE(), 1), (2, 19, 9, GETDATE(), 1), (2, 20, 6, GETDATE(), 1),  
(3, 21, 8, GETDATE(), 1), (3, 22, 12, GETDATE(), 1), (3, 23, 7, GETDATE(), 1), (3, 24, 10, GETDATE(), 1), (3, 25, 9, GETDATE(), 1), 
(3, 26, 11, GETDATE(), 1), (3, 27, 6, GETDATE(), 1), (3, 28, 10, GETDATE(), 1), (3, 29, 8, GETDATE(), 1), (3, 30, 12, GETDATE(), 1);

INSERT INTO chuc_vu(ten_chuc_vu)
VALUES('quan ly');
INSERT INTO chuc_vu(ten_chuc_vu)
VALUES('nhan vien');

INSERT INTO nhan_vien (ma_nhan_vien, ten_nhan_vien, ngay_sinh, gioi_tinh, so_dien_thoai, email, mat_khau, ngay_tao, ngay_sua, ngay_xoa, id_chuc_vu, trang_thai)
VALUES
('hoatvph53993', 'Tran Van Hoa ', '2005-06-15', 1, '0987654321', 'hoa573898@gmail.com', '$2a$10$6PAG2uBCLghFFRk/ymlmB.dE/gFxI9cpuFV0rjXhVOEKMUE6yw1CW', GETDATE(), GETDATE(), NULL, 1, 1),
('linhtt98', 'Tran Thi Linh', '1998-02-20', 0, '0978123456', 'tranthib@gmail.com', '$2a$10$6PAG2uBCLghFFRk/ymlmB.dE/gFxI9cpuFV0rjXhVOEKMUE6yw1CW', GETDATE(), GETDATE(), NULL, 2, 1),
('cuonglh92', 'Le Hoang Cuong', '1992-09-10', 1, '0968543210', 'lehoangc@gmail.com', '$2a$10$6PAG2uBCLghFFRk/ymlmB.dE/gFxI9cpuFV0rjXhVOEKMUE6yw1CW', GETDATE(), GETDATE(), NULL, 2, 1),
('ducmp20', 'Pham Minh Duc', '2000-12-05', 1, '0956321789', 'phamminhd@gmail.com', '$2a$10$6PAG2uBCLghFFRk/ymlmB.dE/gFxI9cpuFV0rjXhVOEKMUE6yw1CW', GETDATE(), GETDATE(), NULL, 2, 1);

-- Phiếu nhập 1
INSERT INTO phieu_nhap(ma_phieu, id_nhan_vien, id_nha_cc, so_luong, tong_tien_nhap, ngay_tao, ngay_sua, ngay_xoa, ngay_nhap, trang_thai)
VALUES ('PN001', 1, 1, 50, 150000000, GETDATE(), NULL, NULL, GETDATE(), 1);

INSERT INTO phieu_nhap_ct(id_phieu_nhap, id_spct, id_nha_kho, so_luong, gia_nhap, thanh_tien, ngay_tao, ngay_sua, trang_thai)
VALUES
(1, 1, 1, 10, 3000000, 30000000, GETDATE(), NULL, 1),
(1, 2, 1, 8, 2800000, 22400000, GETDATE(), NULL, 1),
(1, 3, 1, 12, 2500000, 30000000, GETDATE(), NULL, 1),
(1, 4, 1, 7, 3500000, 24500000, GETDATE(), NULL, 1),
(1, 5, 1, 5, 3800000, 19000000, GETDATE(), NULL, 1),
(1, 6, 1, 9, 2700000, 24300000, GETDATE(), NULL, 1),
(1, 7, 1, 11, 3000000, 33000000, GETDATE(), NULL, 1),
(1, 8, 1, 6, 3200000, 19200000, GETDATE(), NULL, 1),
(1, 9, 1, 8, 3400000, 27200000, GETDATE(), NULL, 1);

-- Phiếu nhập 2
INSERT INTO phieu_nhap(ma_phieu, id_nhan_vien, id_nha_cc, so_luong, tong_tien_nhap, ngay_tao, ngay_sua, ngay_xoa, ngay_nhap, trang_thai)
VALUES ('PN002', 2, 2, 40, 120000000, GETDATE(), NULL, NULL, GETDATE(), 1);

INSERT INTO phieu_nhap_ct(id_phieu_nhap, id_spct, id_nha_kho, so_luong, gia_nhap, thanh_tien, ngay_tao, ngay_sua, trang_thai)
VALUES
(2, 10, 1, 10, 2800000, 28000000, GETDATE(), NULL, 1),
(2, 11, 2, 7, 3500000, 24500000, GETDATE(), NULL, 1),
(2, 12, 2, 12, 2400000, 28800000, GETDATE(), NULL, 1),
(2, 13, 2, 9, 2700000, 24300000, GETDATE(), NULL, 1),
(2, 14, 2, 6, 2900000, 17400000, GETDATE(), NULL, 1),
(2, 15, 2, 8, 3000000, 24000000, GETDATE(), NULL, 1),
(2, 16, 2, 7, 3200000, 22400000, GETDATE(), NULL, 1),
(2, 17, 2, 5, 3500000, 17500000, GETDATE(), NULL, 1),
(2, 18, 2, 10, 3700000, 37000000, GETDATE(), NULL, 1);

-- Phiếu nhập 3
INSERT INTO phieu_nhap(ma_phieu, id_nhan_vien, id_nha_cc, so_luong, tong_tien_nhap, ngay_tao, ngay_sua, ngay_xoa, ngay_nhap, trang_thai)
VALUES ('PN003', 3, 3, 45, 135000000, GETDATE(), NULL, NULL, GETDATE(), 1);

INSERT INTO phieu_nhap_ct(id_phieu_nhap, id_spct, id_nha_kho, so_luong, gia_nhap, thanh_tien, ngay_tao, ngay_sua, trang_thai)
VALUES
(3, 19, 2, 9, 3600000, 32400000, GETDATE(), NULL, 1),
(3, 20, 2, 6, 3900000, 23400000, GETDATE(), NULL, 1),
(3, 21, 3, 8, 3200000, 25600000, GETDATE(), NULL, 1),
(3, 22, 3, 12, 3000000, 36000000, GETDATE(), NULL, 1),
(3, 23, 3, 7, 2800000, 19600000, GETDATE(), NULL, 1),
(3, 24, 3, 10, 2500000, 25000000, GETDATE(), NULL, 1),
(3, 25, 3, 9, 2700000, 24300000, GETDATE(), NULL, 1),
(3, 26, 3, 11, 2400000, 26400000, GETDATE(), NULL, 1),
(3, 27, 3, 6, 2200000, 13200000, GETDATE(), NULL, 1);

-- Phiếu nhập 4
INSERT INTO phieu_nhap(ma_phieu, id_nhan_vien, id_nha_cc, so_luong, tong_tien_nhap, ngay_tao, ngay_sua, ngay_xoa, ngay_nhap, trang_thai)
VALUES ('PN004', 4, 4, 38, 110000000, GETDATE(), NULL, NULL, GETDATE(), 1);

INSERT INTO phieu_nhap_ct(id_phieu_nhap, id_spct, id_nha_kho, so_luong, gia_nhap, thanh_tien, ngay_tao, ngay_sua, trang_thai)
VALUES
(4, 28, 3, 10, 2000000, 20000000, GETDATE(), NULL, 1),
(4, 29, 3, 8, 2200000, 17600000, GETDATE(), NULL, 1),
(4, 30, 3, 12, 2400000, 28800000, GETDATE(), NULL, 1),
(4, 1, 1, 5, 3000000, 15000000, GETDATE(), NULL, 1),
(4, 2, 1, 3, 2800000, 8400000, GETDATE(), NULL, 1),
(4, 3, 1, 7, 2500000, 17500000, GETDATE(), NULL, 1),
(4, 4, 1, 6, 3500000, 21000000, GETDATE(), NULL, 1),
(4, 5, 1, 4, 3800000, 15200000, GETDATE(), NULL, 1),
(4, 6, 1, 3, 2700000, 8100000, GETDATE(), NULL, 1);

-- Phiếu nhập 5
INSERT INTO phieu_nhap(ma_phieu, id_nhan_vien, id_nha_cc, so_luong, tong_tien_nhap, ngay_tao, ngay_sua, ngay_xoa, ngay_nhap, trang_thai)
VALUES ('PN005', 1, 1, 35, 100000000, GETDATE(), NULL, NULL, GETDATE(), 1);

INSERT INTO phieu_nhap_ct(id_phieu_nhap, id_spct, id_nha_kho, so_luong, gia_nhap, thanh_tien, ngay_tao, ngay_sua, trang_thai)
VALUES
(5, 7, 1, 8, 3000000, 24000000, GETDATE(), NULL, 1),
(5, 8, 1, 5, 3200000, 16000000, GETDATE(), NULL, 1),
(5, 9, 1, 7, 3400000, 23800000, GETDATE(), NULL, 1),
(5, 10, 1, 6, 2800000, 16800000, GETDATE(), NULL, 1),
(5, 11, 2, 4, 3500000, 14000000, GETDATE(), NULL, 1),
(5, 12, 2, 6, 2400000, 14400000, GETDATE(), NULL, 1),
(5, 13, 2, 5, 2700000, 13500000, GETDATE(), NULL, 1),
(5, 14, 2, 3, 2900000, 8700000, GETDATE(), NULL, 1),
(5, 15, 2, 4, 3000000, 12000000, GETDATE(), NULL, 1);

-- Phiếu nhập 6
INSERT INTO phieu_nhap(ma_phieu, id_nhan_vien, id_nha_cc, so_luong, tong_tien_nhap, ngay_tao, ngay_sua, ngay_xoa, ngay_nhap, trang_thai)
VALUES ('PN006', 2, 2, 42, 130000000, GETDATE(), NULL, NULL, GETDATE(), 1);

INSERT INTO phieu_nhap_ct(id_phieu_nhap, id_spct, id_nha_kho, so_luong, gia_nhap, thanh_tien, ngay_tao, ngay_sua, trang_thai)
VALUES
(6, 16, 2, 7, 3200000, 22400000, GETDATE(), NULL, 1),
(6, 17, 2, 8, 3500000, 28000000, GETDATE(), NULL, 1),
(6, 18, 2, 10, 3700000, 37000000, GETDATE(), NULL, 1),
(6, 19, 2, 9, 3600000, 32400000, GETDATE(), NULL, 1),
(6, 20, 2, 8, 3900000, 31200000, GETDATE(), NULL, 1),
(6, 21, 3, 5, 3200000, 16000000, GETDATE(), NULL, 1),
(6, 22, 3, 7, 3000000, 21000000, GETDATE(), NULL, 1),
(6, 23, 3, 6, 2800000, 16800000, GETDATE(), NULL, 1),
(6, 24, 3, 4, 2500000, 10000000, GETDATE(), NULL, 1);



