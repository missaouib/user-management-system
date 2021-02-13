<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login</title>
    <jsp:include page="fragments/head-meta-links.jsp"/>

</head>


<body class="form-membership">

<!-- begin::preloader-->
<div class="preloader">
    <svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="50px" height="50px" viewBox="0 0 128 128"
         xml:space="preserve">
        <rect x="0" y="0" width="100%" height="100%" fill="#FFFFFF"/>
        <g>
            <path d="M75.4 126.63a11.43 11.43 0 0 1-2.1-22.65 40.9 40.9 0 0 0 30.5-30.6 11.4 11.4 0 1 1 22.27 4.87h.02a63.77 63.77 0 0 1-47.8 48.05v-.02a11.38 11.38 0 0 1-2.93.37z"
                  fill="#000000" fill-opacity="1"/>
            <animateTransform attributeName="transform" type="rotate" from="0 64 64" to="360 64 64"
                              dur="500ms" repeatCount="indefinite">
            </animateTransform>
        </g>
    </svg>
</div>
<!-- end::preloader -->

<div class="form-wrapper">

    <!-- logo -->
    <div id="logo">
        <img class="logo" src="/static/assets/media/image/logo.png" alt="image">
        <img class="logo-dark" src="/static/assets/media/image/logo-dark.png" alt="image">
    </div>
    <!-- ./ logo -->

    <h5>Sign in</h5>

    <!-- form -->
    <form method="post" action="/login">

        <div class="form-group">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Id" required autofocus>
        </div>
        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Password" required>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
        <div class="form-group d-flex justify-content-between">
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" checked="" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Remember me</label>
            </div>
            <a href="recover-password.html">Reset password</a>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Sign in</button>
        <hr>

        <a href="./register.html" class="btn btn-outline-light btn-sm">Register now!</a>
    </form>
    <!-- ./ form -->

</div>


<jsp:include page="fragments/footer.jsp"/>
<!-- Plugin scripts -->
<script src="/static/vendors/bundle.js"></script>

<!-- App scripts -->
<script src="/static/assets/js/app.min.js"></script>
</body>


</html>
