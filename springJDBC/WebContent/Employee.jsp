    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Insert title here</title>

<link rel="stylesheet"
	href="http://dojotoolkit.org/reference-guide/1.9/_static/js/dijit/themes/claro/claro.css"/>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojox/grid/resources/claroGrid.css"/>
<script>
	dojoConfig = {
		async : true,
		parseOnLoad : true
	}
</script>
<script
	src='http://ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojo/dojo.js'>
</script>  

<script>



	require([ "dojo/parser", "dojo/_base/xhr", "dojo/ready","dijit/Dialog","dojox/grid/DataGrid","dojo/data/ItemFileReadStore" ], function(parser,
			ajax, ready) {
		//require([ "dojo/ready"], function( ready){
		ready(function() {

			//OnLoad load the grid
				dojo.xhrPost({
				url : "${pageContext.request.contextPath}/employee/viewEmpDetail",
				handleAs : "json",
				content : {
					firstParam : ""
					 
				},
				load : function(response, ioArgs) {
				 
					alert(response)
					var newData = {	identifier: "empId",	items: response	};
						
					var dataStore = new dojo.data.ItemFileReadStore({data: newData, id:"dataStoreId"});

					
					var grid = dijit.byId("gridId");
					grid.setStore(dataStore);
					  
				},error : function(response, ioArgs) {
					alert("An error occurred while invoking the service.");
				}
			});//GRID
	
		});
	});
		


		 
</script>

</head>
<body class="claro">


	<table  data-dojo-type="dojox.grid.DataGrid"	data-dojo-props="rowSelector:'20px'" id="gridId"    style="width: 800px; height: 200px;">
	    <thead>
	        <tr>
	            <th width="300px" field="f_name"></th>
	            <th width="150px" field="l_name"></th>
	            <th width="100px" field="kin_id"></th> 
	            <%-- <th field="f_name"> 
	            <spring:message code="label.f_name"/></th>
	            <th field="l_name">
                <spring:message code="label.l_name"/></th>
                <th width="100px" field="kin_id">
                 <spring:message code="label.kin_id"/></th> --%>
	        </tr>
	        
	    </thead>
    
	</table>
</body>
</html>