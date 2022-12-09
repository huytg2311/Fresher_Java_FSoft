create database sql_basic;
use sql_basic;
-- create table --
create table SANPHAM(
MaSP varchar(255) primary key,
TenSP varchar(255),
MaLoaiSP varchar(255),
foreign key (MaLoaiSP) references LOAISP(MaLoaiSP),
GiaBan double
);

create table LOAISP(
MaLoaiSP varchar(255) primary key,
TenLoaiSP varchar(255)
);

create table NHANVIEN(
MaNV varchar(255) primary key,
HoTenNV varchar(255),
GioiTinh varchar(255),
QueQuan varchar(255),
Tuoi int
);

create table BANHANG(
MaNV varchar(255),
MaSP varchar(255),
foreign key (MaNV) references NHANVIEN(MaNV),
foreign key (MaSP) references SANPHAM(MaSP),
SoLuongDaBan int primary key
);

-- Query --
-- Question 1: --
insert into NHANVIEN values
('NV01', 'Nguyễn Chí Phèo', 'Nam', 'Quảng Trị', 18);
-- Question 2: --
delete from NHANVIEN where GioiTinh = 'Nữ' and QueQuan = 'Kom Tum';
-- Question 3: --
update SANPHAM set GiaBan = GiaBan * 2 where MaLoaiSP = 'Type001';
-- Question 4: --
select * from NHANVIEN;
-- Question 5: --
select * from NhanVien where Tuoi >= 23 and QueQuan = 'Bình Định';
-- Question 6: --
select MaSP from BANHANG where SoLuongDaBan >= 1;
-- Question 7: --
select * from NhanVien where HoTenNV LIKE '%Nguyễn%';
-- Question 8: --
select * from NhanVien where HoTenNV LIKE '%Hoa%';
-- Question 9: --
select * from SANPHAM where TenSP LIKE '____________';
-- Question 10: --
select * from SANPHAM where MaLoaiSP = (select MaLoaiSP from LOAISP where TenLoaiSP = 'Mỹ Phẩm');
-- Question 11: --
select * from SANPHAM where MaSP Not In (select MaSP from BANHANG);
-- Question 12: --
select * from NHANVIEN where MaNV Not In (select MaNV from BANHANG)
or  MaNV = (select MaNV from BANHANG where MaSP = (select MaSP from SANPHAM where TenSP = 'Bột Giặt OMO'));
-- Question 13: --
select MaNV from NHANVIEN where QueQuan = 'Gia Lai' and MaNV Not In (select MaNV from BANHANG);
-- Question 14: --
select LOAISP.TenLoaiSP, MaSP, TenSP, LOAISP.MaLoaiSP, GiaBan from SANPHAM 
inner join LOAISP on SANPHAM.MaLoaiSP = LOAISP.MaLoaiSP; 
-- Question 15: --
select NHANVIEN.MaNV, HoTenNV, GioiTinh, QueQuan, BANHANG.MaSP, SANPHAM.TenSP, LOAISP.MaLoaiSP,
LOAISP.TenLoaiSP, BANHANG.SoLuongDaBan from NHANVIEN
inner join BANHANG on NHANVIEN.MaNV = BANHANG.MaNV 
inner join SANPHAM on BANHANG.MaSP = SANPHAM.MaSP 
inner join LoaiSP on SANPHAM.MaLoaiSP = LOAISP.MaLoaiSP;
-- Question 16: --
select SANPHAM.MaLoaiSP, LOAISP.TenLoaiSP from LOAISP 
inner join SANPHAM on LOAISP.MaLoaiSP = SANPHAM.MaLoaiSP
inner join BANHANG on SANPHAM.MaSP = BANHANG.MaSP where BANHANG.MaSP in (select MaSP from BANHANG);
-- Question 17: --
SELECT
   substring_index(HoTenNV, ' ', 1) AS Ho,
   substring_index(HoTenNV, ' ', -1) AS Ten
FROM NHANVIEN 
GROUP BY Ten;
-- Question 18: --
select MaNV, HoTenNV, if(QueQuan is null, 'Cõi Trên Xuống', QueQuan) as QueQuan from NHANVIEN;
-- Question 19: --
select MaNV, HoTenNV, GioiTinh, QueQuan, Tuoi from NHANVIEN order by Tuoi desc limit 5;
-- Question 20: --
select * from NHANVIEN where Tuoi between 25 and 35;

create table STUDENT

