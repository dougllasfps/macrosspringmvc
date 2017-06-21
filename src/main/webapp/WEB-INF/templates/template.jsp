<%--
  Created by IntelliJ IDEA.
  User: dougllas.sousa
  Date: 21/06/2017
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
    <title>
        <tiles:insertAttribute name="title" />
    </title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" />

    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.mask.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/utilfunctions.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/applicationfunctions.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/resources/locales/bootstrap-datepicker.pt-BR.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>

</head>
<body>
    <div class="col-md-10 col-md-offset-1">
        <jsp:include page="/WEB-INF/templates/nav.jsp"/>
        <tiles:insertAttribute name="content" />
    </div>
</body>
</html>
