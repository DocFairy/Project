<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
	th{
	color:white;
	background-color:#af2045;
	}
	#stitle {
	font-size:30px; 
	letter-spacing:-0.1em; 
	color: #af2045; 
	text-align:left; 
	padding-bottom:20px;
  
}
</style>
	<meta charset="utf-8">
	<title>pop</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#table").on("click",".invite",function(){
		var fri=$(this).parent().prev().text();
		$.ajax({
			url:"msg",
			data:{"fri":fri,"id":"${session.members.id}","groupname":"${membergroup.groupname}"}
		});
		alert('초대 메시지를 보냈습니다!');
	});
	$("#search").on("click",function(){
		var id=$("#id").val();
		$.ajax({
			url:"searchid",
			data:{"id":id},
			success:function(response){
				$.each(response.idlist,function(index,item){
					$('#table').append('<tr><td>'+response.idlist[index]+'</td><td>'+"<input type='button' class='invite' value='초대'/>"+'</td></tr>');
				});
			}
		});
	}); 
});

</script>
</head>
<body>


<h2 id="stitle">아이디 검색</h2><br>
현재 그룹이 없는 회원만 검색대상이 됩니다.
<input type="text" id="id">
<input type="button" id="search" value="검색">
		<table id="table">
			<tr>
				<th width="100">아이디</th>
				<th width="40">초대</th>
			</tr>
		</table>

	


</body>

</html>