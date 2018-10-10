<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <h1>Welcome To Struts 2!</h1>
      <s:url action="login" var="loginLink">
         <s:param name="userModel.name">Bruce Phillips</s:param>
      </s:url>

      <p><a href="${loginLink}">Hello Bruce Phillips</a></p>
</body>
</html>