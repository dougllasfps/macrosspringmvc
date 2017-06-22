<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

<div class="col-md-10 col-md-offset-1">
    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/tmb"><i class="fa address-book"></i> Macros</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <a class="navbar-brand " href="${pageContext.request.contextPath}/alimentos"><i class="icon-group"></i> Alimentos</a>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/refeicoes">Refeições</a>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Busca">
                    </div>
                    <button type="submit" class="btn btn-default"> Enviar</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Configurações</a></li>
                </ul>
            </div>

        </div>
    </nav>

    <div class="row">
        <div class="col-lg-12">
            <div id="messagesPanel">
                <c:if test="${not empty msg}">
                    <div id="messages" class="alert alert-${msg.severity.level} fade in">
                        ${msg.message}
                    </div>
                </c:if>
            </div>
        </div>
    </div>

</div>

