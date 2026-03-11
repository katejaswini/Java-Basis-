<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="green">
<div style="text-align:center;">
<%! int a=100; int b=200; int c ; %>//declaration tag
<% c = a + b; %>// scriplet tag
<h1>THE SUM OF A+B : <%=c %></h1>//expression tag
</div>
</body>
</html>