<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빕스 돌잔치 소개 | 돌잔치 - VIPS</title>
<link rel='stylesheet' href='/resources/styles/store/storeFirstBirthdayQ.css' />
</head>
<body>

	<div id="root">
		<div class="background-shadow">
			<jsp:include page="../template/templateHeaderFirst.jsp"></jsp:include>
			<div class="padding-box">

				<div class="wrap">

					<div class="side-menu-area">
						<img src="/resources/images/store/sideSTORE.gif" alt="스토어"
							class="VIPSSTORY" />

						<div class="side-button-area">
							<a href="./storeFirstBirthdayQ">
								<img src="/resources/images/store/firstBirthdayParty.gif" alt="돌잔치"
									class="VIPS-story" />
							</a>
						</div>
					</div>

					<div class="info-area">
						<div class="path">
							<span>
								<a href="/intro">
									<img src="/resources/images/story/storyBrandStory/homeIcon.png"
										alt="홈으로" />
									Home
								</a>
							</span>
							<span>
								<a href="./storeFirstBirthdayQ">
									<img src="/resources/images/story/storyBrandStory/arrowIcon.png"
										alt="화살표" />
									STORE
								</a>
							</span>
							<span>
								<img src="/resources/images/story/storyBrandStory/arrowIcon.png"
									alt="화살표" />
								<strong> 돌잔치</strong>
							</span>
						</div>

						<div class="info-area-title">

							<img src="/resources/images/store/happyBirthday1stParty.png"
								alt="생일축하" />
							<img src="/resources/images/store/firstBirthdayMessage.png" alt="생일축하"
								class="firstBirthdayMessage" />

							<img src="/resources/images/store/infoTitleBackground.png"
								class="infoTitleBackground">

						</div>
						<!-- 여기서부턴 db -->
						<div>예약관련 내용이 들어갈곳</div>
					</div>
				</div>
			</div>
			<jsp:include page="../template/templateFooterFirst.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>