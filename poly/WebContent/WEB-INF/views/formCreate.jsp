<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<h3>
		<a href="all">Danh sách</a>
	</h3>
	<hr />
	<h3>Create</h3>
	<form:form action="create" method="post" modelAttribute="khambenh">
		<table>
			<tr>
				<td>Mã khám bệnh</td>
				<td><form:input path="makb" /></td>
			</tr>
			<tr>
				<td>Tên bệnh nhân</td>
				<td><form:select path="benhNhan.mabn">
						<form:options items="${benhNhans}" itemValue="mabn"
							itemLabel="tenbn"></form:options>
					</form:select></td>
			</tr>
			
			<tr>
				<td>Yêu cầu khám</td>
				<td><form:input path="yeucaukham" /></td>
			</tr>
			<tr>
				<td>Kết luận</td>
				<td><form:input path="ketluan" /></td>
			</tr>
			<tr>
				<td>Ngày khám</td>
				<td><form:input path="ngaykham" /></td>
			</tr>
			
			<tr>
				<td>Tên bác sĩ</td>
				<td><form:select path="bacSi.mabs">
						<form:options items="${bacSis}" itemValue="mabs"
							itemLabel="tenbs"></form:options>
					</form:select></td>
			</tr>
		</table>
		<button>Save</button>
	</form:form>
</body>
</html>