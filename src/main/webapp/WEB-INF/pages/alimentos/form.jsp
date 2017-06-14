<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dougllas.sousa
  Date: 07/06/2017
  Time: 08:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/alimentos/add" method="post" modelAttribute="bean">
        <fieldset>
            <legend>Cadastro</legend>
            <label>Descrição: *</label>
            <form:input type="text" path="descricao" />
            <input type="submit" value="Salvar" />
        </fieldset>
    </form:form>
</body>
</html>
