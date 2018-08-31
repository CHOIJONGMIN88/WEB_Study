<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">

//변수명 = 값을 같이표현
var p ={'name':'일길동,'age':30,'tel':'010-111-2222'};

console.log('이름:' + p.name);
console.log('나이:' + p.age);
console.log('전화:' + p['tel']);
			
				    
var sido_array = ['서울','경기','인천'];
console.log('sido_array length=' + sido_array.length);
for(var i=0; i<sido_array.length;i++){
	
	console.log(sido_array[i]);
	
}

//JSON 배열


var p_array = [
		/* 0 */{'name':'일길동,'age':30,'tel':'010-111-2222'},
		/* 1 */{'name':'이길동,'age':30,'tel':'010-111-2222'},
		/* 2 */{'name':'삼길동,'age':30,'tel':'010-111-2222'},	
	];

for(var i=0; i<p_array.length; i++){
	var pp=p_array[i];
	console.log(pp.name + '/' + pp.age + '/' + pp.tel);
	
}



</script>


<body>




</body>
</html>