<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
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
                     <li><a href="groupmanage"> 그룹 관리 </a>
                     </li>
                     <li class="active"><a href="groupdocdownload"> 서식 문서 </a>
                     </li>
                  </ul>
               </nav>
            </div>
            
         </aside>
         <h1 id="stitle">서식 문서</h1>

            <nav>
               <div class="col-md-9">
               <table class="table table-hover text-center">
               <thead>
               <tr class="text-center">
                  <th class="text-center" style="width:130px;"> # </th>
                  <th class="text-center" style="width:400px;"> 서  식   </th>
                  <th class="text-center" style="width:130px;"> 비고 </th>
               </tr>
               </thead>
               
               <tbody id="groupBody">
               </tbody>
               
               <!-- 그룹 문서가져와서 반복문으로 뿌리기. -->
               <!-- 리더라면 수정과 삭제 가능하도록 -->
             
               </table>
              <!--  <ul class="pagination">
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
               </ul> -->
               </div>
            </nav>
         </div>
      </div>

   <jsp:include page="../footer.jsp"></jsp:include>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/javascript/animate-on-scroll.js"></script>
   <script src="${pageContext.request.contextPath}/javascript/script.js"></script>
   <script
      src="${pageContext.request.contextPath}/javascript/groupDownloadFunc.js">
   </script>
</body>

</html>