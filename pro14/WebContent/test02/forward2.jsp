<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="sec01.ex01.*"  pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");

  // MemberBean 객체 생성 후 회원 정보를 속성에 설정합니다.
  MemberBean member = new MemberBean("lee", "1234", "이순신", "lee@test.com");
  
  // 속성 이름 member로 memberBean 객체를 바인딩 합니다.
  request.setAttribute("member", member);
%>    

<html>
<head>
<meta  charset=”UTF-8">
<title>forward2</title>
</head>
<body>
   <jsp:forward page="member2.jsp" />
</html>
