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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Alimentos</title>
</head>
<body>
    <jsp:include page="/WEB-INF/templates/nav.jsp"/>

    <c:if test="${not empty msg}">
        ${msg}
    </c:if>

    <form:form action="${pageContext.request.contextPath}/alimentos" method="post" modelAttribute="filtro" id="frmBusca">
        <fieldset>
            <legend>Busca</legend>
            <label>Descrição: *</label>
            <form:input type="text" path="descricao" />
            <input type="submit" value="Consultar" />
        </fieldset>
    </form:form>

    <c:if test="${not empty list}">
        <table>
            <thead>
                <tr>
                    <th>Produto</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="produto" items="${list}">
                <tr>
                    <td>${produto.descricao}</td>
                    <td><a href="${pageContext.request.contextPath}/alimentos/editar/${produto.id}">Editar</a> </td>
                    <td><a href="${pageContext.request.contextPath}/alimentos/remove/${produto.id}">Excluir</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</body>
</html>
