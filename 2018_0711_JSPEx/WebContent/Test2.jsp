<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border='1'>

		<tr selection id="food">
			<!-- HTML주석: id=test pwd=1234 -->
			<%-- JSP주석은 소스보기에도 노출되지 않는다. --%>
			<%
				for (int i = 1; i <= 9; i++) {
			%>

			<th width='100'><%=i%>단</th>

			<%
				}
			%>
		</tr>
		
			<%
				for (int dan = 1; dan <= 9; dan++) { %>
					<tr>	
			<% 
					for (int i = 1; i <= 9; i++) {
			%>
			<%--<th width='100'> <% out.ptint(getData()); %> / <%=getDate() %>단 </th>  --%>
			<td><%=i%> X <%=dan%>= <%=i * dan%></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>

	</table>


</body>
</html>