
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- MAIN HEADER -->
<div id="header">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- LOGO -->
            <div class="col-md-3">
                <div class="header-logo">
                    <a href="home" class="logo">
                        <style>
                            img {
                                width: 100%;
                            }
                        </style>
                        <img src="./img/logo-footer.png" alt="">
                    </a>

                </div>
            </div>
            <!-- /LOGO -->

            <!-- SEARCH BAR -->

            <div class="col-md-6">
                <div class="header-search">

                    <form  action="search" method="post" >
                        <select name="category" class="input-select">

                            <option value="0">All Categories</option>
                            <c:forEach items="${listC}" var="c">
                                <option value="${c.id}">${c.category}</option>

                            </c:forEach>
                        </select>
                        <input name="txt" type="text"  class="input" placeholder="Search here">
                        <button type="submit" class="search-btn">Search</button>
                    </form>
                </div>
            </div>

            <!-- /SEARCH BAR -->

            <!-- ACCOUNT -->
            <div class="col-md-3 clearfix">
                <div class="header-ctn">
                    <!-- Cart -->
                    <div class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                            <i class="fa fa-shopping-cart"></i>
<!--                            <span>Giỏ Hàng</span>-->
                            <a href="cart">Giỏ Hàng</a>
                            <div class="qty">${requestScope.size}</div>
                        </a>
                    </div>
                    <!-- /Cart -->
                    <c:if test="${sessionScope.acc != null}">
                        <div class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">     
                                <i class="fa fa-user-o"></i>
                                <span>Account</span>
                            </a>
                            <div class="cart-dropdown">
                                <div class="cart-list">
                                    <div class="product-widget">
                                        <div class="menu">
                                            <a href="profile">
                                                <i class="fa fa-user-o"></i>
                                                <span>Hồ sơ</span>
                                            </a>
                                              </br>
<!--                                            Giỏ hàng</br>
                                            Chi tiết đơn hàng</br>-->
                                            <c:if test="${sessionScope.acc.isSeller == 1 or sessionScope.acc.isAdmin ==1 }">
                                                <a href="product">
                                                    <i class="fa fa-upload"></i>
                                                    <span>Quản lý shop</span>
                                                </a>
                                                </br>
                                            </c:if>
                                            <c:if test="${sessionScope.acc.isAdmin != 0}">
                                                <a href="account">
                                                    <i class="fa fa-arrow-circle-up"></i>
                                                    <span>Quản lý tài khoản</span>
                                                </a>
                                                </br>
                                            </c:if>
                                            <a href="logout">
                                                <i class="fa fa-sign-out"></i>
                                                <span>Đăng xuất</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.acc == null}">
                        <div >
                            <a href="login.jsp">
                                <i class="fa fa-sign-in"></i>
                                <span>Đăng nhập</span>
                            </a>
                        </div>
                    </c:if>
                    <!--
                                                     Menu Toogle 
                                                    <div class="menu-toggle">
                                                        <a href="#">
                                                            <i class="fa fa-bars"></i>
                                                            <span>Menu</span>
                                                        </a>
                                                    </div>
                                                     /Menu Toogle -->
                </div>
            </div>
            <!-- /ACCOUNT -->
        </div>
        <!-- row -->
    </div>
    <!-- container -->
</div>
<!-- /MAIN HEADER -->