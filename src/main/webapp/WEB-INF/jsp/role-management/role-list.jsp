<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>

    <title>List Of Roles</title>

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
            <div class="col-md-8"><h3 class="h3">List of roles</h3></div>
            <div class="col-md-4"><a class="btn btn-primary float-right text-white" href="add-role">Add Role</a></div>
        </div>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Role Id</th>
                    <th scope="col">Role Name</th>
                    <th scope="col">Edit Role</th>
                    <th scope="col">Manage Privileges</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${listOfRoles}" var="role">
                    <tr>
                        <td>${role.id}</td>
                        <td>${role.name}</td>
                        <td>
                            <a href="edit-role/${role.id}" class="btn btn-secondary btn-sm text-white">Edit</a>
                        </td>
                        <td>
                            <a href="roles-privileges/${role.id}" class="btn btn-secondary btn-sm text-white">Manage
                                Privileges</a>
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
