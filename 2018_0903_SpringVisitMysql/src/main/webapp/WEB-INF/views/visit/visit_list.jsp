<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions" %>  
  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- 현재 Context Root : ${ pageContext.request.contextPath } <br> --%>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/visit.css">

<!-- Ajax기능을 사용하기위한 js연결  -->
<script type="text/javascript"  src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>


<script type="text/javascript">
var g_idx;
function del(f){
	
	var c_pwd = f.c_pwd.value;//확인비번
	    g_idx = f.idx.value;//삭제할 게시물 번호
	if(c_pwd==''){
		alert('삭제할 게시물의 비번을 입력하세요');
		f.c_pwd.focus();
		return ;
	}
	    
	//비번체크하기 위한 서버객체 호출
	var url = "check_pwd.do"; // VisitCheckPwdAction
	var param = 'idx=' + g_idx + '&c_pwd=' + c_pwd;
	
	//Ajax 이용해서 서버호출: httpRequest.js 에 사용자 함수
	sendRequest(url,param,resultDeleteFn,'GET');
	
}

function resultDeleteFn(){
	
	//정상 수신 완료
	if(xhr.readyState==4 && xhr.status==200){
		
		var data = xhr.responseText;
		//alert('[' + data +']');
		
		// data='no'  or data='no\n'
		//       0123 
		// data=' no\n'  => data.indexOf('No')=>-1
		if(data.indexOf('no') != -1 ){
			alert('비밀번호가 틀립니다!!');
			return;
		}
		
		//삭제확인
		if(confirm('정말 삭제하시겠습니까?')==false)
			return;
		
		//삭제수행
		location.href='delete.do?idx=' + g_idx;
		
	}
	
}

function modify(f){

	var c_pwd = f.c_pwd.value;//확인비번
	g_idx = f.idx.value;//수정할 게시물 번호
	
	if(c_pwd==''){
		alert('삭제할 게시물의 비번을 입력하세요');
		f.c_pwd.focus();
		return ;
	}
	
	//비번체크하기 위한 서버객체 호출
	var url = "check_pwd.do"; // VisitCheckPwdAction
	var param = 'idx=' + g_idx + '&c_pwd=' + c_pwd;
	
	//Ajax 이용해서 서버호출: httpRequest.js 에 사용자 함수
	sendRequest(url,param,resultModifyFn,'GET');
	
}

function resultModifyFn(){
	
	//정상 수신 완료
	if(xhr.readyState==4 && xhr.status==200){
		
		var data = xhr.responseText;
		
		if(data.indexOf('no') != -1 ){
			alert('비밀번호가 틀립니다!!');
			return;
		}
		
		
		//수정폼 띄우기
		location.href='modify_form.do?idx=' + g_idx;
		
		
	}
	
}


function find(){
	
	var search      = document.getElementById("search").value;
	var search_text = document.getElementById("search_text").value;
	
	//전체검색이 아닌데 검색내용이 비어있으면...
	if(search!='all' && search_text==''){
		alert('검색내용을 입력하세요!!');
		return;
	}
	
	//검색요청
	//               list.do?search=name&search_text=홍길동
	location.href = 'list.do?search=' + search + '&search_text=' + 
			                                      encodeURIComponent(search_text);
	
}

//초기화 이벤트(Html의 컨트롤이 모두 배치가 완료가 되면...)
window.onload = function(){
	
	//검색 search컨트롤 정보 얻기
	var search = document.getElementById("search");
	/* <select id="search">
	    0:<option value="all">전체</option>
	    1:<option value="name">이름</option>
	    2:<option value="content">내용</option>
	    3:<option value="name_content">이름+내용</option>
    </select> */
    //방법1)
    /* if("${ param.search eq 'name'}" == 'true'){
		search[1].selected = true;
    }else if("${ param.search eq 'content'}" == 'true'){
		search[2].selected = true;
    }else if("${ param.search eq 'name_content'}" == 'true'){
		search[3].selected = true;
    } */
    
    //방법2)
    var search_array = ['','name','content','name_content'];
    for(var i=0;i<search_array.length;i++){
    	if("${ param.search }" == search_array[i]){
    		search[i].selected = true;
    	}
    }
    
	
};






</script>


</head>
<body>

<div id="main_box">
    <h1>::::방명록 리스트::::</h1>
    <div style="text-align: center;">
       <input type="button" value="글쓰기" onclick="location.href='insert_form.do'">
    </div>
    
    <hr>
    
    <!-- 검색메뉴 -->
    <div align="right">
        <select id="search">
            <option value="all">전체</option>
            <option value="name">이름</option>
            <option value="content">내용</option>
            <option value="name_content">이름+내용</option>
        </select>
        <input id="search_text" value="${ param.search_text }"> 
        <input type="button"  value="검색" onclick="find();">
    </div>
    
    <hr>
    
    <!-- 데이터가 없을경우 -->
    <c:if test="${ empty list }">
     	<div id="empty_style">등록된 게시물이 없습니다</div>
    </c:if>
    
    
    <!-- 방명록 내용 -->
    <c:forEach var="visit" items="${ list }">
        <form>
            <input type="hidden"  name="idx" value="${ visit.idx }">
		    <div class="box_style">
		       <div class="content_style">${ visit.content }</div>
		       <div class="name_style">작성자:${ visit.name }(${ visit.ip })</div>
		       <div class="regdate_style">
		           작성일자:${ fn:substring(visit.regdate,0,10) }
		                    /
		                    <fmt:formatDate value="${ visit.regdate2 }"  pattern="YYYY년 MM월 dd일" />
		       </div>
		       <div>
		          비밀번호(${ visit.pwd }):<input type="password" name="c_pwd">
		                   <input type="button"  value="삭제" onclick="del(this.form);">
		                   <input type="button"  value="수정" onclick="modify(this.form);">
		       </div>
		    </div>
	    </form>
	    
	    <hr>
    </c:forEach>
    

</div>


</body>
</html>