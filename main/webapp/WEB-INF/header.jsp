<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 08/06/2021
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item"><a   class="nav-link" href="<c:url value="/auth/listProduct" />">  List Produits </a></li>
            <li class="nav-item"><a   class="nav-link" href="<c:url value="/auth/addProduct" />">Ajout un produit </a></li>
            <li class="nav-item"><a   class="nav-link" href="<c:url value="/auth/listCategory" />">  List Category </a></li>
            <li class="nav-item"><a   class="nav-link" href="<c:url value="/auth/addCategory" />">Ajouter Category </a></li>
            <li class="nav-item"><a   class="nav-link" href="<c:url value="/logout" />">Se déconnecter</a></li>
            <li class="nav-item"><a  class="nav-link" href="<c:url value="/login" />">Se connecter</a></li>
        </ul>
    </div>

</nav>
</body>
</html>
