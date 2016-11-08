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
            if(i=='groupFiles'){
//               alert("data : " + data);
               if(data.length != 0){
                  $.each(data, function(i, item){
                     tableTr += '<tr>';
                     tableTr += '<td>' + (i+1) + '</td>';
                     tableTr += '<td>' + item.save_filename + '</td>';
                     tableTr += '<td>' + '<a href="/project/document/fileDownload?tmpName='+ item.save_file + '" class="btn btn-default btn-sm">download</a></td>';
                     tableTr += '</tr>';
                  });
               }else{
                  tableTr += '<tr>';
                  tableTr += '<td colspan="3">공유한 서식 문서가 존재하지 않습니다.</td>';
                  tableTr += '</tr>';
               }
            }
         });
       alert("tableTr:" + tableTr);
         $("#groupBody").append(tableTr);
      }, error: function(){
         alert('load error');
      }
   });
});