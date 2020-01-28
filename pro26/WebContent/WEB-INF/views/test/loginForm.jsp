<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인창</title>
</head>

<body>
<!-- 로그인 클릭 시 /test/login.do로 요청합니다. -->
<form   method="post"  action="${contextPath}/test/login5.do">
    <!-- <input  type="hidden"  name="email" value="hong@test.com" /> -->
	<table width="400">
		<tr>
			<!-- @ReqeustParam에서 설정한 userID와 같습니다. -->
			<td>아이디 <input type="text" name="userID" size="10"></td>
		</tr>
		<tr>
			<!-- @RequestParam에서 설정한 userName과 같습니다. -->
			<td>이름 <input type="text" name="userName" size="10"></td>
		</tr>
	    <tr>
			<td>
			  <input type="submit" value="로그인">
			  <input type="reset" value="다시입력">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
