<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>

    <title>Users's Roles</title>

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
            <div class="col-md-8"><h3 class="h3">Select ${user.firstName} ${user.lastName}'s Roles</h3></div>
            <div class="col-md-4"></div>
        </div>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Role Name</th>
                    <th scope="col">Action</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${listOfRoles}" var="role">
                    <tr>
                        <td>${role.name}</td>
                        <td>
                            <c:if test="${!usersRoles.contains(role)}">
                                <form:form action="/users-roles/add/${user.id}/${role.id}" method="post">
                                    <button class="btn btn-sm btn-primary" type="submit">ADD</button>
                                </form:form>
                            </c:if>

                            <c:if test="${usersRoles.contains(role)}">
                                <form:form action="/users-roles/remove/${user.id}/${role.id}" method="post">
                                    <button class="btn btn-sm btn-danger" type="submit">REMOVE</button>
                                </form:form>
                            </c:if>
                        </td>


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
