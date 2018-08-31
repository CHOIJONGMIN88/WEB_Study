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



<link rel="stylesheet" href="${pageContext.request.contextPath}/css/visit.css">

<script type="text/javascript">

function del(f){
	
	var pwd = f.pwd.value; //원래 비밀번호
	var c_pwd = f.c_pwd.value;//확인비번
	if(c_pwd==''){
		alert(c_pwd);
		alert('삭제할 게시물의 비번을 입력하세요');
		f.c_pwd.focus();
		return;
	}
	//비번확인
	if(pwd!=c_pwd){
		alert('비밀번호가틀립니다');
		return;		
	}

	
	//최종 삭제 확인
	if(confirm("정말삭제 하시겠습니까?")==false)return;
	
	//자바스크립트를 이용해서 직접호출//submit을 통해 전송할때 불필요한 id와 pwd 정보를 전송하지 않아도 가능하다.
	//location.href = 'delete111.do?idx=' + f.idx.value;
	//원하는 정보만 가지고 url에 더해서 넘겨준다.

		
	
	f.action = 'delete.do'
	//전송
	f.submit();
}	

function modify(f){
	
	var pwd = f.pwd.value; //원래 비밀번호
	var c_pwd = f.c_pwd.value;//확인비번
	if(c_pwd==''){
		alert(c_pwd);
		alert('삭제할 게시물의 비번을 입력하세요');
		f.c_pwd.focus();
		return;
	}
	//비번확인
	if(pwd!=c_pwd){
		alert('비밀번호가틀립니다');
		return;		
	}
	
	
	
	//수정폼 띄우기
	location.href='modify_form.do?idx=' + f.idx.value;
	
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
		<input type="hidden" name="pwd" value="${visit.pwd}">
	
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