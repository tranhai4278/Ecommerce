<%-- 
    Document   : checkout
    Created on : Jul 4, 2023, 1:40:55 AM
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
        <!-- include libraries(jQuery, bootstrap) -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

        <!-- include summernote css/js -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>

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

    </head>
    <body>
        <!-- HEADER -->
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
                            <li><a href="home">Home</a></li>
                            <li class="active"><a class="active">Check out</a></li>

                        </ul>
                        <!-- /NAV -->
                    </div>
                    <!-- /responsive-nav -->
                </div>
                <!-- /container -->
            </nav>
            <!-- /NAVIGATION -->

            <!-- BREADCRUMB -->
            <div id="breadcrumb" class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="breadcrumb-header">Checkout</h3>
                            <ul class="breadcrumb-tree">
                                <li><a href="home">Home</a></li>
                                <li class="active">Checkout</li>
                            </ul>
                        </div>
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /BREADCRUMB -->
            <form action="checkout" method="post">
            <!-- SECTION -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">

                        <div class="col-md-7">
                            <!-- Billing Details -->
                            <div class="billing-details">
                                <div class="section-title">
                                    <h3 class="title">Billing address</h3>
                                </div>
                                <div class="form-group">
                                    <input class="input" type="text" name="name" placeholder="Name" value="${profile.userName}" >
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="address" placeholder="Address" value="${profile.address}">
                            </div>
                            <div class="form-group">
                                <input class="input" type="tel" name="phone" placeholder="Phone" value="${profile.phone}">
                            </div>
                            <!--                            <div class="form-group">
                                                            <div class="input-checkbox">
                                                                <input type="checkbox" id="create-account">
                                                                <label for="create-account">
                                                                    <span></span>
                                                                    Create Account?
                                                                </label>
                                                                <div class="caption">
                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
                                                                    <input class="input" type="password" name="password" placeholder="Enter Your Password">
                                                                </div>
                                                            </div>
                                                        </div>-->
                        </div>
                        <!-- /Billing Details -->

                        <!-- Shiping Details -->
                        <div class="shiping-details">

                        </div>
                        <!-- /Shiping Details -->

                        <!-- Order notes -->
                        <div class="order-notes">
                        </div>
                            <textarea id="summernote" class="input" name="note" placeholder="Order Notes"></textarea>
                        </div>
                        <!-- /Order notes -->
                    </div>

                    <!-- Order Details -->
                    <div class="col-md-5 order-details">
                        <div class="section-title text-center">
                            <h3 class="title">Your Order</h3>
                        </div>
                        <div class="order-summary">
                            <div class="order-col">
                                <div><strong>PRODUCT</strong></div>
                                <div><strong>TOTAL</strong></div>
                            </div>
                            <div class="order-products">
                                
                                <c:forEach items="${cart}" var="c">
                                    <input type="hidden" name="pid" value="${c.pid}"/>
                                    <input type="hidden" name="amount" value="${c.amount}"/>
                                    <input type="hidden" name="detailtotal" value="${c.detailtotal}"/>
                                    <div class="order-col">
                                        <div>${c.amount}x ${c.name}</div>
                                        <div>${c.detailtotal}</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="order-col">
                                <div>Shiping</div>
                                <div><strong>FREE</strong></div>
                            </div>
                            <div class="order-col">
                                <input type="hidden" name="total" value="${total}"/>
                                <div><strong>TOTAL</strong></div>
                                <div><strong class="order-total">${total}</strong></div>
                            </div>
                        </div>
                        <div class="payment-method">
                            <!--                            <div class="input-radio">
                                                            <input type="radio" name="payment" id="payment-1">
                                                            <label for="payment-1">
                                                                <span></span>
                                                                Direct Bank Transfer
                                                            </label>
                                                            <div class="caption">
                                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                                            </div>
                                                        </div>
                                                        <div class="input-radio">
                                                            <input type="radio" name="payment" id="payment-2">
                                                            <label for="payment-2">
                                                                <span></span>
                                                                Cheque Payment
                                                            </label>
                                                            <div class="caption">
                                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                                            </div>
                                                        </div>
                                                        <div class="input-radio">
                                                            <input type="radio" name="payment" id="payment-3">
                                                            <label for="payment-3">
                                                                <span></span>
                                                                Paypal System
                                                            </label>
                                                            <div class="caption">
                                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                                            </div>
                                                        </div>-->
                        </div>
                        <div class="input-checkbox">
                            <input type="checkbox" id="terms">
                            <label for="terms">
                                <span></span>
                                I've read and accept the <a href="#">terms & conditions</a>
                            </label>
                        </div>
                            <input type="submit" class="primary-btn order-submit"/> 
                    </div>
                    <!-- /Order Details -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->
            </form  >
        <!-- NEWSLETTER -->
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

        <script>
            $('#summernote').summernote();
        </script>
    </body>
</html>
