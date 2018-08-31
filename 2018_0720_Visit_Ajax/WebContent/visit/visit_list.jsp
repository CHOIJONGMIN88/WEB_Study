<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" 	uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Ajax기능을 사용하기위한 js연결 -->
<script type="text/javascript" src=${pageContext.request.contextPath}/js/httpRequest.js>



</script>



<link rel="stylesheet" href="${pageContext.request.contextPath}/css/visit.css">

<script type="text/javascript">

var g_idx;

function del(f){
	
	var c_pwd = f.c_pwd.value;//입력비번
	    g_idx = f.idx.value; //삭제할 게시물 번호 
	
	    if(c_pwd==''){
		alert(c_pwd);
		alert('삭제할 게시물의 비번을 입력하세요');
		f.c_pwd.focus();
		return;
	}

	  //비번체크하기 위한 서버객체 호출
	  
	  var url="check_pwd.do" //VisiCheckPwdAction
	  var param='idx=' + g_idx + '&c_pwd=' + c_pwd;
	  
	  //Ajax를 이용하여 서버 호출
	  
	  sendRequest(url,param,resultDeleteFn,'GET'); 
	  
}	


function resultDeleteFn(){
	
	if(xhr.readyState==4 && xhr.status==200){
		
		var data = xhr.responseText;
		alert(data);
		// data='no' or data='no\n'
		//data='no\n' => data.indexOf('No')=>-1
		//서버에서 no나 \no 들어올지 알수 없기때문에 indexOf를 이용해서 no가 존재하는경우 정수를 리턴하고 없을경우 -1을 리턴한다.
		
		if(data.indexOf('no') != -1){
			alert('비밀번호가 틀립니다!!');
			return;
			}
		
		//삭제 확인 
		if(confirm('정말 삭제하시겠습니까?')==false)
			return;
			
		//삭제수행
		location.href ='delete.do?idx=' + g_idx;
	
	}
	
}

function modify(f){
	

	var c_pwd = f.c_pwd.value;//입력받은 비밀번호
	 g_idx = f.idx.value; //수정할 게시물 번호
	if(c_pwd==''){
		alert(c_pwd);
		alert('수정할 게시물의 비번을 입력하세요');
		f.c_pwd.focus();
		return;
	}
	// ajax를 통해 서블릿 호출 
	
	var url="check_pwd.do" //VisiCheckPwdAction
	var param='idx=' + g_idx + '&c_pwd=' + c_pwd;
	
	sendRequest(url,param,resultUpdateFn,'GET'); 

}

function resultUpdateFn(){
	
	
if(xhr.readyState==4 && xhr.status==200){
		
		var data = xhr.responseText;
		alert(data);
		// data='no' or data='no\n'
		//data='no\n' => data.indexOf('No')=>-1
		//서버에서 no나 \no 들어올지 알수 없기때문에 indexOf를 이용해서 no가 존재하는경우 정수를 리턴하고 없을경우 -1을 리턴한다.
		
		if(data.indexOf('no') != -1){
			alert('비밀번호가 틀립니다!!');
			return;
			}
		
		//삭제 확인 
		if(confirm('정말 수정하시겠습니까?')==false)
			return;
			
		//삭제수행
		location.href ='modify_form.do?idx=' + g_idx;
	
	}
	
	
	
	
	
}







</script>






</head>
<body>

<div id="main_box">

	<h1> ::::::::방명록 리스트 :::::::::</h1>
	<div style ="text-align:center;"> <input type="button"  value="글쓰기" onclick="location.href='insert_form.do'"></div>
	
	<hr>
	
	<!--  데이터가 없을 경우  -->
		<c:if test="${empty list}">
			<div id="empty_style">
			 등록된 게시물이 없습니다.
			 </div>
		</c:if>
		
	
	<hr>
	<!-- 방명록 내용 -->
	
		
	<c:forEach var="visit" items="${list}">
	<form>
		<input type="hidden" name="idx" value="${visit.idx}">
		
	
		<div class = "box_style">
			
			<div class="content_style">${visit.content}</div>
			<div class="name_style">작성자:${visit.name}${visit.ip}</div>
			
			<div class="regdate_style">
				작성일자:${fn:substring(visit.regdate,0,16)}
					${fn:substring(visit.regdate,0,16)}
						/
						<fmt:formatDate value="${visit.regdate2}" pattern='YYYY년MM월DD일'/>
				</div>
				<div>
				비밀번호:(${visit.pwd}):<input type="password" name="c_pwd">
						<input type="button" value="삭제" onclick="del(this.form);">
						<input type="button" value="수정" onclick="modify(this.form);">
				</div>

			<div> </div>
		</div>
		</form>
	</c:forEach>
	

</div>

</body>
</html>