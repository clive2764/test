<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<style>
			.container{
				color: black;
			}
			#submitC,button{
				width:85px;
				background: #0f1c34;
				box-sizing: border-box;
				border-radius: 5px;
				border: 1px solid white;
				color: #fff;
				font-weight: bold;
				font-size: 14px;
				outline: none;
				cursor: pointer;
				text-align: center;
			}
			a{
				color:#fff;
			}
			#testNum{
				border:1px solid white;
			}
		</style>
</head>
<body>
	<jsp:include page="header.jsp" />
    <div class="about" style="height: -webkit-fill-available;">
    <div class="container">
		<form  action="updateFst" method="post">
			<select name = "t_name">
				<option value="java">JAVA</option>
				<option value="html">HTML</option>
				<option value="jsp">JSP</option>
				<option value="c">C</option>
				<option value="android">Android</option>
			</select>
			<br/><br/>
			<table class="table table-striped">		
				<tr>
					<td width="100"><input type="text" style="width: 25px;" readonly="readonly" name="t_num" id="testNum" value="${test.t_num}"/><span>번 문제</span></td>
					<td><input type="text" name="t_content" value="${test.t_content}"/></td>
				</tr>
				<tr>
					<td width="100">1번</td>
					<td><input type="text" name="t_no1" value="${test.t_no1}"/></td>
				</tr>
				<tr>
					<td width="100">2번</td>
					<td><input type="text" name="t_no2" value="${test.t_no2}"/></td>
				</tr>
				<tr>
					<td width="100">3번</td>
					<td><input type="text" name="t_no3" value="${test.t_no3}"/></td>
				</tr>
				<tr>
					<td width="100">4번</td>
					<td><input type="text" name="t_no4" value="${test.t_no4}"/></td>
				</tr>
				<tr>
					<td width="100">정답번호</td>
					<td>
						<select name = "t_answer">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</td>
				</tr>
			</table>
			<br/>
			<input type = "submit" value="수정 확인" id="submitC">
		</form>
			<button><a href="deleteFst?t_num=${test.t_num}">삭제</a></button>
		</div>
	</div>
<div class="row"></div>
	<div class="sub-footer">
		<div class="container">
			<div class="social-icon">
				<div class="col-md-4">
						
				</div>
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
                        <a href="https://bootstrapmade.com/">BootstrapMade</a>
                        <br/>
                        <a href="#">공지사항</a>&nbsp;&nbsp;&nbsp;
                        <a href="#">faq</a>&nbsp;&nbsp;&nbsp;
                        <a href="#">이용약관</a>
                    </div>
				</div>
			</div>						
		</div>				
	</div>
</body>
	<script src="resources/js/jquery-3.2.1.min.js"></script>		
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/wow.min.js"></script>
	<script>wow = new WOW({}).init();</script>
</html>