<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel='stylesheet' href='/resources/styles/adminPage.css' />
</head>
<body>
	<div class="root">
		<div class="background-Area">
			<div class="header">관리자 권한 설정</div>
			<div class="content01">
				<div class="content01-header">관리자 목록</div>
				<form action="/admin/deleteAdmin">
					<button class="adminRemove">제거</button>
					<hr class="line01">
					<div class="adminList">
						<div class="secondAdmin">
							상위 관리자

							<c:forEach var="subAd" items="${subAdmin}">
								<li>
									<input type="checkBox" name="adminChoice"
										value="${subAd.getId() }">
									<label>
										<c:out value="${subAd.getName() }" />
										<c:out value="${subAd.getLotation() }" />
									</label>
								</li>
							</c:forEach>

						</div>
						<div>
							일반 관리자
							<c:forEach var="lowAd" items="${lowAdmin}">
								<li>
									<input type="checkBox" name="adminChoice"
										value="${lowAd.getId() }">
									<label>
										<c:out value="${lowAd.getName() }" />
										<c:out value="${lowAd.getLotation() }" />
									</label>
								</li>
							</c:forEach>
						</div>
					</div>
				</form>
			</div>
			<div class="content02">
				<div class="content02-header">검색페이지</div>
				<div class="searchImage">
					<img src="/resources/images/templet_admin/search.png">
				</div>
				<form action="">
					<div class="search">
						<input type="text" name="search" value="">
						<button type="submit">검색</button>
					</div>
				</form>
				<hr class="line02">
				<div class="results">
					<div class="adminAdd">추가</div>
					<table class="searchResults">
						<colgroup>
							<col style="width: 20%">
							<col style="width: 20%">
							<col style="width: 20%">
							<col style="width: 40%">
						</colgroup>
						<thead>
							<tr>
								<th>등급</th>
								<th>지역</th>
								<th>이름</th>
								<th>아이디</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>일반 관리자</td>
								<td>서울특별시 강남구</td>
								<td>홍길동</td>
								<td>abc1234@gmail.com</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
</body>
</html>