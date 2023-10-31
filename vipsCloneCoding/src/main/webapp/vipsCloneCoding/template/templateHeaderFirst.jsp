<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>위 템플릿</title>
<script src='../../scripts/main.js'></script>
<link rel='stylesheet' href='includetemplate.css' />
</head>
<body>

	<div id="root">
		<div class="padding-box">
			<div class="background-area">
				<div class="background-inner-area">
					<div class="top-head" id="top-head">
						<div class="english-button-area">
							<div class="english-button">ENGLISH</div>
						</div>

						<div class="VIPS-logo-area">
							<div class="VIPS-logo">
								<a href="intro.jsp">
									<img src="../../images/main/VIPS.png" alt="VIPS"
										class="VIPS-logo" />
								</a>
							</div>
						</div>

						<div class="head-menu-area">
							<div class="head-menu">로그인</div>
							<div class="head-menu">회원가입</div>
							<div class="head-menu-finish">고객센터</div>
						</div>

						<div class="move-menu-area" onmouseleave="close_hidden_menu()">
							<div class="move-menu-button" onmouseover="open_hidden_menu()">VIPS
								STORY</div>

							<div class="move-menu-button" onmouseover="open_hidden_menu()">STEAK</div>

							<div class="move-menu-button" onmouseover="open_hidden_menu()">SALAD
								BAR</div>

							<div class="move-menu-button" onmouseover="open_hidden_menu()">STORE</div>

							<div class="move-menu-button" onmouseover="open_hidden_menu()">EVENT</div>

							<div class="move-menu-button" onmouseover="open_hidden_menu()">BENEFIT</div>

							<div class="move-menu-button" onmouseover="open_hidden_menu()">MEMBERSHIP</div>

							<div class="hidden-move-area" id="hidden-move-area">
								<div class="hidden-move-button">
									<div>브랜드 스토리</div>
									<br>
									<div>새소식</div>
								</div>

								<div class="hidden-move-button">Premium Steak</div>
								<div class="hidden-move-button">
									<div>Salad Bar</div>
									<br>
									<div>Beverage</div>
									<br>
									<div>픽업&딜리버리</div>
									<br>
									<div>원산지 정보</div>
									<br>
									<div>알레르기 정보</div>
									<br>
									<div>
										알레르기 정보
										<br>
										(딜리버리)
									</div>
								</div>
								<div class="hidden-move-button">
									<div>매장안내</div>
									<br>
									<div>돌잔치</div>
								</div>
								<div class="hidden-move-button">HOT 이벤트</div>
								<div class="hidden-move-button">
									<div>제휴/할인카드</div>
									<br>
									<div>상품권</div>
									<br>
									<div>기프트카드</div>
								</div>
								<div class="hidden-move-button">
									<div>CJ ONE</div>
									<br>
									<div>빕스 매니아</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</html>