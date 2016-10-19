<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	<script src="javascript/pace.min.js"></script>
	<script type="text/javascript">
		function useID(){
			opener.document.getElementById('id').value = "${id}";
			window.close();
		}
	</script>

</head>

<body>

<div class="popwrap">

<h2>ID중복확인</h2>
	<div >
		<s:if test="duplicated == false">
	
		[<span>${id }</span>] 아이디는 사용가능합니다.
		
		<p class="list_btn">
		<s:a class="btn btn-primary" onclick="useID();">적용</s:a>
		</p>
		</s:if>
	</div>
	
	
	<div >
		
		<s:if test="duplicated == true">
		[<span>${id }</span>] 아이디는 이미 사용중입니다.
		</s:if>
		
		
		<s:form action="/members/goIdCheck" method="post">
		<p class="list_btn">
		<s:textfield class="wr_idcheck" name="id" id="id" /> <s:submit class="btn btn-danger" value="중복확인"/>
		</p>
		</s:form>
	</div>
</div>



</body>

</html>