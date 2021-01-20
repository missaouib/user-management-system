<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>

    <title>List Of Employees</title>

    <jsp:include page="fragments/head-meta-links.jsp"/>

</head>
<body>

<jsp:include page="fragments/header.jsp"/>


<!-- begin::main -->
<div id="main">

    <jsp:include page="fragments/navigation.jsp"/>

    <!-- begin::main-content -->
    <div class="main-content">
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Employee ID</th>
                    <th scope="col">Fitst Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Department</th>
                    <th scope="col">Status</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${listOfEmployees}" var="employee">
                    <tr>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.company}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>

        <jsp:include page="fragments/footer.jsp"/>

    </div>
    <!-- end::main-content -->

</div>
<!-- end::main -->

<jsp:include page="fragments/plugin-scripts.jsp"/>
</body>
</html>
