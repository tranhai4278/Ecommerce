<%-- 
    Document   : login
    Created on : Jul 6, 2023, 9:01:46 PM
    Author     : Nết
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Electro - HTML Ecommerce Template</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;700&display=swap" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
                function toggleForms() {
                    $('#form-signin').toggle();
                    $('.form-signup').toggle();
                }

                $('#btn-signup').click(toggleForms);
                $('#cancel_signup').click(toggleForms);
            });
        </script>
    </head>
    <body>
        <header>
            <div id="header">
                <div class="container">
                    <div class="row">
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
                        <div class="col-md-6">
                            <div class="header-search">
                            </div>
                        </div>
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">
                                <div>
                                    <a href="#">
                                        <i class="fa fa-user-o"></i>
                                        <span>Account</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div id="login">
            <div class="container">
                <div id="login-row" class="row justify-content-center align-items-center">
                    <div class="col-md-6">
                        <img src="./img/dangnhap.png" alt="">
                    </div>
                    <div id="login-column" class="col-md-6">
                        <div id="login-box" class="col-md-12">
                            <div id="logreg-forms">
                                <c:set var="c" value="${pageContext.request.cookies}" />
                                <form id="form-signin" class="form" action="login" method="post">
                                    <h3 class="text-center text-info">Đăng nhập</h3>
                                    <p style="color: red">${requestScope.error}</p>
                                    <p style="color: red">${requestScope.error2}</p>
                                    <p style="color: red">${requestScope.error3}</p>
                                    <div class="form-group">
                                        <label for="username" class="text-info">Username:</label><br>
                                        <input type="text" name="user" id="username" value="${username}" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="text-info">Password:</label><br>
                                        <input type="password" name="pass" id="password" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="remember-me" class="text-info">
                                            <span>Remember me</span>
                                            <span><input id="remember-me" name="rem" type="checkbox" value="${rem}" ></span>
                                        </label>
                                    </div>
                                    <input type="submit" name="submit" class="btn btn-primary btn-block" value="Đăng nhập">
                                    <button class="btn btn-primary btn-block" type="button" id="btn-signup">
                                        <i class="fas fa-user-plus"></i> Đăng ký ở đây
                                    </button>
                                </form>

                                <form action="signup" class="form-signup" style="display: none;">
                                    <h3 class="text-center text-info">Đăng ký</h3>
                                    <p style="color: red">${requestScope.error3}</p>
                                    <p style="color: red">${requestScope.error2}</p>
                                    <input name="user" type="text" id="user-name" class="form-control" placeholder="Username" required="" autofocus="">
                                    <input name="pass" type="password" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
                                    <input name="repass" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">
                                    <input name="phone" type="text" id="user-phone" class="form-control" placeholder="Phone number" required autofocus="">
                                    <input name="email" type="email" id="user-email" class="form-control" placeholder="Email" required autofocus="">
                                    <button class="btn btn-primary btn-block" type="submit">
                                        <i class="fas fa-user-plus"></i> Đăng ký
                                    </button>
                                    <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer id="footer" >
            <div class="section">
                <div class="container">
                    <div class="footer" style="text-align: center">
                        <h3 class="footer-title">About Us</h3>
                        <p>© 2023 Yunene - Privacy Policy</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-envelope-o"></i>info@yurineko.net</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
