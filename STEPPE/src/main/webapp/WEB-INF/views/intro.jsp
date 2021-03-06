<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<title>steppe 샘플페이지</title>
		<!-- Bootstrap -->
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="resources/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/css/animate.css">
		<link href="resources/css/animate.min.css" rel="stylesheet">
		<link href="resources/css/style.css" rel="stylesheet" />
	</head>
	<body>
		<jsp:include page="header.jsp" />
		
		<!--메인페이지 영역-->
		
			<div class="about">
				
				<div class="container">
					<div class="col-md-4">
						<img src="resources/img/safety.png" style="width: 250px; height: 250px;"/>
					</div>
					<div class="col-md-8">
						 
						<h1>FREEMOA는 안전합니다.</h1>
						<p>
							Steppe은 프로젝트 관리 및 증빙 툴'PMS'를 무료로 이용하실 수 있습니다.
							<br/>
							PMS를 통해 작업 내역을 증빙하고, 개발사와 실시간으로 소통하세요.
						</p>
					</div>	
				</div>
				<hr/>
				
				<div class="container">
					
					<div class="col-md-8">
						 
						<h1>Steppe은 안전합니다.</h1>
						<p>
							프리랜서가 실제로 수행했던 프로젝트 내역과 해당 클라이언트의 솔직한 평가를
							확인하실 수 있습니다. 
							<br/>
							Steppe은 정보를 객관적으로 파악할 수 있도록 노력하고 있습니다.
						</p>
					</div>
					<div class="col-md-4">
						<img src="resources/img/icon.png" style="width: 250px; height: 250px;"/>
					</div>
				</div>
				<hr/>
				<div class="container">
					<div class="col-md-4">
						<img src="resources/img/speed.png" style="width: 250px; height: 250px;"/>
					</div>
					<div class="col-md-8">
						<h1>FREEMOA는 쉽고 빠릅니다.</h1>
						<p>
							PC, 탭, 모바일 어떠한 디바이스에서도 간편하게 프로젝트를 등록
							하실 수 있습니다.
							<br/>등록된 프로젝트는 20,000프리랜서에게 공유되어 1일 이내에
							5명 이상의 지원자를 모집하실 수 있으며, 사용자에게 최적화된 검토 시스템을
							통해 프로젝트 지원자의 견적과 프로필을 한눈에 비교하실 수 있습니다.
						</p>
					</div>
				
				</div>
			</div>
		
		<hr>
	
		<!--푸터 영역 시작-->
		<div class="sub-footer">
			<div class="container">
				<div class="social-icon">
					<div class="col-md-4"></div>
				</div>
	
				<div class="col-md-4 col-md-offset-4">
					<div class="copyright">
						&copy; Day Theme. All Rights Reserved.
						<div class="credits">
							<!-- 
	                            All the links in the footer should remain intact. 
	                            You can delete the links only if you purchased the pro version.
	                            Licensing information: https://bootstrapmade.com/license/
	                            Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Day
	                        -->
							<a href="https://bootstrapmade.com/">Free Bootstrap Themes</a> by
							<a href="https://bootstrapmade.com/">BootstrapMade</a> <br /> <a
								href="#">공지사항</a>&nbsp;&nbsp;&nbsp; <a href="#">faq</a>&nbsp;&nbsp;&nbsp;
							<a href="#">이용약관</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--푸터 영역 끝-->
	
		<script src="resources/js/jquery-3.2.1.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/wow.min.js"></script>
		<script>wow = new WOW({}).init();</script>
	
	</body>
</html>