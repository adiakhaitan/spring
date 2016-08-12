<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

	

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>

	<%@ include file="/header.jsp"%>

</tr>
<tr hieght="900px"> 
<!-- <input type="button" name="employee list" id= "employee list" value="employee list"/>
<input type="button" name="home" id= "home" value="home"/> -->
	
		<%@ include file="/Employee.jsp"%>
	


</tr>



<tr>

	<%@ include file="/footer.jsp"%>

</tr>

</table>
		 
</body>
</html>