<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
  function del(idx){
	  //alert('삭제할 idx='+ idx );
	  	
	  
	  
	  $.ajax({
		  url:'comment_delete.do', //CommentDeleteAction
		  data:{'idx': idx  },
		  dataType: 'json',
		  success:function(data){
			  
			  if(data.result=='fail'){
				  alert('댓글 삭제 실패');
				  return;
			  }
			  
			  //갱신목록 가져오기
			  comment_list(1);
			  
		  }
	  });
	  
  }
</script>
<body>

<c:forEach var="vo" items="${list}">
	작성자: ${vo.name}(${vo.id})<br>
	 <input type="button"  value="x" onclick="del('${ vo.idx }');">
	<div> ${vo.content}</div> 
		
		
	
	<hr>

</c:forEach>

<!--  페이징 메뉴 작성 -->

	${pageMenu}


<!-- <a href="#" onclick="comment_list('1')">1</a>&nbsp;
<a href="#" onclick="comment_list('2')">1</a>&nbsp;
<a href="#" onclick="comment_list('3')">1</a>&nbsp; -->



</body>
</html>