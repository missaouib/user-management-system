<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>

    <title>List Of Users</title>

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
            <div class="col-md-8"><h3 class="h3">List of users</h3></div>
            <div class="col-md-4"><a class="btn btn-primary float-right text-white" href="add-user">Add User</a></div>
        </div>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">User ID</th>
                    <th scope="col">Fitst Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Designation</th>
                    <th scope="col">Department</th>
                    <th scope="col">Status</th>
                    <th scope="col">Roles</th>
                    <th scope="col">Manage Roles</th>
                    <th scope="col">Edit Info</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items = "${listOfUsers}" var = "user">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.designation}</td>
                        <td>${user.department}</td>
                        <td>${user.status}</td>
                        <td>
                            <c:forEach items = "${user.userToRoles}" var = "userToRole">
                                ${userToRole.role.name}
                            </c:forEach>
                        </td>

                        <td><a href="users-roles/${user.id}" class="btn btn-secondary btn-sm text-white">Manage</a></td>

                        <td><a href="edit-user/${user.id}" class="btn btn-secondary btn-sm text-white">Edit</a></td>

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
