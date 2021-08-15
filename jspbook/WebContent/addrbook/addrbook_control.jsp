<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addrbook_error"%>
<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="gb" scope="page" class="jspbook.addrbook.AddrBean" />
<jsp:useBean id="addrbook" class="jspbook.addrbook.AddrBook" />
<jsp:setProperty name="addrbook" property="*"/>
<%
String action=request.getParameter("action");
if(action.equals("list")){
	
}else if(action.equals("insert")){
	
}else if(action.equals("edit")){
	
}else if(action.equals("update")){
	
}else if(action.equals("delete")){
	
}else{
	
}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>