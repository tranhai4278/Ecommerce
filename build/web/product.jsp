<%-- 
    Document   : product
    Created on : Jul 8, 2023, 4:21:03 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <body id="reportsPage">
        <nav class="navbar navbar-expand-xl">
             <jsp:include page="head.jsp"></jsp:include>
        </nav>
        <div class="container mt-5">
            <div class="row tm-content-row">
            <c:if test="${sessionScope.acc.isSeller == 1}">
                <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="tm-product-table-container">
                            <table class="table table-hover tm-table-small tm-product-table">
                                <thead>
                                    <tr>
                                        <th scope="col">Tên sản phẩm</th>
                                        <th scope="col">Giá</th>
                                        <th scope="col">Còn hàng</th>
                                        <th scope="col">Sale </th>
                                        <th scope="col">Ngôn ngữ</th>
                                        <th scope="col">Ngày bán</th>
                                        <th scope="col">&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listP}" var="p">
                                        <tr>
                                            <td>
                                                <a href="edit?pid=${p.id}" class="tm-product-name">
                                                    <i class="tm-product-name"> ${p.name} </i>
                                                </a>
                                            </td>
                                            <td>${p.pd.price}</td>
                                            <td>${p.pd.amount}</td>
                                            <td>${p.s.sale}</td>
                                            <td>${p.lang.language}</td>
                                            <td>${p.pd.sellDate}</td>
                                            <td>
                                                <a href="delete?pid=${p.id}&lid=${p.lang.id}" class="tm-product-delete-link">
                                                    <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- table container -->
                        <a
                            href="add"
                            class="btn btn-primary btn-block text-uppercase mb-3">Thêm sản phẩm</a>

                    </div>
                </div>
                </c:if>
                
            <c:if test="${sessionScope.acc.isAdmin == 1}">
                <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
                        <h2 class="tm-block-title">Product Categories</h2>
                        <div class="tm-product-table-container">
                            <table class="table tm-table-small tm-product-table">
                                <tbody>
                                    <c:forEach items="${listG}" var="g">
                                    <tr>
                                        <td class="tm-product-name">${g.genres}</td>
                                        <td class="text-center">
                                            <a href="deleteG?gid=${g.id}" class="tm-product-delete-link">
                                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                            </a>
                                        </td>
                                    </tr>
                                     </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- table container -->
                        <a href="add-genres.jsp" class="btn btn-primary btn-block text-uppercase mb-3">
                            Add new category
                        </a>
                    </div>
                </div>
                </c:if>
            </div>
        </div>
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                   Copyright &copy; <b>2018</b> © 2023 Yunene - Privacy Policy
                    
                    Design: <a rel="nofollow noopener" class="tm-footer-link">info@yurineko.net</a>
                </p>
            </div>
        </footer>

        <script src="manager/js/jquery-3.3.1.min.js"></script>

    <script src="manager/js/moment.min.js"></script>

    <script src="manager/js/Chart.min.js"></script>

    <script src="manager/js/bootstrap.min.js"></script>
 
    <script src="manager/js/tooplate-scripts.js"></script>
<!--        <script>
            $(function () {
                $(".tm-product-name").on("click", function () {
                    window.location.href = "edit-product";
                });
            });
        </script>-->
    </body>
</html>
</html>
