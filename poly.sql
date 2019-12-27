create database poly
go

use poly
go

create table benhnhan(
	mabn varchar(10),
	tenbn varchar(50),
	ngaysinh date,
	diachi varchar(255),
	dienthoai varchar(15),
	gioitinh bit,
	constraint pk_benhnhan primary key (mabn)
)
go

create table bacsi(
	mabs varchar(10),
	tenbs varchar(50),
	tendangnhap varchar(20),
	matkhau varchar(10),
	chuyenmon varchar(50),
	dienthoai varchar(15),
	constraint pk_bacsi primary key(mabs)
)
go

create table dichvu(
	madv int,
	tendv varchar(50),
	dongia float,
	constraint pk_dichvu primary key (madv)
)
go

create table khambenh(
	makb int,
	mabn varchar(10),
	yeucaukham varchar(500),
	ngaykham date,
	ketluan varchar(500),
	mabs varchar(10),
	constraint pk_khambenh primary key(makb),
	constraint fk_khambenh_benhnhan foreign key(mabn) references benhnhan(mabn),
	constraint fk_khambenh_bacsi foreign key(mabs) references bacsi(mabs)
)
go

create table thuphi(
	matp int,
	makb int,
	madv int,
	soluong int,
	constraint pk_thuphi primary key(matp),
	constraint fk_thuphi_khambenh foreign key(makb) references khambenh(makb),
	constraint fk_thuphi_dichvu foreign key(madv) references dichvu(madv)
)
go