<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"   isELIgnored="false"  %>
<%
  request.setCharacterEncoding("UTF-8");
%>    

<html>
<head>
<meta  charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border=1  align="center"   >
   <tr align="center"  bgcolor="#99ccff">
      <td width="20%"><b>아이디</b></td>
      <td width="20%"><b>비밀번호</b></td>
      <td width="20%" ><b>이름</b></td>
      <td width="20%"><b>이메일</b></td>
</tr>
  <tr align="center">
  
      <% // 표현 언어에서 속성 이름으로 ArrayList에 접근한 후 인덱스를 이용해 첫 번째 회원 정보를 출력합니다. %>
      <td>${membersList[0].id}</td>
      <td>${membersList[0].pwd}</td>
      <td>${membersList[0].name}</td>
      <td>${membersList[0].email}</td>
  </tr>
  <tr align="center">
  
      <% // 표현 언어에서 속성 이름으로 ArrayList에 접근한 후 인덱스를 이용해 두 번째 회원 정보를 출력합니다. %>
      <td>${membersList[1].id}</td>
      <td>${membersList[1].pwd}</td>
      <td>${membersList[1].name}</td>
      <td>${membersList[1].email}</td>
</tr>
</table>
</body>
</html>
