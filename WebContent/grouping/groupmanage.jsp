<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
		<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/swiper.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	<style>
	#add{
	width:600px;
	margin-left:600px;
	}
	.gg{
	margin-right:300px;
	}
	#pp{
	margin-left:530px;
	}
	</style>
	<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery-3.1.0.min.js"></script>
	<script>
	
	$(function(){
		if("${fri}"!=""){
			alert("${fri}");
		}
		$("#create").on("click",function(){
			$("#add").append('<br><form action="creategroup" method="post" onsubmit="formcheck();">그룹명<input type="text" name="membergroup.groupname" id="groupname"><input type="hidden" name="membergroup.leaderno" value="${session.members.memberno}"}><input type="submit" value="그룹 생성">')
			$("#create").off();
		});	
		$("#dest").on("click",function(){
			var c=confirm('정말로 이 그룹을 해체하시겠습니까?');
			if(c){
			location.href='dest';
			}
		});
		$("#leave").on("click",function(){
			var c=confirm('정말로 이 그룹에서 나가시겠습니까?');
			if(c){
				location.href='leave';
			}
		});
		$("#invite").on("click",function(){
			window.open("invite", "pop", 'resizable=no scrollbars=yes top=300 left=500 width=500 height=300');
		});
	});
	</script>
</head>

<body>
<jsp:include page="../header.jsp"/>
	<div class="container">
		<div class="row">
			<aside class="col-md-3 sidebar">
				<div class="block">
					<h3><span>그룹핑 메뉴</span></h3>
					<nav>
						<ul class="nav">
							<li class="active"><a href="groupmanage">그룹관리</a>
							</li>
							<li><a href="docmanage">서식문서관리</a>
							</li>
							<li><a href="groupdocdownload">서식문서다운</a>
							</li>
						</ul>
					</nav>
				</div>
				</aside>
			<h1 id="stitle">그룹관리</h1>
			<s:if test="#session.members.groupno==null">
			<center>나만의 그룹을 만들어보세요!<br><br>
			<input type="button" value="그룹 만들기" id="create" class="btn btn-success">
			</center>
			<div id="add"></div>
			</s:if>
			<s:else>
			
			<s:property value="groupname"/>
			<div class="gg"><h2><b>그룹명:<s:property value="membergroup.groupname"/></b></h2><br></div>
			<div id="pp">그룹 멤버 목록</div><br>
			<center>
			<table border="1"> 
			<tr>
			<th width="150">그룹 멤버 아이디</th>
			<th width="100">비고</th>
			</tr>
			<s:iterator value="mlist">
			<tr>
			<td><s:property value="id"/></td>
			<td><s:if test="membergroup.leaderno==memberno">그룹 리더</s:if></td>
			</tr>
			</s:iterator>
			</table>
			<br>
			<s:if test="membergroup.leaderno!=#session.members.memberno">
			<input id="leave" type="button" value="그룹에서 탈퇴" class="btn btn-warning">
			</s:if>
			<s:else>
			<input id="dest" type="button" value="그룹 해체" class="btn btn-danger">
			</s:else>
			<input id="invite" type="button" value="다른 멤버 초대" class="btn btn-info">	
			</center>
			</s:else>
			</div></div>
				
				
<jsp:include page="../footer.jsp"></jsp:include>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/script.js"></script>
</body>

</html>