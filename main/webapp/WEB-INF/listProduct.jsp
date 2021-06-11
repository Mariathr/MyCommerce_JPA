<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 08/06/2021
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Produit</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/header.jsp" %>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-lg-8">
            <h2 class="h1-responsive font-weight-bold text-center my-4">List Product</h2>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">content</th>
                    <th scope="col">price</th>
                    <th scope="col">category</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listproduct}" var="t"> <tr>
                    <th scope="row"><c:out value="${t.id}" /></th>
                    <td><c:out value="${t.name}" /></td>
                    <td><c:out value="${t.content}" /></td>
                    <td><c:out value="${t.price}" /></td>
                    <td><c:out value="${t.category.name}" /></td>
                    <td><a href="<c:url value="/auth/removeProduct?id=${t.id}"/>">remove</a></td>
                    <td><a href="<c:url value="/auth/showProduct?id=${t.id}"/>">view</a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
