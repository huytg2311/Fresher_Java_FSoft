create database SQLFinal

use [SQLFinal]

create table THISINH(
MaTS nvarchar(10) primary key,
TenTS nvarchar(50),
GioiTinh nvarchar(10) check(GioiTinh in ('Nam','Nu')),
DiaChi nvarchar(50),
SoDienThoai nvarchar(10),
);

create table LOAICHUNGCHI(
MaLoaiCC nvarchar(10) primary key,
TenLoaiCC nvarchar(50),
MoTa nvarchar(100),
);

create table CHUNGCHI(
MaCC nvarchar(10) primary key,
MaLoaiCC nvarchar(10),
MaTS nvarchar(10),
NgayThi date,
NgayCap date,
NgayHetHan date,
foreign key(MaLoaiCC) references LOAICHUNGCHI(MaLoaiCC),
foreign key(MaTS) references THISINH(MaTS),
);

create table LICHSUGIAHAN(
MaCC nvarchar(10),
LanGiaHan nvarchar(10) primary key,
NgayDKGiaHan date,
PhiGiaHan money,
TrangThai nvarchar(50),
foreign key(MaCC) references CHUNGCHI(MaCC),
);

create table LINHVUC(
MaLV nvarchar(10) primary key,
TenLV nvarchar(50),
);

create table HOATDONG(
MaHD nvarchar(10) primary key,
MaTS nvarchar(10),
MaLV nvarchar(10),
DiemSo nvarchar(10),
NgayThamGia date,
GhiChu nvarchar(50),
foreign key(MaTS) references THISINH(MaTS),
foreign key(MaLV) references LINHVUC(MaLV),
);

insert into THISINH values('TS001', 'Nguyen Van Hung', 'Nam','76 CMT8','0907657654')
insert into THISINH values('TS002', 'Nguyen Van Son', 'Nam','25 Ha Huy Tap','0988765432')
insert into THISINH values('TS003', 'Tran Thi Phuong', 'Nu', '17 Hai Phong', '0915976546')
insert into THISINH values('TS004', 'Le Phan Thi', 'Nu', '5 Nam Ky Khoi Nghia', '0987643342')
insert into THISINH values('TS005', 'Bui Viet Linh', 'Nam', '257 Nguyen Tri Phuong', '0963456543')
insert into THISINH values('TS006', 'Truong Van Vinh', 'Nam', '30 Phan Chu Trinh', '0987657865')
insert into THISINH values('TS007', 'Bui Viet Linh', 'Nu', '257 Nguyen Tri Phuong', '0983456543')

select * from THISINH

insert into CHUNGCHI values('CC001', 'LCC001', 'TS001', '30/03/2014', '30/04/2014', '30/04/2020')
insert into CHUNGCHI values('CC002', 'LCC002', 'TS001', '31/01/2017', '31/02/2017', '31/02/2020')
insert into CHUNGCHI values('CC003', 'LCC002', 'TS003', '30/04/2017', '30/05/2017', '30/05/2020')
insert into CHUNGCHI values('CC004', 'LCC003', 'TS004', '02/29/2017', '03/29/2017', '03/29/2020')
insert into CHUNGCHI values('CC005', 'LCC004', 'TS005', '09/06/2017', '09/07/2017', '09/07/2020')
insert into CHUNGCHI values('CC006', 'LCC003', 'TS002', '02/06/2020', '02/07/2020', '09/07/2022')
insert into CHUNGCHI values('CC007', 'LCC003', 'TS002', '02/06/2020', '02/07/2020', '09/07/2022')
insert into CHUNGCHI values('CC008', 'LCC002', 'TS001', '02/06/2020', '02/07/2020', '09/07/2022')
insert into CHUNGCHI values('CC009', 'LCC003', 'TS003', '02/06/2020', '02/07/2020', '09/07/2022')
insert into CHUNGCHI values('CC0010', 'LCC002', 'TS004', '02/06/2020', '02/07/2020', '09/07/2022')

select * from CHUNGCHI

insert into LOAICHUNGCHI values('LCC001', 'PMP', 'Quan tri du an')
insert into LOAICHUNGCHI values('LCC002', 'Alige', 'Quy trinh Alige')
insert into LOAICHUNGCHI values('LCC003', 'SCJP', 'Java')
insert into LOAICHUNGCHI values('LCC004', 'MCSD', '.NET')

select * from LOAICHUNGCHI

insert into LICHSUGIAHAN values('CC001', 1, '2017-03-30',2000000,'Da Duyet')

select * from LICHSUGIAHAN

insert into HOATDONG values('HD001','TS001','LV001',5,'2017-2-15','Workshop')

insert into LINHVUC values('LV001','Chia se kien thuc')
insert into LINHVUC values('LV002','Viet bai')
insert into LINHVUC values('LV003','Doc sach')


--cau3

select * from THISINH where SoDienThoai like '098%' and DiaChi like '%Nguyen Tri Phuong'

--cau4

select MaCC, TenLoaiCC, NgayThi,NgayCap,NgayHetHan from CHUNGCHI CC join LOAICHUNGCHI LCC on CC.MaLoaiCC=LCC.MaLoaiCC
where (NgayCap between '2020-2-01' and '2020-2-29')

--cau5

select TS.MaTS,TenTS,GioiTinh,DiaChi,SoDienThoai,MaCC,TenLoaiCC,NgayThi,NgayCap,NgayHetHan
from THISINH TS left join CHUNGCHI CC on TS.MaTS=CC.MaTS
left join LOAICHUNGCHI LCC on CC.MaLoaiCC=LCC.MaLoaiCC
order by TS.MaTS asc, NgayCap desc

--cau 6

select TS.MaTS,TenTS,GioiTinh,DiaChi,SoDienThoai from THISINH TS join CHUNGCHI CC on TS.MaTS=CC.MaTS
join LICHSUGIAHAN LS on CC.MaCC=LS.MaCC
where NgayDKGiaHan<'2020-1-1'

select * from THISINH where MaTS in
	(select MaTS from CHUNGCHI where MaCC in
		(select MaCC from LICHSUGIAHAN where NgayDKGiaHan <'2020-1-1'))

--cau7

select * from THISINH TS join CHUNGCHI CC on TS.MaTS=CC.MaTS
join LOAICHUNGCHI LCC on CC.MaLoaiCC=LCC.MaLoaiCC
join LICHSUGIAHAN LS on CC.MaCC=LS.MaCC
where LCC.MaLoaiCC='LCC001' and CC.NgayHetHan between '2020-8-1' and '2020-8-31' and;

--cau 8

select distinct top(1) with ties TenLoaiCC, MoTa from LOAICHUNGCHI LCC join CHUNGCHI CC on LCC.MaLoaiCC=CC.MaLoaiCC
where CC.NgayThi between '2020-1-1' and '2020-3-31' order by TenLoaiCC desc

select * from CHUNGCHI where NgayThi between '2020-1-1' and '2020-3-31' order by MaLoaiCC desc


---cau9

select month(NgayThi) as Thang, count(MaTS) as SoTSDo
from CHUNGCHI 

where MaLoaiCC = 'LCC002'

--cau10

select CC.MaCC,LCC.TenLoaiCC,TenTS,SoDienThoai from CHUNGCHI CC join THISINH TS on CC.MaTS=TS.MaTS
join LICHSUGIAHAN LS on CC.MaCC=LS.MaCC
join LOAICHUNGCHI LCC on CC.MaLoaiCC=LCC.MaLoaiCC
where LS.TrangThai='Chua Duyet'

--cau11

select TS.MaTS, TenTS, GioiTinh, SoDienThoai from THISINH TS  
join CHUNGCHI CC on TS.MaTS=CC.MaTS 
where (CC.NgayHetHan between '2020-5-1' and '2020-5-31') and TS.MaTS in
	(select MaTS from HOATDONG  where DiemSo<100 and NgayThamGia between NgayCap and NgayHetHan)

--cau 12

select MaCC, TenTS, NgayThi, NgayCap, NgayHetHan from CHUNGCHI CC join THISINH TS on CC.MaTS=TS.MaTS
where CC.MaLoaiCC='LCC002' and MaCC in (select MaCC from LICHSUGIAHAN where LanGiaHan>=1)

--cau13

update CHUNGCHI set NgayHetHan='2020-1-1' where MaLoaiCC='LCC004' and NgayCap between '2017-1-1' and '2017-1-31' and MaTS in
	(select MaTS from THISINH where GioiTinh='Nu')

select * from THISINH TS  
join CHUNGCHI CC on TS.MaTS=CC.MaTS where GioiTinh='Nu' and MaLoaiCC='LCC004'

--cau14

delete from LOAICHUNGCHI LCC 
where Count(MaCC) in
	(select count(MaCC) from CHUNGCHI where MaCC between '2019-1-1' and '2019-12-31') c 

