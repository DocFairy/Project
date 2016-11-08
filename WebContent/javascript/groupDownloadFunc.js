/**
 * 
 */
$(function(){
   $.ajax({
      url: 'groupDocs',
      success: function(response){
//         alert('list load');
         var tableTr = "";
         $("#groupBody").children().remove();
         $.each(response,function(i,data){
           var leader = "";
           if(i=='leader'){
              leader = data;
           }
            if(i=='groupFiles'){
//               alert("data : " + data);
//               $("#groupBody tr").remove();
               if(data.length != 0){
                  $.each(data, function(i, item){
                     tableTr += '<tr>';
                     tableTr += '<td>' + (i+1) + '</td>';
                     tableTr += '<td>' + item.save_filename + '</td>';
                     tableTr += '<td id="btnColumn">' + '<a href="/project/document/fileDownload?tmpName='+ item.save_file 
                     tableTr += '" class="btn btn-default btn-sm">download</a>&nbsp;';
                     tableTr += '<s:if test="#session.members.memberno == '+ leader +'">';
                     tableTr += '<a href="/project/document/delLeaderFile?delFileName='+ item.save_file +'" class="btn btn-default btn-sm">delete</a>'
                     tableTr += '</s:if>';
                     tableTr += '</td>';
                     tableTr += '</tr>';
                  });
               }else{
                  tableTr += '<tr>';
                  tableTr += '<td colspan="3">공유한 서식 문서가 존재하지 않습니다.</td>';
                  tableTr += '</tr>';
               }
            }
         });
         $("#groupBody").append(tableTr);
      }, error: function(){
         alert('load error');
      }
   });
});