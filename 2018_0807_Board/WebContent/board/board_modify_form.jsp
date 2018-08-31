<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script language="JavaScript">
	function modify(f) {

		f.action = 'modify_action.do?page=${param.page}';
		f.submit();
	}
</script>
</HEAD>

<BODY>
	<table width="690" height="50" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img src="../img/title_04.gif"></td>
		</tr>
	</table>



	<form method = "post">
		<!-- idx를 숨겨서 서블릿으로 보내주기 위해 사용한다.-->
		<input type="hidden" name="idx" value="${vo.idx}"><%-- <input
			type="hidden" name="page" value="${param.page}">  트래킹 확인 ${param.page} --%>
		 

		<table width="690" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td width="120" height="25" class="td_d">제목</td>
				<td class="td_d_1"><input name="subject" value="${vo.subject}"
					type="text" class="search" style="width: 250px;"></td>
			</tr>



			<tr>
				<td width="120" height="25" class="td_d_4">이름</td>
				<td class="td_d_2"><input name="name" value="${vo.name}"
					readonly="readonly" type="text" class="search"
					style="width: 250px;"></td>

			</tr>
			<tr>
				<td width="120" height="25" class="td_d_4">날짜</td>
				<td class="td_d_2">${vo.regdate}</td>
			</tr>
			<tr>


				<td width="120" class="td_d_4">내용</td>



				<td class="td_d_3" width="570"
					style="word-wrap: break-word; word-break: break-all"><TEXTAREA
						NAME='content' rows="9" cols="65">${vo.content}</TEXTAREA></td>
		
			</tr>

		</table>

		<table width="690" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td height="5"></td>
			</tr>
			<tr>
				<td><input type="image" src="../img/btn_list.gif"
					onclick="location.href='list.do?page=${param.page}'; return false;"
					style="cursor: hand"> <!-- <img src="../img/btn_list.gif" onclick="location.href='list.do'" style="cursor:hand">
		해당 input타입 이미지는 onclick은 무조건 onsubmit을 호출하게 되있으므로 action을 정해주지 않았으면 자기자신을 계속해서
		호출한다.그러므로 onsubmit을 제한한다.
 --> <!--  글작성자만 수정/삭제 가능 --> <c:if test="${vo.id eq user.id or 1 eq 1}">
						<input type="image" src="../img/btn_modify.gif"
							onClick="modify(this.form); return false;" style="cursor: hand">


					</c:if></td>
			</tr>
		</table>
	</form>

	<p>
		<br>
</BODY>
</HTML>