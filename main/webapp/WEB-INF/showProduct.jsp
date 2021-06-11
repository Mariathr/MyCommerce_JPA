<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 08/06/2021
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produit</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/header.jsp" %>
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-lg-6">
            <h2 class="h1-responsive font-weight-bold text-center my-4">Produit </h2>

            <h4>Produit id : <c:out value="${product.id}" />   </h4>
            <h4>Produit    : <c:out value="${product.name}" /> </h4>
            <h4>Content    :<c:out value="${product.content}" /> </h4>
            <h4>Category   :<c:out value="${product.category.name}" /> </h4>
            <h4>Price      :<c:out value="${product.price}" /> </h4>

        </div>
    </div>
</div>
</body>
</html>
