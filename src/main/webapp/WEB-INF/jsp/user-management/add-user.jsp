<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>

    <title>Add User</title>

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
            <div class="col-md-8"><h3 class="h3">Add User</h3></div>
            <div class="col-md-4"></div>
        </div>

        <form:form method="POST" action="/add-user" modelAttribute="user">

            <div class="form-row">
                <div class="col-md-6 mb-6">
                    <form:label path="userId">User Id</form:label>
                    <form:input type="number" path="userId" class="form-control"/>
                    <form:errors cssClass="text-danger" path="userId"/>
                </div>
                <div class="col-md-6 mb-6">
                    <form:label path="password">Password</form:label>
                    <form:input path="password" class="form-control"/>
                    <form:errors cssClass="text-danger" path="password"/>
                </div>
            </div>

            <div class="form-row">
                <div class="col-md-6 mb-6">
                    <form:label path="firstName">First Name</form:label>
                    <form:input path="firstName" class="form-control"/>
                    <form:errors cssClass="text-danger" path="firstName"/>
                </div>

                <div class="col-md-6 mb-6">
                    <form:label path="lastName">Last Name</form:label>
                    <form:input path="lastName" class="form-control"/>
                    <form:errors cssClass="text-danger" path="lastName"/>
                </div>
            </div>

            <div class="form-row">
                <div class="col-md-6 mb-6">
                    <form:label path="designation">Designation</form:label>
                    <form:input path="designation" class="form-control"/>
                    <form:errors cssClass="text-danger" path="designation"/>
                </div>
                <div class="col-md-6 mb-6">
                    <form:label path="department">Department</form:label>
                    <form:input path="department" class="form-control"/>
                    <form:errors cssClass="text-danger" path="department"/>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6 mb-6">
                    <form:label path="workLocation">Work Location</form:label>
                    <form:input path="workLocation" class="form-control"/>
                    <form:errors cssClass="text-danger" path="workLocation"/>
                </div>

                <div class="col-md-6 mb-6">
                    <form:label path="company">Company</form:label>
                    <form:input path="company" class="form-control"/>
                    <form:errors cssClass="text-danger" path="company"/>
                </div>
            </div>

            <div class="form-row">
                <div class="col-md-6 mb-6">
                    <form:label path="email">Email</form:label>
                    <form:input path="email" class="form-control"/>
                    <form:errors cssClass="text-danger" path="email"/>
                </div>
                <div class="col-md-6 mb-6">
                    <form:label path="mobile">Mobile</form:label>
                    <form:input path="mobile" class="form-control"/>
                    <form:errors cssClass="text-danger" path="mobile"/>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <form:label path="joiningDate">Joining Date</form:label>
                    <form:input type="date" path="joiningDate" class="form-control"/>
                    <form:errors cssClass="text-danger" path="joiningDate"/>
                </div>
                <div class="col-md-6 mb-3">
                    <form:label path="active">Active</form:label>
                    <form:checkbox path="active" class="form-control"/>
                    <form:errors cssClass="text-danger" path="active"/>
                </div>
            </div>
            <div class="form-row">


            </div>

            <button class="btn btn-primary" type="submit">Add User</button>
        </form:form>

        <jsp:include page="../fragments/footer.jsp"/>

    </div>
    <!-- end::main-content -->

</div>
<!-- end::main -->

<jsp:include page="../fragments/plugin-scripts.jsp"/>
</body>
</html>