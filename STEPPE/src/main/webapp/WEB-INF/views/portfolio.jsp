<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html lang="en">
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
<script src="resources/js/jquery-3.2.1.min.js"></script>
<!-- =======================================================
        Theme Name: Day
        Theme URL: https://bootstrapmade.com/day-multipurpose-html-template-for-free/
        Author: BootstrapMade
        Author URL: https://bootstrapmade.com
    ======================================================= -->
<style>
.container {
	color: black;
}
input{
color:black;
}
table {
color:black;
	text-align: center;
	vertical-align: middle;
}
#cTable{
	color: black;
}
#complete {
	width: 100%;
	height: 40px;
	background: cornflowerblue;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid white;
	color: #fff;
	font-weight: bold;
	font-size: 14px;
	outline: none;
	cursor: pointer;
}

input {
	border-radius: 5px;
}
</style>
</head>
<body>
	<!--상단 메뉴바-->
	<header id="header">
		<nav class="navbar navbar-default navbar-static-top" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="navbar-brand">
						<a href="main"><h1>steppe</h1></a>
					</div>
				</div>
				<div class="navbar-collapse collapse">
					<div class="menu">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a href="intro">steppe?</a></li>
							<li role="presentation"><a href="project">프로젝트</a></li>
							<li role="presentation"><a href="freelancer">프리랜서</a></li>
							<li role="presentation"><a href="manual">이용방법</a></li>
							<li role="presentation"><a href="pms">프로젝트 관리</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</header>

	<div class="container">
		<!--style="height:-webkit-fill-available;"-->
		<form action="addPortfolio" method="post" id="portfolio" enctype="multipart/form-data">
			<table class="table">
				<tr>
					<td><p>제목</p></td>
					<td colspan="2"><input style="width: 40%;" type="text"
						placeholder="포트폴리오 제목을 입력해주세요" name="pf_title" id="title"></td>
				</tr>
				<tr>
					<td><p>기간</p></td>
					<td colspan="2"><input style="width: 40%;" type="text"
						placeholder="포트폴리오 기간을 입력해주세요" name="pf_term" id="term"></td>
				</tr>
				<tr>
					<td><p>기여도</p></td>
					<td colspan="2"><input style="width: 40%;" type="text"
						placeholder="포트폴리오 기여도를 입력해주세요" name="pf_contribute" id="contribute"></td>
				</tr>
				<tr>
					<td><p>내용</p></td>
					<td colspan="2"><input style="width: 40%;" type="text"
						placeholder="포트폴리오 내용을 입력해주세요" name="pf_content" id="content"></td>
				</tr>
				<tr>
					<td><p>포트폴리오 첨부</p></td>
					<td><input type="file" name="pf_image[]" onchange="fileChk(this)" multiple="multiple"/>
				</tr>
				<tr rowspan="3" colspan="3">
					<td colspan="3"><input type="button" id="complete"
						value="작성완료" /></td>
				</tr>
			</table>
		</form>
		<table>
			<tr align="center" height="25">
				<td width="200"></td>
			</tr>
		</table>
		<table id="pfTable">
			<c:forEach var="portfolio" items="${mapList}">
				<tr align="center" height="25">
					<td width="200"></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<hr>
	<div class="container">
		<!--style="height:-webkit-fill-available;"-->
		<h1 style="text-align: center;"></h1>
	</div>
	<div class="row"></div>
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


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!--<script src="js/jquery.js"></script>-->
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/wow.min.js"></script>
	<script>
		wow = new WOW({}).init();
	</script>
</body>
<script>
	/* $("#complete").click(function(){
	    var term = $("#term").val();
	    var company = $("#company").val();
	    var rank= $("#rank").val();
	    console.log(term);
	    console.log(company);
	    if(term == "" || company == "" || rank == ""){
	      alert("빈항목이 존재합니다!");      
	    } 
	      
	    if(term != "" && company != "" && rank != ""){
	        $("#career").submit();
	    }
	}); */
	/* $(document).ready(function(){
		var clist=''; 	
		$.ajax({
			type : 'get',
			url : 'showMyCareer',
			data : $('#career').serialize(),
			//$('#rForm').serialize(), 폼 전체 데이터 전송
			dataType : 'json',
			success : function(data) { //댓글 리스트 json형태 반환
				console.log(data); //json 구조파악
				for(var i=0;i<data.length;i++){
					clist+='<tr height="25" align="center">'
					+'<td width="200">'+data[i].ca_term+'</td>'
					+'<td width="200">'+data[i].ca_company+'</td>'
					+'<td width="200">'+data[i].ca_rank+'</td>'
					+"<td><input type='button' value='삭제' onclick='memberDelete("+data[i].ca_num+")'/></td></tr>"
			}
			$('#cTable').html(clist);
			},
			error : function(error) {
				alert("error");
				console.log(error);
			}
		}); */

	   $("#complete").click(function() {
				var pflist='';
		$.ajax({
			type : 'get',
			url : 'addPortfolio',
			data : $('#portfolio').serialize(),
			//$('#rForm').serialize(), 폼 전체 데이터 전송
			dataType : 'json',
			success : function(data) { //댓글 리스트 json형태 반환
				console.log(data); //json 구조파악
				for(var i=0;i<data.length;i++){
					pflist+='<tr height="25" align="center">'
					+'<td width="200">'+data[i].pf_term+'</td>'
					+'<td width="200">'+data[i].pf_content+'</td></tr>'
			}
			$('#pfTable').html(pflist);
			},
			error : function(error) {
				alert("error");
				console.log(error);
			}
		});
	});

	/*function memberDelete(num){
		var number = num;
		var clist='';
		$.ajax({
			type : 'get',
			url : 'deleteCareerInfo',
			data : {num:num},
			//$('#rForm').serialize(), 폼 전체 데이터 전송
			dataType : 'json',
			success : function(data) { //댓글 리스트 json형태 반환
				console.log(data); //json 구조파악
				for(var i=0;i<data.length;i++){
					clist+='<tr height="25" align="center">'
					+'<td width="200">'+data[i].ca_term+'</td>'
					+'<td width="200">'+data[i].ca_company+'</td>'
					+'<td width="200">'+data[i].ca_rank+'</td>'
					+"<td><input type='button' value='삭제' onclick='memberDelete("+data[i].ca_num+")'/></td></tr>"
			}
			$('#cTable').html(clist);
			},
			error : function(error) {
				console.log(error);
			} 
	});
		location.reload();
	} */
	

	/* function(){
		
	} */
	/*function complete(){
	    var term = $("#term").val();
	    var company = $("#company").val();
	    var rank= $("#rank").val();
	    console.log(term);
	    console.log(company);
	    if(term == "" || company == "" || rank == ""){
	      alert("빈항목이 존재합니다!");      
	    } 
	      
	    if(term != "" && company != "" && rank != ""){
	        $("#career").submit();
	    }    
	}*/
</script>
</html>