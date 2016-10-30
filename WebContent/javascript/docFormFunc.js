/**
 * 
 */
function createObject(){
	
	var companyName = $('#companyName');
	var companyNo = $('#companyNo');
	var ownerName = $('#ownerName');
	var address = $('#address');
	var phoneNumber = $('#phoneNumber');
	var fax = $('#fax');
	var createList = $("input:checkbox:checked");
	var chkArr = "";
	if(createList.size()!=0){
		$.each(createList, function(i, data){
			chkArr += data.value;
			if((createList.size()-1) != i){
				chkArr += ","
			}
		});
	}else{
		alert("서식 파일의 종류 선택 요망!");
		return false;
	}
	if(companyName.val().trim().length < 1){
		alert("상호명 입력 요망!");
		companyName.focus();
		companyName.select();
		return false;
	}
	if(companyNo.val().trim().length < 1 || companyNo.val().trim().length != 10){
		alert("사업자 등록번호 확인!");
		companyNo.focus();
		companyNo.select();
		return false;
	}
	if(isNaN(companyNo.val().trim())){
		alert("사업자 등록번호는 숫자만 기입하세요!");
		companyNo.focus();
		companyNo.select();
		return false;
	}
	if(ownerName.val().trim().length < 1){
		alert("대표자 성명 입력 요망!");
		ownerName.focus();
		ownerName.select();
		return false;
	}
	if(address.val().trim().length < 1){
		alert("주소 입력 요망!");
		address.focus();
		address.select();
		return false;
	}
	if(phoneNumber.val().trim().length < 1 || isNaN(phoneNumber.val())){
		alert("전화번호 확인!");
		phoneNumber.focus();
		phoneNumber.select();
		return false;
	}
	
	var data = {
		"aNewCreate.companyName" : companyName.val(),
		"aNewCreate.companyNo" : companyNo.val(), 
		"aNewCreate.ownerName" : ownerName.val(),
		"aNewCreate.address" : address.val() ,
		"aNewCreate.phoneNumber" : phoneNumber.val(), 
		"aNewCreate.fax" : fax.val(),
		"arr" : chkArr
	}
	return data;
}
function cleanInput(){
	$('#companyName').val("");
	$('#companyNo').val("");
	$('#ownerName').val("");
	$('#address').val("");
	$('#phoneNumber').val("");
	$('#fax').val("");
}
$(function(){
	    $('#searchPage').on("click",".searchBtn",function(){
	        alert($("#searchKeyword").val());
	     });
		
		$("#createPage").on("click",".createBtn",function(){
			if(!(createObject()===false)){
				$.ajax({
					url : 'docCreate',
					data : createObject(),
					dataType : 'json',
					success : function(response){
						alert('success');
						cleanInput();
					}, error : function(){
						alert('error');
					}
				});
			}
		});
		
		
		$("#docSearch").on("click",function(){
			$("#createPage table").remove();
			$("#imagelistdiv").show();
			$("#regularFormUpload").show();
			var str = "";
			str += "<div class='col-md-9 text-center'> <table><tr>";
			str += "<td style='padding: 5px'><input type='text' id='searchKeyword' placeholder='찾으시는 서식의 이름' size='50' style='font-size:1.2em;'/></td><td><button class='searchBtn btn btn-primary btn-sm'> search </button></td>";
			str += "</tr></table><div>";
			$("#searchPage").append(str);
		});
		$("#docCreate").on("click",function(){
			$("#searchPage table").remove();
			$("#imagelistdiv").hide();
			$("#regularFormUpload").hide();
			var str = "";
			$.ajax({
				url : 'customizingDoc'
				, dataType : 'json'
				, success : function(response){
					$.each(response, function(i, data){
						if(i=='createList'){
							str += "<table class='table'>";
							$.each(data, function(i, item){
								if(i==0 || i==3){
									str += "<tr>";
								}
								str +="<td><input type='checkbox' value='"+ i +"'/><label for='inputlg'>&nbsp" + item + " &nbsp</label></td>"
								if(i==2){
									str += "</tr>";
								}
							});
							str += "</table>";
							str += "<table class='col-md-9 table' style='float:left;'>";
							str += "<tr><td style='padding-top:5px;padding-right:10px;'> <label for='inputlg'> 상호(법인명) </label> </td><td><input type='text' class='input-lg' id='companyName' size='40'/></td></tr>";
							str += "<tr><td style='padding-top:5px;padding-right:10px;'> <label for='inputlg'> 사업자 등록번호  </label> </td><td><input type='text' class='input-lg' id='companyNo' placeholder='숫자만 기입하세요' size='40'/></td>	</tr>";
							str += "<tr><td style='padding-top:5px;padding-right:10px;'> <label for='inputlg'> 대표자 성명  </label></td><td><input type='text' class='input-lg' id='ownerName' size='50'/></td> </tr>";
							str += "<tr><td style='padding-top:5px;padding-right:10px;'> <label for='inputlg'> 주소  </label></td><td><input type='text' class='input-lg' id='address' size='50'/></td> </tr>";
							str += "<tr><td style='padding-top:5px;padding-right:10px;'> <label for='inputlg'> 전화번호  </label></td><td><input type='text' class='input-lg' id='phoneNumber' placeholder='-를 포함하여 기입하세요' size='40'/></td> </tr>";
							str += "<tr><td style='padding-top:5px;padding-right:10px;'> <label for='inputlg'> 팩스  </label></td><td><input type='text' class='input-lg' id='fax' placeholder='-를 포함하여 기입하세요' size='40'/></td></tr>";
							str += "<tr><td colspan='2' class='text-right' style='padding:10px 30px;'><button class='createBtn btn btn-primary btn-lg'> Create </button></td> </tr>"
							str += "</table>";
						}
					});
				$("#createPage").append(str);
				},
				error : function(){
					alert('error');
				}
			});
		});
	});