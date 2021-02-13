<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>

    <title>Add Privilege</title>

    <jsp:include page="../fragments/head-meta-links.jsp"/>

</head>
<body>

<jsp:include page="../fragments/header.jsp"/>


<!-- begin::main -->
<div id="main">

    <jsp:include page="../fragments/navigation.jsp"/>

    <!-- begin::main-content -->
    <div class="main-content">
        <div class="row mb-3">
            <div class="col-md-8"><h3 class="h3">Add Privilege Url</h3></div>
            <div class="col-md-4"></div>
        </div>

        <form:form method="POST" action="/add-privilege" modelAttribute="privilege">

            <div class="form-row">
                <div class="col-md-6 mb-6">
                    <form:label path="url">Privilege URL</form:label>
                    <form:input path="url" class="form-control"/>
                    <form:errors cssClass="text-danger" path="url"/>
                </div>
            </div>
            <div class="form-row mt-3">
                <div class="col-md-6 mb-6">
                    <button class="btn btn-primary" type="submit">Add Privilege</button>
                </div>
            </div>


        </form:form>

        <jsp:include page="../fragments/footer.jsp"/>

    </div>
    <!-- end::main-content -->

</div>
<!-- end::main -->

<jsp:include page="../fragments/plugin-scripts.jsp"/>
</body>
</html>