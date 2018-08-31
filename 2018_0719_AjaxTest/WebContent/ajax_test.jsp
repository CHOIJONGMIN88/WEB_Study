<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

#disp{
	width:300px;
	height:300px;
	background-color:black;
	color:white;
}

</style>

<!-- 외부에서 작성된 javascript함수 기능을 이용하려면 -->
<script type="text/javascript" src="js/test.js"></script>
<script type="text/javascript" src="js/httpRequest.js"></script>

<script type="text/javascript">
/*연습예제
console.log(hi());
console.log(msg);
console.log(add(3,4));
*/

function gugudan(){
	var reg_gugudan = /^[2-9]{1}$/;	//2~9사이의 값 1자리
	var dan_ctrl=document.getElementById("dan");
	var dan = document.getElementById("dan").value;
	if(reg_gugudan.test(dan)==false){
		
		alert('2~9사이의 정수만 입력하세요');
		dan_ctrl.value='';
		dan_ctrl.focus();
		return;
	}

	//요청서버정보 
	var url='gugudan.do';
	var param ='dan=' + dan; //gugudan.do?dan=2
			
	//Ajax 통신으로 요청
	sendRequest(url,param,resultFn,'GET');


	
	//요청한 결과를 처리하는 callback 함수

	function resultFn(){
		console.log('xhr.status='+xhr.status);
		console.log('xhr.readyState='+xhr.readyState);
		
		//정상수신된 경우 
		if(xhr.status==200 && xhr.readyState==4){
			
			var data = xhr.responseText;//응답내용 수신
			
			//disp
			document.getElementById("disp").innerHTML = data;	
		}	
	}
}
</script>
</head>
<body>
	
	단:<input id="dan">
	  <input type="button" value="계산" onclick="gugudan();">
	  <hr>
	  <div id="disp"> </div>


</body>
</html>