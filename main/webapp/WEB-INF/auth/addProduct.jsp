<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 08/06/2021
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/header.jsp" %>
    <div class="row">
        <div class="col-md-6">
            <h2 class="h1-responsive font-weight-bold text-center my-4">Ajouter Produit</h2>
            <form action="<c:url value="/auth/addProduct" />" method="post" class='bd-example'>
                <div class="mb-3">
                    <label for='name' class="form-label"> Name Produit: </label>
                    <input type='text' class="form-control" name='name' id='name' required>
                </div>
                <div class="mb-3">
                    <label for="Content" class="form-label"> Content: </label>
                    <input type='text' class="form-control" name='Content' id='Content'>
                </div>
                <div class="mb-3">
                    <label for="Price" class="form-label"> Price: </label>
                    <input type='text' class="form-control" name='Price' id='Price'>
                </div>
                <div class="mb-3">
                    <select class="form-select" aria-label="Default select example" name="CategorySelect" required>
                        <c:forEach items="${listCategory}" var="t">
                              <option value="${t.id}">${t.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class='form'>
                    <input type='submit' class="btn btn-primary" value='submit'>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

</html>