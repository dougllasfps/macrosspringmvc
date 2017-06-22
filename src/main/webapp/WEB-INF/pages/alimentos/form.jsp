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
    <title>Cadastro de Alimentos</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.mask.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/utilfunctions.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/applicationfunctions.js"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/templates/nav.jsp"/>

    <script>
        jQuery(function () {
            maskQuantidade('.inputQuantidade');
            fcCalculaCalorias();

            $('#formulario').validate({
                errorClass: 'invalid',
                rules:{
                    descricao: {   required:true },
                    unidadeMedida: {   required : true  },
                    quantidade: {  required:true },
                    proteina: { required:true   },
                    carbos: { required:true },
                    gordura: { required:true }
                },
                messages:{},
                highlight: function(element, errorClass) {
                    $(element).fadeOut(function() {
                        $(element).fadeIn();
                    });
                }
            });
        });

    </script>

    <div class="col-md-10 col-md-offset-1">
        <div class="well">
            <form:form id="formulario" action="${pageContext.request.contextPath}/alimentos/add" method="post" modelAttribute="bean">

            <fieldset>
                <legend>Cadastro</legend>

                <div class="row">
                    <div class="col-sm-1">
                        <form:hidden path="id" />
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5">
                        <div class="form-group">
                            <label class="control-label">Descrição: *</label>
                            <form:input type="text" path="descricao" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <label class="control-label">Unidade de Medida: *</label>
                            <form:select path="unidadeMedida" items="${unidadesMedida}" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-group">
                            <label class="control-label">Quantidade: *</label>
                            <form:input path="quantidade" cssClass="form-control inputQuantidade" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group">
                            <label class="control-label">Proteínas: *</label>
                            <form:input id="inputProteinas" type="text" path="proteina" cssClass="form-control" onblur="fcCalculaCalorias();" />
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-group">
                            <label class="control-label">Carboidratos: *</label>
                            <form:input id="inputCarboidratos" type="text" path="carbos" cssClass="form-control" onblur="fcCalculaCalorias();"/>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-group">
                            <label class="control-label">Gorduras: *</label>
                            <form:input id="inputGorduras" path="gordura" cssClass="form-control" onblur="fcCalculaCalorias();"/>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-group">
                            <label class="control-label">Calorias/Qtd: *</label>
                            <form:input id="inputCalorias" path="calorias" cssClass="form-control" disabled="true"/>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-sm-1">
                        <input type="submit" value="Salvar" class="btn btn-info" />
                    </div>

                    <div class="col-sm-1">  </div>

                    <div class="col-sm-1">
                        <input type="button"
                               value="Voltar"
                               onclick="window.location.href='${pageContext.request.contextPath}/alimentos'"
                               class="btn btn-default" />
                    </div>
                </div>

            </fieldset>
        </form:form>
        </div>
        <script>
            var fcCalculaCalorias = function () {
                var proteinas = document.getElementById('inputProteinas').value;
                var carbos    = document.getElementById('inputCarboidratos').value;
                var gorduras  = document.getElementById('inputGorduras').value;
                var calorias = calculaCalorias(proteinas, carbos, gorduras);
                document.getElementById('inputCalorias').value = calorias;
            }
        </script>

    </div>
</body>
</html>
