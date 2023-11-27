<%-- 
    Document   : newjsp
    Created on : Jul 4, 2023, 1:37:10 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
        <header>
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
<!--                            <li><a href="#">Giảm Giá</a></li>-->
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

            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- shop -->
                        <div class="col-md-4 col-xs-6">
                            <div class="shop">
                                <div class="shop-img">
                                    <img src="./img/shop1.png" alt="" height="500">
                                </div>
                                <div class="shop-body">
                                    <h3>Light Novel</h3>
                                    <a href="category?cid=1" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <!-- /shop -->

                        <!-- shop -->
                        <div class="col-md-4 col-xs-6">
                            <div class="shop">
                                <div class="shop-img">
                                    <img src="./img/shop2.jpeg" alt="" height="500">
                                </div>
                                <div class="shop-body">
                                    <h3>Manga</h3>
                                    <a href="category?cid=2" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <!-- /shop -->

                        <!-- shop -->
                        <div class="col-md-4 col-xs-6">
                            <div class="shop">
                                <div class="shop-img">

                                    <img src="./img/figure.jpg" alt="" height="500">
                                </div>
                                <div class="shop-body">
                                    <h3>Phụ Kiện</h3>
                                    <a href="category?cid=3" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <!-- /shop -->
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /SECTION -->

            <!-- SECTION -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">

                        <!-- section title -->
                        <div class="col-md-12">
                            <div class="section-title">
                                <h3 class="title">New Products</h3>
                                <div class="section-nav">

                                </div>
                            </div>
                        </div>
                        <!-- /section title -->

                        <!-- Products tab & slick -->
                        <div class="col-md-12">
                            <div class="row">
                                <div class="products-tabs">
                                    <div id="tab1" class="tab-pane active">
                                        <form id="f" action="" method="post">
                                        <div class="products-slick" data-nav="#slick-nav-1">
                                            
                                        <c:forEach items="${listN}" var="n">
                                            <c:set var="id" value="${p.id}"/>
                                            <div class="product">
                                                <div class="product-img">
                                                    <img src="./img/product/${n.img}" alt=" " height="400px">
                                                    <div class="product-label">
                                                        <span class="new">NEW</span>
                                                    </div>                     
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">${n.title}</p>
                                                    <h3 class="product-name"><a href="detail?pid=${n.id}">${n.name}</a></h3>
                                                    <h4 class="product-price">${n.pd.price}00đ</h4>

<!--                                                    <div class="product-btns">
                                                        <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                        <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                    </div>-->
                                                </div>
<!--                                                <div class="add-to-cart">
                                                    <input  type="button" class="add-to-cart-btn" onclick="buy('${id}')" value="add to cart" />
                                                </div>-->
                                            </div>
                                        </c:forEach> 
                                               
                                    </div>
                                             </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Products tab & slick -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->

            <!-- /SECTION -->

            <!-- HOT DEAL SECTION -->
            <div id="hot-deal" class="section" style="background-image: url(./img/hotdeal.jpg);">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="hot-deal">
                                <ul class="hot-deal-countdown">
                                    <li>
                                        <div>
                                            <h3></h3>
                                            <span></span>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <h3></h3>
                                            <span></span>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <h3></h3>
                                            <span></span>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <h3></h3>
                                            <span></span>
                                        </div>
                                    </li>
                                </ul>
                                <h2 class="text-uppercase">hot deal this week</h2>
                                <p>New Collection Up to 50% OFF</p>
                                <a class="primary-btn cta-btn" href="#">Shop now</a>
                            </div>
                        </div>
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /HOT DEAL SECTION -->

            <!-- SECTION -->
            <div class="section">
                <!--                 container -->
                <div class="container">
                    <!--                     row -->
                    <div class="row">

                       
                        <div class="col-md-12">
                            <div class="section-title">
                                <h3 class="title">Top selling</h3>
                                <div class="section-nav">
                                    <ul class="section-tab-nav tab-nav">
                                        <li class="active"><a data-toggle="tab" href="#tab2">Light novel</a></li>
                                        <li><a data-toggle="tab" href="#tab2">Manga</a></li>
                                        <li><a data-toggle="tab" href="#tab2">Phụ Kiện</a></li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                                    

                           
                        <div class="col-md-12">
                            <div class="row">
                                <div class="products-tabs">
                                                                   
                                    <div id="tab2" class="tab-pane fade in active">
                                        <div class="products-slick" data-nav="#slick-nav-2">
                                                                             
                                            <div class="product">
                                                <div class="product-img">
                                                    <img src="./img/product06.png" alt="">
                                                    <div class="product-label">
                                                        <span class="sale">-30%</span>
                                                        <span class="new">NEW</span>
                                                    </div>
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">Category</p>
                                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                                    <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                                    <div class="product-rating">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                    </div>
                                                    <div class="product-btns">
                                                        <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                        <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                    </div>
                                                </div>
                                                <div class="add-to-cart">
                                                    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                                </div>
                                            </div>
                                                                  
                                        </div>
                                        <div id="slick-nav-2" class="products-slick-nav"></div>
                                    </div>
                                                     
                                </div>
                            </div>
                        </div>
                                         
                    </div>
                            
                </div>
                      
            </div>
                
            <div class="section">
                   
                <div class="container">
                          
                    <div class="row">
                        <div class="col-md-4 col-xs-6">
                            <div class="section-title">
                                <h4 class="title">Top selling</h4>
                                <div class="section-nav">
                                    <div id="slick-nav-3" class="products-slick-nav"></div>
                                </div>
                            </div>

                            <div class="products-widget-slick" data-nav="#slick-nav-3">
                                <div>
                                          
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="./img/product07.png" alt="">
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">Category</p>
                                            <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                            <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                        </div>
                                    </div>
                                                    
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4 col-xs-6">
                            <div class="section-title">
                                <h4 class="title">Top selling</h4>
                                <div class="section-nav">
                                    <div id="slick-nav-4" class="products-slick-nav"></div>
                                </div>
                            </div>

                            <div class="products-widget-slick" data-nav="#slick-nav-4">
                                <div>
                
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="./img/product04.png" alt="">
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">Category</p>
                                            <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                            <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                        </div>
                                    </div>
                                                      
                                </div>
                            </div>
                        </div>

                        <div class="clearfix visible-sm visible-xs"></div>

                        <div class="col-md-4 col-xs-6">
                            <div class="section-title">
                                <h4 class="title">Top selling</h4>
                                <div class="section-nav">
                                    <div id="slick-nav-5" class="products-slick-nav"></div>
                                </div>
                            </div>

                            <div class="products-widget-slick" data-nav="#slick-nav-5">
                                <div>
                                                          
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="./img/product01.png" alt="">
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">Category</p>
                                            <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                            <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                        </div>
                                    </div>
                                </div>

                                                      
                            </div>
                        </div>
                    </div>

                </div>
                             
            </div>
                        
        </div>
        <!--         /SECTION-->

        <!-- NEWSLETTER -->
        <div id="newsletter" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="newsletter">
                            <p>Trở thành <strong>người bán</strong></p>
                            <form>
                                <input class="input" type="text" placeholder="Enter Your Phone Number">
                                <button class="newsletter-btn"><i class="fa fa-envelope"></i> Submit</button>
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
        <script src="js/owl.carousel.min.js"></script>
        <script type="text/javascript">
                                                    function buy(id) {
                                                        var m = 1;
                                                        document.f.action = "buy?id=" + id + "&num=" + m;
                                                        document.f.sumit();
                                                    }

        </script> 
    </body>
</html>

