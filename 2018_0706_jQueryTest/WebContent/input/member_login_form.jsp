<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
<link rel = "stylesheet" href="../css/join_form.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript"> 

function pop(){
    new daum.Postcode({
        oncomplete: function(data) {
            // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ��Դϴ�.
            // ������ �����Ͽ� �پ��� Ȱ����� Ȯ���� ������.
            //alert("�����ȣ:" + data.zonecode + "\n�����ּ�:" +data.roadAddress);
            document.getElementById("m_zip_code").value = data.zonecode;
            document.getElementById("m_addr").value = data.roadAddress;
        }
    }).open();
}




</script>


</head>

<!--��� �̹��� ����-->
<body background="images/back_join_form.png">


  <div class="center">
     
     <label class="welcom_font">WELCOME B.B JOIN~������</label>			
    
    </div>	
	
	
	
	
	<form>

		<!-- input:�Է�â css , input_s �Է�â ũ��  -->

<input class="input input_s" placeholder="���̵�"> 
<input  id="id_bnt" class="button button_id" type="button" value="�ߺ�Ȯ��"><br>

<input class="input input_s" placeholder="�̸�"><br>




<!-- ID�ߺ�üũ -->
<input class="input input_s" placeholder="�г���">	
<input  id="id_bnt" class="button button_id" type="button" value="�ߺ�Ȯ��"><br>

<input class="input input_s" type="password" placeholder="��й�ȣ"><br>
<input class="input input_s" type="password" placeholder="��й�ȣ Ȯ��"><br>
<input class="input input_m" placeholder="E-MAIL"><br>	
<input class="input input_s" placeholder="����ó"><br>

<!-- �ּҰ˻� ��ư  -->

<input id="m_zip_code" class="input input_s" type="text" placeholder="�����ȣ"> 	 	
<input type="button"  class="button button_id" value="�˻�" onclick="pop();"><br>
<input id="m_addr" class="input input_m" type="text" placeholder="�ּ�">   <br>
	



<input class="input input_s" type="text" placeholder="�����ʻ���"> <br>
<input class="input input_s" type="text" placeholder="���弱��">  <br>		
	
	
	</form>



</body>
</html>