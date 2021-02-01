<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>

    <title>List Of Employees</title>

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
            <div class="col-md-8"><h3 class="h3">List of employees</h3></div>
            <div class="col-md-4"><a class="btn btn-primary float-right" href="add-employee-form">Add Employee</a></div>
        </div>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Employee ID</th>
                    <th scope="col">Fitst Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Designation</th>
                    <th scope="col">Department</th>
                    <th scope="col">Status</th>
                    <th scope="col">Roles</th>
                    <th scope="col">Action</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items = "${listOfEmployees}" var = "employee">
                    <tr>
                        <td>${employee.employeeId}</td>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.designation}</td>
                        <td>${employee.department}</td>
                        <td>${employee.status}</td>
                        <td>
                            <c:forEach items = "${employee.roles}" var = "role">
                                ${role.name}
                            </c:forEach>
                        </td>
                        <td><a href="/edit-employee-form/${employee.id}" class="btn btn-secondary btn-sm">Edit</a></td>
                            <%--todo implement edit and delete employee action --%>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>

        <jsp:include page="../fragments/footer.jsp"/>

    </div>
    <!-- end::main-content -->

</div>
<!-- end::main -->

<jsp:include page="../fragments/plugin-scripts.jsp"/>
</body>
</html>
