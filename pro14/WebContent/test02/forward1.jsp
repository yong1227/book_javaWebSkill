<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");

  // request 내장 객체에 바인딩합니다.
  request.setAttribute("id","hong");
  request.setAttribute("pwd", "1234");
  
  // session 내장 객체에 바인딩합니다.
  session.setAttribute("name", "홍길동");
  
  // application 내장 객체에 바인딩합니다.
  application.setAttribute("email", "hong@test.com");
%>    

<html>
<head>
<meta  charset=”UTF-8">
<title>forward1</title>
</head>
<body>
   <% //member1.jsp로 포워딩합니다. %>
   <jsp:forward page="member1.jsp" />
</html>
