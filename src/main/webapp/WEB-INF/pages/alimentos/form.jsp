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
    <title>Cadastro de Alimento</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/templates/nav.jsp"/>

    <div class="col-md-10 col-md-offset-1">
        <form:form action="${pageContext.request.contextPath}/alimentos/add" method="post" modelAttribute="bean">
            <fieldset>
                <legend>Cadastro</legend>

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
                        <input type="submit" value="Salvar" class="btn btn-info" />
                    </div>

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
</body>
</html>
