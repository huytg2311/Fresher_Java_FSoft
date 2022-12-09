create database sql_base;

use sql_base;

create table sanpham(
MaSP varchar(10) primary key,
TenSP nvarchar(20),
GiaBan int,
SoLuong int,
MaLoaiSP varchar(10),
foreign key (MaLoaiSP) references loaisp(MaLoaiSP)
);

insert into sanpham values
('SP001', 'Iphone 14', 200, 5, 'LSP001'),
('SP002', 'Picture 4k', 500, 5, 'LSP003'),
('SP003', 'Skirt LV', 600, 5, 'LSP002');


create table loaisp(
MaLoaiSP varchar(10) primary key,
TenLoaiSP varchar(20)
);

insert into loaisp values
('LSP001', 'Technology'),
('LSP002', 'Fashion'),
('LSP003', 'Art');


create table nhanvien(
MaNV varchar(10) primary key,
HoTenNV nvarchar(20),
GioiTinh varchar(10),
QueQuan varchar(20),
Tuoi int
);

insert into nhanvien values
('NV001', 'Truong Gia Huy', 'Nam', 'Hai Phong', 21),
('NV002', 'Nguyen Van Hieu', 'Nu', 'Hue', 25),
('NV003', 'Le Ngoc Khoi', 'Nu', 'Quang Tri', 21),
('NV004', 'Ho Quoc Bao Truong', 'Nam', 'Hue', 21),
('NV005', 'Le Dinh Phong', 'Nam', 'Hanoi', 21);

create table banhang(
MaNV varchar(10),
foreign key (MaNV) references nhanvien(MaNV),
MaSP varchar(10),
foreign key (MaSP) references sanpham(MaSP),
SoLuongDaBan int
);

insert into banhang values
('NV002', 'SP004', 2),
('NV002', 'SP005', 1),
('NV002', 'SP001', 2),
('NV003', 'SP001', 1),
('NV003', 'SP001', 1),
('NV004', 'SP003', 1),
('NV005', 'SP003', 3),
('NV005', 'SP002', 1),
('NV005', 'SP001', 1);



-- ---------------------------------------------------

-- cau 1:
select loaisp.MaLoaiSP, sanpham.SoLuong from sanpham inner join loaisp where sanpham.MaLoaiSP = loaisp.MaLoaiSP;

-- cau 2-3:
select nhanvien.MaNV, nhanvien.HoTenNV, count(banhang.MaSP) as 'MaSP' from nhanvien left join banhang on nhanvien.MaNV = banhang.MaNV group by banhang.MaNV;

-- cau 4:
select sanpham.MaSP, sanpham.TenSP, loaisp.MaLoaiSP, loaisp.TenLoaiSP from sanpham join loaisp on sanpham.MaLoaiSP = loaisp.MaLoaiSP where sanpham.SoLuong > 0;

-- cau 5:
select nhanvien.MaNV, nhanvien.HoTenNV, banhang.SoLuongDaBan from nhanvien left join banhang on nhanvien.MaNV = banhang.MaNV where SoLuongDaBan >= 10;

-- cau 6:
select sanpham.MaLoaiSP from sanpham join loaisp on sanpham.MaLoaiSP = loaisp.MaLoaiSP where not loaisp.TenLoaiSP = 'Fashion' group by sanpham.MaLoaiSP having count(sanpham.MaSP) > 1;

-- cau 7:
select GioiTinh,QueQuan,Tuoi, count(nhanvien.MaNV) as 'So luong' from nhanvien group by GioiTinh,QueQuan,Tuoi;

-- cau 8:
select nhanvien.MaNV, sanpham.TenSP, loaisp.TenLoaiSP  from nhanvien inner join banhang on nhanvien.MaNV = banhang.MaNV 
inner join sanpham on banhang.MaSP = sanpham.MaSP inner join loaisp on sanpham.MaLoaiSP = loaisp.MaLoaiSP order by nhanvien.MaNV asc;

-- cau 9:
select count(MaNV) from banhang where MaSP = 'SP001' group by MaSP;

-- cau 10:
select count(*) from (select count(banhang.MaNV)  from nhanvien inner join banhang on nhanvien.MaNV = banhang.MaNV 
inner join sanpham on banhang.MaSP = sanpham.MaSP 
inner join loaisp on sanpham.MaLoaiSP = loaisp.MaLoaiSP where nhanvien.QueQuan = 'Hai Phong' and loaisp.TenLoaiSP = 'Technology'
group by nhanvien.QueQuan, banhang.MaNV) as so_luong;