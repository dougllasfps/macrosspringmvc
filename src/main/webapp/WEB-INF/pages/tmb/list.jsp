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
    <title>Taxa M. Basal</title>
</head>
<body>
    <jsp:include page="/WEB-INF/templates/nav.jsp"/>

    <script>
        jQuery(function () {

            maskDate('.campoData');
            maskInteger('.campoInteiro');
            maskQuantidade('.campoDouble');
            createDatePicker('.campoData');

            $('#formulario').validate({
                errorClass: 'invalid',
                rules:{
                    data: {
                        required:true
                    },
                    idade: {
                        required : true,
                        min:10
                    },
                    peso: {
                        required:true
                    },
                    altura: {
                        required:true,
                        min:100
                    }
                },
                messages:{
                    idade:{
                        min : 'Idade deve ser maior que 10'
                    },
                    altura : {
                        min: 'Altura deve ser maior que 100 cm.'
                    }

                },
                highlight: function(element, errorClass) {
                    $(element).fadeOut(function() {
                        $(element).fadeIn();
                    });
                }
            });
        });
    </script>

    <div class="col-md-10 col-md-offset-1">
        <fieldset>
            <legend>Macros</legend>

            <form:form id="formulario" action="${pageContext.request.contextPath}/tmb/add" modelAttribute="tmb">

                <form:hidden path="id" />

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="inputData" class="control-label">Data</label>
                            <form:input id="inputData" path="data" cssClass="form-control campoData" />
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="inputIdade" class="control-label">Idade</label>
                            <form:input id="inputIdade" path="idade" cssClass="form-control campoInteiro" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="inputPeso" class="control-label">Peso</label>
                            <form:input id="inputPeso" path="peso" cssClass="form-control campoDouble" />
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="inputAltura" class="control-label">Altura</label>
                            <form:input id="inputAltura" path="altura" cssClass="form-control campoInteiro"  />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-1">
                        <input type="submit" class="btn btn-default" value="Salvar"  />
                    </div>
                </div>

            </form:form>

            <c:if test="${not empty list}">
            <div class="well">
                <div class="row">
                    <div class="col-lg-12">
                        <table class="table table-bordered table-hover whitebg">
                            <thead>
                                <tr>
                                    <th class="center">Data</th>
                                    <th class="center">Idade</th>
                                    <th class="center">Peso</th>
                                    <th class="center">Altura</th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${list}" >
                                    <tr>
                                        <td   class="center"><fmt:formatDate value="${item.data.time}" pattern="dd/MM/yyyy" /> </td>
                                        <td   class="center">${item.idade}</td>
                                        <td   class="center"><fmt:formatNumber value="${item.peso}" minFractionDigits="3" maxFractionDigits="3"/> </td>
                                        <td   class="center">${item.altura}</td>
                                        <td s class="center">
                                            <button type="button" class="btn btn-primary"
                                                    data-toggle="modal" data-target="#resultadoModal" >
                                                Calcular
                                            </button>
                                        </td>
                                        <td  class="center">
                                            <button class="btn btn-success"
                                                    onclick="window.location.href='${pageContext.request.contextPath}/tmb/editar/${item.id}'" >
                                                Editar
                                            </button>
                                        </td>
                                        <td  class="center">
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
            </div>
            </c:if>

        </fieldset>
    </div>

    <div class="modal fade" id="resultadoModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Resultado</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body">
                    <p>modal</p>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" >Salvar</button>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
