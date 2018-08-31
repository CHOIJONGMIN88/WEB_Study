<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

function search(){
	
	if($('#book_name').val()==''){
		alert('검색할 상품명을 입력하세요.');
		$('#book_name').focus();
		return;	
	}
	
	
	$.ajax({
		url:'book_serch.do',
		data:{'book_name':$("#book_name").val(),
			  'start_page':$("#start_page").val(),
			  'display_count':$("#display_count").val()
			},
		success:function(data){
			
			
			$('#disp').html(data);
			
		}
			
		
		
		
		
		
		
	});
	
	
}



</script>

</head>
<body>

=======네이버 API 사용 책 검색===========
<div >
책 이름 : <input id="book_name">
	   <input type="button" value="검색" onclick="search();">
	 
	 시작 Page:<select id = "start_page">
			<option value="1">1</option>		
			</select>
	
	조회건수 : <select id="display_count">
			<option value="10">10</option>
			</select>	  


</div>

<div id="disp">


</div>


</body>
</html>