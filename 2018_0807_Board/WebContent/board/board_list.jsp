<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>목록보기</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html;">
<style type="text/css">
.subject_style{
   display: inline-block;
   
}

</style>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">


function search(){
	
	var search_text = $('#search_text').val();
	var search = $('#search').val();
	
	
	
	if(search!='all' && search_text==''){
		alert('검색내용을 입력하세요');	
		return;
	}
	

	
	location.href = 'list.do?search=' + search + '&search_text=' + 
    encodeURIComponent(search_text);
	//자바스크립트는 특수문자 전송시 인코딩을 해주어야 한다.	
	
	
	
	
}


function insert_form(){
	//로그인이 하지 않는 상태
	if(${ empty user} == 'true'){
		if(confirm('글쓰기는 로그인 하신후에 가능합니다.\n로그인하시겠습니까?')==false)
		
		location.href='../member/login_form.do';	
			return;	
	}
		//로그인상태이면 글쓰기 폼을 띄운다.
		location.href='insert_form.do';

}
 
</script>
</head>

<body>

<!--로케이션 & 로그인끝-->
<!--타이틀 영역-->
<div style="width:700px; margin:auto;">

<c:if test="${empty user }">
		<input type="button" value="로그인" onclick="location.href='../member/login_form.do'">

</c:if>

<c:if test="${not empty user}">
	
	${user.name} 님 환영합니다.
		<input type="button" value="로그아웃" onclick="location.href='../member/logout.do'">
</c:if>

</div>


<table width="700" align="center">
<tr>
<td>
<table width="690" height="50" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td><img src="../img/title_04.gif"></td>
	</tr>
</table>
<!--타이틀 영역--끝-->
</td>
</tr>
<tr>
<td>
<!--LIST START-->

<table width="690" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
		<table width="690" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="50" class="td_a">번호</td>
				<td width="2" class="td_b"><img src="../img/td_bg_01.gif"></td>
				<td class="td_b" width="300">제목  </td>
				<td width="2" class="td_b"><img src="../img/td_bg_01.gif"></td>
				<td width="90" class="td_b">작성자</td>
				<td width="2" class="td_b"><img src="../img/td_bg_01.gif"></td>
				
				<td width="90" class="td_b">작성일</td>
				<td width="2" class="td_b"><img src="../img/td_bg_01.gif"></td>
				<td width="60" class="td_c">조회수</td>
			</tr>
			<c:forEach var="vo" items="${list}">
			<tr>
				<td align="center" class="td_a_1">${vo.no} [idx ${vo.idx}]</td>
				<td class="td_b_1"><img src="../img/td_bg_02.gif"></td>
				<td class="td_b_1 left">
				
				
				<!-- 들여쓰기 -->
				<c:forEach begin="1" end="${vo.depth}">
					&nbsp;&nbsp;
				</c:forEach>
		
				<!-- depth가 0이 아닐경우 답글이다.  -->
				<c:if test="${vo.depth != 0 }">
				ㄴ
				</c:if>	
				
				
				<!-- 사용 가능한 글인지 판단할때 -->
				<c:if test="${vo.use_yn eq 'y'}">
				
				
				<a href="view.do?idx=${vo.idx}&page=${(empty param.page)?1:param.page}" class="num">
					${vo.subject} (${vo.c_count})	
				
				</c:if>
			
				<!--삭제된 글인경우 -->
				<c:if test="${vo.use_yn eq 'n'}">				
				
					<font color=red> (삭제된 글입니다)</font>
				</c:if>
				
				
				
				
				
				</a>${vo.content}</td>
			
				
				<td class="td_b_1"><img src="../img/td_bg_02.gif"></td>
				<td align="center" class="td_b_1">${(vo.use_yn eq 'y')?vo.name:''}</td>
				<td class="td_b_1"><img src="../img/td_bg_02.gif"></td>
				<td align="center" class="td_b_1">${vo.regdate }</td>
				<td class="td_b_1"><img src="../img/td_bg_02.gif"></td>
				<td align="center" class="td_c_1">${vo.readhit}</td>
			</tr>
			</c:forEach>
			<c:if test="${empty list}">
			<tr>
				<td align="center" colspan="11" width="100%" height="50" style="border:1 solid #efefef">
					현재 등록된 글이 없습니다.
				</td>
			</tr>
			</c:if>
		</table>
		</td>
	</tr>
	<tr>
		<td height="8"></td>
	</tr>
	<tr>
		<td>
		<table width="690" border="0" cellpadding="0" cellspacing="0" bgcolor="#F1F5F4">
			<tr>
				<td width="7"><img src="../img/search_bg_01.gif"></td>
				<td class="f11" align="center">
				
				  <!-- 검색 메뉴  -->
                   <select id="search">
                         <option value="all">전체</option>
                         <option value="name">이름</option>
                         <option value="subject">제목</option>
                         <option value="content">내용</option>
                         <option value="name_subject_content">이름+제목+내용</option>
                   </select>
                   <input id="search_text">
                   <input type="button"  value="검색" onclick="search();">
				
				
				
						<!-- 페이지 메뉴 파트 -->
					${pageMenu}					
				</td>
			</tr>
			
			<tr>
				<td width="7"><img src="../img/search_bg_01.gif"></td>
				<td class="f11" align="center">
						<!-- 페이지 메뉴 파트 -->
				<!-- 검색 메뉴  -->
				<select id="search">
					
					<option value ="all">전체</option>
					<option value ="name">이름으로검색<option>
					<option value ="subject">제목으로검색<option>
					<option value ="content">내용<option>
					<option value ="name_subject_content">이름+제목+내용<option>
				 
				</select>
				<input id="search_text">
				<input type="button" value="검색" onclick="search()">

				</td>
			</tr>
			
			
			
			
			
			
		
		</table>
		</td>
	</tr>
	<tr>
		<td height="5"></td>
	</tr>
	<tr>
		<td>

		<img src="../img/btn_reg.gif" onClick="insert_form()" style="cursor:hand">

		</td>
	</tr>

</table>
<!--WRITE,MODIFY,REPLY END-->
</td>
</tr>
</table>
</body>

</html>