<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 검색창</title>
</head>
<body>
 <form action="${pageContext.request.contextPath}/mem3.do">
 <!-- 검색할 값을 입력합니다. -->
   입력 : <input  type="text" name="value" />
   <!-- 셀렉트 박스의 검색 조건을 선택합니다. -->
   <select name="action">
     <option value="listMembers" >전체</option>
     <option value="selectMemberById" >아이디</option>
     <option  value="selectMemberByPwd">비밀번호</option>
   </select> <br>
   <input type="submit" value="검색"  />
</form>   
</body>
</html>
