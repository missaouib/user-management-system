<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- begin::navigation -->
<div class="navigation">
<c:set var="URI" value="${pageContext.request.requestURI}"/>

    <!-- begin::navigation menu -->
    <div class="navigation-menu-body">
        <ul>
            <li class="navigation-divider">Navigation</li>
            <li>
                <a href="index.html">
                    <i class="nav-link-icon" data-feather="bar-chart-2"></i>
                    <span>Dashboard</span>
                </a>
                <ul>
                    <li><a href="index.html">CRM System</a></li>
                    <li><a href="dashboard-two.html">Ecommerce</a></li>
                    <li><a href="dashboard-three.html">Analytics</a></li>
                    <li><a href="dashboard-four.html">Project Management</a></li>
                    <li><a href="dashboard-five.html">Helpdesk Management</a></li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="command"></i>
                    <span>Apps</span>
                </a>
                <ul>
                    <li>
                        <a href="chat.html">
                            <span>Chat</span>
                            <span class="badge badge-danger">2</span>
                        </a>
                    </li>
                    <li>
                        <a href="inbox.html">
                            <span>Mail</span>
                            <span class="badge badge-success">2</span>
                        </a>
                    </li>
                    <li>
                        <a href="app-todo.html">
                            <span>Todo</span>
                            <span class="badge badge-warning">2</span>
                        </a>
                    </li>
                    <li>
                        <a href="file-manager.html">
                            <span>File Manager</span>
                        </a>
                    </li>
                    <li>
                        <a href="calendar.html">
                            <span>Calendar</span>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="navigation-divider">UI Elements</li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="monitor"></i>
                    <span>Components</span>
                </a>
                <ul>
                    <li>
                        <a href="#">Basic</a>
                        <ul>
                            <li><a href="alerts.html">Alert</a></li>
                            <li><a href="accordion.html">Accordion</a></li>
                            <li><a href="buttons.html">Buttons</a></li>
                            <li><a href="dropdown.html">Dropdown</a></li>
                            <li><a href="list-group.html">List Group</a></li>
                            <li><a href="pagination.html">Pagination</a></li>
                            <li><a href="typography.html">Typography</a></li>
                            <li><a href="media-object.html">Media Object</a></li>
                            <li><a href="progress.html">Progress</a></li>
                            <li><a href="modal.html">Modal</a></li>
                            <li><a href="spinners.html">Spinners</a></li>
                            <li><a href="navs.html">Navs</a></li>
                            <li><a href="tab.html">Tab</a></li>
                            <li><a href="tooltip.html">Tooltip</a></li>
                            <li><a href="popovers.html">Popovers</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Cards</a>
                        <ul>
                            <li><a href="basic-cards.html">Basic Cards </a></li>
                            <li><a href="image-cards.html">Image Cards </a></li>
                            <li><a href="card-scroll.html">Card Scroll </a></li>
                            <li><a href="other-cards.html">Others </a></li>
                        </ul>
                    </li>
                    <li><a href="avatar.html">Avatar</a></li>
                    <li><a href="icons.html">Icons</a></li>
                    <li><a href="colors.html">Colors</a></li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="globe"></i>
                    <span>Plugins</span>
                </a>
                <ul>
                    <li><a href="sweet-alert.html">Sweet Alert</a></li>
                    <li><a href="lightbox.html">Lightbox</a></li>
                    <li><a href="toast.html">Toast</a></li>
                    <li><a href="tour.html">Tour</a></li>
                    <li><a href="slick-slide.html">Slick Slide</a></li>
                    <li><a href="nestable.html">Nestable</a></li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="mouse-pointer"></i>
                    <span>Forms</span>
                </a>
                <ul>
                    <li><a href="basic-form.html">Form Layouts</a></li>
                    <li><a href="custom-form.html">Custom Forms</a></li>
                    <li><a href="advanced-form.html">Advanced Form</a></li>
                    <li><a href="form-validation.html">Validation</a></li>
                    <li><a href="form-wizard.html">Wizard</a></li>
                    <li><a href="file-upload.html">File Upload</a></li>
                    <li><a href="datepicker.html">Datepicker</a></li>
                    <li><a href="timepicker.html">Timepicker</a></li>
                    <li><a href="colorpicker.html">Colorpicker</a></li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="grid"></i>
                    <span>Tables</span>
                </a>
                <ul>
                    <li><a href="tables.html">Basic Tables</a></li>
                    <li><a href="data-table.html">Datatable</a></li>
                    <li><a href="responsive-table.html">Responsive Tables</a></li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="pie-chart"></i>
                    <span>Charts</span>
                </a>
                <ul>
                    <li><a href="apexchart.html">Apex</a></li>
                    <li><a href="chartjs.html">Chartjs</a></li>
                    <li><a href="justgage.html">Justgage</a></li>
                    <li><a href="morsis.html">Morsis</a></li>
                    <li><a href="peity.html">Peity</a></li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="map-pin"></i>
                    <span>Maps</span>
                </a>
                <ul>
                    <li><a href="google-map.html">Google</a></li>
                    <li><a href="vector-map.html">Vector</a></li>
                </ul>
            </li>
            <li class="navigation-divider">Management</li>
            <li <c:if test="${URI.contains('user-management')}">class="open" </c:if>>
                <a href="#">
                    <i class="nav-link-icon" data-feather="user"></i>
                    <span>User</span>
                </a>
                <ul>
                    <li><a <c:if test="${URI.contains('add-user')}">class="active"</c:if> href="/add-user">Add User</a></li>
                    <li><a <c:if test="${URI.contains('user-list')}">class="active"</c:if> href="/user-list">Users</a></li>
                </ul>
            </li>
            <li <c:if test="${URI.contains('role-management')}">class="open" </c:if>>
                <a href="#">
                    <i class="nav-link-icon" data-feather="sliders"></i>
                    <span>Role</span>
                </a>
                <ul>
                    <li><a <c:if test="${URI.contains('add-role')}">class="active"</c:if> href="/add-role">Add Role</a></li>
                    <li><a <c:if test="${URI.contains('role-list')}">class="active"</c:if> href="/role-list">Roles</a></li>
                </ul>
            </li>
            <li <c:if test="${URI.contains('privilege-management')}">class="open" </c:if>>
                <a href="#">
                    <i class="nav-link-icon" data-feather="sliders"></i>
                    <span>Privileges</span>
                </a>
                <ul>
                    <li><a <c:if test="${URI.contains('add-privilege')}">class="active"</c:if> href="/add-privilege">Add Privilege</a></li>
                    <li><a <c:if test="${URI.contains('privilege-list')}">class="active"</c:if> href="/privilege-list">Privileges</a></li>
                </ul>
            </li>
            <li class="navigation-divider">Extras</li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="copy"></i>
                    <span>Pages</span>
                </a>
                <ul>
                    <li><a href="profile.html">Profile</a></li>
                    <li><a href="timeline.html">Timeline</a></li>
                    <li><a href="invoice.html">Invoice</a></li>

                    <li><a href="pricing-table.html">Pricing Table</a></li>
                    <li><a href="search-result.html">Search Result</a></li>
                    <li>
                        <a href="#">Error Pages</a>
                        <ul>
                            <li><a href="404.html">404</a></li>
                            <li><a href="404-2.html">404 V2</a></li>
                            <li><a href="503.html">503</a></li>
                            <li><a href="mean-at-work.html">Mean at Work</a></li>
                        </ul>
                    </li>
                    <li><a href="blank-page.html">Starter Page</a></li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="send"></i>
                    <span>Email Templates</span>
                </a>
                <ul>
                    <li><a href="email-template-basic.html">Basic</a></li>
                    <li><a href="email-template-alert.html">Alert</a></li>
                    <li><a href="email-template-billing.html">Billing</a></li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="nav-link-icon" data-feather="menu"></i>
                    <span>Menu Level</span>
                </a>
                <ul>
                    <li>
                        <a href="#">Menu Level</a>
                        <ul>
                            <li>
                                <a href="#">Menu Level </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- end::navigation menu -->

</div>
<!-- end::navigation -->