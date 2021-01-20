<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>

    <title>Add Employee</title>

    <jsp:include page="fragments/head-meta-links.jsp"/>

</head>
<body>

<jsp:include page="fragments/header.jsp"/>


<!-- begin::main -->
<div id="main">

    <jsp:include page="fragments/navigation.jsp"/>

    <!-- begin::main-content -->
    <div class="main-content">


        <form:form method="POST"
                   action="add-employee-form-action" modelAttribute="employee">

            <div class="form-row">
                <div class="col-md-6 mb-6">
                    <form:label path="firstName">First Name</form:label>
                    <form:input path="firstName" class="form-control"/>
                    <form:errors path="firstName"/>
                </div>

                <div class="col-md-6 mb-6">
                    <form:label path="lastName">Last Name</form:label>
                    <form:input path="lastName" class="form-control"/>
                    <form:errors path="lastName"/>
                </div>

            </div>
            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <form:label path="company">Company</form:label>
                    <form:input path="company" class="form-control"/>
                    <form:errors path="company"/>
                </div>
            </div>

            <button class="btn btn-primary" type="submit">Submit form</button>
        </form:form>

        <jsp:include page="fragments/footer.jsp"/>

    </div>
    <!-- end::main-content -->

</div>
<!-- end::main -->

<jsp:include page="fragments/plugin-scripts.jsp"/>
</body>
</html>