<!doctype html>
<html lang="en">
<head>

    <title>Error</title>

    <jsp:include page="fragments/head-meta-links.jsp"/>

</head>
<body class="error-page bg-white">

<div>
    <h4 class="mb-0 text-muted font-weight-normal">${ errorMessage }</h4>
    <div>
        <span class="error-page-item font-weight-bold">${ errorCode }</span>

    </div>
    <a href="/" class="btn btn-outline-light btn-lg">Go Home</a>
</div>

<!-- Plugin scripts -->
<script src="static/vendors/bundle.js"></script>

<!-- App scripts -->
<script src="static/assets/js/app.min.js"></script>
</body>
</html>