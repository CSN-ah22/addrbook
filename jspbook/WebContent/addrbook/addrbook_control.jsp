<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addrbook_error"%>
<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="gb" scope="page" class="jspbook.addrbook.AddrBean" />
<jsp:useBean id="addrbook" class="jspbook.addrbook.AddrBook" />
<jsp:setProperty name="addrbook" property="*"/>
<%
String action=request.getParameter("action");
if(action.equals("list")){ //주소록 목록 보여주기
	
}else if(action.equals("insert")){//주소록 신규 등록
	
}else if(action.equals("edit")){//선택한 주소록 수정 페이지로 이동
	
}else if(action.equals("update")){//주소록 수정 처리
	
}else if(action.equals("delete")){//주소록 삭제 처리
	
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