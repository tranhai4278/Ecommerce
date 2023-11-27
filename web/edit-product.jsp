<%-- 
    Document   : edit-product
    Created on : Jul 14, 2023, 12:48:13 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <div class="container tm-mt-big tm-mb-big">
                <div class="row">
                    <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                        <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                            <div class="row">
                                <div class="col-12">
                                    <h2 class="tm-block-title d-inline-block">Edit Product</h2>
                                </div>
                            </div>
                            <div class="row tm-edit-product-row">
                                <div class="col-xl-6 col-lg-6 col-md-12">
                                    <form action="edit" method="post" class="tm-edit-product-form" enctype='multipart/form-data'>
                                        <div class="form-group mb-3">
                                            <label
                                                for="id"
                                                >ID
                                            </label>
                                            <input
                                                id="name"
                                                value="${detail.id}"
                                            name="id"
                                            type="text"
                                            class="form-control validate"
                                            readonly
                                            />
                                    </div>
                                        <div class="form-group mb-3">
                                            <label
                                                for="name"
                                                >Tên sản phẩm
                                            </label>
                                            <input
                                                id="name"
                                                value="${detail.name}"
                                            name="name"
                                            type="text"
                                            class="form-control validate"
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="title"
                                            >Title</label>
                                        <textarea
                                            name="title"
                                            class="form-control validate"
                                            >${detail.title}</textarea>
                                    </div>

                                    <div class="form-group mb-3">
                                        <label
                                            for="description"
                                            >Description</label
                                        >
                                        <textarea

                                            name="description"
                                            class="form-control validate"
                                            >${detail.description}</textarea>

                                    </div>


                                    <div class="form-group mb-3" >
                                        <label
                                            for="category"
                                            >Category</label
                                        >
                                        <select
                                            name="categoryid"

                                            class="custom-select tm-select-accounts"
                                            id="category"
                                            >
                                            <option selected >Select category</option>
                                            <c:forEach items="${listC}" var="c">
                                                <option <c:if test="${detail.cid eq c.id}">
                                                               selected
                                                           </c:if> value="${c.id}">
                                                    ${c.category}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="language"
                                                >Ngôn ngữ</label
                                            >
                                            <select
                                                name="languageid" 
                                                class="custom-select tm-select-accounts"
                                                id="language"
                                                >
                                                <option selected >Select language</option>
                                                <c:forEach items="${listL}" var="l">
                                                    <option <c:if test="${detail.lang.id eq l.id}">
                                                               selected
                                                           </c:if> value="${l.id}">
                                                        ${l.language}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <input type="hidden" name="sellDate" id="sellDateInput" value="">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="sale"
                                                >Sale </label
                                            >
                                            <select
                                                name="saleid" 
                                                class="custom-select tm-select-accounts"
                                                id="sale"
                                                >
                                                <option selected >Select sale</option>
                                                <c:forEach items="${listS}" var="s">
                                                    <option <c:if test="${detail.s.id eq s.id}">
                                                               selected
                                                           </c:if> value="${s.id}">${s.sale}%</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="price"
                                                >Giá tiền
                                            </label>
                                            <input
                                                id="price"
                                                value="${detail.pd.price}"
                                                name="price"
                                                type="int"
                                                class="form-control validate"
                                                data-large-mode="true"

                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="amount"
                                                >Số lượng
                                            </label>
                                            <input
                                                id="amount"
                                                name="amount"
                                                value="${detail.pd.amount}"
                                                type="text"
                                                class="form-control validate"

                                                />
                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="genres" >Genres </label>
                                        <c:forEach items="${listG}" var="g">
                                            <div class="form-check"  >
                                                <input type="checkbox" name="genres" value="${g.id}" 
                                                       id="genre-${g.id}" class="form-check-input" 
                                                       <c:forEach items="${listGG}" var="genre">
                                                           <c:if test="${genre.genres eq g.genres}">
                                                               checked
                                                           </c:if>
                                                       </c:forEach>
                                                <label class="form-check-label" for="genre-${g.id}">
                                                    <span></span>
                                                    ${g.genres}
                                                </label>
                                            </div>
                                        </c:forEach>
                                    </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                <div class="custom-file mt-3 mb-3">
                                    <input name="file" id="fileInput" type="file" style="display:none;" onchange="displaySelectedImage(event)"  />
                                    <img id="selectedImage" src="./img/product/${detail.img}" alt="Selected Image" style=" max-width: 100%; height: auto;" />
                                    <input type="button" class="btn btn-primary btn-block mx-auto" value="UPLOAD PRODUCT IMAGE" onclick="document.getElementById('fileInput').click();" />
                                </div>
                            </div>
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary btn-block text-uppercase">Update Now</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                    Copyright &copy; <b>2018</b> All rights reserved. 

                    Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                </p>
            </div>
        </footer> 
        <script>
            function displaySelectedImage(event) {
                var file = event.target.files[0];
                var reader = new FileReader();
                reader.onload = function (e) {
                    document.getElementById('selectedImage').setAttribute('src', e.target.result);
                    document.getElementById('selectedImage').style.display = 'block';
                    var formData = new FormData();
                    formData.append('img', file);
                    var xhr = new XMLHttpRequest();
                    xhr.open('POST', 'YourServletURL', true);
                    xhr.send(formData);
                };
                reader.readAsDataURL(file);
            }
        </script>

        <script src="manager/js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="manager/jquery-ui-datepicker/jquery-ui.min.js"></script>
        <!-- https://jqueryui.com/download/ -->
        <script src="manager/js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->

    </body>
</html>
