<%--
  Created by IntelliJ IDEA.
  User: dougllas.sousa
  Date: 20/06/2017
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Macros</title>
</head>
<body>
    <jsp:include page="/WEB-INF/templates/nav.jsp"/>

    <script>
        jQuery(function () {
            maskDate('.campoData');
            maskInteger('.campoInteiro');
            maskQuantidade('.campoDouble');
            createDatePicker('.campoData');
            createDialog('.dialog');
        });
    </script>

    <style>
        .dialog{
            display: none;
        }
    </style>

    <div class="col-md-10 col-md-offset-1" id="test">
        <fieldset>
            <legend>Macros</legend>

            <form:form action="${pageContext.request.contextPath}/tmb/add" modelAttribute="tmb">

                <form:hidden path="id" />

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label">Data</label>
                            <form:input id="inputData" path="data" cssClass="form-control campoData" />
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label">Idade</label>
                            <form:input id="inputIdade" path="idade" cssClass="form-control campoInteiro" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label">Peso</label>
                            <form:input id="inputPeso" path="peso" cssClass="form-control campoDouble" />
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="control-label">Altura</label>
                            <form:input id="inputAltura" path="altura" cssClass="form-control campoInteiro" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-1">
                        <input type="submit" class="btn btn-default" value="Salvar" />
                    </div>
                </div>

            </form:form>

            <c:if test="${not empty list}">
                <div class="row">
                    <div class="col-lg-12">
                        <table class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Data</th>
                                    <th>Idade</th>
                                    <th>Peso</th>
                                    <th>Altura</th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${list}" >
                                    <tr>
                                        <td  style="text-align: center;"><fmt:formatDate value="${item.data.time}" pattern="dd/MM/yyyy" /> </td>
                                        <td  style="text-align: center;">${item.idade}</td>
                                        <td  style="text-align: center;"><fmt:formatNumber value="${item.peso}" minFractionDigits="3" maxFractionDigits="3"/> </td>
                                        <td  style="text-align: center;">${item.altura}</td>
                                        <td style="text-align: center;">
                                            <button class="btn btn-default"
                                                    onclick="$('#macrosDialog').dialog('open');" >
                                                Calcular
                                            </button>
                                        </td>
                                        <td style="text-align: center;">
                                            <button class="btn btn-success"
                                                    onclick="window.location.href='${pageContext.request.contextPath}/tmb/editar/${item.id}'" >
                                                Editar
                                            </button>
                                        </td>
                                        <td style="text-align: center;">
                                            <button class="btn btn-danger"
                                                    onclick="window.location.href='${pageContext.request.contextPath}/tmb/remove/${item.id}'" >
                                                Remover
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>

        </fieldset>
    </div>

    <div id="macrosDialog" class="dialog">
        Dialog parça
    </div>

</body>
</html>
