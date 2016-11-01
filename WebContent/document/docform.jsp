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
<link rel="shortcut icon" href="images/favicon.ico" />
<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700&amp;subset=latin,latin-ext'
   rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}css/animate.css" />
<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}css/swiper.min.css" />
<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}css/style.css" />

<style type="text/css">
#doctable {
   border: 1px solid black;
}

#doctable th {
   background-color: orange;
   border: 1px solid black;
   width: 212px;
   height: 20px;
}

.update {
   display: inline-block;
   height: 47px;
}
</style>


<script src="${pageContext.request.contextPath}/javascript/pace.min.js"></script>
<script type="text/javascript">
	if(("#upfile").val()==""){
		alert('파일을 선택하지 않았습니다.');
		return false;
	}
</script>

</head>

<body>
   <header>
      <jsp:include page="../header.jsp"></jsp:include>
   </header>

   <div class="container">
      <div class="row">
         <aside class="col-md-3 sidebar">
            <div class="block">
               <h3>
                  <span>문서 메뉴</span>
               </h3>
               <nav>
                  <ul class="nav">
                     <li><a href="docintegrate">통합문서</a></li>
                     <li class="active"><a href="docform">문서양식</a></li>
                     <li><a href="doctransform">문서변환</a></li>
                  </ul>
               </nav>
            </div>


         </aside>
         <h1 id="stitle"> 문서 양식</h1>
         <div class="col-md-9 " style="padding: 5px;">
            <ul class="nav nav-tabs">
               <li class="active"><a data-toggle="tab" id="docSearch"
                  href="#searchPage"> 서식 검색 </a></li>
               <li><a data-toggle="tab" id="docCreate" href="#createPage">
                     서식 만들기 </a></li>
            </ul>
            <div class="tab-content" style="padding: 5px;">
               <div id="searchPage" class="tab-pane in active">
                  <div class='col-md-9 text-center'  id="searchPageSearchText">
                  	<form action="docFormSearch">
                     <table>
                        <tr>
                              <td style='padding: 5px'><input type='text'
                                 placeholder='찾으시는 서식의 이름' id='searchKeyword' name='searchKeyword' size='50'
                                 style='font-size: 1.2em;' /></td>
                              <td>
                                 <input type='submit' class='searchBtn btn btn-primary btn-sm'
                                    id='searchBtn' value="Search">
                              </td>
                        </tr>
                     </table>
                  	</form>
                  </div>
                  <span id="imagelistspan">
                  <div id="imagelistdiv" class="panel row">
                     <s:iterator var="ImageFilenameConnector" value="imageList" >
                        <div style="float: left; width: 33%; padding: 10px;" class="row">
                           <a href="fileDownload?save_fileno=<s:property value="#ImageFilenameConnector.save_fileno"/>" class="preview"> 
                              <img src="../pdf/<s:property value="#ImageFilenameConnector.imageFilename"/>"
                                 class="imagePreview" /><br>
                           </a> <a href="fileDownload?save_fileno=<s:property value="#ImageFilenameConnector.save_fileno"/>" class="preview"> <s:property
                                 value="#ImageFilenameConnector.save_filename" />
                           </a>
                           <a id="pdfshow" href="../pdf/<s:property value="imageFilenameWithoutType"/>.pdf"<s:property value="filename_pdf"/>>미리보기</a>
                           <s:if test="#session.members.id!=null">
									<s:if test="#session.members.id.equals('admin')">
									
									<a href="docFormDeleteF?save_fileno=<s:property value="#ImageFilenameConnector.save_fileno"/>">삭제</a>
								</s:if>
							</s:if>
                        </div>
                     </s:iterator>
                  </div>
               </span>
               <div >
                  <%--       <table id="doctable">
            <tr>
               <th>번호</th><th>제목</th><th>글쓴이</th>
               <s:iterator value="docFormList">
                  <tr><td><s:property value="save_fileno"/></td><td><s:a namespace="/document" action="fileshow?save_fileno=%{save_fileno}"><s:property value="save_filename"/></s:a></td><td><s:property value="memberno"/></td>
               </s:iterator>
            </tr>
            <!-- <tr><td><input type="text" id="docformSearch"/> <input type="button" id="docformSearchButton" value="검색"/></td></tr> -->
            </table> --%>
                  <br>
                  <div class="row" id="regularFormUpload">
               <s:if test="#session.members.id!=null">
                  <s:if test="#session.members.id.equals('admin')">
                     <form action="insertfile_docform" method="post"
                        enctype="multipart/form-data" onsubmit="return formcheck();">
                        <input type="hidden" name="files.filetype" value="f">
                        <!-- 문서타입: f(문서양식) -->
                        <input type="hidden" name="files.memberno"
                           value="${session.members.memberno}"> <label><input
                           id="buttons2" type="file" class="btn btn-custom" name="upload"
                           id="upfile"></label> <input type="submit"
                           class="update btn btn-custom" value="올리기">
                     </form>
                  </s:if>
               </s:if>
                  </div>
               </div>
               </div>
               
               <div id="createPage" class="tab-pane">
               </div>
            </div>

            <%-- <nav class="text-center">
               <ul class="pagination">
                  <li>
                     <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                     </a>
                  </li>
                  <li class="active"><a href="#">1</a>
                  </li>
                  <li><a href="#">2</a>
                  </li>
                  <li><a href="#">3</a>
                  </li>
                  <li class="disabled"><a href="#">4</a>
                  </li>
                  <li><a href="#">5</a>
                  </li>
                  <li>
                     <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                     </a>
                  </li>
               </ul>
            </nav> --%>
         </div>
      </div>
   <!--    <button id="mBtn" data-toggle="modal" data-target="#createModal"></button> -->
   <a  id="mBtn" data-toggle="modal" href="#createModal"> d </a>
   <div class="modal fade" id="createModal" role="dialog">
    <div class="modal-dialog">
   <div class="modal-content">
      <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
         <h4 class="modal-title">create Files</h4>
      </div>
      <div class="modal-body">
         <ul id="nameList">
         </ul>
      </div>
      <div class="modal-footer">
         <button type="button" class="btn btn-default">Save Files</button>
         <button type="button" class="btn btn-default">Share Files</button>
         <button type="button" class="btn btn-default" data-dismiss="modal">close</button>
      </div>
   </div>
            <%-- <nav class="text-center">
               <ul class="pagination">
                  <li>
                     <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                     </a>
                  </li>
                  <li class="active"><a href="#">1</a>
                  </li>
                  <li><a href="#">2</a>
                  </li>
                  <li><a href="#">3</a>
                  </li>
                  <li class="disabled"><a href="#">4</a>
                  </li>
                  <li><a href="#">5</a>
                  </li>
                  <li>
                     <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                     </a>
                  </li>
               </ul>
            </nav> --%>
         </div>
      </div>
   </div>

   <footer class="page-footer">
      <jsp:include page="../footer.jsp"></jsp:include>
   </footer>
   <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script
      src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
   <script
      src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
   <script src="${pageContext.request.contextPath}/javascript/script.js"></script>
   <script
      src="${pageContext.request.contextPath}/javascript/docFormFunc.js">
   </script>
<%--    <script type="text/javascript">
      $(function(){
         $('#searchBtn').on("click",function(){
            var searchKeyword = $("#searchKeyword").val();
            $.ajax({
               url: 'docFormSearch',
               data:{"searchKeyword":searchKeyword},
               success:function(response){
                  alert("docFormSearch success");
                  $("#imagelistdiv").children().remove();
                     alert($("#imageList").val());
                     var str = ""; 
                     str+='<s:iterator var="ImageFilenameConnector" value="imageList">';
                     str+='<div style="float: left; width: 33%; padding: 5px;" class="row">';
                     str+='<a href="fileDownload?save_fileno=<s:property value="#ImageFilenameConnector.save_fileno"/>" class="preview">';
                     str+='<img src="../pdf/<s:property value="#ImageFilenameConnector.imageFilename"/>"';
                     str+='class="imagePreview" /><br>';
                     str+='</a> <a href="fileDownload?save_fileno=<s:property value="#ImageFilenameConnector.save_fileno"/>" class="preview"> <s:property value="#ImageFilenameConnector.save_filename" />';
                     str+='</a><a id="pdfshow" href="../pdf/<s:property value="imageFilenameWithoutType"/>.pdf"<s:property value="filename_pdf"/>>미리보기</a></div></s:iterator>)';
                     alert(str);
                     $("#imagelistdiv").append(str);
                  cleanInput();
               }//function
            });//ajax
         });//functionclick
      });//function
   </script> --%>
</body>

</html>