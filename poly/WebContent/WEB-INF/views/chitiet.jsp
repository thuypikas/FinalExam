<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi tiết</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
</head>
<body>
<h3><a href="all">Danh sách</a></h3>
<hr/>
<h3>Thông tin chi tiết</h3>
<table border="1">
		<tr>
			<td>Mã khám bệnh</td>
			<td>${khambenh.makb }</td>
		</tr>
		<tr>
			<td>Tên bệnh nhân</td>
			<td>${khambenh.benhNhan.tenbn }</td>
		</tr>
		<tr>
			<td>Yêu cầu khám</td>
			<td>${khambenh.yeucaukham }</td>
		</tr>
		<tr>
			<td>Kết luận</td>
			<td>${khambenh.ketluan }</td>
		</tr>
		<tr>
			<td>Ngày khám</td>
			<td>${khambenh.ngaykham }</td>
		</tr>
	</table>
</body>
</html>