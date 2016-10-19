<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>DocFairy</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!--[if lt IE 9]>
		<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" />
	<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/swiper.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
</head>

<body class="home-page">
	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div class="swiper-container">
			<div class="parallax-bg" style="background-image:url(${pageContext.request.contextPath}/images/a.jpg)" data-swiper-parallax="-15%"></div>
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<div class="swiper-caption">
						<div class="title" data-swiper-parallax="-100" data-animation="fadeInDownBig">통합 문서 관리</div>
						<div class="subtitle" data-swiper-parallax="-200" data-animation="fadeIn">Doc Fairy는 매일매일의 결산 기록을 입력하시면 그것을 통합 문서로 제공합니다.</div>
						<div class="text" data-swiper-parallax="-300" data-animation="fadeInUpBig">
							<a href="card.html" class="btn btn-custom btn-lg">기능 더 알아보기</a>
						</div>
					</div>
				</div>
				<div class="swiper-slide">
					<div class="swiper-caption">
						<div class="title" data-swiper-parallax="-100" data-animation="fadeInDownBig">그룹핑 제공</div>
						<div class="subtitle" data-swiper-parallax="-200" data-animation="fadeIn">사원들끼리 회사에 맞는 문서의 양식을 공유하세요!</div>
						<div class="text" data-swiper-parallax="-300" data-animation="fadeInUpBig">
							<a href="card.html" class="btn btn-custom btn-lg">기능 더 알아보기</a>
						</div>
					</div>
				</div>
				<div class="swiper-slide">
					<div class="swiper-caption">
						<div class="title" data-swiper-parallax="-100" data-animation="fadeInDownBig">가계부를 한눈에</div>
						<div class="subtitle" data-swiper-parallax="-200" data-animation="fadeIn">거래내역이 들어있는 가계부를 올리시면 표와 그래프로 한눈에 보기 쉽게 정리해드립니다.</div>
						<div class="text" data-swiper-parallax="-300" data-animation="fadeInUpBig">
							<a href="card.html" class="btn btn-custom btn-lg">기능 더 알아보기</a>
						</div>
					</div>
				</div>
			</div>
			<!-- Add Pagination -->
			<div class="swiper-pagination swiper-pagination-white"></div>
			<!-- Add Navigation -->
			<div class="swiper-button-prev swiper-button-white"></div>
			<div class="swiper-button-next swiper-button-white"></div>
		</div>
	</section>
	<div id="info">
	
	</div>
	<div id="download">
	
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/swiper.jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
	<script>
	var swiper = new Swiper('.swiper-container', {
		pagination: '.swiper-pagination',
		paginationClickable: true,
		nextButton: '.swiper-button-next',
		prevButton: '.swiper-button-prev',
		parallax: true,
		speed: 600,
		autoplay: 2500,
		onSlideChangeStart: (function (swiper) {
			var active = swiper.slides[swiper.activeIndex];
			var animated = $(active).find('*[data-animation]');
			$.each(animated, function (key, value) {
				$(value).addClass($(value).data('animation'));
				$(value).addClass('animated');
			});
		})
	});

	</script>
</body>

</html>
