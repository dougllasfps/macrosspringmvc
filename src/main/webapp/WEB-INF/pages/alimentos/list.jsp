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
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>

<head>

    <c:set var="ctx" value="${pageContext.request.contextPath}" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" type="text/css" />

    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.mask.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/utilfunctions.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/applicationfunctions.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/locales/bootstrap-datepicker.pt-BR.min.js"></script>

    <style>
        .center{text-align:center;}
    </style>

</head>
<body>

<jsp:include page="/WEB-INF/templates/nav.jsp"/>

<div class="col-md-10 col-md-offset-1">
        <form:form id="frmBusca" modelAttribute="filtro">
            <div class="well">
            <fieldset>
                <legend>Busca</legend>

                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="control-label">Descrição: </label>
                            <input id="inputDescricao" type="text" name="descricao" class="form-control" />
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="col-md-1">
                        <button id="consultarButton" type="button" class="btn btn-default" value="Consultar" >
                            Consultar
                        </button>
                    </div>

                    <div class="col-sm-1">
                    </div>

                    <div class="col-md-1">
                        <input type="button"
                               onclick="window.location.href='${ctx}/alimentos/novo'"
                               class="btn btn-warning" value="Novo" />
                    </div>
                </div>

            </fieldset>
            </div>
        </form:form>
        <div class="well">
            <div class="row">
                <div class="col-md-12" id="resultTableContent" name="resultTableContent">
                    <table id="resultTable" style="background: #ffffff;" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">Produto</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${not empty list}" >
                                    <c:forEach var="produto" items="${list}">
                                        <tr>
                                        <td class="center">${produto.descricao}</td>
                                        <td class="center">
                                            <a id="btnEditar"
                                               class="btn btn-success"
                                               onclick="window.location.href='${ctx}/alimentos/editar/${produto.id}'">Editar
                                            </a>
                                        </td>
                                        <td class="center">
                                            <a id="btnDelete"
                                               class="btn btn-danger"
                                               onclick="if(confirm('Confirma a exclusão?')){window.location.href='${ctx}/alimentos/remove/${produto.id}';}">Excluir
                                            </a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="3">
                                            Nenhum Resultado.
                                        </td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</div>

<script>
    var submitSearch = function () {
        $.ajax({
            url : '${ctx}/alimentos',
            data:{'descricao' : $('#inputDescricao').val() },
            type: 'POST',
            success : function( response ) {
                var parsedHTML = $.parseHTML(response);
                var resultTableContent = $(parsedHTML).find('#resultTableContent');
                var messagesPanel = $(parsedHTML).find('#messagesPanel');

                $('#resultTableContent').html(resultTableContent);
                $('#messagesPanel').html(messagesPanel);
            },
        });
        return false;
    };

    $('#consultarButton').on('click', function () {
        submitSearch();
    });

    $('#frmBusca').on('submit', function () {
        submitSearch();
        return false;
    });

</script>

</body>
</html>