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
		$("#table").hide(300).show(300);
		
		$(this).on('click', '.add',function(){
			$("#table").append(
				'<tr><td><input type="text" id="date" readonly="readonly" value="<s:property value='date'/>" ></td>'
			   +'<td><input type="text" name="content" id="content"></td>'
			   +'<td><input type="text" name="input"  id="in"></td>'
			   +'<td><input type="text" name="out" id="out"></td>'
			   +'<td><select name="note" class="form-control">'
			   +'<option value="의류비">의류비</option>'
			   +'<option value="식비">식비</option>'
			   +'<option value="건강/문화">건강/문화</option>'
				+'<option value="경조사/회비">경조사/회비</option>'
				+'<option value="저축/보험">저축/보험</option>'
				+'<option value="주거/통신">주거/통신</option>'
			   +'<option value="기타">기타</option>'
			   +'</select></td>'
			   +'<td><input type="button" id="add" class="add btn btn-primary btn-sm" value="   +   "></td>'
			   +'<td class="delt"><input type="button" class="del btn btn-primary btn-sm" value="   -   "></td>'
			);
		});
	
		$("#table").on('click','.del',function(){
			$(this).parent().parent().remove();
		});
		
		function check(){
			var date=$("#date").val();
			if(date==""||date.length==0){
				alert('날짜 입력');
				xhr.abort;
			}
		}
		
		
		$("#form-data").on('submit', function(){
		var date = $("#date").val();
		var content = $("#content").val();
		var input = $("#in").val();
		var out = $("#out").val();
		var note = $("#note").val();
		
		if(content == "" || content.length==0){alert('내용 입력하세요'); return false;}
		if(input == "" || input.length==0){alert('수입을 입력하세요'); return false;}
		if(isNaN(input)){alert('수입에는 숫자만 입력하세요'); return false;}
		if(out == "" || out.length==0){alert('지출을 입력하세요'); return false;}
		if(isNaN(out)){alert('지출에는 숫자만 입력하세요'); return false;}
		});
		
		
		
		
		
	});
</script>
<style type="text/css">
th{
	magin-right : 5px;
	padding : 5px;
	width : auto;
	height : 30px;
	background-color : #af2045;
	color : white;
	text-align :center;
}
h1{
	padding : 5px;
	magin-right : 20px;
	color:#fff ;
}
.table{
	margin-right : 5px;
	padding : 5px;
	width : 50px;
	height : 30px;
	text-align: center;
}
input[type=text]{
	height : 30px;
	width : 160px;
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
	
	<s:form id="form-data" action="account/saveAccount" method="post">
	
	<table   id="table" class="text-center">
		<tr>
			<th class="text-center">날짜</th><th class="text-center">내용</th><th class="text-center">수입</th>
			<th class="text-center">지출</th><th class="text-center">비고</th><th>추가</th><th>삭제</th>
		<tr>
		<tr>
			<td><input type="text" name="date" id="date" readonly="readonly" value="<s:property value='date'/>" ></td>
			<td><input type="text" name="content" id="content"></td>
			<td><input type="text" name="input" id="in"></td>
			<td><input type="text" name="out" id="out"></td>
			<td><select name="note" class="form-control">
					<option value="의류비">의류비</option>
					<option value="식비">식비</option>
					<option value="건강/문화">건강/문화</option>
					<option value="경조사/회비">경조사/회비</option>
					<option value="저축/보험">저축/보험</option>
					<option value="주거/통신">주거/통신</option>
					<option value="기타">기타</option>
				</select></td>
			<td><input type="button" id="add" class="add btn btn-primary btn-sm" value="   +   "></td>
			<td><input type="button" id="del" class="del btn btn-primary btn-sm" value="   -   "></td>
	</table>
	<label><s:submit class="btn btn-danger" value="저장" /></label>
	<label><s:reset class="btn btn-primary" value="취소"/></label>
	</s:form>

				
	</div>		
	
	
	
	</div>	
	
	</div>	
	<jsp:include page="../footer.jsp"></jsp:include>



</body>
</html>