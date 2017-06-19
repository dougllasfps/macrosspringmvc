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
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/templates/nav.jsp"/>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />

    <div class="col-md-10 col-md-offset-1">
        <form:form modelAttribute="filtro" id="frmBusca">
            <fieldset>
                <legend>Busca</legend>

                <div class="row">
                    <div class="col-sm-5">
                        <div class="form-group">
                            <label class="control-label">Descrição: *</label>
                            <form:input type="text" path="descricao" cssClass="form-control" />
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="col-sm-1">
                        <input type="submit" class="btn btn-default" value="Consultar" />
                    </div>

                    <div class="col-sm-1">
                        <input type="button"
                               onclick="window.location.href='${ctx}/alimentos/novo'"
                               class="btn btn-warning" value="Novo" />
                    </div>
                </div>

            </fieldset>
        </form:form>

        <c:if test="${not empty list}">
            <div class="row">
                <div class="col-md-6">
                    <table id="resultTable" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>Produto</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="produto" items="${list}">
                            <tr>
                                <td>${produto.descricao}</td>
                                <td><a class="btn btn-success" onclick="window.location.href='${ctx}/alimentos/editar/${produto.id}'">Editar</a> </td>
                                <td><a id="btnDelete" class="btn btn-danger" onclick="window.location.href='${ctx}/alimentos/remove/${produto.id}'" >Excluir</a> </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>
    </div>

    <script>
        var ajaxSubmit = function (url, type, render) {
            $.ajax({
                url : url,
                type: type,
                dataType:"html",
                success : function(data) {
                    var element = $('<z></z>');
                    if(render){
                        var dom = element.append(data);
                        var component = dom.find(render);
                        $('#result').html(component);
                    }else{
                        $('#result').html(data);
                    }
                },
            });
        }

        $(document).ready( function () {
            $('#frmBusca').submit(
                function () {
                    ajaxSubmit('${ctx}/alimentos', 'POST', '#resultTable')
                }
            );
        });

    </script>

</body>
</html>
