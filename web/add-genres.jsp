<%-- 
    Document   : add-product
    Created on : Jul 8, 2023, 4:18:22 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Manager Board</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="manager/css/fontawesome.min.css">

        <link rel="stylesheet" href="manager/css/bootstrap.min.css">

        <link rel="stylesheet" href="manager/css/templatemo-style.css">

    </head>

    <body>
        <nav class="navbar navbar-expand-xl">
            <jsp:include page="head.jsp"></jsp:include>
            </nav>
            <form action="addG" method="post">
                <div class="container tm-mt-big tm-mb-big">
                    <div class="row">
                        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                                <div class="row">
                                    
                                    <div class="col-12">
                                        <h2 class="tm-block-title d-inline-block">Add Genres</h2>
                                        <p style="color: red">${requestScope.error}</p>
                                    </div>
                                </div>
                                <div class="row tm-edit-product-row">
                                    <div class="col-xl-6 col-lg-6 col-md-12">
                                            <div class="form-group mb-3">
                                                <label
                                                    for="genres"
                                                    >Tên thể loại
                                                </label>
                                                <input
                                                    id="genres"
                                                    name="genres"
                                                    type="text"
                                                    class="form-control validate"
                                                    required
                                                    />
                                            </div>
                                     </div>
                                    <div class="col-12">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase">Add Now</button>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <script src="manager/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="manager/jquery-ui-datepicker/jquery-ui.min.js"></script>
        <!-- https://jqueryui.com/download/ -->
        <script src="manager/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->

    </body>
</html>
