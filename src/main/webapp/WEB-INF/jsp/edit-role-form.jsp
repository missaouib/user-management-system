<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>

    <title>Edit Role</title>

    <jsp:include page="fragments/head-meta-links.jsp"/>

</head>
<body>

<jsp:include page="fragments/header.jsp"/>


<!-- begin::main -->
<div id="main">

    <jsp:include page="fragments/navigation.jsp"/>

    <!-- begin::main-content -->
    <div class="main-content">


        <form:form method="POST" action="/update-role/${role.id}" modelAttribute="role">

            <div class="form-row">
                <div class="col-md-6 mb-6">
                    <form:label path="name">Role Name</form:label>
                    <form:input path="name" class="form-control"/>
                    <form:errors cssClass="text-danger" path="name"/>
                </div>
            </div>
            <div class="row mt-3">
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
                <form:form action="/delete-role/${ role.id }" method="POST">
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
                                        Are you sure you want to delete this Role?
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

        <jsp:include page="fragments/footer.jsp"/>

    </div>
    <!-- end::main-content -->

</div>
<!-- end::main -->

<jsp:include page="fragments/plugin-scripts.jsp"/>
</body>
</html>