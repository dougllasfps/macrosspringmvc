<%--
  Created by IntelliJ IDEA.
  User: dougllas.sousa
  Date: 05/06/2017
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    hello ${nome}

<form:form action="/mvcp/hello/nome" method="post" modelAttribute="nome">
    <form:input type="text" path="nome" />
    <input type="submit" value="Vai" />
    <form:errors path="name" />
</form:form>
</body>
</html>
