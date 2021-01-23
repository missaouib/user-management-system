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


        <form:form method="POST" action="/update-employee/${ employee.get().id }" modelAttribute="employee">

        <div class="form-row">
            <div class="col-md-6 mb-6">
                <form:label path="employeeId">Employee Id</form:label>
                <form:input type="number" path="employeeId" class="form-control"/>
                <form:errors path="employeeId"/>
            </div>
        </div>

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
            <div class="col-md-6 mb-6">
                <form:label path="designation">Designation</form:label>
                <form:input path="designation" class="form-control"/>
                <form:errors path="designation"/>
            </div>
            <div class="col-md-6 mb-6">
                <form:label path="department">Department</form:label>
                <form:input path="department" class="form-control"/>
                <form:errors path="department"/>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-6">
                <form:label path="workLocation">Work Location</form:label>
                <form:input path="workLocation" class="form-control"/>
                <form:errors path="workLocation"/>
            </div>

            <div class="col-md-6 mb-6">
                <form:label path="company">Company</form:label>
                <form:input path="company" class="form-control"/>
                <form:errors path="company"/>
            </div>
        </div>

        <div class="form-row">
            <div class="col-md-6 mb-6">
                <form:label path="email">Email</form:label>
                <form:input path="email" class="form-control"/>
                <form:errors path="email"/>
            </div>
            <div class="col-md-6 mb-6">
                <form:label path="mobile">Mobile</form:label>
                <form:input path="mobile" class="form-control"/>
                <form:errors path="mobile"/>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <form:label path="joiningDate">Joining Date</form:label>
                <form:input type="date" path="joiningDate" class="form-control"/>
                <form:errors path="joiningDate"/>
            </div>
            <div class="col-md-6 mb-3">
                <form:label path="role">Role</form:label>
                <form:select path="role" class="form-control">
                    <form:option value="ADMIN"/>
                    <form:option value="HR"/>
                    <form:option value="EXECUTIVE"/>
                </form:select>
                <form:errors path="role"/>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <form:label path="status">Status</form:label>
                <form:input path="status" class="form-control"/>
                <form:errors path="status"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-3">
                <button class="btn btn-primary" type="submit">UPDATE</button>
            </div>
            </form:form>
            <form action="/delete-employee/${ employee.get().id }" method="post">
                <div class="col-md-3">
                    <button type="submit" class="btn btn-danger"
                            onclick="return confirm('Are you sure you want to delete this employee?');">DELETE
                    </button>
                </div>
            </form>
            <div class="col-md-3"></div>
        </div>


        <jsp:include page="fragments/footer.jsp"/>

    </div>
    <!-- end::main-content -->

</div>
<!-- end::main -->

<jsp:include page="fragments/plugin-scripts.jsp"/>
</body>
</html>