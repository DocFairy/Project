<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
	

	<title>DocFairy-통합 문서 관리 시스템</title>
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
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

   <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
   <script src="${pageContext.request.contextPath}/javascript/script.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		
		$(this).on('click', '.add',function(){
			$("#table").append(
				'<tr><td><input type="text" id="date" readonly="readonly" value="<s:property value='date'/>" ></td>'
			   +'<td><input type="text" name="content" id="content"></td>'
			   +'<td><input type="text" name="input"  id="in"></td>'
			   +'<td><input type="text" name="out" id="out"></td>'
			   +'<td><select name="note">'
			   +'<option value="의류비">의류비</option>'
			   +'<option value="식비">식비</option>'
			   +'<option value="건강/문화">건강/문화</option>'
				+'<option value="경조사/회비">경조사/회비</option>'
				+'<option value="저축/보험">저축/보험</option>'
				+'<option value="주거/통신">주거/통신</option>'
			   +'<option value="기타">기타</option>'
			   +'</select></td>'
			   +'<td><input type="button" id="add" class="add btn btn-info" value="  +  "></td>'
			   +'<td class="delt"><input type="button" class="del btn btn-info" value="  -  "></td>'
			);
		});
	
		$("#table").on('click','.del',function(){
			$(this).parent().parent().remove();
		});
		
		
		
		
		
	});
	
	function check(){
		var date = getElementById('date').value();
		var content = getElementById('content').value();
		var input = getElementById('input').value();
		var out = getElemetById('output').value();
		var note = getElementById('note').value();
		
		if(date == ""){alert('날짜 입력하세요'); return false;} 
		if(content == ""){alert('내용 입력하세요'); return false;}
		if(input == ""){alert('수입을 입력하세요'); return false;}
		if(out == ""){alert('지출을 입력하세요'); return false;}
		
	}
</script>
<style type="text/css">
th{
	border : 1px solid black;
	text-align: center;
	magin-right : 5px;
	padding : 5px;
	width : 10px;
	height : 40px;
	background-color : violet;
	color : "red";
	
}
h1{
	padding : 5px;
	magin-right : 20px;
	color:#fff ;
}
.table{
	border : 1px solid black;
	margin-right : 5px;
	padding : 5px;
	width : 50px;
	text-align: center;
	text-align: center;
}
input[type=text]{
	height : 40px;
	width : 160px;
	text-align: center;
}
</style>
</head>
<body>
	
<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<aside class="col-md-3 sidebar">
				<div class="block">
					<h3><span>가계부 메뉴</span></h3>
					<nav>
						<nav>
						<ul class="nav">
							<li class="active"><a href="calendar">달력</a>
							</li>
							<li><a href="accountmanage">가계부 관리</a>
							</li>
						</ul>
					</nav>
					</nav>
				
			
			</aside>
	<div class="centerMain">
			
			<h1>가계부 달력</h1><br><br>
	</div>

	<div class="col-md-9">
	
	<s:form action="account/saveAccount" method="post">
	
	<table border="1"  id="table">
		<tr>
			<th>날짜</th><th>내용</th><th>수입</th>
			<th>지출</th><th>비고</th><th>추가</th><th>삭제</th>
		<tr>
		<tr>
			<td><input type="text" name="date" id="date" readonly="readonly" value="<s:property value='date'/>" ></td>
			<td><input type="text" name="content" id="content"></td>
			<td><input type="text" name="input" id="in"></td>
			<td><input type="text" name="out" id="out"></td>
			<td><select name="note">
					<option value="의류비">의류비</option>
					<option value="식비">식비</option>
					<option value="건강/문화">건강/문화</option>
					<option value="경조사/회비">경조사/회비</option>
					<option value="저축/보험">저축/보험</option>
					<option value="주거/통신">주거/통신</option>
					<option value="기타">기타</option>
				</select></td>
			<td><input type="button" id="add" class="add btn btn-info" value="  +  "></td>
			<td><input type="button" id="del" class="del btn btn-info" value="  -  "></td>
	</table>
	<label><s:submit class="btn btn-danger" value="저장" onclick="check()" /></label>
	<label><s:reset class="btn btn-primary" value="취소"/></label>
	</s:form>

				
	</div>		
	
	
	
	</div>	
	
	</div>	
	<jsp:include page="../footer.jsp"></jsp:include>



</body>
</html>