<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 10/06/2021
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/header.jsp" %>

    <div class="row">
        <div class="col-md-6">
            <h2 class="h1-responsive font-weight-bold text-center my-4">Category </h2>

            <h4>Category id : <c:out value="${category.id}" />   </h4>
            <h4>Category    : <c:out value="${category.name}" /> </h4>

        </div>
    </div>
</div>
</body>
</html>
