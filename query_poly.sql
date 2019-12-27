use poly
go

-- Liet ke tat ca dich vu hien tai
select * from dichvu

-- Liet ke thong tin bn o Ninh Thuan
select mabn,tenbn,ngaysinh,dienthoai from benhnhan 
where gioitinh = 1 and diachi like '%ninh thuan%'

-- Thong tin khambenh cua cac benh nhan
select khambenh.mabn,tenbn,ngaykham,yeucaukham,ketluan,bacsi.tenbs from benhnhan join khambenh on benhnhan.mabn = khambenh.mabn
join bacsi on bacsi.mabs = khambenh.mabs

-- bac si co nhieu luot kham nhat
select top 1 count(khambenh.mabs) as ketqua, bacsi.tenbs
from khambenh join bacsi on khambenh.mabs = bacsi.mabs
group by bacsi.tenbs

-- sp thembenhnhan
IF OBJECT_ID('sp_thembenhnhan') IS NOT NULL
BEGIN 
DROP PROC sp_thembenhnhan 
END
GO
CREATE PROCEDURE sp_thembenhnhan
	@mabn varchar(10),
	@tenbn varchar(50),
	@ngaysinh date,
	@diachi varchar(255),
	@dienthoai varchar(15),
	@gioitinh bit
AS
BEGIN
INSERT INTO benhnhan
    VALUES (
		@mabn ,
		@tenbn ,
		@ngaysinh,
		@diachi,
		@dienthoai,
		@gioitinh)
END
go

-- sua
IF OBJECT_ID('sp_suabenhnhan') IS NOT NULL
BEGIN 
DROP PROC sp_suabenhnhan
END 
GO
CREATE PROC sp_suabenhnhan
    @mabn varchar(10),
	@tenbn varchar(50),
	@ngaysinh date,
	@diachi varchar(255),
	@dienthoai varchar(15),
	@gioitinh bit
AS 
BEGIN 
 
UPDATE benhnhan
SET	tenbn = @tenbn, 
	ngaysinh = @ngaysinh,
	diachi = @diachi,
	dienthoai = @dienthoai
WHERE mabn = @mabn
END
GO
-- sp xoa
IF OBJECT_ID('sp_xoabenhnhan') IS NOT NULL
BEGIN 
DROP PROC sp_xoabenhnhan
END 
GO
CREATE PROC sp_xoabenhnhan 
    @mabn varchar(10)
AS 
BEGIN 
DELETE
FROM  benhnhan
WHERE mabn = @mabn
 
END
GO