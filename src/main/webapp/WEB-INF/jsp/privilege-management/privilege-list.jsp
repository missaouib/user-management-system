<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>

    <title>List Of Privileges</title>

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
            <div class="col-md-8"><h3 class="h3">List of privileges</h3></div>
            <div class="col-md-4"><a class="btn btn-primary float-right text-white" href="add-privilege">Add Privilege</a></div>
        </div>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Privilege Id</th>
                    <th scope="col">Privilege URL</th>
                    <th scope="col">Edit Role</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items = "${listOfPrivileges}" var = "privilege">
                    <tr>
                        <td>${privilege.id}</td>
                        <td>${privilege.url}</td>

                        <td><a href="/edit-privilege/${privilege.id}" class="btn btn-secondary btn-sm text-white">Edit</a></td>
                            <%--todo implement edit and delete user action --%>
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
