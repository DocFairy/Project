<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
	<script type="text/javascript">
		function goHancok(){
			var id = $("#id").val();
			var password = $("#password").val();
			var passwordre = $("#passwordre").val();
			var name = $("#name").val();
			var phone = $("#phone").val();
			var address = $("#address").val();
			if(password != passwordre){
				alert('비밀번호와 비밀번호 확인이 일치하지 않아요');
				return false;
			}	
			if(id == ""){alert('아이디 입력하세요');return false;}
			if(password == ""){alert('패스워드를 입력하세요'); return false;}
			if(name == ""){alert('이름을 입력하세요');return false;}
			if(phone == ""){alert('전화번호 입력하세요');return false;}
			if(address == ""){alert('주소를 입력하세요');return false;}
			
		}
	
	</script>
	
	
</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<h1 id="stitle2">회원정보 수정</h1>
	<div class="login_area">
				<s:form action="members/update" onsubmit="return goHancok()" method="post"  theme="simple">
					<ul><!-- 회원가입 -->
						<li class="grp_area"><s:label for="">회원구분</s:label><s:radio name="members.division"
						list="#{1:'관리자',2:'일반회원'}" value="#{2}"></s:radio> </li>
						<li><s:textfield placeholder="아이디" class="join_write" name="members.id"  readonly="true" id="id" />
						<li><s:password placeholder="비밀번호" class="login_write" name="members.password"  id="password"/></li>
						<li><s:password placeholder="비밀번호 확인" class="login_write" id="passwordre"/></li>
						<li><s:textfield placeholder="이름" class="login_write" name="members.name" readonly="true" id="name"/></li>
						<li><s:textfield placeholder="전화번호" class="login_write" name="members.phonenum" id="phone"/></li>
						<li><s:textfield placeholder="주소" class="login_write" name="members.address" id="address"/></li>
						<li><s:submit class="btn_join" value="수정" /></li>
					</ul>											
				</s:form>
			</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
</body>

</html>