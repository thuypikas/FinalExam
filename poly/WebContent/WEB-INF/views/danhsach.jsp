<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
</head>
<body>

	<h3><a href="all">Danh sách</a></h3>
	<hr />
	<form action="search" method="get">
		<input type="text" placeholder="Nhập tên bệnh nhân" name="tenbn" />
		<button>Tìm kiếm</button>
	</form>
	<br />
	<button>
		<a href="create">Thêm khám bệnh</a>
	</button>
	<table border="1">
		<tr>
			<th>Mã khám bệnh</th>
			<th>Tên bệnh nhân</th>
			<th>Yêu cầu khám</th>
			<th>Kết luận</th>
			<th>Ngày khám</th>
			<th colspan="2"></th>
		</tr>
		<c:forEach items="${khamBenhs }" var="e">
			<tr>
				<td>${e.makb }</td>
				<td><a href="detail?makb=${e.makb }">${e.benhNhan.tenbn }</td>
				<td>${e.yeucaukham }</td>
				<td>${e.ketluan }</td>
				<td>${e.ngaykham }</td>
				<td><a href="update?makb=${e.makb }">Cập nhật</a></td>
				<td><a href="delete?makb=${e.makb }">Xóa</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>