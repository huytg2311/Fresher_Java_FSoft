create database sqle;

use sqle;

create table DUAN(
MaDA varchar(50) primary key,
TenDA nvarchar(50),
NgayBD date,
NgayKT date,
SoLuongNV int,
DiaDiem nvarchar(50)
);

alter table DUAN
alter column NgayKT date;

insert into DUAN values
('DA001', 'NIC', '12/15/2021', '6/15/2022', 10, 'Tang 3, FC1'),
('DA002', 'WAS', '4/20/2022', '10/20/2022', 20, 'Tang 4, FC2'),
('DA003', 'SAWA', '6/30/2021', '12/30/2021', 15, 'Tang 5, FC1'),
('DA004', 'YKC', '12/25/2021', '6/25/2022', 40, 'Tang 3, FC1'),
('DA005', 'INTRA', '3/7/2022', '9/7/2022', 60, 'Tang 4, FC2'),
('DA006', 'SEIKI', '3/9/2022', '9/9/2022', 75, 'Tang 5, FC1');

create table DOANKHACH(
MaDoan varchar(50) primary key,
TenNguoiDaiDien nvarchar(50),
QuocTich nvarchar(50),
NgayDen date,
NgayVe date,
MaDA varchar(50)
foreign key (MaDA) references DUAN(MaDA)
);


insert into DOANKHACH values
('D001', 'Steven', 'My', '5/4/2022', '5/20/2022', 'DA001'),
('D002', 'Ana', 'Anh', '9/3/2022', '9/10/2022', 'DA002'),
('D003', 'Ebihara', 'Nhat', '8/5/2022', '8/20/2022', 'DA003');

create table LOAITIEPKHACH(
MaLoaiTK varchar(50) primary key,
TenLoaiTK nvarchar(50)
);

insert into LOAITIEPKHACH values
('L001', 'An trua'),
('L002', 'An toi'),
('L003', 'Tham quan');

create table NHANVIEN(
MaNV varchar(50) primary key,
HoTen nvarchar(50),
CCCD varchar(50),
GioiTinh varchar(50),
NgaySinh date,
DiaChi varchar(50),
SoDienThoai varchar(50),
NgayVaoCongTy date
);


insert into NHANVIEN values
('NV001', 'Nguyen Van Hung', '1914235876', 'Nam', '11/5/1987', '76 CMT8', '0907657654', '11/5/2019'),
('NV002', 'Nguyen Van Son', '1937687654', 'Nam', '6/15/1978', '25 Ha Huy Tap', '0988765432', '6/15/2018'),
('NV003', 'Tran Thi Phuong', '1974654328', 'Nu', '5/24/1978', '17 Hai Phong', '0915976546', '5/24/2019'),
('NV004', 'Le Phan Thi', '1978653295', 'Nu', '5/4/1980', '5 Nam Ky Khoi Nghia', '0987643342', '5/4/2018'),
('NV005', 'Bui Viet Linh', '2018076543', 'Nam', '10/10/1975', '257 Nguyen Tri Phuong', '0963456543', '10/10/2017'),
('NV006', 'Truong Van Vinh', '2018976789', 'Nam', '10/14/1990', '30 Phan Chau Trinh', '0987657865', '10/14/2018');

create table LSTIEPKHACH(
MaLSTK varchar(50) primary key,
MaDoan varchar(50),
foreign key (MaDoan) references DOANKHACH(MaDoan),
MaNV varchar(50),
foreign key (MaNV) references NHANVIEN(MaNV),
MaLoaiTK varchar(50),
foreign key (MaLoaiTK) references LOAITIEPKHACH(MaLoaiTK),
NgayTK varchar(50),
DiaDiem nvarchar(50),
ChiPhi int
);


insert into LSTIEPKHACH values
('LS001', 'D001', 'NV001', 'L001', '5/4/2022', 'Ngon Bistro', 400000),
('LS002', 'D001', 'NV001', 'L002', '5/5/2022', 'Canteen FC', 100000),
('LS003', 'D002', 'NV002', 'L001', '9/3/2022', 'Milano', 300000),
('LS004', 'D003', 'NV003', 'L003', '8/5/2022', 'Hoi An', 1000000);

-- ----------------------------------------------------------------------------------
-- Cau 3:
select MaNV, HoTen, NgaySinh, HoTen, NgaySinh, DiaChi, SoDienThoai, NgayVaoCongTy from NHANVIEN
order by NHANVIEN.NgaySinh desc, MaNV asc; 

-- Cau 4:
-- Cach 1
select du.MaDA, du.TenDA, du.NgayBD, du.NgayKT from DUAN as du join DOANKHACH as do on du.MaDA = do.MaDA;
-- Cach 2
select MaDA, TenDA, NgayBD, NgayKT from DUAN where MaDA in (select MaDA from DOANKHACH);

-- Cau 5
select l.MaNV, n.HoTen, n.DiaChi, n.SoDienThoai from NHANVIEN as n join LSTIEPKHACH as l on n.MaNV = l.MaNV 
where MONTH(NgayTK) >= 1  and MONTH(NgayTK) <= 6 and YEAR(NgayTK) = 2022
group by l.MaNV,n.HoTen, n.DiaChi, n.SoDienThoai ;

-- Cau 6
select  da.MaDA, da.TenDA, da.SoLuongNV, da.DiaDiem, count(dk.MaDoan) as So_Doan_Khach from DUAN as da inner join DOANKHACH as dk on da.MaDA = da.MaDA
where NgayDen < GETDATE() group by da.MaDA, da.TenDA, da.SoLuongNV, da.DiaDiem;

-- Cau 7
select DUAN.MaDA, DUAN.TenDA, SUM(LSTIEPKHACH.ChiPhi) as Tong_Chi_Phi from DUAN left join DOANKHACH on DUAN.MaDA = DOANKHACH.MaDA left join LSTIEPKHACH on DOANKHACH.MaDoan = LSTIEPKHACH.MaDoan
where Month(DOANKHACH.NgayDen) >= 1 and Month(DOANKHACH.NgayDen) <= 3 group by DUAN.MaDA, DUAN.TenDA;

-- Cau 8
select NHANVIEN.MaNV, NHANVIEN.HoTen from NHANVIEN inner join LSTIEPKHACH on NHANVIEN.MaNV = LSTIEPKHACH.MaNV 
inner join DOANKHACH on LSTIEPKHACH.MaDoan = DOANKHACH.MaDoan group by NHANVIEN.MaNV, NHANVIEN.HoTen
having Count(MaDA) > 1 and Sum(ChiPhi) < 5000000;

-- Cau 9
select * from DUAN inner join DOANKHACH on DUAN.MaDA = DOANKHACH.MaDA 
inner join LSTIEPKHACH on DOANKHACH.MaDoan = LSTIEPKHACH.MaDoan 
inner join NHANVIEN on LSTIEPKHACH.MaNV = NHANVIEN.MaNV 
where DUAN.SoLuongNV < 10 ;

-- Cau 10
update LSTIEPKHACH
set NgayTK = DOANKHACH.NgayDen
where NgayTK < DOANKHACH.NgayDen;

-- Cau 11:


-- cau 12:
select NHANVIEN.MaNV, NHANVIEN.HoTen, Count(LSTIEPKHACH.MaDoan) as SoLuong from NHANVIEN join LSTIEPKHACH on NHANVIEN.MaNV = LSTIEPKHACH.MaNV
group by NHANVIEN.MaNV, NHANVIEN.HoTen;