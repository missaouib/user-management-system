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
            <div class="col-md-8"><h3 class="h3">Edit User</h3></div>
            <div class="col-md-4"></div>
        </div>

        <form:form method="POST" action="/update-user/${ user.id }" modelAttribute="user">

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
                    <form:label path="status">Status</form:label>
                    <form:input path="status" class="form-control"/>
                    <form:errors cssClass="text-danger" path="status"/>
                </div>
            </div>

            <div class="form-row">
                <h5>Roles: </h5>
<%--                <c:forEach items="${roles}" var="role">--%>
<%--                    <div class="col">--%>
<%--                        <div class="form-check">--%>
<%--                            <input class="form-check-input" type="checkbox" name="selectedRoles"--%>
<%--                                   value="${role.name}" <c:if test="${user.roles.contains(role)}">checked</c:if>>--%>
<%--                            <label class="form-check-label" for="${role.name}">--%>
<%--                                    ${role.name}--%>
<%--                            </label>--%>
<%--                        </div>--%>

<%--                    </div>--%>
<%--                </c:forEach>--%>
            </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-3">
                <button class="btn btn-primary" type="submit">UPDATE</button>
            </div>
            </form:form>
            <div class="col-md-3">
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                    DELETE
                </button>
            </div>
            <form:form action="/delete-user/${ user.id }" method="POST">
                <div class="col-md-3">
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Confirm Deletion</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Are you sure you want to delete this user?
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>

        </div>


        <jsp:include page="../fragments/footer.jsp"/>

    </div>
    <!-- end::main-content -->

</div>
<!-- end::main -->

<jsp:include page="../fragments/plugin-scripts.jsp"/>
</body>
</html>