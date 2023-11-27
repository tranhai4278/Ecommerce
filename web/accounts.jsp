<%-- 
    Document   : acount
    Created on : Jul 11, 2023, 9:36:52 PM
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
    <div class="" id="home">
      <nav class="navbar navbar-expand-xl">
          <jsp:include page="head.jsp"></jsp:include>
      </nav>
         <div class="container mt-5">
        <div class="row tm-content-row">
            <div class="col-12 tm-block-col">
                <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                    <h2 class="tm-block-title">List of Accounts</h2>
                    <label for="selected-id"><p class="text-white">Accounts</p></label>
                    <select id="selected-id" name="selected-id" class="custom-select"
                            onchange="changeAccount(this.value)">
                        <c:forEach items="${accounts}" var="account">
                            <option
                                ${selected == account.id? 'selected' : ''}
                                    value="${account.id}">${account.userName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <!-- row -->
        <c:forEach items="${accounts}" var="account">
            <form action="accounts" method="post">
                <div class="account-wrapper row tm-content-row"
                     id="account-${account.account_id}" ${selected == account.id? '' : 'style="display:none"'}>
                    <div class="tm-block-col tm-col-avatar">
                        <div class="tm-bg-primary-dark tm-block tm-block-avatar">
                            <h2 class="tm-block-title">Avatar</h2>
                            <div class="tm-avatar-container">
                                <img
                                        src="${account.avatar}"
                                        alt="Avatar"
                                        class="tm-avatar img-fluid mb-4"
                                />
                            </div>
                        </div>
                    </div>
                    <div class="tm-block-col tm-col-account-settings">
                        <div class="tm-bg-primary-dark tm-block tm-block-settings">
                            <h2 class="tm-block-title">Account Settings</h2>
                            <div class="form-group col-lg-6">
                                <label for="username">Username</label>
                                <input
                                        id="username"
                                        name="username"
                                        type="text"
                                        value="${account.userName}"
                                        class="form-control validate"
                                />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="phone">Phone</label>
                                <input
                                        id="first-name"
                                        name="phone"
                                        type="text"
                                        value="${account.phone}"
                                        class="form-control validate"
                                />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="email">Email</label>
                                <input
                                        id="last-name"
                                        name="email"
                                        type="text"
                                        value="${account.email}"
                                        class="form-control validate"
                                />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="email">Address</label>
                                <input
                                        id="email"
                                        name="email"
                                        type="email"
                                        value="${account.address}"
                                        class="form-control validate"
                                />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="phone">Genres</label>
                                <input
                                        id="phone"
                                        name="phone"
                                        type="tel"
                                        value="${profile.gender == true ? 'Male' : 'Female'}"
                                        class="form-control validate"
                                />
                            </div>
                                        
                            <div class="form-group col-12">
                                <button
                                        type="submit"
                                        name="make-admin"
                                        value="${account.account_id}"
                                        class="btn btn-primary btn-block text-uppercase"
                                    ${account.username.equals(sessionScope.account.getUsername())? 'disabled' : ''}
                                >
                                    <input type="hidden" name="role" value="${account.role_id}">
                                        ${account.role_id == 0? 'Make Admin' : 'Remove Admin'}
                                </button>
                            </div>
                            <div class="form-group col-12">
                                <button
                                        type="submit"
                                        name="disable-enable"
                                        value="${account.account_id}"
                                        class="btn btn-primary btn-block text-uppercase"
                                    ${account.username.equals(sessionScope.account.getUsername())? 'disabled' : ''}
                                >
                                    <input type="hidden" name="status" value="${account.status? 1 : 0}">
                                        ${account.status? 'Disable Account' : 'Enable Account'}
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </c:forEach>
    </div>
<script src="manager/js/jquery-3.3.1.min.js"></script>

    <script src="manager/js/moment.min.js"></script>

    <script src="manager/js/Chart.min.js"></script>

    <script src="manager/js/bootstrap.min.js"></script>
 
    <script src="manager/js/tooplate-scripts.js"></script>
  </body>
</html>
