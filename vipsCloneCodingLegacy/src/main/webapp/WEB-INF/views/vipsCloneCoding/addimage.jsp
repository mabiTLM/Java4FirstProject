<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 추가 - VIPS</title>
<link rel='stylesheet' href='/resources/styles/commonEx.css' />
<link rel='stylesheet' href='/resources/styles/becard.css' />
</head>
<body>
	<div id="root">
		<div class="background-area">
			<div class="wrapall">
				<!-- 이 사이에 내용을 적으면 추가 됩니다. -->
				<div class="header"><jsp:include
						page="../vipsCloneCoding/template/templateHeaderFirst.jsp"></jsp:include>
				</div>
				<div id="container" class="clfix">
					<div id="lnb">
						<h3>
							<img src="/resources/images/benefit/beCard/ADMINTab.png"
								alt="BENEFIT">
						</h3>
						<ul style="min-height: 1000px;">
							<li class="active"><a href="imageadmin"><img
									src="/resources/images/benefit/beCard/image_check_on.png"></a></li>
							<li class="active"><a href="imageGroups"><img
									src="/resources/images/benefit/beCard/card_admin.png"></a></li>
						</ul>
					</div>
					<div id="content-wrap" class="clfix">
						<div class="path">
							<a href="#" class="home">관리자</a><a href="#">ADMIN</a><strong>이미지
								추가</strong>
						</div>
						<div class="visual-sub benefit-visual">
							<h4 class="DB-info-title">이미지 데이터 조회/삭제</h4>

							<h5 class="DB-info-text">데이터베이스의 이미지를 관리합니다.</h5>

						</div>
						<div id="content">
							<ul class="discount-tab clfix" style="height: 1300px">
								<li><a href="imageadmin"><h5>
											<img src="/resources/images/benefit/beCard/addimg.png">
										</h5></a></li>
								<li><a href="addimage"><h5>
											<img src="/resources/images/benefit/beCard/addimg_on.png"
												alt="10~30% 할인">
										</h5> </a>
									<div class="contents-box">

										<form method="POST" action="/addimage"
											enctype="multipart/form-data">
											<div>
												<label for="image">Image:</label> <input type="file"
													id="image" name="image" accept="image/*" required>
											</div>
											<div>
												<label for="image_name">Image Name:</label> <input
													type="text" id="image_name" name="image_name" required>
											</div>
											<div>
												<label for="description1">Description 1:</label> <input
													type="text" id="description1" name="description1">
											</div>
											<div>
												<label for="description2">Description 2:</label> <input
													type="text" id="description2" name="description2">
											</div>
											<div>
												<label for="description3">Description 3:</label> <input
													type="text" id="description3" name="description3">
											</div>
											<div>
												<label for="description4">Description 4:</label> <input
													type="text" id="description4" name="description4">
											</div>
											<div>
												<label for="description5">Description 5:</label> <input
													type="text" id="description5" name="description5">
											</div>
											<div>
												<label for="description6">Description 6:</label> <input
													type="text" id="description6" name="description6">
											</div>
											<div>
												<button type="submit">Upload Image</button>
											</div>
										</form>
									</div>
							</ul>
						</div>
					</div>
				</div>

				<div class="footer"><jsp:include
						page="../vipsCloneCoding/template/templateFooterFirst.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
</html>