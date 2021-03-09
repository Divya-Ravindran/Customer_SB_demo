<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>Apache Tomcat Examples</TITLE>
<META http-equiv=Content-Type content="text/html">
</HEAD>
<BODY>
<form action="add" method="post" modelAttribute="customer">

    Name:<input type="text" name = "name"> <br>
    Email:<input type="text" name = "email"> <br>
    Phone:<input type="text" name = "phone"> <br>
    Age:<input type="text" name = "age"> <br>
    <input type="submit"> <br>
    </form>
</BODY></HTML>