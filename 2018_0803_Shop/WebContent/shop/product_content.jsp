<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	
	
	
	
	
	function check_login(){
		
		//session에 user로 로그인한 정보 저장
		//로그인된 정보가 없으면 false
		if('${ empty user}' =='true')return false;
		
	    return true;
	}

	function add_cart(){
		if(check_login()==false){
			alert('로그인 한 후에 이용하세요');
			location.href="../member/login_form.do";
			return;
		}
	
	var m_idx='${sessionScope.user.idx}';
	var p_idx='${requestScope.vo.idx}';
	
	$.ajax({ 
		url:'cart_insert.do',
		data:{'m_idx':m_idx,'p_idx':p_idx},
		dataType:'json',
		success: function(data){
			//data={"result":"success"} or {"result":"exist"}
			
			if(data.result=='success'){
				alert('장바구니에 담았습니다');	

			}
			else if(data.result=='exist'){
				alert('이미 장바구니에 담겨 있습니다.');
				
			}
		}
	
	});
		
	
	
	}

	function show_cart(){
		
		if(check_login()==false){
			alert('로그인 한 후에 이용하세요');
			location.href="../member/login_form.do";
			return;
		}
		
		location.href="cart_list.do";
	
	}
	
	</script>

<body>

	<jsp:include page="index.jsp" />

	<table align="center" width="600" border="1"
		style="border-collapse: collapse; font-size: 8pt" bordercolor="navy"
		cellpadding="4" cellspacing="0">
		<tr>
			<td width="40%">제품분류</td>
			<td width="60%">${ vo.category }</td>
		</tr>
		<tr>
			<td width="40%">제품번호</td>
			<td width="60%">${ vo.p_num }</td>
		</tr>
		<tr>
			<td width="40%">제품명</td>
			<td width="60%">${ vo.p_name }</td>
		</tr>
		<tr>
			<td width="40%">제조사</td>
			<td width="60%">${ vo.p_company }</td>
		</tr>
		<tr>
			<td width="40%">제품가격</td>
			<td width="60%">
		<fmt:formatNumber  value="${ vo.p_price }"/>원
		(할인가:<fmt:formatNumber  value="${ vo.p_saleprice }"/>원)		
			</td>
		</tr>
		<tr>
			<td colspan="2">제품설명</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<img width="600" src="${ pageContext.request.contextPath }/images/${ vo.p_image_l }">
			
		</tr>
		<tr>
			<td colspan="2">${ vo.p_content }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="장바구니에 담기"  onclick="add_cart();"/>
				<input type="button" value="장바구니 보기"    onclick="show_cart();"/>
	
	
		</tr>
	</table>
</body>
</html>