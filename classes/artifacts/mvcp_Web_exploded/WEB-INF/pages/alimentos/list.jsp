<%--
  Created by IntelliJ IDEA.
  User: dougllas.sousa
  Date: 07/06/2017
  Time: 08:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Alimentos</title>
</head>
<body>
    <form:form action="/alimentos/filtrar">
        <fieldset>
            <legend>Busca</legend>
        <label>Descrição: *</label>
            <input type="text" value="${filtro.descricao}" />
            <input type="submit" value="Consultar" />
        </fieldset>
    </form:form>
</body>
</html>
