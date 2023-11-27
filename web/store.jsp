<%-- 
    Document   : store
    Created on : Jul 4, 2023, 1:42:38 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Yurineko Shop</title>

        <!-- Google font -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;700&display=swap" rel="stylesheet">
        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <jsp:include page="headmain.jsp"></jsp:include>
        </header>
        <!-- /HEADER -->
        <!-- NAVIGATION -->
        <nav id="navigation">
            <!-- container -->
            <div class="container">
                <!-- responsive-nav --> 
                <div id="responsive-nav">
                    <!-- NAV -->
                    <ul class="main-nav nav navbar-nav">
                        <li class="active"><a href="home">Home</a></li>
                        <li><a href="store">Tất cả hàng</a></li>
<!--                        <li><a href="#">Giảm Giá</a></li>-->
                        <li><a href="category?cid=1">Light novel</a></li>
                        <li><a href="category?cid=2">Manga</a></li>
                        <li><a href="category?cid=3">Phụ kiện</a></li>
                    </ul>
                    <!-- /NAV -->
                </div>
                <!-- /responsive-nav -->
            </div>
            <!-- /container -->
        </nav>

        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb-tree">
                            <li><a href="home">Home</a></li>
                            <li> <a href="store">All Categories </a></li>
                            <c:if test="${tag == 1}">
                            <li class="active"> Light Novel</li>
                            </c:if>
                            <c:if test="${tag == 2}">
                            <li class="active"> Manga</li>
                            </c:if>
                            <c:if test="${tag == 3}">
                            <li class="active"> Phụ kiện</li>
                            </c:if>
                    </ul>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /BREADCRUMB -->

    <!-- SECTION -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- ASIDE -->
                <div id="aside" class="col-md-3">
                    <!-- aside Widget -->
                    <div class="aside">
                        <h3 class="aside-title">Categories</h3>
                        <c:forEach items="${listC}" var="c">
                            <li><a href="category?cid=${c.id}" style="font-size: medium">${c.category}</a></li>
                            </c:forEach>  
                    </div>
                    <!-- /aside Widget -->

                    <!-- aside Widget -->
                    <div class="aside">
                        <h3 class="aside-title">Price</h3>
                        <div class="price-filter">
                            <div id="price-slider"></div>
                            <div class="input-number price-min">
                                <input id="price-min" type="number" >
                                <span class="qty-up">+</span>
                                <span class="qty-down">-</span>
                            </div>
                            <span>-</span>
                            <div class="input-number price-max">
                                <input id="price-max" type="number" >
                                <span class="qty-up">+</span>
                                <span class="qty-down">-</span>
                            </div>
                        </div>
                    </div>
                    <!-- /aside Widget -->

                    <!-- aside Widget -->
                    <div class="aside">
                        <h3 class="aside-title">Genres</h3>
                        <div class="checkbox-filter">
                            <form id="f1" action="filtergenres">
                                <c:forEach items="${listG}" var="g">
                                    <div class="input-checkbox">
                                        <input type="checkbox" id="${g.id}" name="gid" ${g.id==gidd?"checked":""}
                                               value="${g.id}" onclick="setCheck(this)" />
                                        <label for="${g.id}">
                                            <span></span>
                                            ${g.genres}
                                            <small>(${g.count})</small>
                                        </label>
                                    </div>
                                </c:forEach>
                            </form> 
                        </div>
                    </div>
                    <!-- /aside Widget -->


                    <!-- /aside Widget -->
                </div>
                <!-- /ASIDE -->

                <!-- STORE -->
                <div id="store" class="col-md-9">
                    <!-- store top filter -->
                    <div class="store-filter clearfix">
                        <div class="store-sort">
                            <label>
                                Sort By:
                                <form id="f2" action="store" method="post">
                                    <select class="input-select" onchange="setSort(this)" name="sort">
                                        <option value="0"></option>
                                        <option ${requestScope.sort ==1 ? 'selected' : ' ' }  value="1">A-Z</option>
                                        <option ${requestScope.sort ==2 ? 'selected' : ' ' } value="2">Z-A</option>
                                    </select>
                                </form> 
                            </label>
                        </div>
                        <ul class="store-grid">
                            <form  action="search" method="post" >
                                <input oninput="searchByName(this)" name="txt" type="text"  class="input" placeholder="Search here">
                            </form>
                        </ul>
                    </div>
                    <!-- /store top filter -->

                    <!-- store products -->
                    <div id="content" class="row">
                        <!-- product -->
                        <form id="f" action="" method="post">
                            <c:forEach items="${listP}" var="p">
                                <c:set var="id" value="${p.id}"/>
                                <div class="col-md-4 col-xs-6">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="./img/product/${p.img}" alt=" " height="400px" width="auto">
                                            <div class="product-label">
                                            </div>                     
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${p.title}</p>
                                            <h3 class="product-name"><a href="detail?pid=${p.id}">${p.name}</a></h3>
                                            <h4 class="product-price">${p.pd.price}00đ </h4>
                                            <div class="product-btns">
                                                <button class="quick-view" ><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button></a>
                                            </div>
                                        </div>
<!--                                        <div class="add-to-cart">
                                            <input  type="button" class="add-to-cart-btn" onclick="buy('${id}')" value="add to cart" />
                                        </div>-->
                                    </div>
                                </div>
                            </c:forEach>
                        </form>

                    </div>
                    <!-- /store products -->

                    <!-- store bottom filter -->
                    <div class="store-filter clearfix">
                        <!--                            <span class="store-qty">Showing 20-100 products</span>-->
                        <ul class="store-pagination">
                            <button onclick="loadPrevious()"><i class="fa fa-angle-left"></i></button>
                            <button onclick="loadNext()"><i class="fa fa-angle-right"></i></button>
                        </ul>
                    </div>
                    <!-- /store bottom filter -->
                </div>
                <!-- /STORE -->
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /SECTION -->

    <!-- NEWSLETTER -->
    <div id="newsletter" class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12">
                    <div class="newsletter">
                        <p>Trở thành <strong>Người bán</strong></p>
                        <form>
                            <input class="input" type="email" placeholder="Enter Your Email">
                            <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /NEWSLETTER -->

    <!-- FOOTER -->
    <footer id="footer">
        <!-- top footer -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-3 col-xs-6">
                        <div class="footer">
                            <h3 class="footer-title">About Us</h3>
                            <p>© Copyright 2023 Yunene - Privacy Policy</p>
                            <ul class="footer-links">

                                <li><a href="#"><i class="fa fa-envelope-o"></i>info@yurineko.net</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-3 col-xs-6">
                        <div class="footer">
                            <h3 class="footer-title">Categories</h3>
                            <ul class="footer-links">
                                <li><a href="#">Hot deals</a></li>
                                <li><a href="#">Light novel</a></li>
                                <li><a href="#">Manga</a></li>
                                <li><a href="#">Accessories</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="clearfix visible-xs"></div>

                    <div class="col-md-3 col-xs-6">
                        <div class="footer">
                            <h3 class="footer-title">Information</h3>
                            <ul class="footer-links">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Contact Us</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Orders and Returns</a></li>
                                <li><a href="#">Terms & Conditions</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-3 col-xs-6">
                        <div class="footer">
                            <h3 class="footer-title">Service</h3>
                            <ul class="footer-links">
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">View Cart</a></li>
                                <li><a href="#">Wishlist</a></li>
                                <li><a href="#">Track My Order</a></li>
                                <li><a href="#">Help</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /top footer -->

    </footer>
    <!-- /FOOTER -->

    <!-- jQuery Plugins -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/nouislider.min.js"></script>
    <script src="js/jquery.zoom.min.js"></script>
    <script src="js/main.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script>
                                var currentPage = 1; // Trang hiện tại

                                function loadPrevious() {
                                    if (currentPage > 1) {
                                        currentPage--;
                                        loadPage(currentPage);
                                    }
                                }

                                function loadNext() {
                                    currentPage++;
                                    loadPage(currentPage);
                                }

                                function loadPage(pageNumber) {
                                    $.ajax({
                                        url: "/project/load",
                                        type: "get",
                                        data: {
                                            num: pageNumber
                                        },
                                        success: function (data) {
                                            var row = document.getElementById("content");
                                            row.innerHTML = data;
                                        },
                                        error: function (jqXHR) {

                                        }
                                    });
                                }
    </script>
    <script>
        function searchByName(param) {
            var txtS = param.value;
            $.ajax({
                url: "/project/searchajax",
                type: "get",
                data: {
                    txt: txtS
                },
                success: function (data) {
                    var row = document.getElementById("content");
                    row.innerHTML = data;
                },
                error: function (jqXHR) {

                }
            });
        }
    </script>
 
    <script>
        function setSort(obj) {
            document.getElementById('f2').submit();
        }
    </script> 

</body>
</html>
